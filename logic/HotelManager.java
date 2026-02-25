package logic;

import model.Hotel;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {

    public String[] getCities() {
        return new String[]{
                "Paris",
                "London",
                "Madrid",
                "New York",
                "Los Angeles"
        };
    }

    public List<Hotel> getHotelsByCity(String city) {

        List<Hotel> hotels = new ArrayList<>();

        switch (city) {

            case "Paris":
                hotels.add(new Hotel("Hotel Lumiere", 4000, 7000, 10000));
                hotels.add(new Hotel("Eiffel Stay", 3500, 6000, 9000));
                hotels.add(new Hotel("Royal Paris Inn", 5000, 8500, 12000));
                break;

            case "London":
                hotels.add(new Hotel("London Bridge Hotel", 4500, 7500, 11000));
                hotels.add(new Hotel("Royal Thames", 4000, 7000, 10000));
                hotels.add(new Hotel("Oxford Suites", 3800, 6500, 9500));
                break;

            case "Madrid":
                hotels.add(new Hotel("Madrid Central", 3000, 5500, 8000));
                hotels.add(new Hotel("Plaza Inn", 3200, 6000, 8500));
                hotels.add(new Hotel("Sunset Madrid", 2800, 5000, 7500));
                break;

            case "New York":
                hotels.add(new Hotel("Manhattan Elite", 6000, 10000, 15000));
                hotels.add(new Hotel("Central Park Stay", 5500, 9000, 14000));
                hotels.add(new Hotel("NYC Comfort", 5000, 8500, 13000));
                break;

            case "Los Angeles":
                hotels.add(new Hotel("LA Sunset Hotel", 5000, 8500, 12000));
                hotels.add(new Hotel("Hollywood Stay", 4800, 8000, 11500));
                hotels.add(new Hotel("Beverly Suites", 6500, 11000, 16000));
                break;
        }

        return hotels;
    }
}