package com.storeArticle.store.model.provider;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="provider")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "provider_id")
    private int providerId;

    @Column(name =  "name_provider")
    private String nameProvider;

    @Column(name = "code_provider")
    private String codeProvider;

    @Column(name = "numbre_phone_provider")
    private int numbrePhoneProvider;

    @Column(name = "is_delete_provider")
    private boolean isDelete;

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getCodeProvider() {
        return codeProvider;
    }

    public void setCodeProvider(String codeProvider) {
        this.codeProvider = codeProvider;
    }

    public int getNumbrePhoneProvider() {
        return numbrePhoneProvider;
    }

    public void setNumbrePhoneProvider(int numbrePhoneProvider) {
        this.numbrePhoneProvider = numbrePhoneProvider;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}

