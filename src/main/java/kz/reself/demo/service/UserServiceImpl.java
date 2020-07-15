package kz.reself.demo.service;

import kz.reself.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, User> userListMap;

    public UserServiceImpl() {
        this.userListMap = new HashMap<>();
        this.userListMap.put("001", new User(1, "Yerbolat", "0000111122223333", "1111", 1000.0));
        this.userListMap.put("002", new User(2, "Saule", "1111222233334444", "2222", 10000.0));
    }

    @Override
    public String checkPin(String pinCode, String userId) {
        for (String key : userListMap.keySet()) {
            if (userListMap.get(key).getId() == Integer.parseInt(userId) && userListMap.get(key).getPinCode().equals(pinCode)   ) {
                return "true";
            }
        }
        return "false";
    }

    @Override
    public int checkUser(String numberCard, String pinCode) {
        for (User user : userListMap.values()) {
            if (user.getPinCode().equals(pinCode) && user.getCardNumber().equals(numberCard)) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public double getUser(int id) {
        for (User user : userListMap.values()) {
            if (user.getId() == id) {
                return user.getBalance();
            }
        }
        return -1;
    }

    @Override
    public User getRandomUser() {
        Random random = new Random();
        int rand = random.nextInt(userListMap.size());
        return (User) userListMap.values().toArray()[rand];
    }

    @Override
    public void addUser(User user) {
        int size = userListMap.size();
        userListMap.put("00" + (size + 1), user);
    }

    @Override
    public int withdrawBalance(int id, double amount) {
        for (String key : userListMap.keySet()) {
            if (userListMap.get(key).getId() == id) {
                if (userListMap.get(key).getBalance() >= amount) {
                    userListMap.get(key).setBalance(userListMap.get(key).getBalance() - amount);
                    return 1;
                } else {
                    break;
                }
            }
        }
        return 0;
    }

    @Override
    public void addSumInBalance(int id, double sum) {
        for (String key : userListMap.keySet()) {
            if (userListMap.get(key).getId() == id) {
                userListMap.get(key).setBalance(userListMap.get(key).getBalance() + sum);
                break;
            }
        }
    }

}
