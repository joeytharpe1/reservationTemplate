package com.genspark.backend.service;

import com.genspark.backend.entity.Reservation;

import com.genspark.backend.error.DataNotFoundException;
import com.genspark.backend.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

//    @Autowired
//    private JavaMailSender mailSender;

    @Override
    public List<Reservation> getReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation getResById(Long reservationId) throws DataNotFoundException {
        Optional<Reservation> reservationOptional = reservationRepo.findById(reservationId);
        if(!reservationOptional.isPresent())
            throw new DataNotFoundException("user with id: " + reservationId + " not found");
        return reservationOptional.get();
    }

    @Override
    public Reservation addRes(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateRes(Reservation reservation, Long reservationId) throws DataNotFoundException {
        Optional<Reservation> reservationOptional = reservationRepo.findById(reservationId);
        if(!reservationOptional.isPresent())
            throw new DataNotFoundException("user with id: " + reservationId + " not found");

        Reservation reservationUpdated = reservationOptional.get();

        if(reservation.getDateTime() != null)
            reservationUpdated.setDateTime(reservation.getDateTime());
        if(reservation.getType() != null)
            reservationUpdated.setType(reservation.getType());
        if(reservation.getNumberOfGuests() != 0)
            reservationUpdated.setNumberOfGuests(reservation.getNumberOfGuests());
        if(reservation.getResName() != null)
            reservationUpdated.setResName(reservation.getResName());
        if(reservation.getResNumber() != null)
            reservationUpdated.setResNumber(reservation.getResNumber());

        return reservationRepo.save(reservationUpdated);
    }

    @Override
    public void deleteRes(Long reservationId) throws DataNotFoundException {
        Optional<Reservation> reservationOptional = reservationRepo.findById(reservationId);
        if(!reservationOptional.isPresent())
            throw new DataNotFoundException("user not found");
        reservationRepo.deleteById(reservationId);
    }


//    public void sendEmail(String address, String subject, String body) {
//        String from = "restaurant@restaurant.fake";
//        String to = address;
//
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(body);
//
//        mailSender.send(message);
//    }
}
