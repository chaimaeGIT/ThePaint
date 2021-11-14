

import javax.swing.*;
import java.awt.* ;
import java.awt.event.* ;
import java.util.* ;
import java.io.*;


class Dessin extends JPanel implements MouseMotionListener, MouseListener {

    private ArrayList<Figure> liste;
    private Color c;
    private String nomFigure;

    private int X,Y;

    public Dessin () {

        super();
        liste = new ArrayList<Figure>();
        c = Color.RED;
        nomFigure = "Cercle";

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void paintComponent (Graphics g) {

        super.paintComponent(g);
        setBackground(Color.white);
		/*Color Rouge = Color.RED;
		g.fillRect(50,50,200,100);*/
        for(Figure f : liste) {
            f.draw(g);
        }
    }

    public void setColor (Color c) {
        this.c = c;
    }

    public void setnomFigure (String nomFigure) {
        this.nomFigure = nomFigure;
    }

    public ArrayList<Figure> getliste () {
        return liste;
    }

    public void mouseDragged(MouseEvent e) {
        int dX = e.getX()-X ;
        int dY = e.getY()-Y ;

        int i=0;
        for(Figure f : liste)
        {
            i++;
        }
        liste.get(i-1).setBoundingBox(dX, dY);
        repaint();
        //System.out.println("j'ai bougé en étant appuyé");
    }

    public void mousePressed(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
        if(nomFigure.equals("Rectangle")) {
            liste.add(new Rectangle(X,Y,c));
        }
        else if(nomFigure.equals("Carré")) {
            liste.add(new Carre(X,Y,c));
        }
        else if(nomFigure.equals("Ellipse")) {
            liste.add(new Ellipse(X,Y,c));
        }
        else if(nomFigure.equals("Cercle")) {
            liste.add(new Cercle(X,Y,c));
        }
        //System.out.println("j'ai appuyé");
    }

    public void mouseReleased(MouseEvent e)	{
        X = e.getX();
        Y = e.getY();
        int dX = e.getX()-X ;
        int dY = e.getY()-Y ;

        repaint();
        //System.out.println("j'ai relaché");
    }

    public void mouseMoved(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

    public void exporter() {
        try {
            FileOutputStream fos = new FileOutputStream("Dessin.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(liste);
            oos.close();
        }
        catch(Exception err) {
            err.printStackTrace();
            System.out.println("export failed");
        }
    }

    public void importer() {
        try {
            FileInputStream fis = new FileInputStream("Dessin.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            liste = (ArrayList<Figure>) ois.readObject();
            repaint();
            ois.close();
        }
        catch(Exception err) {
            err.printStackTrace();
            System.out.println("import failed");
        }
    }

    public void exportFile(String monFichier) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(monFichier));

            bw.close();
        }
        catch(Exception err) {
            err.printStackTrace();
        }
    }
}