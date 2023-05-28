package pl.gameshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="availabilityType")

@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean inStock;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        name = name;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }
}
