

import javax.swing.*;
import java.awt.* ;
import java.awt.event.* ;
import java.util.* ;
import java.io.*;

public abstract class Figure implements Serializable {
    protected Point origine;
    protected int grandAxe;
    protected int petitAxe;
    protected Color c;

    public Figure (Point origine) {
        this.origine = origine;
    }

    public Figure (int grandAxe, int petitAxe){
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    public Figure(Point p,Color co) {
        origine = p;
        c = co;
    }


    public String toString() {
        return "Rectangle : ("+origine.getX()+","+origine.getY()+")";
    }

    public abstract double getPerimetre();
    public abstract double getSurface();
    public abstract void setBoundingBox(int hauteurBB, int largeurBB);
    public abstract void draw(Graphics g);
}