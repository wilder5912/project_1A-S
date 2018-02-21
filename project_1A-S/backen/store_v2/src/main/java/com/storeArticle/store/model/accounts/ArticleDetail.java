
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
@Table(name="articledetail")
public class ArticleDetail implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="articledetail_id", nullable = false, updatable = false)
    private int articleDetailId;

    @ManyToOne
    @JoinColumn(name = "subsection_id")
    private SubSection subSectionId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

    @Column(name="is_delete_articledetail")
    private boolean isDelete;

    public int getArticleDetailId() {
        return articleDetailId;
    }

    public void setArticleDetailId(int articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    public SubSection getSubSectionId() {
        return subSectionId;
    }

    public void setSubSectionId(SubSection subSectionId) {
        this.subSectionId = subSectionId;
    }

    public Article getArticleId() {
        return articleId;
    }

    public void setArticleId(Article articleId) {
        this.articleId = articleId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
