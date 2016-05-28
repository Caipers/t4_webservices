# -*- coding: utf-8 -*-
from accommodationDesire import accommodationDesire 
from util import exec_request, validate

class buyAccommodation():
    """
    Class that receive User information about accomodation and
    send these information for the Java REST Web Service server
    in JSON format
    """

    def __init__(self):
        getHotels()

        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/buyAccomodation"
        code = int(raw_input("\nPlease press the code of the Hotel: "))
        try: 
            beginDate = raw_input("Start date (dd/mm/aaaa): ")
            validate(beginDate)
            endDate = raw_input("Final date (dd/mm/aaaa): ")
            validate(endDate)
        except ValueError:
            print "Incorrect data format, should be dd/mm/aaaa\n"
            return None
        numberPerson = int(raw_input("Inform number of rooms: "))
        age = []

        for i in xrange(0, numberPerson):
            age.append(int(raw_input("Inform the age of client #"+str(i)+" ")))

        print "Inform the credicard information:"
        cardNumber = int(raw_input("Credicard number: "))
        dateValid = raw_input("Validity (mm/aaaa): ")
        secret = int(raw_input("Inform the secret number: "))
        parts = int(raw_input("Inform how many months of paying: "))
        
        ##########################
        # For testing purposes 
        # code = 1
        # destination = "Sao Paulo"
        # beginDate = "10/12/2016"
        # endDate = "12/12/2016"
        # numberPerson = 2
        # age = [22, 23]
        # cardNumber = 31232131
        # dateValid = "12/2018"
        # secret = 323
        # parts = 1
        ##########################

        accDes = accommodationDesire(code, beginDate, endDate, 
            numberPerson, age, cardNumber, dateValid, secret, parts)

        response = exec_request(url, "post", json = accDes.to_JSON())
        print str(response.text)
        

class getAccommodation():
    """
    Class that request accommodation records from Java 
    REST Web Service server in String format
    """

    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/getAccomodations"

        response = exec_request(url, "get")
        print "Accomodation records:"
        print str(response.text)

class getHotels():
    """
    Class that request hotel records from Java 
    REST Web Service server in String format
    """

    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/getHotels"

        response = exec_request(url, "get")
        print "Hotel records:"
        print str(response.text)