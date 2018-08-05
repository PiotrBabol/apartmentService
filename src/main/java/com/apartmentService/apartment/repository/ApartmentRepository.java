package com.apartmentService.apartment.repository;

import com.apartmentService.apartment.model.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentModel,Long>{

    public List<ApartmentModel> findAllByNameAndDateOfPostage(String name, java.sql.Date dateOfPostage);

}
