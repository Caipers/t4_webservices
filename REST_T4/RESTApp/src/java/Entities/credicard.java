package Entities;

public class credicard {
    private int number;
    private String dateValid;
    private int secretNumber;

    /**
     * Credicard class
     * @param number Credicard number
     * @param dateValid Credicard Validate
     * @param secretNumber Credicard secret number
     */
    
    public credicard(int number, String dateValid, int secretNumber) {
        this.number = number;
        this.dateValid = dateValid;
        this.secretNumber = secretNumber;
    }
    
    public int getNumber() {
        return number;
    }
}
