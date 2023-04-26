package com.cars.reto3.repository;

import com.cars.reto3.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Integer> {

    /*
    * @Query(value= "")
    * */
    List<CarModel> findByBrand(String brand);

}
