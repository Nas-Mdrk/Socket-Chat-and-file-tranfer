/*spackage client;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class MyClientThread extends Thread{
    private Socket socket;
    private static DataInputStream input=null;
    static int un=1;

   
    public MyClientThread(Socket s) throws IOException{
        this.socket=s;
        this.input=new DataInputStream(socket.getInputStream());
    }
    @Override
    public void run(){
        try{
            while(true){
               
                receiveFile(un+".txt");
                un=un++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                input.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
      private static void receiveFile(String fileName)throws Exception{
            int bytes=0;
            FileOutputStream fileOutputStream=new FileOutputStream(fileName);

            long size=input.readLong(); //read file size
            byte[] buffer=new byte[4*1024];
            while(size>0 && (bytes = input.read(buffer,0,(int)Math.min(buffer.length,size))) !=-1){
                fileOutputStream.write(buffer,0,bytes);
                size -= bytes; //read up to file size
            }
            fileOutputStream.close();
        }
   
}*/