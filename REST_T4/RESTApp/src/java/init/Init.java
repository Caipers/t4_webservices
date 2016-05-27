/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import Entities.accommodation;
import Entities.flight;
import Entities.hotel;
import Entities.tickets;
import java.util.ArrayList;

/**
 *
 * @author Samuel P. Caipers
 */
public class Init {
    public ArrayList<flight> listOfFlights                 = new ArrayList<>();
    public ArrayList<hotel> listOfHotels                   = new ArrayList<>();
    public ArrayList<tickets> listOfTickets                = new ArrayList<>();
    public ArrayList<accommodation> listOfAccommodation    = new ArrayList<>();
    
    public Init() {
        
    }
    
    public void initAccomodation() {
        listOfHotels.add(new hotel("ABC", "Curitiba", 50, 50));
        listOfHotels.add(new hotel("XYZ", "São Paulo", 70, 80));
        listOfHotels.add(new hotel("POI", "São Paulo", 30, 150));
        listOfHotels.add(new hotel("QWE", "Rio de Janeiro", 100, 30));
    }
    
    public void initFlight() {
        listOfFlights.add(new flight("Curitiba", "São Paulo", 100, 130));
        listOfFlights.add(new flight("São Paulo", "Curitiba", 50, 100));
        listOfFlights.add(new flight("Curitiba", "Rio de Janeiro", 200, 160));
        listOfFlights.add(new flight("Rio de Janeiro", "Curitiba", 250, 150));        
    }
}
