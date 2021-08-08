package org.romit.learning.concurrency.dao;

import org.romit.learning.concurrency.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private List<User> userDataStore = new ArrayList<>();

    public boolean saveUser(User user) {
        return userDataStore.add(user);
    }

    public List<User> getUserList() {
        return userDataStore;
    }
}
