/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entities;

/**
 *
 * @author Samuel
 */
public class accommodationDesire {
    public int code;
    public String destination;
    public String beginDate;
    public String endDate;
    public int numberPerson;
    public int age[];
    public int cardNumber;
    public String dateValid;
    public int secretNumber;
    public int parts;
    
    public accommodationDesire(int code, String destination, String beginDate, 
             String endDate, int numberPerson, int age[], int cardNumber, 
             String dateValid, int secretNumber, int parts) {
        this.code           = code;
        this.destination    = destination;
        this.beginDate      = beginDate;
        this.endDate        = endDate;
        this.numberPerson   = numberPerson;
        this.age            = age;
        this.cardNumber     = cardNumber;
        this.dateValid      = dateValid;
        this.secretNumber   = secretNumber;
        this.parts          = parts;
    }
}    
