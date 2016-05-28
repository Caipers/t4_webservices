package REST;

import Entities.accommodation;
import Entities.flight;
import Entities.hotel;
import Entities.tickets;
import java.util.ArrayList;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * Jersey JAX-RS API RESTful Web Service Server for the 4th assigment of 
 * distributed
 * @author Samuel Pelegrinello Caipers
 * 
 */

// URL base for the other URIs Resources.
@javax.ws.rs.ApplicationPath("/REST_Resources")
public class ApplicationConfig extends Application {
    public static ArrayList<flight> listOfFlights                 = new ArrayList<>();
    public static ArrayList<hotel> listOfHotels                   = new ArrayList<>();
    public static ArrayList<tickets> listOfTickets                = new ArrayList<>();
    public static ArrayList<accommodation> listOfAccommodation    = new ArrayList<>();

    public ApplicationConfig() {
        // My initial "DB".
        listOfHotels.add(new hotel("ABC", "Curitiba", 50, 50));
        listOfHotels.add(new hotel("XYZ", "Sao Paulo", 70, 80));
        listOfHotels.add(new hotel("POI", "Sao Paulo", 30, 150));
        listOfHotels.add(new hotel("QWE", "Rio de Janeiro", 100, 30));

        listOfFlights.add(new flight("Curitiba", "Sao Paulo", 100, 130));
        listOfFlights.add(new flight("Sao Paulo", "Curitiba", 50, 100));
        listOfFlights.add(new flight("Curitiba", "Rio de Janeiro", 200, 160));
        listOfFlights.add(new flight("Rio de Janeiro", "Curitiba", 250, 150));      

    }
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(REST_Resources.AccomodationResource.class);
        resources.add(REST_Resources.AirTicketsResource.class);
    }
}