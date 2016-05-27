# -*- coding: utf-8 -*-
from accommodationDesire import accommodationDesire 
from util import exec_request, request_to_json, print_list, reservar



class buy():
    def __init__(self):
        print "buy"
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/buy"

        # code = int(raw_input("\nPlease press the code of the flight:"))
        # destination = raw_input("\nInform destination (Hotel or City):")
        # beginDate = raw_input("\nStart date:")
        # endDate = raw_input("\nFinal date:")
        # numberPerson = int(raw_input("\nInform number of rooms:"))
        # age = []

        # for i in xrange(0,numberPerson):
        #     age.append(int(raw_input("\nInform the age of client #"+str(i))))

        # print "\nInform the credicard information:"
        # cardNumber = int(raw_input("Credicard number:"))
        # dateValid = raw_input("\nValidity (mm/aaaa):")
        # secret = int(raw_input("\nInform the secret number:"))
        # parts = int(raw_input("\nInform how many months of paying:"))
        
        code = 1
        destination = "Sao Paulo"
        beginDate = "10/12/2016"
        endDate = "12/12/2016"
        numberPerson = 2
        age = [22, 23]
        cardNumber = 31232131
        dateValid = "12/2018"
        secret = 323
        parts = 1

        accDes = accommodationDesire(code, destination, beginDate, endDate, 
            numberPerson, age, cardNumber, dateValid, secret, parts)

        print accDes.to_JSON()

        response = exec_request(url, accDes.to_JSON(), "post")
        print "resposta: " + str(response.text)
        # list_hospedagem = request_to_json(response)

        # print_list(list_hospedagem)
        # nova_busca = False
        # while not(nova_busca):
        #     opc = input('Para escolher a hospedagem digite o c�digo. Para fazer uma nova busca digite N')
            
        #     if opc == 'N' or opc == 'n':
        #         nova_busca = True
        #     else:
        #         for lh in list_hospedagem:
        #             opc2 = int(opc)
        #             if opc2 == lh.get('codigo'):
        #                 reservar(opc, url)
        #                 break        


class get():
    def __init__(self):
        print "GET"
        url = "http://localhost:8080/RESTApp/REST_Resources/accomodation/get"

        response = exec_request(url, "bla", "get")
        print "resposta: " + str(response.text)