package AllThingsByAV.backend.models;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    @Column
    @ElementCollection
    @CollectionTable(
            name="CartItem"
    )
    private Set<CartItem> cart;

    public User(Long id, String email, String password, Set<Order> orders, Set<CartItem> cart) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.orders = orders;
        this.cart = cart;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<CartItem> getCart() {
        return cart;
    }

    public void setCart(Set<CartItem> cart) {
        this.cart = cart;
    }
}
