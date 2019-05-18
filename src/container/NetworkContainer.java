package container;

import rbvs.product.SimpleProduct;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by @author Rron Shabani - 1526907
 * on 18/05/2019
 */
public class NetworkContainer<E> extends Container<E> {
    String host;
    int sendPort;
    int receivePort;
    Sender sendThread;
    Receiver receiveThread;

    class Sender extends Thread {
        Socket socket;
        String operation;
        Object data;

        @Override
        public void run() {
            try {
                ServerSocket ss = new ServerSocket(sendPort);
                socket = ss.accept();
                while(!isInterrupted()) {
                    if(data != null && operation != null) {
                        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                        dos.writeUTF(operation);
                        dos.flush();
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(data);
                        oos.flush();
                        data = null;
                        operation = null;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    class Receiver extends Thread {
        Socket socket;

        @Override
        public void run() {
            try {
                socket = new Socket(host, receivePort);
                while(!isInterrupted()) {
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String operation = dis.readUTF();
                    ObjectInputStream ois;
                    switch(operation) {
                        case "add":
                            ois = new ObjectInputStream(socket.getInputStream());
                            add((E)ois.readObject());
                            break;
                        case "remove":
                            ois = new ObjectInputStream(socket.getInputStream());
                            remove(ois.readObject());
                            break;
                    }
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public NetworkContainer(String host, int sendPort, int receivePort) {
        super();
        this.host = host;
        this.sendPort = sendPort;
        this.receivePort = receivePort;
        if(sendPort != 0) {
            sendThread = new Sender();
            sendThread.start();
        }
        if(receivePort != 0) {
            receiveThread = new Receiver();
            receiveThread.start();
        }
    }

    @Override
    public boolean add(E e) {
        if(sendPort != 0) {
            sendThread.setOperation("add");
            sendThread.setData(e);
        }
        return super.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if(sendPort != 0) {
            sendThread.setOperation("remove");
            sendThread.setData(o);
        }
        return super.remove(o);
    }

    public void stop() {
        if(receivePort != 0)
            receiveThread.interrupt();

        if(sendPort != 0)
            sendThread.interrupt();
    }
}
