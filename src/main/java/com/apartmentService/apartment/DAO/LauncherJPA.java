package com.apartmentService.apartment.DAO;

import com.apartmentService.apartment.model.ApartmentModel;
import com.apartmentService.apartment.model.Seller;
import com.apartmentService.apartment.model.TypeOfProperty;
import com.apartmentService.apartment.repository.ApartmentRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.apartmentService.apartment.DAO.LauncherJPAConstants.*;

@Component
public class LauncherJPA {

    @Autowired
    ApartmentRepository apartmentRepository;

    public List<ApartmentModel> save() {

        org.jsoup.nodes.Document document;
        ApartmentModel apartmentModel = null;
        List<ApartmentModel> apartmentModels = null;
        try {
            apartmentModels = new ArrayList<>();
            document = Jsoup.connect(URL).get();
            Date date = new Date(new java.util.Date().getTime());
            Elements els = document.select(CSS_QUERY_DETAILS);
            for (Element el : els) {
                double price = 0.0;
                if (el.select(CSS_QUERY_PRICE).hasText()) {
                    price = Double.parseDouble(el.select(CSS_QUERY_PRICE).text().replace("zł", EMPTY_STRING).replace(SPACE, EMPTY_STRING));
                }
                String type = "APARTMENT";
                String seller = "OWNER";
                if (el.getElementsContainingOwnText(SEARCH_TEXT_TYPE).hasText()) {
                    type = String.valueOf(TypeOfProperty.check(el.getElementsContainingOwnText(ZABUDOWA).text().replaceAll(SEARCH_TEXT_TYPE, EMPTY_STRING).toUpperCase()));
                }
                int room = 0;
                int meters = 0;
                if (el.getElementsContainingOwnText(SEARCH_TEXT_POW).hasText()) {
                    meters = Integer.parseInt(el.getElementsContainingOwnText(SEARCH_TEXT_POW).text().replace(M_SQRD, EMPTY_STRING).replace(SEARCH_TEXT_POW, EMPTY_STRING));
                }
                if (el.getElementsContainingOwnText(SEARCH_TEXT_ROOM).hasText()) {
                    room = Integer.parseInt(el.getElementsContainingOwnText(SEARCH_TEXT_ROOM).text().replace(TARGET_ROOM_QNT, EMPTY_STRING));
                }
                String city = el.select(CSS_QUERY_CITY).text();
                String name = el.select(CSS_QUERY_TITLE).text();
                apartmentModel = new ApartmentModel(date, price, room, meters, name, city, TypeOfProperty.valueOf(type), Seller.valueOf(seller));
                if (apartmentRepository.findAllByNameAndDateOfPostage(apartmentModel.getName(), date).isEmpty()) {
                    apartmentModels.add(apartmentModel);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apartmentModels;
    }

}