# -*- coding: utf-8 -*-

###############################################################################
# File that contains commom util functions to support other classes
###############################################################################

import json
import requests
import datetime

def validate(date):
    """
    Function that validates date in a specific format.
    """

    try:
        datetime.datetime.strptime(date, '%d/%m/%Y')
    except:
        raise ValueError("Incorrect data format, should be DD-MM-YYYY")

def exec_request(url, http_comand, json = None):
    """
    Function sends HTTP commands for the Java REST Webservice server.
    """

    if http_comand == "post":
        resposta = requests.post(url=url, json=json)
    elif http_comand == "get":
        resposta = requests.get(url=url)
    elif http_comand == "put":
        resposta = requests.put(url=url, json=json)
    else:
        print "Not supported HTTP Command!"

    if(resposta.status_code == 200):
        return resposta
    else:
        print("Error has occurred : ", resposta.status_code)