__BANGLADESH UNIVERSITY OF ENGINEERING AND TECHNOLOGY__

_Department of Computer Science and Engineering_

January 2024 __CSE 214__

_Offline Assignment on_

--------------------------Creational Design Patterns--------------------------


**Problem 1:**

Consider a company producing public transport ticketing systems which are commonly used in metro systems. The system consists of a hardware device and a web server for the administrator. Passengers provide necessary information on the screen including the destination and the number of tickets from which the ticket price is determined. After the customer completes the payment, the tickets are issued to them. The admin can manage passenger data and track trips on the web. The major components of the system are described as follows:

1. **Display Unit:**
   1. **Microcontroller/Microprocessor**: You can choose any of ATMega32, Arduino Mega or Raspberry Pi around which the device will be built.
   2. **Display:** There are several options such as touch screen display, OLED display, LED or LCD display.
2. **Ticketing/Identification**: ATMega32 and Arduino will utilize RFID cards, while Raspberry Pi will use NFC cards for identification.
3. **Payment Terminal:** This will manage on-spot payment, collect and store cash and provide change to the passengers if needed.
4. **Internet connection:** WiFi or GSM modules can be used with ATMega32 or Arduino Mega. Raspberry Pi supports Ethernet too. Client i/p
5. **Storage:** If Raspberry Pi is used, storage will be provided along with it. ATMega32 and Arduino will be interfaced with an SD card.
6. **Controller:** The touch screen of the Raspberry Pi works as a controller. A separate controller unit is needed for the other options.
7. **Web Server:** The web server can be developed with any of the four frameworks: Django, NodeJS or Ruby. Client i/p

The company offers four packages. Client i/p

| **Package** | **Details**                            |
| ----------- | -------------------------------------- |
| Basic       | ATMega32 with LCD display              |
| Standard    | Arduino Mega with LED display          |
| Advanced    | Raspberry Pi with OLED display         |
| Premium     | Raspberry Pi with touch screen display |

The client would choose a package, mention how the device would be connected to the internet (WiFi, Ethernet or SIM card) and choose a framework for the web server. You have to create and print the details of the system.

**Tasks:**

- Identify the design pattern(s) that can best capture the scenario above. Implement the scenario in Java. **Note that, the scenario may require multiple design patterns. You may have to apply two different design patterns for building the ticketing system and managing customer choices related to packages, internet options and frameworks.**
- For demonstration, the user would be prompted to give input on the console and based on the choice, the details (name of the specific components) of the created system would be shown on the console.
- You just need to implement the structure. For example, you do not need to implement how microprocessors would work. You just need to create appropriate classes and functions to just print “ATMega32/Arduino Mega has been added to the system”

**Problem 2:**

You are tasked with designing a system for a bank that offers multiple services. For now, we are considering two major operations: loan and savings account operations. The bank has three customer types: Regular, Premium and VIP. The payment schemes and interest types vary based on the customer type. The interest rates for different customers are shown in the following table.

<table><tr><th colspan="1" rowspan="2" valign="top">Operation</th><th colspan="3" valign="top">Interest rate</th></tr>
<tr><td colspan="1" valign="top">Regular</td><td colspan="1" valign="top">Premium</td><td colspan="1" valign="top">VIP</td></tr>
<tr><td colspan="1" valign="top">Accounts</td><td colspan="1" valign="top">2.5%</td><td colspan="1" valign="top">3.5%</td><td colspan="1" valign="top">5%</td></tr>
<tr><td colspan="1" valign="top">Loan</td><td colspan="1" valign="top">14%</td><td colspan="1" valign="top">12%</td><td colspan="1" valign="top">10%</td></tr>
</table>

**Tasks:**

- Identify the design pattern(s) that can best capture the scenario.
- Implement the appropriate classes. The loan and account classes must contain functions that calculate the total interest given a certain period of time. You may use simple or compound interest formulas.
- A simple demonstration showing a user utilizing these functionalities would suffice.

**Guideline:**

1. **The main objective of this assignment is to evaluate your design pattern skills. We will evaluate you based on how you have applied your design pattern knowledge to solve the problems. Printing the correct output is necessary but not sufficient and will not ensure full marks.**
1. Put all the source files in a directory and rename it with your 7-digit student ID. Zip this directory and rename it with your 7-digit student ID. Finally, submit the Zip file (e.g.2105XXX.zip)
1. Please DO NOT COPY solutions from anywhere (e.g., your friends, seniors, internet). Any form of plagiarism, irrespective of source or destination, will result in -100% marks in the online/offline.
1. Deadline: 11.55 PM, September 20, 2024
1. For any query, contact: <amsrumi@gmail.com>
