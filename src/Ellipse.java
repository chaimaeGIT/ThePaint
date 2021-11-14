
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import java.awt.* ;

class Ellipse extends Figure {

    public Ellipse (int grandAxe, int petitAxe) {
        super(grandAxe, petitAxe);
    }

    public Ellipse (int px, int py, Color c) {
        super(new Point(px,py), c);
        grandAxe = 0;
        petitAxe = 0;
    }

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        grandAxe = hauteurBB;
        petitAxe = largeurBB;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(origine.X, origine.Y, grandAxe, petitAxe);
    }

    public int getGrandAxe(){
        return grandAxe;
    }
    public int getPetitAxe(){
        return petitAxe;
    }
    public double getPerimetre(){
        return 2*PI*sqrt((grandAxe*grandAxe+petitAxe*petitAxe)/2);
    }
    public double getSurface(){
        return (PI*grandAxe*petitAxe)/4;
    }
}
