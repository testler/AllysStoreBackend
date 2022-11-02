package AllThingsByAV.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String image;
    @Column
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private List<Product> products;

    public Category( String image, String name) {
        this.image = image;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public Category(Long id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.products = new ArrayList<>();
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "name of category" + this.name;
    }



    public void addProduct(Product product) {
        this.products.add(product);
        System.out.println(this.products);
    }
}
