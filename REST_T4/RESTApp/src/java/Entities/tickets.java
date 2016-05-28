package Entities;

public class tickets {
    private int code;
    private int type;
    private String from;
    private String depature;
    private String beginDate;
    private String endDate;
    private int numberOfPeople;
    private int age[];
    private credicard card;
    private int parts;
    
    /**
     * 
     * @param code The Flight's Code
     * @param type Type of the ticket 
     * @param from Starting city
     * @param departure End city
     * @param beginDate The start date of the trip
     * @param endDate The end date of the trip
     * @param numberOfPeople Number of tickets
     * @param age Age of these people
     * @param card Credicard object
     * @param parts How many monthly payment
     */
    
    public tickets(int code, int type, String from, 
                   String departure, String beginDate, String endDate, 
                   int numberOfPeople, int age[], credicard card, int parts) {
        this.code = code;
        this.type = type;
        this.from = from;
        this.depature = departure;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.numberOfPeople = numberOfPeople;
        this.age = age;
        this.card = card;
        this.parts = parts;
    }
    
    public String toString() {
        String aux;
        aux =  "\nCode: " + code + 
               " Type: " + type + 
               " From: " + from + 
               " Departure: " + depature + 
               " Begin Date: " + beginDate + 
               " End Date: " + endDate + 
               " Number of People: " + numberOfPeople +
               " Ages: [ ";
        for(int i = 0; i < numberOfPeople; i++) {
            aux += age[i] + " ";
        }
        aux += "]";
        
        aux += " Card: " + card.getNumber() + 
               " Parts: " + parts + "\n";
        return aux;
    }
}