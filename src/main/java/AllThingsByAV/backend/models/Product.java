package AllThingsByAV.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @OneToMany
    private List<Image> imageArr;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private int stock;
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(String name, List<MultipartFile> imageArr, String description, Double price, int stock) {
        this.name = name;
        this.imageArr = createAndSave(imageArr);
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
    public List<Image> createAndSave(List<MultipartFile> imageArr){
        List<Image> arr = new ArrayList<>();
        imageArr.forEach((image) -> {
            try {
                arr.add(new Image(image));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return arr;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setImageArr(List<File> images) {
        this.imageArr = imageArr;
    }
    public void addImagesToImageArr(List<MultipartFile> images){
        images.forEach((newImage) -> {
            try {
                this.imageArr.add(new Image(newImage));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
