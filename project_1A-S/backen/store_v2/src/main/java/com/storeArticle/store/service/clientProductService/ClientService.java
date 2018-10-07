package com.storeArticle.store.service.clientProductService;

import com.storeArticle.store.model.clientModel.Client;
import com.storeArticle.store.service.dto.SelectDTOService;
import com.storeArticle.store.service.dto.SelectVEO;
import com.storeArticle.store.service.enumPage.clientEnum.ClientQueryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ClientService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SelectDTOService selectDTOService;

    public boolean addClient(Client client){
        boolean isCreate = false;
        if(isCreateClient(client.getCiNitClient(), client.getNameClient())){
            entityManager.persist(client);
        }
        return isCreate;
    }

    public Client addClientAndGet(Client client){
        if(isCreateClient(client.getCiNitClient(), client.getNameClient())){
            entityManager.persist(client);
        }else{
           client =  getClientList(client.getCiNitClient(), client.getNameClient()).get(0);
        }
        return client;
    }

    public Client getClient(int clientId){
        return entityManager.find(Client.class, clientId);
    }

    public boolean isCreateClient(String codeCiNit, String nameClient){
        List<Client> clientList = getClientList(codeCiNit, nameClient);
        if(clientList.size() == 0){
            return true;
        } else{
            return false;
        }
    }

    public Client getClientOrAdd(Client clientNew){
        Client client = getClient(clientNew.getClientId());
        if( null != client){
             client.setCiNitClient(clientNew.getCiNitClient());
             client.setNameClient(clientNew.getNameClient());
        }else{
            client =  addClientAndGet(clientNew);
        }
        return client;
    }

    public List<Client> getClientList(String codeCiNit, String nameClient){
        return entityManager.createQuery(ClientQueryEnum.getClientHql.getHql())
                .setParameter(1, codeCiNit)
                .setParameter(2, nameClient)
                .setParameter(3,false)
                .getResultList();
    }

    public List<Object[]> getClientListLookFor(String infoClient){
        return entityManager.createQuery(ClientQueryEnum.getlookForClient.getHql())
                .setParameter(1, "%"+infoClient+"%")
                .setParameter(2, "%"+infoClient+"%")
                .setParameter(3, "%"+infoClient+"%")
                .setParameter(4, "%"+infoClient+"%")
                .setParameter(5,false)
                .getResultList();
    }

    public List<SelectVEO> getListSelectDTO(String infoClient){
        return  selectDTOService.getTreeDataDTO(getClientListLookFor(infoClient));
    }

}
