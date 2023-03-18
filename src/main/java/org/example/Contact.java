package org.example;

import java.util.ArrayList;

public class Contact {
    private int id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    ArrayList<Message> messages = new ArrayList<>();
    public Contact(int id, String phoneNumber, String firstName, String lastName){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Contact(){

    }
    public void addMessage(Message m){
        messages.add(m);
    }
    @Override
    public String toString(){
        return phoneNumber + " " + firstName + " " + lastName;
    }
}
