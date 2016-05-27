# -*- coding: utf-8 -*-
from accommodationDesire import accommodationDesire 
from util import exec_request



class buyAccomodation():
    def __init__(self):
        getHotels()

        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/buyAccomodation"

        code = int(raw_input("\nPlease press the code of the Hotel: "))
        # destination = raw_input("\nInform destination (Hotel or City):")
        beginDate = raw_input("Start date (dd/mm/aaaa): ")
        endDate = raw_input("Final date (dd/mm/aaaa): ")
        numberPerson = int(raw_input("Inform number of rooms: "))
        age = []

        for i in xrange(0, numberPerson):
            age.append(int(raw_input("Inform the age of client #"+str(i)+" ")))

        print "Inform the credicard information:"
        cardNumber = int(raw_input("Credicard number: "))
        dateValid = raw_input("Validity (mm/aaaa): ")
        secret = int(raw_input("Inform the secret number: "))
        parts = int(raw_input("Inform how many months of paying: "))
        
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

        accDes = accommodationDesire(code, beginDate, endDate, 
            numberPerson, age, cardNumber, dateValid, secret, parts)

        response = exec_request(url, "post", json = accDes.to_JSON())
        print str(response.text)
        

class getAccomodations():
    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/getAccomodations"

        response = exec_request(url, "get")
        print "Accomodations rented:"
        print str(response.text)

class getHotels():
    def __init__(self):
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/getHotels"

        response = exec_request(url, "get")
        print "Hotels Available:"
        print str(response.text)

