package com.storeArticle.store.model.cashierModel;

import com.storeArticle.store.model.clientModel.Client;
import com.storeArticle.store.model.warehouse.Warehouse;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="sellproduct")
public class SellProduct implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sellproduct_id")
    private int sellProductId;

    @ManyToOne
    @JoinColumn(name = "detailsell_id")
    private DetailSell detailSellId;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client idClient;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouseId;

    @Column(name = "cost_product_country_spt")
    private double costProductCountrySpt;

    @Column(name = "numberPrudctSp")
    private double number_prudct_sp;

    @Column(name= "cost_typemoney_sp")
    private double costTypeMoneySp;

    @Column(name = "is_delete_sp")
    private boolean isDelete;

    public int getSellProductId() {
        return sellProductId;
    }

    public void setSellProductId(int sellProductId) {
        this.sellProductId = sellProductId;
    }

    public DetailSell getDetailSellId() {
        return detailSellId;
    }

    public void setDetailSellId(DetailSell detailSellId) {
        this.detailSellId = detailSellId;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getCostProductCountrySpt() {
        return costProductCountrySpt;
    }

    public void setCostProductCountrySpt(double costProductCountrySpt) {
        this.costProductCountrySpt = costProductCountrySpt;
    }

    public double getNumber_prudct_sp() {
        return number_prudct_sp;
    }

    public void setNumber_prudct_sp(double number_prudct_sp) {
        this.number_prudct_sp = number_prudct_sp;
    }

    public double getCostTypeMoneySp() {
        return costTypeMoneySp;
    }

    public void setCostTypeMoneySp(double costTypeMoneySp) {
        this.costTypeMoneySp = costTypeMoneySp;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
