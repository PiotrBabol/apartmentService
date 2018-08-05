package com.apartmentService.exporters;

import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;

@Component
public class ExporterPDF {
    @Value("pdfgenerator.path")
    private static  String file ;
    public static  void Process(List entities ) throws Exception {

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Apartments.pdf"));
        document.open();
        document.addTitle("Apartments data");
        document.addAuthor("Jacek");
        entities.size();
        document.add(entities);
        document.close();
    }
//    public static void main(String[] args) throws Exception {
//
//        ApartmentModel apartmentModel = new ApartmentModel(1L,new Date(118,07,22), 2000, 4, 60, "Lodzkie", "Lodz", TypeOfProperty.APARTMENT, Seller.AGENCY,null);
//        ApartmentModel apartmentModel1 = new ApartmentModel(2L,new Date(118,07,22), 1000, 3, 36, "Lodzkie", "Pabianice", TypeOfProperty.APARTMENT, Seller.OWNER,null);
//        List entitiesTemp = new List(List.ORDERED);
//        entitiesTemp.add(new ListItem(apartmentModel.toString()));
//        entitiesTemp.add(new ListItem(apartmentModel1.toString()));
//        System.out.println(apartmentModel);
//        System.out.println(apartmentModel.toString());
//
//        Process(entitiesTemp);
//
//    }
}
