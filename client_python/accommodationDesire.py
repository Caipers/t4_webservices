# -*- coding: utf-8 -*-    

class accommodationDesire(object):
    def __init__(self, code, beginDate, 
             endDate, numberPerson, age, cardNumber, 
             dateValid, secretNumber, parts):
        self.code           = code;
        self.beginDate      = beginDate;
        self.endDate        = endDate;
        self.numberPerson   = numberPerson;
        self.age            = age;
        self.cardNumber     = cardNumber;
        self.dateValid      = dateValid;
        self.secretNumber   = secretNumber;
        self.parts          = parts;
        
 
    def to_JSON(self):
        return {"code":self.code, "beginDate":self.beginDate, 
                "endDate":self.endDate, "numberPerson":self.numberPerson, "age":self.age,
                "cardNumber":self.cardNumber, "dateValid":self.dateValid, "secretNumber":self.secretNumber,
                "parts":self.parts}
