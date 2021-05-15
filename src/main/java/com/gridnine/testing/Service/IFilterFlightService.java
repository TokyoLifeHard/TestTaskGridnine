package com.gridnine.testing.Service;

import com.gridnine.testing.Entity.Flight;
import java.util.List;

public interface IFilterFlightService {

    List<Flight> getDepartureBeforeCurrentTime();

    List<Flight> getArrivalMoreThanDeparture();

    List<Flight> getFlightsThatStop(int filtredHours);

}
