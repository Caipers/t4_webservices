package Entities;

public class flight {
    private String from;
    private String destination;
    private float price;
    private int maxCapacity;
    private int seatsAvailable;
    
    /**
     * Flight class
     * @param from Starting city
     * @param destination Destination of the Flight
     * @param maxCapacity Max Capacity of the Flight
     * @param price Price of a seat
     */
    
    public flight(String from, String destination, int maxCapacity, float price) {
        this.from           = from;
        this.destination    = destination;
        this.price          = price;
        this.maxCapacity    = maxCapacity;
        this.seatsAvailable = maxCapacity;
    }
    
    public void setFrom(String from) {
        this.from = from;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    /**
     * 
     * @param tickets How many tickets wanted
     * @return 0 if OK or 1 o.w.
     */
    public int booking(int tickets) {
        if (tickets < seatsAvailable) {
            seatsAvailable -= tickets;
            return 0;
        } else {
            System.out.println("There is no enough seats available!");
            return 1;
        }
    }
    
    /**
     * 
     * @param number Number of seats to be freed
     * @return 0 if OK or 1 o.w.
     */
    public int free(int number) {
        if (seatsAvailable + number > maxCapacity) {
            System.out.println("Invalid free value!");
            return 1;
        } else {
            System.out.println("Seats has been freed");
            return 0;
        }
    }
    
    public String getFrom() {
        return from;
    }
    
    public String getDestination() {
        return destination;
    }
    
    public float getPrice() {
        return price;
    }
    
    public int getMaxCapacity() {
        return maxCapacity;
    }
    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    @Override
    public String toString() {
        String aux;
        aux = "From: " + from + 
              " Destination: " + destination +
              " Price: " + price +
              " Max Capacity: " + maxCapacity +
              " Seats Available: " + seatsAvailable + "\n";
        
        return aux;
    }
}