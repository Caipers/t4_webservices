# -*- coding: utf-8 -*-
import accomodationControl

class main():
    while True:
        print("What do you need?")
        print("[1] buy accommodation")
        print("[2] query accommodation")
        code = raw_input()
        
        if code == "":
            continue
        elif code == "1":
            accomodationControl.buy()
        elif code == "2":
            accomodationControl.get()
            