package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConnection {
    private final String IP;
    private final int port; //16-bit 0-65535
    private final ConnectionThread conn;
    private final Consumer<Serializable> receiveCallback;

    public NetworkConnection(String IP, int port, Consumer<Serializable> receiveCallback) {
        this.IP = IP;
        this.port = port;
        this.conn = new ConnectionThread();
        this.receiveCallback = receiveCallback;
    }

    public void sendMsg(Serializable msg) {
        // accedere a output stream per scrivere il msg
        try {
            conn.oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        this.conn.start();
    }

    public void disconnect() {
        try {
            this.conn.s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract boolean isServer();

    //classe innestata gestione connessione
    private class ConnectionThread extends Thread {
        ObjectOutputStream oos;
        Socket s;

        @Override
        public void run() {
            try(Socket s = isServer() ? new ServerSocket(port).accept() : new Socket(IP,port);
                //Non possono essere scambiato perché ObjectInputStream attende un'inizializzazione
                //dall'altro quindi se sia Client che Server fanno richiesta di ObjectInputStream
                //ognuno aspetta l'altro. Se invece inizializziamo prima ObjectOutputStream esso fa
                //una richiesta di lettura all'altro e ObjectInputStream inizializza ObjectInputStream
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                ) {
                this.oos = oos;
                this.s = s;
                while(true) {
                    Serializable msg = (Serializable) ois.readObject();
                    receiveCallback.accept(msg);
                }

            } catch (IOException e) {

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}