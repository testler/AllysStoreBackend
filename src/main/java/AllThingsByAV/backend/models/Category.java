package AllThingsByAV.backend.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String image;
    @Column
    private String name;
    @Column
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category(Long id, String image, String name, Set<Product> products) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.products = products;
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
