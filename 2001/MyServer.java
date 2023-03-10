package client; 
import java.net.*;  
import java.io.*;  
class MyServer{  
        private static DataOutputStream dataOutputStream= null;
        private static DataInputStream dataInputStream= null;
        static int un=1;
        public static void main(String[] args){
            try(ServerSocket serverSocket = new ServerSocket(8699)){
                System.out.println("listening to port:5000");
                Socket clientSocket=serverSocket.accept();
                System.out.println(clientSocket+":connected");
                dataInputStream=new DataInputStream(clientSocket.getInputStream());
                dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());

                receiveFile(un+".txt");
                un=un++;
                dataInputStream.close();
                clientSocket.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        private static void receiveFile(String fileName)throws Exception{
            int bytes=0;
            FileOutputStream fileOutputStream=new FileOutputStream(fileName);

            long size=dataInputStream.readLong(); //read file size
            byte[] buffer=new byte[4*1024];
            while(size>0 && (bytes = dataInputStream.read(buffer,0,(int)Math.min(buffer.length,size))) !=-1){
                fileOutputStream.write(buffer,0,bytes);
                size -= bytes; //read up to file size
            }
            fileOutputStream.close();
        }
}  