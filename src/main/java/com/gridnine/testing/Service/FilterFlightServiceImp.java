package com.gridnine.testing.Service;

import com.gridnine.testing.Entity.Flight;
import com.gridnine.testing.Entity.Segment;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightServiceImp implements IFilterFlightService{

    private final List<Flight> flights;

    public FilterFlightServiceImp(List<Flight> flights) {
        this.flights = flights;
    }


    @Override
    public List<Flight> getDepartureBeforeCurrentTime() {
        List<Flight> filtredFlights = new ArrayList<Flight>();

        for (Flight flight : this.flights) {
            if(flight.getSegments().size()>1){
                for (Segment segment: flight.getSegments()){
                    if (segment.getDepartureDate().isBefore(LocalDateTime.now())){
                        filtredFlights.add(flight);
                    }
                }
            }else {
                Segment segment = flight.getSegments().get(0);
                if(segment.getDepartureDate().isBefore(LocalDateTime.now())){
                    filtredFlights.add(flight);
                }
            }
        }

        return filtredFlights;
    }

    @Override
    public List<Flight> getArrivalMoreThanDeparture() {
        List<Flight> filtredFilghts = new ArrayList<>();
        for(Flight flight:this.flights){
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size(); i++) {
                LocalDateTime arrDate = segments.get(i).getArrivalDate();
                LocalDateTime depDate = segments.get(i).getDepartureDate();
                if(arrDate.compareTo(depDate)<0){
                    filtredFilghts.add(flight);
                }
            }
        }

        return filtredFilghts;
    }

    @Override
    public List<Flight> getFlightsThatStop(int filtredHours) {

        if (filtredHours<0){
            return null;
        }

        List<Flight> filtredFlights = new ArrayList<>();

        for (Flight flight:this.flights){
            List<Segment> segments = flight.getSegments();
            int hours = 0;
               for (int i = 1; i<flight.getSegments().size();i++){
                   Segment seg1 = segments.get(i);
                   Segment seg2 = segments.get(i-1);
                   hours += seg1.getDepartureDate().getHour()-seg2.getArrivalDate().getHour();
               }
               if (hours<filtredHours){
                   filtredFlights.add(flight);
               }
        }


        return filtredFlights;
    }


}
