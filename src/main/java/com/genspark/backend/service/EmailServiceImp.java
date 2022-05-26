//package com.genspark.backend.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
//
//public class EmailServiceImp implements EmailService {
//    private final String reservationReminderTitle = "A Reminder About Your Reservation at Restaurant";
//    @Autowired
//    private MailSender mailSender;
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    @Override
//    public void sendReservationReminder(Reservation reservation) {
//        var user = reservation.getUserAccount();
//        LocalDateTime timeDate = LocalDateTime.from(reservation.getDateTime());
//        StringBuilder sb = new StringBuilder();
//        sb.append("Hello ").append(user.getPrimaryName()).append(". You have a reservation at Restaurant ");
//        sb.append(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(timeDate)).append(" at ");
//        sb.append(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(timeDate));
//        sb.append("\n\nIf you need to change your reservation or cancel, please visit our website at localhost:8080/reservations");
//        sb.append("or call us at 555-555-5555.\n\nThank you for eating at Restaurant!");
//        sendEmail(reservation.getUserAccount().getEmail(), reservationReminderTitle, sb.toString());
//    }
//
//    @Override
//    public void sendNewUserWelcomeMessage(UserAccount userAccount) {
//
//    }
//
//    @Override
//    public boolean sendEmail(String to, String subject, String body) {
//        var email = new SimpleMailMessage();
//        email.setTo(to);
//        email.setFrom("Restaurant.catdogramb@gmail.com");
//        email.setSubject(subject);
//        email.setText(body);
//        try {
//            this.mailSender.send(email);
//            return true;
//        }
//        catch (MailException me){
//            me.printStackTrace();
//        }
//        return false;
//    }
//}
