**Problem 1:**

Consider a company producing public transport ticketing systems which are commonly used in metro systems. The system consists of a hardware device and a web server for the administrator. Passengers provide necessary information on the screen including the destination and the number of tickets from which the ticket price is determined. After the customer completes the payment, the tickets are issued to them. The admin can manage passenger data and track trips on the web. The major components of the system are described as follows:

1. **Display Unit:**
   1. **Microcontroller/Microprocessor**: You can choose any of ATMega32, Arduino Mega or Raspberry Pi around which the device will be built.
   1. **Display:** There are several options such as touch screen display, OLED display, LED or LCD display.
1. **Ticketing/Identification**: ATMega32 and Arduino will utilize RFID cards, while Raspberry Pi will use NFC cards for identification.
1. **Payment Terminal:** This will manage on-spot payment, collect and store cash and provide change to the passengers if needed.
1. **Internet connection:** WiFi or GSM modules can be used with ATMega32 or Arduino Mega. Raspberry Pi supports Ethernet too. Client i/p
1. **Storage:** If Raspberry Pi is used, storage will be provided along with it. ATMega32 and Arduino will be interfaced with an SD card.
1. **Controller:** The touch screen of the Raspberry Pi works as a controller. A separate controller unit is needed for the other options.
1. **Web Server:** The web server can be developed with any of the four frameworks: Django, NodeJS or Ruby. Client i/p

The company offers four packages. Client i/p



|**Package**|**Details**|
| - | - |
|Basic|ATMega32 with LCD display|
|Standard|Arduino Mega with LED display|
|Advanced|Raspberry Pi with OLED display|
|Premium|Raspberry Pi with touch screen display|

The client would choose a package, mention how the device would be connected to the internet (WiFi, Ethernet or SIM card) and choose a framework for the web server. You have to create and print the details of the system.

**Tasks:**

- Identify the design pattern(s) that can best capture the scenario above. Implement the scenario in Java. **Note that, the scenario may require multiple design patterns. You may have to apply two different design patterns for building the ticketing system and managing customer choices related to packages, internet options and frameworks.**
- For demonstration, the user would be prompted to give input on the console and based on the choice, the details (name of the specific components) of the created system would be shown on the console.
- You just need to implement the structure. For example, you do not need to implement how microprocessors would work. You just need to create appropriate classes and functions to just print “ATMega32/Arduino Mega has been added to the system”



