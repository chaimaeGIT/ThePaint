

import javax.swing.*;
import java.awt.* ;
import java.awt.event.* ;


class Fenetre extends JFrame implements ActionListener {

    private Dessin dessin;

    public Fenetre (String titre, int locationX, int locationY, int sizeX, int sizeY, boolean visi) {

        super(titre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(locationX,locationY);
        setSize(sizeX,sizeY);

        Container contentPane = getContentPane() ;
        JMenuBar menu = new JMenuBar();



        JMenu File = new JMenu("File");
        JMenuItem New = new JMenuItem("New") ;
        New.addActionListener(this);
        File.add(New);
        JMenuItem Open = new JMenuItem("Open") ;
        Open.addActionListener(this);
        File.add(Open);
        JMenuItem Save = new JMenuItem("Save") ;
        Save.addActionListener(this);
        File.add(Save);

        JMenu Apropos = new JMenu("A propos");
        JMenuItem Authors = new JMenuItem("Author");
        Authors.addActionListener(this);
        Apropos.add(Authors);


        File.addSeparator();
        JMenuItem Quit = new JMenuItem("Quit");
        File.add(Quit);
        Quit.addActionListener(this);

        New.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        Open.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        Save.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        Quit.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        Authors.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));


        menu.add(File);
        menu.add(Apropos);

        setJMenuBar(menu);

        JPanel Panneau = new JPanel();
        Panneau.setLayout(new GridLayout(1,2));


        JPanel PanneauCouleur = new JPanel();
        PanneauCouleur.setLayout(new GridLayout(2,4));

        JButton Noir = new JButton("Noir");
        Noir.addActionListener(this);
        Noir.setBackground(Color.black);
        PanneauCouleur.add(Noir);

        JButton Rouge = new JButton("Rouge");
        Rouge.addActionListener(this);
        Rouge.setBackground(Color.red);
        PanneauCouleur.add(Rouge);

        JButton Vert = new JButton("Vert");
        Vert.addActionListener(this);
        Vert.setBackground(Color.green);
        PanneauCouleur.add(Vert);

        JButton Bleu = new JButton("Bleu");
        Bleu.addActionListener(this);
        Bleu.setBackground(Color.blue);
        PanneauCouleur.add(Bleu);

        JButton Jaune = new JButton("Jaune");
        Jaune.addActionListener(this);
        Jaune.setBackground(Color.yellow);
        PanneauCouleur.add(Jaune);

        JButton Rose = new JButton("Rose");
        Rose.addActionListener(this);
        Rose.setBackground(Color.pink);
        PanneauCouleur.add(Rose);

        JButton Magenta = new JButton("Magenta");
        Magenta.addActionListener(this);
        Magenta.setBackground(Color.magenta);
        PanneauCouleur.add(Magenta);

        JButton Orange = new JButton("Orange");
        Orange.addActionListener(this);
        Orange.setBackground(Color.orange);
        PanneauCouleur.add(Orange);

        Panneau.add(PanneauCouleur);

        JPanel PanneauOutil = new JPanel();
        PanneauOutil.setLayout(new GridLayout(2,2));

        JButton Ellipse = new JButton("Ellipse");
        Ellipse.addActionListener(this);
        PanneauOutil.add(Ellipse);

        JButton Cercle = new JButton("Cercle");
        Cercle.addActionListener(this);
        PanneauOutil.add(Cercle);

        JButton Carre = new JButton("Carre");
        Carre.addActionListener(this);
        PanneauOutil.add(Carre);

        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(this);
        PanneauOutil.add(Rectangle);

        Panneau.add(PanneauOutil);
        setVisible(true);

        contentPane.add(Panneau,"South");

        dessin = new Dessin();
        contentPane.add(dessin,"Center");
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if(cmd.equals("New")) {
            dessin.getliste().clear();
            repaint();
        }
        else if(cmd.equals("Open")) { System.out.println("bouton presse = " + cmd); }
        else if(cmd.equals("File")) { System.out.println("bouton presse = " + cmd); }
        else if(cmd.equals("Save")) { System.out.println("bouton presse = " + cmd); }
        else if(cmd.equals("Author")) {
            JOptionPane Author = new JOptionPane();
            Author.showMessageDialog( new Frame(), "Fatima Zahra", "Author", JOptionPane.PLAIN_MESSAGE);
        }
        else if(cmd.equals("Noir")) { dessin.setColor(Color.BLACK); }
        else if(cmd.equals("Rouge")) { dessin.setColor(Color.RED); }
        else if(cmd.equals("Vert")) { dessin.setColor(Color.GREEN); }
        else if(cmd.equals("Bleu")) { dessin.setColor(Color.BLUE); }
        else if(cmd.equals("Jaune")) { dessin.setColor(Color.YELLOW); }
        else if(cmd.equals("Rose")) { dessin.setColor(Color.PINK); }
        else if(cmd.equals("Magenta")) { dessin.setColor(Color.MAGENTA); }
        else if(cmd.equals("Orange")) { dessin.setColor(Color.ORANGE); }
        else if(cmd.equals("Ellipse")) { dessin.setnomFigure("Ellipse"); }
        else if(cmd.equals("Cercle")) { dessin.setnomFigure("Cercle"); }
        else if(cmd.equals("Carré")) { dessin.setnomFigure("Carré"); }
        else if(cmd.equals("Rectangle")) { dessin.setnomFigure("Rectangle"); }
        else if(cmd.equals("Quit")) { System.exit(0); }
        else { System.err.println(cmd); }
    }
}