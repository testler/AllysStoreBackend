package AllThingsByAV.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String image;
    @Column
    private String description;
    @Column
    private Double price;
    @Column
    private Boolean inStock;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    public Product(Long id, String name, String image, String description, Double price, Boolean inStock) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.category = null;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }
}
