/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST_Resources;

import Entities.credicard;
import Entities.flight;
import Entities.tickets;
import java.rmi.RemoteException;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("/airTicket")
public class AirTicketResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AirTicketResource
     */
    public AirTicketResource() {
    }

    /**
     * Retrieves representation of an instance of REST_Resources.AirTicketResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String queryAirTickets()  {
//        interCli.echo("\nAir Flights:");
//        Iterator<flight> itr = listOfFlights.iterator();
//        int count = 0;
//        while (itr.hasNext()) {
//            flight elem = itr.next();
//            String aux = "Index: " + count +
//                         " From: " + elem.getFrom() +
//                         " Destination: " + elem.getDestination() +
//                         " Price: " + elem.getPrice();
//            interCli.echo(aux);
//            count++;
//        }
          return "dadsa";
    }

    /**
     * PUT method for updating or creating an instance of AirTicketResource
     * @param content representation for the resource
     */
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
//    public String buyAirTickets(int code, int type, String from, 
//                              String departure, String beginDate, String endDate, 
//                              int numberOfPeople, int age[], int cardNumber, 
//                              String dateValid, int secretNumber, int parts) {
        
    public String buyAirTickets() {
//        flight fl = listOfFlights.get(code);
//        int ret = fl.booking(numberOfPeople);
//        
//        if (ret == 1) {
//            interCli.echo("Seats not available at the moment");
//            interCli.echo("Request has not been processed!");
//        } else {
//            credicard card = new credicard(cardNumber, dateValid, secretNumber);
//            tickets tick = new tickets(code, type, from, departure,
//                                 beginDate, endDate, numberOfPeople,
//                                 age, card, parts);
//            listOfTickets.add(tick);
//            interCli.echo("\nTicket has been processed!");
//            interCli.echo(tick.toString());
//        }
        return "dadsa";
    }
}
