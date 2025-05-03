package Tetris;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class TetrisGame extends JPanel{
	private int gameState; //gamestate: pause,continue, replay
	//image of the blocks
	public static BufferedImage I;
    public static BufferedImage J;
    public static BufferedImage L;
    public static BufferedImage O;
    public static BufferedImage S;
    public static BufferedImage T;
    public static BufferedImage Z;
    public static BufferedImage background;
    //load images
    static {
        try {
            I = ImageIO.read(new File("src/resource/images/I.png"));
            J = ImageIO.read(new File("src/resource/images/J.png"));
            L = ImageIO.read(new File("src/resource/images/L.png"));
            O = ImageIO.read(new File("src/resource/images/O.png"));
            S = ImageIO.read(new File("src/resource/images/S.png"));
            T = ImageIO.read(new File("src/resource/images/T.png"));
            Z = ImageIO.read(new File("src/resource/images/Z.png"));
            background = ImageIO.read(new File("Tetris-master/images/background.png"));
        } catch (IOException e) {
            System.out.print("image not found");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2=(Graphics2D) g;
    	g2.drawImage(background, 0, 0, this);
    }
	public static void main(String[] args) {
		

	}

}
