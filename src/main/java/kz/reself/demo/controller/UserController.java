package kz.reself.demo.controller;

import kz.reself.demo.model.User;
import kz.reself.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // get rand user
    @GetMapping("/users/rand")
    public User getRandomUser() {
        return userService.getRandomUser();
    }

    // check pin code
    @GetMapping("/users")
    public String checkPinCode(@RequestParam("pinCode") String pinCode, @RequestParam("userId") String userId) {
        return userService.checkPin(pinCode, userId);
    }

    // get user balance
    @GetMapping("/users/{id}/balance")
    public double getUserBalance(@PathVariable("id") int id ) {
        return userService.getUser(id);
    }

    // withdraw user balance
    @PutMapping("/users/{id}/balance/withdraw")
    public int withdrawBalance(@PathVariable int id, @RequestBody double amount) {
        return userService.withdrawBalance(id, amount);
    }

    // add sum in user balance
    @PutMapping("/users/{id}/balance/add")
    public void addValueBalance(@PathVariable int id, @RequestBody double sum) {
        userService.addSumInBalance(id, sum);
    }

    // check card number and pin code
    @GetMapping("/users/check")
    public int checkCard(@RequestParam("cardNumber") String cardNumber, @RequestParam("pinCode") String pinCode) {
        return userService.checkUser(cardNumber, pinCode);
    }


    @PostMapping
    public void addUser(@RequestBody User user) {
        System.out.println("UserController.addUser");
        System.out.println("user = " + user);
        userService.addUser(user);
    }

}
