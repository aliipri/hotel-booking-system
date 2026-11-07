package hotel;

import hotel.service.RoomService;
import hotel.service.RoomPhotoService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        // Получаем Spring-контекст
        WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(context);

        // Получаем бины из Spring-контекста
        RoomService roomService = springContext.getBean(RoomService.class);
        RoomPhotoService roomPhotoService = springContext.getBean(RoomPhotoService.class);

        // Сохраняем сервисы в ServletContext
        context.setAttribute("roomService", roomService);
        context.setAttribute("roomPhotoService", roomPhotoService);

        System.out.println("Сервисы RoomService и RoomPhotoService добавлены в ServletContext.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Освобождение ресурсов (если нужно)
        System.out.println("Контекст приложения уничтожен.");
    }
}
