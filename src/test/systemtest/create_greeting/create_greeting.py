#!/usr/bin/env python3

import requests as req

if __name__ == "__main__":
    #melding = input("Skriv inn melding: ")
    #navn = input("Hilsen: ")

    with req.post("http://127.0.0.1:8080/greeting/",  verify=False,headers= {'Content-Type': 'application/json', 'Accept': 'text/plain'},
                  json= {'to':'john', 'message': '{}'.format("Merry christmas"), 'from':'santa'.format("navn")}) as response:
        print(response.status_code)