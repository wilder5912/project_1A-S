package com.storeArticle.store.model.accounts;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="section")
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="section_id")
    private int sectionId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupProduct groupId;

    @Column(name="name_section")
    private String nameSection;

    @Column(name="is_delete_section")
    private boolean isDelete;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public GroupProduct getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupProduct groupId) {
        this.groupId = groupId;
    }

    public String getNameSection() {
        return nameSection;
    }

    public void setNameSection(String nameSection) {
        this.nameSection = nameSection;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}