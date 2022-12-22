package client;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Raquette extends JPanel{
    Vector<String>j1;
    String j;
    int ct;
    public Raquette()
    {
        this.setVisible(true);
        this.setSize(400,400);
        this.setBackground(new Color(100,100,100));
        
    }
    public void setj(String a, int c)
    {
        this.j=a;
        this.ct=c;
    }
    public void setj1(Vector<String>x1)
    {
        this.j1=x1;
    }
   
    public void paint(Graphics g)
    {
    
         g.drawString(this.j,10,this.ct);
        try{
            Thread.sleep(2);
        }
        catch (Exception e)
        {

        }
        this.repaint();
        
       

    }
}