package AllThingsByAV.backend.models;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String type;
    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;


    public Image() {

    }

    public Image(MultipartFile image) throws IOException {
        this.name = image.getOriginalFilename();
        this.type = image.getContentType();
        try {
            this.imageData = image.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}