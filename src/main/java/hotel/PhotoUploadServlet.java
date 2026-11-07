package hotel;

import hotel.model.Room;
import hotel.model.RoomPhoto;
import hotel.service.RoomPhotoService;
import hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/uploadPhoto")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // Максимальный размер файла 5 MB
public class PhotoUploadServlet extends HttpServlet {

    @Autowired
    private RoomPhotoService roomPhotoService;

    @Autowired
    private RoomService roomService;

    @Override
    public void init() throws ServletException {
        // Подключение Spring к сервлету
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        try {
            Part filePart = req.getPart("photo"); // Получение файла из формы
            InputStream fileInputStream = filePart.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[1024]; // Размер буфера
            while ((nRead = fileInputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush(); // Убедитесь, что все данные записаны

            byte[] photoBytes = buffer.toByteArray(); // Получение массива байтов
            fileInputStream.close();
            buffer.close();


            Room room = roomService.getRoomById(Long.parseLong(req.getParameter("roomId")));
            String description = req.getParameter("description");

            System.out.println("Размер photoBytes: " + (photoBytes != null ? photoBytes.length : "null"));
            System.out.println("Тип данных photoBytes: " + (photoBytes != null ? photoBytes.getClass().getName() : "null"));

            RoomPhoto roomPhoto = new RoomPhoto();
            roomPhoto.setRoom(room);
            roomPhoto.setPhoto(photoBytes);
            roomPhoto.setDescription(description);

            System.out.println("Тип данных photo в roomPhoto: " + (roomPhoto.getPhoto() != null ? roomPhoto.getPhoto().getClass().getName() : "null"));


            roomPhotoService.saveRoomPhoto(roomPhoto); // Сохранение в базу




            resp.sendRedirect(req.getContextPath() + "/rooms");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка обработки файла.");
        }

    }
    }
