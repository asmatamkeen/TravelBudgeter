package logic;

import java.util.*;
import model.Hotel;
import model.Plan;

public class HotelManager {

    private Map<String, List<Hotel>> cityHotels;

    public HotelManager() {
        cityHotels = new HashMap<>();

        // PARIS
        // PARIS
        List<Hotel> parisHotels = new ArrayList<>();

        parisHotels.add(new Hotel(
                "Hotel Lumiere",
                120, "Free WiFi, Breakfast",
                200, "WiFi, Breakfast, City View Room",
                350, "All Meals, Eiffel Tower View, Airport Pickup"
        ));

        parisHotels.add(new Hotel(
                "Grand Paris Stay",
                100, "WiFi",
                180, "WiFi, Breakfast Buffet",
                320, "All Meals, River Cruise Access"
        ));

        parisHotels.add(new Hotel(
                "Royal Seine Hotel",
                150, "WiFi, Complimentary Coffee",
                240, "Breakfast, Balcony Room",
                400, "Suite Room, Dinner, Spa Access"
        ));

        cityHotels.put("Paris", parisHotels);


// NEW YORK
        List<Hotel> nyHotels = new ArrayList<>();

        nyHotels.add(new Hotel(
                "Manhattan Elite",
                180, "WiFi",
                280, "WiFi, Breakfast",
                450, "Suite, Times Square View, Airport Transfer"
        ));

        nyHotels.add(new Hotel(
                "Central Park Inn",
                160, "WiFi, Coffee",
                260, "Breakfast, Park View",
                420, "All Meals, Guided City Tour"
        ));

        nyHotels.add(new Hotel(
                "Empire Stay",
                140, "WiFi",
                230, "WiFi, Breakfast",
                390, "Suite, Rooftop Access, Dinner"
        ));

        cityHotels.put("New York", nyHotels);


// LONDON
        List<Hotel> londonHotels = new ArrayList<>();

        londonHotels.add(new Hotel(
                "Royal London Hotel",
                130, "WiFi",
                220, "Breakfast, Tea Service",
                360, "All Meals, London Eye Tickets"
        ));

        londonHotels.add(new Hotel(
                "Thames View Stay",
                110, "WiFi",
                190, "Breakfast Buffet",
                330, "River View Room, Dinner"
        ));

        londonHotels.add(new Hotel(
                "Crown Palace London",
                170, "WiFi, Coffee",
                260, "Breakfast, Balcony",
                420, "Suite, Spa, City Tour"
        ));

        cityHotels.put("London", londonHotels);


// SINGAPORE
        List<Hotel> singaporeHotels = new ArrayList<>();

        singaporeHotels.add(new Hotel(
                "Marina Bay Suites",
                150, "WiFi",
                240, "Breakfast, Pool Access",
                380, "Infinity Pool, All Meals, City Tour"
        ));

        singaporeHotels.add(new Hotel(
                "Orchard Grand",
                140, "WiFi",
                230, "Breakfast Buffet",
                360, "Suite, Dinner, Airport Pickup"
        ));

        singaporeHotels.add(new Hotel(
                "Lion City Hotel",
                120, "WiFi",
                200, "Breakfast",
                340, "All Meals, Universal Studios Tickets"
        ));

        cityHotels.put("Singapore", singaporeHotels);
        cityHotels.put("Singapore", singaporeHotels);
    }

    public String[] getCities() {
        return new String[]{"Paris", "New York", "London", "Singapore"};
    }

    public List<Hotel> getHotelsByCity(String city) {
        return cityHotels.getOrDefault(city, new ArrayList<>());
    }
}