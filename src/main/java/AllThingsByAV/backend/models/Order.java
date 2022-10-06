package AllThingsByAV.backend.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Entity
public class Order implements Serializable{

    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp timestamp;

//    @ElementCollection
//    private List<Object> items;

    private Long comment;
//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;

    public Order(String status, Long id, Timestamp timestamp, List<Object> items, Long comment, User user) {
        this.status = status;
        this.id = id;
        this.timestamp = timestamp;
//        this.items = items;
        this.comment = comment;
//        this.user = user;
    }

    public Order() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

//    public List<Object> getItems() {
//        return items;
//    }

    public void setItems(List<Object> items) {
//        this.items = items;
    }

    public Long getComment() {
        return comment;
    }

    public void setComment(Long comment) {
        this.comment = comment;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Long getId() {
        return id;
    }
}
