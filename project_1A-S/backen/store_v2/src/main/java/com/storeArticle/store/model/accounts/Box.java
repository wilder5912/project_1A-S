
package com.storeArticle.store.model.accounts;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="box")
public class Box implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="box_id", nullable= false, updatable = false)
    private int boxId;

    @ManyToOne
    @JoinColumn(name = "bussine_id")
    private Bussine bussineId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userID;

    @Column(name ="name_box")
    private String nameBox;

    @Column(name = "code_box" )
    private String codeBox;

    @Column(name = "is_select_box" )
    private boolean isSelectBox;

    @Column(name = "is_delete_box" )
    private boolean isDelete;

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public Bussine getBussineId() {
        return bussineId;
    }

    public void setBussineId(Bussine bussineId) {
        this.bussineId = bussineId;
    }

    public User getUserId() {
        return userID;
    }

    public void setUserId(User userId) {
        this.userID = userId;
    }

    public String getNameBox() {
        return nameBox;
    }

    public void setNameBox(String nameBox) {
        this.nameBox = nameBox;
    }

    public String getCodeBox() {
        return codeBox;
    }

    public void setCodeBox(String codeBox) {
        this.codeBox = codeBox;
    }

    public boolean isSelectBox() {
        return isSelectBox;
    }

    public void setSelectBox(boolean selectBox) {
        isSelectBox = selectBox;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
