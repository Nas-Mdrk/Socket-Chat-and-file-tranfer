package client;
import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    Wind uno=new Wind();
    int r;
    Vector<String>tab=new Vector<String>();
    /* private static DataOutputStream dataOutputStream= null;
        private static DataInputStream dataInputStream= null;*/


    public ServerThread(Socket socket, ArrayList<ServerThread> threads,int ri){
        this.socket= socket;
        this.threadList = threads;
        this.r=ri;
    }
    @Override
    public void run()
    {
        try
        {
            BufferedReader input = new BufferedReader (new InputStreamReader(socket.getInputStream()));
            output= new PrintWriter(socket.getOutputStream(),true);
            while(true)
            {
                String outputString = input.readLine();
                if(outputString.equals("exit")){
                    break;
                }
                //receiveFile("NewFile.pdf");
                this.tab.add(outputString);
                Raquette un=new Raquette();
                //un.setj1(this.tab);
                un.setj(outputString,this.r);
                this.r=this.r+20;
                this.uno.add(un);
                printToAllClients(outputString);
                System.out.println("Server received "+ outputString);
            }
        }
        catch(Exception e){
            System.out.println("Error"+e.getStackTrace());
        }
    }
    private void printToAllClients(String outputString)
    {
        for(ServerThread sT: threadList)
        {
            sT.output.println(outputString);
        }
    }
    
    /* private static void receiveFile(String fileName)throws Exception{
            int bytes=0;
            FileOutputStream fileOutputStream=new FileOutputStream(fileName);

            long size=dataInputStream.readLong(); //read file size
            byte[] buffer=new byte[4*1024];
            while(size>0 && (bytes = dataInputStream.read(buffer,0,(int)Math.min(buffer.length,size))) !=-1){
                fileOutputStream.write(buffer,0,bytes);
                size -= bytes; //read up to file size
            }
            fileOutputStream.close();
        }*/
}