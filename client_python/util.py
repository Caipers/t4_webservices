# -*- coding: utf-8 -*-
import json
import requests

#Este arquivo tem métodos comuns as outras classes
#Este método converte a resposta recebioda pelo metodo exec_request para uma lista de JSONs


def request_to_json(response):
    if(response.status_code == 200):
        response_content_byte = response.content
        response_content_str = response_content_byte.decode('unicode_escape')
        response_content_json = json.loads(response_content_str)
        
        return response_content_json
    else:
        print("TENHO PROBLEMAS ", response.status_code)
        


#Este método imprime uma lista de JSONs na tela.



def exec_request(url, http_comand, json = None):
    if http_comand == "post":
        resposta = requests.post(url=url, json=json)
    if http_comand == "get":
        resposta = requests.get(url=url)
    if http_comand == "put":
        resposta = requests.put(url=url, json=json)
    if(resposta.status_code == 200):
        return resposta
    else:
        print("TENHO PROBLEMAS ", resposta.status_code)
