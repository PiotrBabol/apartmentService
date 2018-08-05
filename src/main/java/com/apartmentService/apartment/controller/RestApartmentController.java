package com.apartmentService.apartment.controller;

import com.apartmentService.apartment.DAO.LauncherJPA;
import com.apartmentService.apartment.model.ApartmentModel;
import com.apartmentService.apartment.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApartmentController {

    private static final String REST_PATH = "/rest";
    private static final String ADD_PATH = "/add";
    private static final String ADDMULTIPLE_PATH = "/addm";
    private static final String ALL_PATH = "/all";

    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    LauncherJPA jpa;

    @RequestMapping(REST_PATH)
    public ApartmentModel sample() {
        return new ApartmentModel();
    }

    @PostMapping(value = ADD_PATH)
    private ResponseEntity<ApartmentModel> save(@RequestBody ApartmentModel apartment) {
        apartmentRepository.save(apartment);
        return new ResponseEntity<>(apartment, HttpStatus.OK);
    }

    @PostMapping(value = ADDMULTIPLE_PATH)
    private ResponseEntity<ApartmentModel> savemultiple(@RequestBody List<ApartmentModel> apartments) {
        apartmentRepository.save(apartments);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = ALL_PATH)
    public ResponseEntity<List<ApartmentModel>> getApartments() {
        List<ApartmentModel> apartmentModels = apartmentRepository.findAll();
        return ResponseEntity.ok(apartmentModels);
    }






}
