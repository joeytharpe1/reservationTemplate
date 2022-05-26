package com.genspark.backend.service;

import com.genspark.backend.entity.Reservation;
import com.genspark.backend.entity.UserAccount;
import com.genspark.backend.error.DataNotFoundException;

import java.util.List;

public interface ReservationService {


    List<Reservation> getReservations();

    Reservation getResById(Long reservationId) throws DataNotFoundException;

    Reservation addRes(Reservation reservation);

    Reservation updateRes(Reservation reservation, Long reservationId) throws DataNotFoundException;

    void deleteRes(Long reservationId) throws DataNotFoundException;

}
