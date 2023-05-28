package pl.gameshop.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")

@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name="order_date")
    private Date orderDate;
    @JoinColumn(name="user_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<OrderItem> items;
    @Min(0)
    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
