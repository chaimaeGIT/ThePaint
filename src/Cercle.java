
import static java.lang.Math.PI;
import java.awt.* ;

class Cercle extends Ellipse {

    public Cercle (int grandAxe) {
        super(grandAxe, grandAxe);
    }

    public Cercle (int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        grandAxe = hauteurBB;
        petitAxe = hauteurBB;
    }

    public int getDiametre(){
        return grandAxe;
    }


    public double getPerimetre(){
        return grandAxe*PI;
    }

    public double getSurface(){
        return Math.pow(PI*(grandAxe/2),2);
    }
}
