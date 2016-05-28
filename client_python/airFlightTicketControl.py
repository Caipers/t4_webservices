# -*- coding: utf-8 -*-
from airFlightTicketsDesire import airFlightTicketsDesire 
from util import exec_request, validate


class buyFlightTicket():
    """
    Class that receive User information about flight tickets and
    send these information for the Java REST Web Service server
    in JSON format
    """

    def __init__(self):
        getFlights()

        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/airTicket"
        code = int(raw_input("\nPlease press the code of a Flight: "))
        type_ = int(raw_input("Press 1 to One-Way Ticket or 2 to Two-Way Ticket: "))

        if (type_ != 1 and type_ != 2):
            print "Invalid type of ticket!\n"
            return None

        try: 
            beginDate = raw_input("Start date (dd/mm/aaaa): ")
            validate(beginDate)
            endDate = raw_input("Final date (dd/mm/aaaa): ")
            validate(endDate)
        except ValueError:
            print "Incorrect data format, should be dd/mm/aaaa\n"
            return None

        numberOfPeople = int(raw_input("Inform number of seats: "))
        age = []

        for i in xrange(0, numberOfPeople):
            age.append(int(raw_input("Inform the age of client #"+str(i)+" ")))

        print "Inform the credicard information:"
        cardNumber = int(raw_input("Credicard number: "))
        dateValid = raw_input("Validity (mm/aaaa): ")
        secret = int(raw_input("Inform the secret number: "))
        parts = int(raw_input("Inform how many months of paying: "))
        
        ##########################
        # For testing purposes 
        # code = 1
        # type_ = 1
        # beginDate = "10/12/2016"
        # endDate = "12/12/2016"
        # numberOfPeople = 2
        # age = [22, 23]
        # cardNumber = 31232131
        # dateValid = "12/2018"
        # secret = 323
        # parts = 1
        ##########################

        airTicket = airFlightTicketsDesire(code, type_, beginDate, endDate, numberOfPeople, age, cardNumber, dateValid, secret, parts)

        response = exec_request(url, "post", json = airTicket.to_JSON())
        print str(response.text)


class getAirTicketsBooked():
    """
    Class that request air tickets records from Java 
    REST Web Service server in String format
    """
    
    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/getBookedAirTickets"

        response = exec_request(url, "get")
        print "airTickets booked:"
        print str(response.text)

class getFlights():
    """
    Class that request Flight records from Java 
    REST Web Service server in String format
    """

    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/getFlights"

        response = exec_request(url, "get")
        print "Flights Available:"
        print str(response.text)