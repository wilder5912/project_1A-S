package com.storeArticle.store.model.clientModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_client")
    private int clientId;

    @Column(name = "name_client")
    private String nameClient;

    @Column(name = "last_name_client")
    private String lastNameClient;

    @Column(name = "ci_nit_client")
    private String ciNitClient;

    @Column(name = "date_birth_client")
    private String dateBirthClient;

    @Column(name = "cellphone_client")
    private String cellPhoneClient;

    @Column(name  = "phone_client")
    private String  phoneClient;

    @Column(name = "address_client")
    private String addressClient;

    @Column(name = "email_client")
    private String emailClient;

    @Column(name = "discount_client")
    private boolean discountClient;

    @Column(name = "is_delete_client")
    private boolean isDelete;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getCiNitClient() {
        return ciNitClient;
    }

    public void setCiNitClient(String ciNitClient) {
        this.ciNitClient = ciNitClient;
    }

    public String getDateBirthClient() {
        return dateBirthClient;
    }

    public void setDateBirthClient(String dateBirthClient) {
        this.dateBirthClient = dateBirthClient;
    }

    public String getCellPhoneClient() {
        return cellPhoneClient;
    }

    public void setCellPhoneClient(String cellPhoneClient) {
        this.cellPhoneClient = cellPhoneClient;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public boolean isDiscountClient() {
        return discountClient;
    }

    public void setDiscountClient(boolean discountClient) {
        this.discountClient = discountClient;
    }
}
