

import java.awt.* ;

class Carre extends Rectangle {

    public Carre (int cote) {
        super(cote,cote);
    }

    public Carre (int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int hauteurBB, int largeurBB) {
        longueur = hauteurBB;
        largeur = hauteurBB;
    }

    public void setCote(int cote) {
        this.longueur = cote;
        this.largeur = cote;
    }
}