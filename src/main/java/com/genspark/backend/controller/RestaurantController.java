package com.genspark.backend.controller;

import com.genspark.backend.entity.Reservation;
import com.genspark.backend.entity.UserAccount;
import com.genspark.backend.error.DataNotFoundException;
import com.genspark.backend.service.ReservationService;
import com.genspark.backend.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class RestaurantController{
    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private ReservationService reservationService;

//    @Autowired
//    private EmailService emailService;

    @PostMapping("/login")
    public UserAccount logUser(@RequestBody UserAccount userAccount) {
        return this.userAccountService.logUser(userAccount);
    }


    @PostMapping("/signup")
    public UserAccount signUp(@RequestBody UserAccount userAccount) {
        return this.userAccountService.signUp(userAccount);
    }

    @GetMapping("/user")
    public List<UserAccount> getUsers(){
        return this.userAccountService.getUsers();
    }

    @GetMapping("/user/{userId}")
    public UserAccount getUserById(@PathVariable("userId") Long userId) throws DataNotFoundException {
        return this.userAccountService.getUserById(userId);
    }

    @PostMapping("/user")
    public UserAccount addUser(@RequestBody UserAccount userAccount) {
        return this.userAccountService.addUser(userAccount);
    }

    @PutMapping("/user/{userID}")
    public UserAccount updateUserAccount(@RequestBody UserAccount userAccount, @PathVariable("userId") Long userId) throws DataNotFoundException {
        return this.userAccountService.updateUser(userAccount, userId);
    }

    @DeleteMapping("/user/{userID}")
    public void deleteAccount(@PathVariable("userId") Long userId) throws DataNotFoundException {
        this.userAccountService.deleteUser(userId);
    }


    @GetMapping("/reservation")
    public List<Reservation> getReservations(){
        return this.reservationService.getReservations();
    }

    @GetMapping("/reservation/{reservationId}")
    public Reservation getResById(@PathVariable("reservationId") Long reservationId) throws DataNotFoundException {
        return this.reservationService.getResById(reservationId);
    }

    @PostMapping("/reservation")
    public Reservation addRes(@RequestBody Reservation reservation) {
        return this.reservationService.addRes(reservation);
    }

    @PutMapping("/reservation/{reservationId}")
    public Reservation updateRes(@RequestBody Reservation reservation, @PathVariable("reservationId") Long reservationId) throws DataNotFoundException {
        return this.reservationService.updateRes(reservation, reservationId);
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void deleteRes(@PathVariable("reservationId") Long reservationId) throws DataNotFoundException {
        this.reservationService.deleteRes(reservationId);
    }

//    @GetMapping("/dev/testing/email")
//    public String sendTestEmail(){
//        return emailService.sendEmail("catdogramb@gmail.com",
//                "Test from Restaurant",
//                "this was a test message")
//                ?
//                "Successfully sent email"
//                :
//                "Error while sending email";
//    }
}
