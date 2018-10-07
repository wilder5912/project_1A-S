package com.storeArticle.store.model.SellModel;

import com.storeArticle.store.model.TypeMoneyModel.PaymentType;
import com.storeArticle.store.model.accounts.BusinessCurrentUser;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailsell")
public class DetailSell implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "detailsell_id")
    private int detailSellId;

    @ManyToOne
    @JoinColumn(name = "businesscurouser_id")
    private BusinessCurrentUser businessCurouserId;

    @Column(name = "code_control_detailsell")
    private String codeControlDetailSell;

    @Column(name = "date_detailsell")
    private String dateDetailSell;

    @Column(name = "date_register_detailsell")
    private String dateRegisterDetailSell;

    @Column(name = "amount_detailsell")
    private float amountDetailSell;

    @Column(name = "type_change_detailsell")
    private String  typeChangeDetailSell;

    @Column(name = "change_amount_detailsell")
    private float changeAmountDetailsell;

    @Column(name = "sales_check_detailsell")
    private float salesCheckDetailsell;

    @Column(name = "role_cashier_id")
    private int roleCashierId;

    @Column(name = "role_seller_id")
    private int roleSellerId;

    @ManyToOne
    @JoinColumn(name = "paymenttype_id")
    private PaymentType paymentTypeId;

    @Column(name = "is_delete_detailsell")
    private boolean isDelete;

    public int getDetailSellId() {
        return detailSellId;
    }

    public void setDetailSellId(int detailSellId) {
        this.detailSellId = detailSellId;
    }

    public BusinessCurrentUser getBusinessCurouserId() {
        return businessCurouserId;
    }

    public void setBusinessCurouserId(BusinessCurrentUser businessCurouserId) {
        this.businessCurouserId = businessCurouserId;
    }

    public String getCodeControlDetailSell() {
        return codeControlDetailSell;
    }

    public void setCodeControlDetailSell(String codeControlDetailSell) {
        this.codeControlDetailSell = codeControlDetailSell;
    }

    public String getDateDetailSell() {
        return dateDetailSell;
    }

    public void setDateDetailSell(String dateDetailSell) {
        this.dateDetailSell = dateDetailSell;
    }

    public String getDateRegisterDetailSell() {
        return dateRegisterDetailSell;
    }

    public void setDateRegisterDetailSell(String dateRegisterDetailSell) {
        this.dateRegisterDetailSell = dateRegisterDetailSell;
    }

    public float getAmountDetailSell() {
        return amountDetailSell;
    }

    public void setAmountDetailSell(float amountDetailSell) {
        this.amountDetailSell = amountDetailSell;
    }

    public String getTypeChangeDetailSell() {
        return typeChangeDetailSell;
    }

    public void setTypeChangeDetailSell(String typeChangeDetailSell) {
        this.typeChangeDetailSell = typeChangeDetailSell;
    }

    public float getChangeAmountDetailsell() {
        return changeAmountDetailsell;
    }

    public void setChangeAmountDetailsell(float changeAmountDetailsell) {
        this.changeAmountDetailsell = changeAmountDetailsell;
    }

    public float getSalesCheckDetailsell() {
        return salesCheckDetailsell;
    }

    public void setSalesCheckDetailsell(float salesCheckDetailsell) {
        this.salesCheckDetailsell = salesCheckDetailsell;
    }

    public int getRoleCashierId() {
        return roleCashierId;
    }

    public void setRoleCashierId(int roleCashierId) {
        this.roleCashierId = roleCashierId;
    }

    public int getRoleSellerId() {
        return roleSellerId;
    }

    public void setRoleSellerId(int roleSellerId) {
        this.roleSellerId = roleSellerId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public PaymentType getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(PaymentType paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }
}
