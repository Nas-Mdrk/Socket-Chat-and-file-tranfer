package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    /*private static DataOutputStream dataOutputStream=null;
    private static DataInputStream dataInputStream=null;*/

    public static void main(String[] args)
    {
        try{
            
            Socket socket = new Socket("Localhost",5000);
            System.out.println("tafiditra");
          /*  dataInputStream=new DataInputStream(socket.getInputStream());
            dataOutputStream=new DataOutputStream(socket.getOutputStream());*/

            BufferedReader input= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output= new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner= new Scanner(System.in);
            String userInput;
            //String response;
            String clientName="empty";//this.getidentifiant()
            ClientThread clientThread= new ClientThread(socket);
            clientThread.start();
           
            do{
                if(clientName.equals("empty")){
                    System.out.println("your name please");
                    userInput= scanner.nextLine();
                    clientName=userInput;
                    output.println(userInput);
                    if(userInput.equals("exit")){
                        break;
                    }
                }
                else{
                    String message=clientName;
                    //System.out.println(message+":");
                    userInput = scanner.nextLine();//this.getTexte();
                    //this.getTexte()
                    if(userInput.contains(".txt"))//chemin
                    {
                        MyClient ab=new MyClient(userInput);
                        ab.MyClient1();
                        userInput="sent file";
                    }
                    output.println(message+": "+userInput);
                    //this.setenvoyer(message+ " "+ userInput);
                    if(userInput.equals("exit")){
                        break;
                  
                    }
                         
                    
                }

            }
            while(!userInput.equals("exit"));
        }
        catch(Exception e){
            System.out.println("client main exception"+ e.getStackTrace());
        }
    }
   /*  private static void sendFile(String path) throws Exception{
        int bytes=0;
        File file=new File(path);
        FileInputStream fileInputStream=new FileInputStream(file);

        //send file size
        dataOutputStream.writeLong(file.length());
        //break file into chunks
        byte[] buffer=new byte[4*1024];
        while((bytes=fileInputStream.read(buffer))!=-1){
            dataOutputStream.write(buffer,0,bytes);
            dataOutputStream.flush();
        }
        System.out.println("Receive file");
        fileInputStream.close();
    }*/
}