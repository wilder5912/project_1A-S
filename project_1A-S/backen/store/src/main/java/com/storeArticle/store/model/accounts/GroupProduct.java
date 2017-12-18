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
@Table(name="groupproduct")
public class GroupProduct  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="group_id")
    private int groupId;

    @ManyToOne
    @JoinColumn(name = "bussine_id")
    private Bussine bussine_id;

    @Column(name="name_group")
    private String nameGroup;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Bussine getBussine_id() {
        return bussine_id;
    }

    public void setBussine_id(Bussine bussine_id) {
        this.bussine_id = bussine_id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }
}