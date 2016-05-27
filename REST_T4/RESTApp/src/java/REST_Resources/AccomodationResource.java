/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST_Resources;

import Entities.accommodation;
import Entities.accommodationDesire;
import Entities.credicard;
import Entities.hotel;
import json.JSONObject;
import init.Init;
import java.util.ArrayList;
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
import json.JSONArray;
import REST.ApplicationConfig;


/**
 * REST Web Service
 *
 * @author root
 */
@Path("/accomodation")
public class AccomodationResource {
    @Context
    private UriInfo context;
    
//    Init init = new Init();
    /**
     * Creates a new instance of AccomodationResource
     */
//    public AccomodationResource() {
//        init.initAccomodation();
//        
//    }
    
        /**
     * PUT method for updating or creating an instance of AccomodationResource
     * @param JSONobj
     * @return 
     */
    @POST
    @Path("/buy")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String buyAccommodation(String content) {
        ArrayList<hotel> listOfHotels = REST.ApplicationConfig.listOfHotels;
        ArrayList<accommodation> listOfAccommodation = REST.ApplicationConfig.listOfAccommodation;
        
        System.out.println(content);
        System.out.println("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
        JSONObject jsonobj = new JSONObject(content);
        
        int code            = jsonobj.getInt("code");
        String destination  = jsonobj.getString("destination");
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
            str += "Room(s) not available at the moment\n";
            str += "Request has not been processed!\n";
        } else {
            credicard card = new credicard(cardNumber, dateValid, secretNumber);
            accommodation acc = new accommodation(ho, beginDate,
                endDate, numberPerson, age, card, parts);
            
            System.out.println(listOfAccommodation.size());
            listOfAccommodation.add(acc);
            System.out.println(listOfAccommodation.size());

            str += "Accommodation book has been processed\n";
            str += acc.toString();
        }
        return str;
    }


    /**
     * Retrieves representation of an instance of REST_Resources.AccomodationResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String queryAccommodation()  {
        ArrayList<accommodation> listOfAccommodation = REST.ApplicationConfig.listOfAccommodation;
        System.out.println(listOfAccommodation.size());
        return "\n"+listOfAccommodation.toString();
    }
}
