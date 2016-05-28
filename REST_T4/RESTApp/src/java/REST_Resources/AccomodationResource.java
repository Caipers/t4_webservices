package REST_Resources;

import Entities.accommodation;
import Entities.credicard;
import Entities.hotel;
import json.JSONArray;
import json.JSONObject;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Samuel Pelegrinello Caipers
 */
@Path("/accomodation")
public class AccomodationResource {
    @Context
    private UriInfo context;
    
    
    /**
     * Retrieves representation of an instance of REST_Resources.AccomodationResource
     * @param content A JSON Object
     * @return String response
     */
    @POST
    @Path("/buyAccomodation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String buyAccommodation(String content) {
        ArrayList<hotel> listOfHotels                = REST.ApplicationConfig.listOfHotels;
        ArrayList<accommodation> listOfAccommodation = REST.ApplicationConfig.listOfAccommodation;
        
        JSONObject jsonobj = new JSONObject(content);
        
        // parsing the JSON Object
        int code            = jsonobj.getInt("code");
        String beginDate    = jsonobj.getString("beginDate");
        String endDate      = jsonobj.getString("endDate");
        int numberPerson    = jsonobj.getInt("numberPerson");
        JSONArray jsonAge   = jsonobj.getJSONArray("age");
        int cardNumber      = jsonobj.getInt("cardNumber");
        String dateValid    = jsonobj.getString("dateValid");
        int secretNumber    = jsonobj.getInt("secretNumber");
        int parts           = jsonobj.getInt("parts");

        // parsing age
        int age[] = new int[jsonAge.length()];
        for(int i = 0; i < jsonAge.length(); i++) {
            age[i] = jsonAge.getInt(i);
        }
        
        String str = "";
        
        // some checks
        if (code >= listOfHotels.size()) {
            String s = "Hotel does not exists!\n";
            System.out.println(s);
            return s;
        }
        
        hotel ho = listOfHotels.get(code);
        int ret = ho.booking(numberPerson);
        if (ret == 1) {
            str += "[Server] Room(s) not available at the moment\n";
            str += "[Server] Request has not been processed!\n";
        } else {
            credicard card = new credicard(cardNumber, dateValid, secretNumber);
            accommodation acc = new accommodation(ho, beginDate,
                endDate, numberPerson, age, card, parts);
            
            System.out.println(listOfAccommodation.size());
            listOfAccommodation.add(acc);
            System.out.println(listOfAccommodation.size());
            
            str += "[Server] Accommodation book has been processed\n";
            str += "[Server]:\n";
            str += acc.toString();
        }
        return str;
    }

    /**
     * Retrieves representation of an instance of REST_Resources.AccomodationResource
     * @return a String response
     */
    @GET
    @Path("/getAccomodations")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAccommodation()  {
        ArrayList<accommodation> listOfAccommodation = REST.ApplicationConfig.listOfAccommodation;
        String str = "";
        for (int i = 0; i < listOfAccommodation.size(); i++) {
            str += "[Code = "+i+"] "+listOfAccommodation.get(i).toString();
        }
        return str;
    }
    
    /**
     * Retrieves representation of an instance of REST_Resources.AccomodationResource
     * @return a String response
     */
    @GET
    @Path("/getHotels")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHotels()  {
        ArrayList<hotel> listOfHotels = REST.ApplicationConfig.listOfHotels;
        String str = "";
        for (int i = 0; i < listOfHotels.size(); i++) {
            str += "[Code = "+i+"] "+listOfHotels.get(i).toString();
        }
        return str;
    }
}
