# -*- coding: utf-8 -*-    

###############################################################################
# Class is used for easily built a JSON output to send it for the Java WEB 
# Service server.
###############################################################################

class accommodationDesire():
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
            "cardNumber":self.cardNumber, "dateValid":self.dateValid, 
            "secretNumber":self.secretNumber, "parts":self.parts}
