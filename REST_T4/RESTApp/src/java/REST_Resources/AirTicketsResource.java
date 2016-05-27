/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST_Resources;

import Entities.credicard;
import Entities.flight;
import Entities.tickets;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import json.JSONArray;
import json.JSONObject;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("/airTickets")
public class AirTicketsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AirTicketsResource
     */
    public AirTicketsResource() {
    }

    @POST
    @Path("/airTicket")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String buyairTicket(String content) {
        ArrayList<tickets> listOfTickets = REST.ApplicationConfig.listOfTickets;
        ArrayList<flight> listOfFlights = REST.ApplicationConfig.listOfFlights;
        
        JSONObject jsonobj = new JSONObject(content);
        
        int code                = jsonobj.getInt("code");
        int type                = jsonobj.getInt("type");
        String beginDate        = jsonobj.getString("beginDate");
        String endDate          = jsonobj.getString("endDate");
        int numberOfPeople      = jsonobj.getInt("numberOfPeople");
        JSONArray jsonAge       = jsonobj.getJSONArray("age");
        int cardNumber          = jsonobj.getInt("cardNumber");
        String dateValid        = jsonobj.getString("dateValid");
        int secretNumber        = jsonobj.getInt("secretNumber");
        int parts               = jsonobj.getInt("parts");
        
        // parsing age
        int age[] = new int[jsonAge.length()];
        for(int i = 0; i < jsonAge.length(); i++) {
            age[i] = jsonAge.getInt(i);
        }
        
        String str = "";
        
        // some checks
        if (code >= listOfFlights.size()) {
            String s = "Flight does not exists!\n";
            System.out.println(s);
            return s;
        }
        
        flight fl = listOfFlights.get(code);
        int ret = fl.booking(numberOfPeople);
        if (ret == 1) {
            str += "[Server] Seats(s) not available at the moment\n";
            str += "[Server] Request has not been processed!\n";
        } else {
            credicard card = new credicard(cardNumber, dateValid, secretNumber);
            tickets tick = new tickets(code, type, fl.getFrom(), fl.getDestination(),
                                 beginDate, endDate, numberOfPeople,
                                 age, card, parts);
            listOfTickets.add(tick);
            str += "[Server] Ticket book has been processed\n";
            str += "[Server]:\n";
            str += tick.toString();
        }
        
        return str;
    }
    
    @GET
    @Path("/getBookedAirTickets")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTickets() {
        ArrayList<tickets> listOfTickets = REST.ApplicationConfig.listOfTickets;
        String str = "";
        for (int i = 0; i < listOfTickets.size(); i++) {
            str += "[Code = "+i+"] "+listOfTickets.get(i).toString();
        }
        return str;
    }
    
    @GET
    @Path("/getFlights")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFlights() {
        ArrayList<flight> listOfFlights = REST.ApplicationConfig.listOfFlights;
        String str = "";
        for (int i = 0; i < listOfFlights.size(); i++) {
            str += "[Code = "+i+"] "+listOfFlights.get(i).toString();
        }
        return str;
    }
}
