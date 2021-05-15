package com.gridnine.testing;

import com.gridnine.testing.Builders.FlightBuilder;
import com.gridnine.testing.Entity.Flight;
import com.gridnine.testing.Service.FilterFlightServiceImp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightBuilder.createFlights().stream().forEach(System.out::println);
        System.out.print("_________________________________________________________________________________________");
        System.out.print("_________________________________________________________________________________________");
        System.out.println();

        FilterFlightServiceImp flightServiceImp = new FilterFlightServiceImp(FlightBuilder.createFlights());
        List<Flight> flights = flightServiceImp.getDepartureBeforeCurrentTime();
        flights.stream().forEach(System.out::println);
        System.out.print("_________________________________________________________________________________________");
        System.out.print("_________________________________________________________________________________________");
        System.out.println();

        List<Flight> flights2 = flightServiceImp.getFlightsThatStop(2);
        flights2.stream().forEach(System.out::println);
        System.out.print("_________________________________________________________________________________________");
        System.out.print("_________________________________________________________________________________________");
        System.out.println();

        List<Flight> flights3 = flightServiceImp.getArrivalMoreThanDeparture();
        flights3.stream().forEach(System.out::println);
        System.out.print("_________________________________________________________________________________________");
        System.out.print("_________________________________________________________________________________________");
        System.out.println();
    }
}
