package kz.reself.demo.service;

import kz.reself.demo.model.User;

public interface UserService {
    User getRandomUser();
    String checkPin(String pinCode, String userId);
    double getUser(int id);
    int withdrawBalance(int id, double amount);
    void addSumInBalance(int id, double sum);
    int checkUser(String numberCard, String pinCode);

    void addUser(User user);
}
