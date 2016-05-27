# -*- coding: utf-8 -*-    

#Esta classe representa um desejo de hospedagem, onde referencia o local da hospedagem o período e a quantidade de quartos

import json

class accommodationDesire(object):
    def __init__(self, code, destination, beginDate, 
             endDate, numberPerson, age, cardNumber, 
             dateValid, secretNumber, parts):
        self.code           = code;
        self.destination    = destination;
        self.beginDate      = beginDate;
        self.endDate        = endDate;
        self.numberPerson   = numberPerson;
        self.age            = age;
        self.cardNumber     = cardNumber;
        self.dateValid      = dateValid;
        self.secretNumber   = secretNumber;
        self.parts          = parts;
        
        
 
    #Este método retorna esta classe em formato JSON.
    def to_JSON(self):
        return {"code":self.code, "destination":self.destination, "beginDate":self.beginDate, 
                "endDate":self.endDate, "numberPerson":self.numberPerson, "age":self.age,
                "cardNumber":self.cardNumber, "dateValid":self.dateValid, "secretNumber":self.secretNumber,
                "parts":self.parts}
