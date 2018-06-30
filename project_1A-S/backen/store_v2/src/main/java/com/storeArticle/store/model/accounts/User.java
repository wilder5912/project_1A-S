package com.storeArticle.store.model.accounts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="userbusiness")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="user_id")
    private int userID;

    @Column(name="firt_name_user")
    private String firtNameUser;

    @Column(name="last_name_user")
    private String lastNameUser;

    @Column(name="email_user")
    private String emailUser;

    @Column(name="password_user")
    private String password;

    @Column(name="type_user")
    private String typeUser;

    @Column(name="imagen_user")
    private String imagenUser;

    @Column(name="token_user")
    private String tokenUser;

    @Column(name="code_user")
    private String codeUser;

    @Column(name = "id_box_user")
    private int idBoxUser;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirtNameUser() {
        return firtNameUser;
    }

    public void setFirtNameUser(String firtNameUser) {
        this.firtNameUser = firtNameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getImagenUser() {
        return imagenUser;
    }

    public void setImagenUser(String imagenUser) {
        this.imagenUser = imagenUser;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public int getIdBoxUser() {
        return idBoxUser;
    }

    public void setIdBoxUser(int idBoxUser) {
        this.idBoxUser = idBoxUser;
    }
}