package org.romit.learning.concurrency.callables;

import org.romit.learning.concurrency.dao.UserDao;
import org.romit.learning.concurrency.pojo.User;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class UserCallable implements Callable<Boolean> {

    private String userRecord;
    private UserDao userDao;

    public UserCallable(String userRecord, UserDao userDao) {
        this.userDao = userDao;
        this.userRecord = userRecord;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println(Thread.currentThread().getName().concat(" is running now for ").concat(userRecord));
        Boolean result = false;

        StringTokenizer stringTokenizer = new StringTokenizer(userRecord, ",");
        while (stringTokenizer.hasMoreTokens()) {
            User user = new User();
            user.setEmailId(stringTokenizer.nextToken());
            user.setName(stringTokenizer.nextToken());
            user.setId(Integer.valueOf(stringTokenizer.nextToken()));
            result = userDao.saveUser(user);
        }

        return result;
    }
}
