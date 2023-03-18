package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Phone {
    /** Abstract Class for a Phone object that emulates the behavior of a real phone.
     * This is the parent class for the Iphone and Samsung child classes.
     * You can add contacts and fetch them, call them and send messages.
     * You can display the call history, retrieve first or second message for each contact.
     * Each call or message drains the battery and you can use getBatteryLife() to check current levels.
     */
    protected final int batteryLife;
    protected String color;
    protected String material;
    protected String imei;
    protected int currentBatteryLife;
    LinkedHashMap<String, Contact> contactList = new LinkedHashMap<>();
    private ArrayList<String> callHistory = new ArrayList<>();

    protected Phone(int batteryLife, String color, String material, String imei) {
        this.batteryLife = batteryLife;
        this.color = color;
        this.material = material;
        this.imei = imei;
        currentBatteryLife = batteryLife;
    }

    public void addContact(int id, String phoneNumber, String firstName, String lastName) {
        Contact contact = new Contact(id, phoneNumber, firstName, lastName);
        contactList.put(phoneNumber, contact);
    }

    public void printContacts() {
        for (Map.Entry<String, Contact> set : contactList.entrySet()) {
            System.out.println(set.getValue());
        }
    }

    public String sendMessage(String phoneNumber, String content) {
        if (contactList.containsKey(phoneNumber)) {
            Message newMessage = new Message(content);
            contactList.get(phoneNumber).addMessage(newMessage);
            currentBatteryLife -= 1;
            return "Message sent";
        } else {
            System.out.println("This number does not exist in the Contact List");
            return "Message not sent";
        }
    }

    public String getFirstMessage(String phoneNumber) {
        if (contactList.containsKey(phoneNumber)) {
            return contactList.get(phoneNumber).messages.get(0).getContent();
        } else {
            System.out.println("Contact not in list");
            return "Unable to get message";
        }
    }

    public String getSecondMessage(String phoneNumber) {
        if (contactList.containsKey(phoneNumber)) {
            if(contactList.get(phoneNumber).messages.size()<2){
                return "There is no second message";
            }
            else{
            return contactList.get(phoneNumber).messages.get(1).getContent();}
        } else {
            System.out.println("Contact not in list");
            return "Unable to get message";
        }
    }

    public void call(String phoneNumber) {
        if (contactList.containsKey(phoneNumber)) {
            callHistory.add(phoneNumber);
            System.out.println("Calling " + phoneNumber);
            currentBatteryLife -= 2;
        }
        else{
            System.out.println("Phone number not in contact list");
        }
    }
    public void viewHistory(){
        System.out.println("Printing call history...");
        for( String number : callHistory){
            System.out.println("Called " + number);
        }
        System.out.println("End of call history");
    }
    public Contact getFirstContact(){
       return contactList.entrySet().iterator().next().getValue();
    }
    public Contact getLastContact(){
        int count = 1;
        Contact lastContact = new Contact();

        for (Map.Entry<String, Contact> it :
                contactList.entrySet()) {

            if (count == contactList.size()) {
                lastContact = it.getValue();
            }
            count++;
        }
        return  lastContact;
    }
public int getBatteryLife(){
        return currentBatteryLife;
}
}