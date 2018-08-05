package com.apartmentService.apartment.exporters;

import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class ExporterPDF {
    @Value("pdfgenerator.path")
    private static  String file ;

    public static  byte[] process(List entities ) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        Document document = new Document(PageSize.LETTER, 0.75F, 0.75F, 0.75F, 0.75F);
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();
        document.add(entities);
        document.close();
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        return pdfBytes;
    }


}
