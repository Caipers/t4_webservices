# -*- coding: utf-8 -*-

###############################################################################
# This is a Python REST WEB Service client for the 4th assigment of distributed 
# systems.
#
# Assigment: Arquitetura Cliente-Servidor Middleware para Comunicação entre 
#            Ambientes heterogêneos
# Creator: Samuel Pelegrinello Caipers (1097261)
# Professor: Ana Cristina B. Kochem Vendramin
###############################################################################

import accomodationControl
import airFlightTicketControl
import sys

class main():
    """
    Main class that receives user commands
    """
    
    while True:
        print("What do you need?")
        print("[1] buy an accommodation")
        print("[2] query hotels")
        print("[3] query accommodation")
        print("[4] buy a ticket")
        print("[5] query flights")
        print("[6] query airTickets booked")
        print("[0] exit")

        code = raw_input()
        
        if code == "":
            continue
        elif code == "1":
            accomodationControl.buyAccommodation()
        elif code == "2":
            accomodationControl.getHotels()
        elif code == "3":
            accomodationControl.getAccommodation()
        elif code == "4":
            airFlightTicketControl.buyFlightTicket()
        elif code == "5":
            airFlightTicketControl.getFlights()
        elif code == "6":
            airFlightTicketControl.getAirTicketsBooked()
        elif code == "0":
            sys.exit(0)