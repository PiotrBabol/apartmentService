package com.apartmentService.apartment.service;

import com.apartmentService.apartment.exporters.ExporterPDF;
import com.apartmentService.apartment.repository.ApartmentRepository;
import com.itextpdf.text.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExportService {

    @Autowired
    ApartmentRepository apartmentRepository;

    public byte[] export() {
        List entitiesTemp = new List(List.ORDERED);
        apartmentRepository.findAll().stream().forEach(n -> entitiesTemp.add(String.valueOf(n)));
        byte[] result = new byte[0];
        try {
            result = ExporterPDF.process(entitiesTemp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
