package com.storeArticle.store.model.accounts;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="registeruser")
public class RegisterUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_register_id")
    private int userRegisterId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_user_id")
    private TypeUser typeUser;

    public int getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(int userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

}
