package org.example;
public class App {
    public static void main(String[] args) {

   Phone xs = new IphoneXS(70, "silver", "metal","hdgkasdkja1234");
   xs.addContact(1,"0743751700","Hut","Talpes");
   xs.addContact(2,"0743751709", "Ziggy", "Stan");
   System.out.println(xs.getFirstContact());
   System.out.println(xs.getLastContact());
   xs.sendMessage("0743751700", "Hey yo!");
   xs.sendMessage("0743751700", "Hey yo 2!");
   xs.sendMessage("0743751709", "Oy!");
   xs.sendMessage("0743751709", "Oy!oy!");
   System.out.println(xs.getFirstMessage("0743751709"));
   System.out.println(xs.getSecondMessage("0743751709"));
   System.out.println(xs.getBatteryLife());
   xs.call("0743751700");
   xs.call("0743751700");
       System.out.println(xs.getBatteryLife());
       xs.viewHistory();
       xs.printContacts();

    }
}
