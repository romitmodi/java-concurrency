package org.romit.learning.concurrency;

import org.romit.learning.concurrency.callables.UserCallable;
import org.romit.learning.concurrency.dao.UserDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class UserExecutorApp {
    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
        // Read Data from File and return list of user details
        List<String> userData = getUserDataFromFile("C:\\Users\\romit\\Work\\codebase\\Java\\java-concurrency\\src\\main\\resources\\new_users.txt");
        UserDao userDao = new UserDao();

        // Create Executor service thread pool
        ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<Boolean>> threadResult = new ArrayList<>();

        // Iterate over list of user record and push it to database
        for (String user : userData) {
            UserCallable userCallable = new UserCallable(user, userDao);
            Future<Boolean> booleanFuture = service.submit(userCallable);
            threadResult.add(booleanFuture);
            System.out.println(booleanFuture.get());
        }

        threadResult.forEach(booleanFuture -> {
            try {
                System.out.println(booleanFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        userDao.getUserList().forEach(user -> {
            System.out.println(user.toString());
        });

        // Shutdown the executor service
        service.shutdown();
    }

    public static List<String> getUserDataFromFile(String filePath) throws FileNotFoundException {
        List<String> userData = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            userData.add(scanner.nextLine());
        }
        return userData;
    }
}
