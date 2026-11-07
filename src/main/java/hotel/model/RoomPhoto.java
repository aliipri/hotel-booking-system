package hotel.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "room_photo")
public class RoomPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false) // Связь с таблицей Room через room_id
    private Room room;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    @Column(name = "photo", nullable = false) // Поле photo для хранения бинарных данных
    private byte[] photo;

    @Column(name = "description")
    private String description;

    @Transient // Поле не будет сохраняться в базу данных
    private String base64Photo;

    // Конструктор по умолчанию
    public RoomPhoto() {
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBase64Photo() {
        return base64Photo;
    }

    public void setBase64Photo(String base64Photo) {
        this.base64Photo = base64Photo;
    }
}
