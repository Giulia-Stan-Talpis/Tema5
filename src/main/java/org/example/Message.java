package org.example;

public class Message {
    private String content;
    public Message(String content){
        if(content.length()>500){
            System.out.println("Text limit is 500 characters");}
        else{
            this.content = content;
        }
    }
    public String getContent(){
        return content;
    }

}
