package com.storeArticle.store.service.accounts;

import com.storeArticle.store.model.accounts.User;

 interface UserCrup {

    void addUser(User user);

    void deleteUser(int userId);

    void updatedUser(int userId, User user);

    User getUser(int userId);

    Boolean getIsDeleted();

}
