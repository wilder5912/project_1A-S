package com.storeArticle.store.model.SellModel;

import com.storeArticle.store.model.TypeMoneyModel.PaymentType;
import com.storeArticle.store.model.clientModel.Client;
import com.storeArticle.store.model.warehouse.Warehouse;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sellproduct")
public class SellProduct implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "sellproduct_id")
    private int sellproductId;

    @ManyToOne
    @JoinColumn(name = "detailsell_id")
    private DetailSell detailSellId;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client clientId;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouseId;

    @Column(name = "cost_product_country_spt")
    private float costProductCountrySpt;

    @Column(name ="number_prudct_sp")
    private int numberPrudctSp;

    @Column(name ="discount_sp")
    private int discountSp;

    @Column(name = "name_money_sp")
    private String nameMoneySp;

    @Column(name = "cost_typemoney_sp")
    private float costTypeMoneySp;

    @Column(name = "business_ar_sp")
    private int businessArSp;

    @Column(name = "is_delete_sp")
    private boolean isDelete;

    public String getNameMoneySp() {
        return nameMoneySp;
    }

    public void setNameMoneySp(String nameMoneySp) {
        this.nameMoneySp = nameMoneySp;
    }

    public int getSellproductId() {
        return sellproductId;
    }

    public void setSellproductId(int sellproductId) {
        this.sellproductId = sellproductId;
    }

    public DetailSell getDetailSellId() {
        return detailSellId;
    }

    public void setDetailSellId(DetailSell detailSellId) {
        this.detailSellId = detailSellId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Warehouse getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Warehouse warehouseId) {
        this.warehouseId = warehouseId;
    }

    public float getCostProductCountrySpt() {
        return costProductCountrySpt;
    }

    public void setCostProductCountrySpt(float costProductCountrySpt) {
        this.costProductCountrySpt = costProductCountrySpt;
    }

    public int getNumberPrudctSp() {
        return numberPrudctSp;
    }

    public void setNumberPrudctSp(int numberPrudctSp) {
        this.numberPrudctSp = numberPrudctSp;
    }

    public float getCostTypeMoneySp() {
        return costTypeMoneySp;
    }

    public void setCostTypeMoneySp(float costTypeMoneySp) {
        this.costTypeMoneySp = costTypeMoneySp;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getDiscountSp() {
        return discountSp;
    }

    public void setDiscountSp(int discountSp) {
        this.discountSp = discountSp;
    }

    public int getBusinessArSp() {
        return businessArSp;
    }

    public void setBusinessArSp(int businessArSp) {
        this.businessArSp = businessArSp;
    }

}
