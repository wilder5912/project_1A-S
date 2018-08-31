package com.storeArticle.store.model.cashierModel;

import com.storeArticle.store.model.TypeMoneyModel.PaymentType;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailsell")
public class DetailSell implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "detailsell_id")
    private int detailsellId;

    @ManyToOne
    @JoinColumn(name = "detailauthorization_id")
    private DetailAuthorization detailAuthorizationId;

    @ManyToOne
    @JoinColumn(name = "paymenttype_id")
    private PaymentType paymentTypeId;

    @Column(name = "code_control_detailsell")
    private String codeControlDetailSell;

    @Column(name = "date_detailsell")
    private String dateDetailSell;

    @Column(name = "date_register_detailsell")
    private String dateRegisterDetailSell;

    @Column(name = "amount_detailsell")
    private double amountDetailSell;

    @Column(name = "type_change_detailsell")
    private String typeChangeDetailSell;

    @Column(name = "change_amount_detailsell")
    private double changeAmountDetailSell;

    @Column(name = "sales_check_detailsell")
    private float salesCheckDetailSell;

    @Column(name = "is_delete_detailsell")
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "role_cashier_id")
    private DetailAuthorization roleCashierId;

    @ManyToOne
    @JoinColumn(name = "role_seller_id")
    private DetailAuthorization roleSellerId;

    public int getDetailsellId() {
        return detailsellId;
    }

    public void setDetailsellId(int detailsellId) {
        this.detailsellId = detailsellId;
    }

    public DetailAuthorization getDetailAuthorizationId() {
        return detailAuthorizationId;
    }

    public void setDetailAuthorizationId(DetailAuthorization detailAuthorizationId) {
        this.detailAuthorizationId = detailAuthorizationId;
    }

    public PaymentType getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(PaymentType paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
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

    public double getAmountDetailSell() {
        return amountDetailSell;
    }

    public void setAmountDetailSell(double amountDetailSell) {
        this.amountDetailSell = amountDetailSell;
    }

    public String getTypeChangeDetailSell() {
        return typeChangeDetailSell;
    }

    public void setTypeChangeDetailSell(String typeChangeDetailSell) {
        this.typeChangeDetailSell = typeChangeDetailSell;
    }

    public double getChangeAmountDetailSell() {
        return changeAmountDetailSell;
    }

    public void setChangeAmountDetailSell(double changeAmountDetailSell) {
        this.changeAmountDetailSell = changeAmountDetailSell;
    }

    public float getSalesCheckDetailSell() {
        return salesCheckDetailSell;
    }

    public void setSalesCheckDetailSell(float salesCheckDetailSell) {
        this.salesCheckDetailSell = salesCheckDetailSell;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public DetailAuthorization getRoleCashierId() {
        return roleCashierId;
    }

    public void setRoleCashierId(DetailAuthorization roleCashierId) {
        this.roleCashierId = roleCashierId;
    }

    public DetailAuthorization getRoleSellerId() {
        return roleSellerId;
    }

    public void setRoleSellerId(DetailAuthorization roleSellerId) {
        this.roleSellerId = roleSellerId;
    }
}
