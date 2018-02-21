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
@Table(name="subsection")
public class SubSection implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="subsection_id")
    private int subSectionId;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section sectionId;

    @Column(name="name_sub_section")
    private String nameSubSection;

    @Column(name="is_delete_sub_section")
    private boolean isDelete;

    public int getSubSectionId() {
        return subSectionId;
    }

    public void setSubSectionId(int subSectionId) {
        this.subSectionId = subSectionId;
    }

    public Section getSectionId() {
        return sectionId;
    }

    public void setSectionId(Section sectionId) {
        this.sectionId = sectionId;
    }

    public String getNameSubSection() {
        return nameSubSection;
    }

    public void setNameSubSection(String nameSubSection) {
        this.nameSubSection = nameSubSection;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}