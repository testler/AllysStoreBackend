package AllThingsByAV.backend.models;

import jakarta.persistence.*;
;import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue()
    private Long id;

    private String image;

    private String name;
//    @OneToMany(mappedBy = "category")
//    private List<Product> productList;

    public Category(Long id, String image, String name, List<Product> productList) {
        this.id = id;
        this.image = image;
        this.name = name;
//        this.productList = productList;
    }

    public Category() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "name of category" + this.name;
    }
}
