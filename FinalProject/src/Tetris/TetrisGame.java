package Tetris;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
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
            I = ImageIO.read(new File("src/resource/I.png"));
            J = ImageIO.read(new File("src/resource/J.png"));
            L = ImageIO.read(new File("src/resource/L.png"));
            O = ImageIO.read(new File("src/resource/O.png"));
            S = ImageIO.read(new File("src/resource/S.png"));
            T = ImageIO.read(new File("src/resource/T.png"));
            Z = ImageIO.read(new File("src/resource/Z.png"));
            background = ImageIO.read(new File("src/resource/background.png"));
        } catch (IOException e) {
            System.out.print("image not found");
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	Graphics2D g2=(Graphics2D) g;
    	g2.drawImage(background, 0, 0, this); //setup the backgroun image
    	g2.drawImage(I, 0, 0, this); //test draw a block
    }
	public static void main(String[] args) {
		JFrame frame=new JFrame("Tetris Game");
		TetrisGame panel=new TetrisGame();
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(810,940);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
