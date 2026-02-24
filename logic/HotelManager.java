package logic;

import model.Hotel;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelManager {

    private static HashMap<String, ArrayList<Hotel>> hotelData = new HashMap<>();

    static {

        // Paris
        ArrayList<Hotel> parisHotels = new ArrayList<>();
        parisHotels.add(new Hotel("Eiffel Stay", 120));
        parisHotels.add(new Hotel("Paris Luxury Inn", 200));
        parisHotels.add(new Hotel("Budget Paris Lodge", 80));
        hotelData.put("Paris", parisHotels);

        // London
        ArrayList<Hotel> londonHotels = new ArrayList<>();
        londonHotels.add(new Hotel("Royal London Hotel", 150));
        londonHotels.add(new Hotel("Thames View Inn", 220));
        londonHotels.add(new Hotel("London Budget Stay", 90));
        hotelData.put("London", londonHotels);

        // Madrid
        ArrayList<Hotel> madridHotels = new ArrayList<>();
        madridHotels.add(new Hotel("Madrid Central", 110));
        madridHotels.add(new Hotel("Royal Madrid Palace", 180));
        madridHotels.add(new Hotel("Budget Madrid Lodge", 70));
        hotelData.put("Madrid", madridHotels);

        // New York
        ArrayList<Hotel> nyHotels = new ArrayList<>();
        nyHotels.add(new Hotel("NY Grand Hotel", 250));
        nyHotels.add(new Hotel("Manhattan Stay", 300));
        nyHotels.add(new Hotel("NY Budget Inn", 150));
        hotelData.put("New York", nyHotels);

        // Los Angeles
        ArrayList<Hotel> laHotels = new ArrayList<>();
        laHotels.add(new Hotel("LA Sunset Hotel", 200));
        laHotels.add(new Hotel("Hollywood Palace", 280));
        laHotels.add(new Hotel("LA Budget Stay", 130));
        hotelData.put("Los Angeles", laHotels);
    }

    public static ArrayList<Hotel> getHotels(String city) {
        return hotelData.get(city);
    }
}