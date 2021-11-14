
import java.awt.* ;

class Rectangle extends Figure {
    protected int longueur;
    protected int largeur;

    public Rectangle (int longueur, int largeur) {
        super(new Point(0,0));
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public Rectangle (int px, int py, Color c) {
        super(new Point(px,py), c);
        longueur = 0;
        largeur = 0;
    }

    public String toString () {
        int i, j;
        System.out.print("\n+");
        for(i=0;i<longueur;i++) {
            System.out.print("--");
        }
        System.out.println("+");
        for(j=0;j<largeur;j++) {
            System.out.print("|");
            for(i=0;i<longueur;i++) {
                System.out.print("  ");
            }
            System.out.println("|");
        }
        System.out.print("+");
        for(i=0;i<longueur;i++) {
            System.out.print("--");
        }
        return "+";
    }

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        longueur = hauteurBB;
        largeur = largeurBB;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(origine.X, origine.Y, longueur, largeur);
    }

    public int getLongueur(){
        return longueur;
    }

    public int getLargeur(){
        return largeur;
    }

    public double getPerimetre(){
        return longueur*2+largeur*2;
    }

    public double getSurface(){
        return longueur*largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}