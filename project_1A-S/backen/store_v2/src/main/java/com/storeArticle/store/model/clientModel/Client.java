package com.storeArticle.store.model.clientModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
public class Client implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "detailsell_id")
    private int id_client;

    @Column(name = "name_client")
    private String name_client;

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

    @Column(name = "is_delete_client")
    private boolean isDelete;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
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
}
