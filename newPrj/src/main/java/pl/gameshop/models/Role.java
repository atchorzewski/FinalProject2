package pl.gameshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.ORDINAL)//przechowywane w postaci string
    private Types type;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public enum Types{
        ROLE_ADMIN,
        ROLE_USER
    }

    public Role() {
        // Konstruktor domyślny
    }

    public Integer getId() {
        return id;
    }

    public Types getType() {
        return type;
    }

    public Set<User> getUser() {
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role(Types type){
        this.type = type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
