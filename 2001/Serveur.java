package client;
import java.net.*;
import java.util.ArrayList;


public class Serveur{
    static int r=10;
    public static void main(String[] args){
       
        ArrayList<ServerThread> threadList=new ArrayList<>();
        Serveur uno=new Serveur();
        try{
            ServerSocket serversocket= new ServerSocket(5000);
            while(true){
                Socket socket= serversocket.accept();
                ServerThread serverThread= new ServerThread(socket,threadList,r);
                threadList.add(serverThread);
                serverThread.start();
                r=r+10;
            }
           
        }
        catch(Exception e){
            System.out.println("Error"+ e.getStackTrace());
        }
    }
    
    
   
}