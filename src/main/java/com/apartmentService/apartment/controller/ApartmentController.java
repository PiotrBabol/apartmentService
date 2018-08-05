package com.apartmentService.apartment.controller;

import com.apartmentService.apartment.DAO.LauncherJPA;
import com.apartmentService.apartment.repository.ApartmentRepository;
import com.apartmentService.apartment.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.apartmentService.apartment.controller.ApartmentContorllerConstants.*;


@Controller
public class ApartmentController {

    @Autowired
    ApartmentRepository apartmentRepository;
    @Autowired
    LauncherJPA jpa;
    @Autowired
    ExportService service;

    @GetMapping(DEFAULT_PATH)
    public String introductoryPage() {
        return DEFAULT_PAGE;
    }

    @GetMapping(value = READ_APARTMENTS_PATH)
    public String savetest() {
        apartmentRepository.save(jpa.save());
        return REDIRECT_TO_JSON_ALL_LIST;
    }

    @GetMapping(LOGIN_PATH)
    public String login() {
        return LOGIN_PAGE;
    }

    @GetMapping(ADMIN_PATH)
    public String admin() {
        return ADMIN_PAGE;
    }

    @GetMapping(EXPORT_PATH)
    public String export() {
        return REDIRECT_PDFREPORT;
    }

    @RequestMapping(value = PDFREPORT_PATH, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] citiesReport() {
        return service.export();
    }


}
