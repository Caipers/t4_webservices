# -*- coding: utf-8 -*-
from airFlightTicketsDesire import airFlightTicketsDesire 
from util import exec_request


class buyFlightTicket():
    def __init__(self):
        # getHotels()

        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/airTicket"

        # code = int(raw_input("\nPlease press the code of the Hotel: "))
        # type_ = int(raw_input("Press 1 to One-Way Ticket or 2 to Two-Way Ticket: "))

        # # destination = raw_input("\nInform destination (Hotel or City):")
        # beginDate = raw_input("Start date (dd/mm/aaaa): ")
        # endDate = raw_input("Final date (dd/mm/aaaa): ")
        # numberOfPeople = int(raw_input("Inform number of rooms: "))
        # age = []

        # for i in xrange(0, numberPerson):
        #     age.append(int(raw_input("Inform the age of client #"+str(i)+" ")))

        # print "Inform the credicard information:"
        # cardNumber = int(raw_input("Credicard number: "))
        # dateValid = raw_input("Validity (mm/aaaa): ")
        # secret = int(raw_input("Inform the secret number: "))
        # parts = int(raw_input("Inform how many months of paying: "))
        
        code = 1
        type_ = 1
        beginDate = "10/12/2016"
        endDate = "12/12/2016"
        numberPerson = 2
        age = [22, 23]
        cardNumber = 31232131
        dateValid = "12/2018"
        secret = 323
        parts = 1

        airTicket = airFlightTicketsDesire(code, type_, beginDate, endDate, numberPerson, age, cardNumber, dateValid, secret, parts)

        response = exec_request(url, "post", json = airTicket.to_JSON())
        print str(response.text)

class getAirTicketsBooked():
    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/getBookedAirTickets"

        response = exec_request(url, "get")
        print "airTickets booked:"
        print str(response.text)

class getFlights():
    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/airTickets/getFlights"

        response = exec_request(url, "get")
        print "Flights Available:"
        print str(response.text)