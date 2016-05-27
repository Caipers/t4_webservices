# -*- coding: utf-8 -*-    

class airFlightTicketsDesire():
    def __init__(self, code, type_, beginDate, 
             endDate, numberOfPeople, age, cardNumber, 
             dateValid, secretNumber, parts):
        self.code           = code;
        self.type_          = type_;
        self.beginDate      = beginDate;
        self.endDate        = endDate;
        self.numberOfPeople = numberOfPeople;
        self.age            = age;
        self.cardNumber     = cardNumber;
        self.dateValid      = dateValid;
        self.secretNumber   = secretNumber;
        self.parts          = parts;
        
    def to_JSON(self):
        return {"code":self.code, "type":self.type_,"beginDate":self.beginDate, 
                "endDate":self.endDate, "numberOfPeople":self.numberOfPeople, "age":self.age,
                "cardNumber":self.cardNumber, "dateValid":self.dateValid, "secretNumber":self.secretNumber,
                "parts":self.parts}