package main;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Server s = new Server(12100,msg -> System.out.println("SERVER: Ricevuto: " + msg));
        s.connect(); //avvio thread ausiliario per connettersi
        System.out.println("Server in attesa di connessione");

        Thread.sleep(2*1000);

        Client c = new Client("localhost", 12100, msg -> System.out.println("CLIENT: Ricevuto: " + msg));
        c.connect();
        System.out.println("client in attesa di connessione!");
        Thread.sleep(2*1000);

        c.sendMsg("Ciao server!");
        Thread.sleep(1*1000);

        s.sendMsg("Ciao client!");

        Thread.sleep(2*1000);
        s.disconnect();
        c.disconnect();
    }
}
