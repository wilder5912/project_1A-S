
package com.storeArticle.store.model.groupProductModel;

import com.storeArticle.store.model.boxModel.Box;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="listproduct")
public class ListProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="list_product_id", nullable= false, updatable = false)
    private int listProductId;

    @ManyToOne
    @JoinColumn(name = "box_id")
    private Box boxId;


    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article articleId;

                                //,nullable = false, updatable = false
    @Column(name = "num_product")
    private int numProduct;

    @Column(name = "is_delete_list_product")
    private boolean isDelete;

    public int getListProductId() {
        return listProductId;
    }

    public void setListProductId(int listProductId) {
        this.listProductId = listProductId;
    }

    public Box getBoxId() {
        return boxId;
    }

    public void setBoxId(Box boxId) {
        this.boxId = boxId;
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

    public int getNumProduct() {
        return numProduct;
    }

    public void setNumProduct(int numProduct) {
        this.numProduct = numProduct;
    }
}
