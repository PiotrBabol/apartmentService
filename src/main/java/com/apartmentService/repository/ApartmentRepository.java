package com.apartmentService.repository;

import com.apartmentService.model.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentModel,Long>{

}
