package com.cars.reto3.repository;

import com.cars.reto3.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Integer> {
    List<ReservationModel> findByStartDateBetween(Date stDate, Date edDate);

    Integer countByStatus(String status);
}
