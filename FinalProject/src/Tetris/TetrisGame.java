package Tetris;
/**
 * @author mingkun fu
 */
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
	private Cell[][] grid=new Cell[18][9]; //the grids in the window
	private final int GRID_SIZE=48; //grid size is 48*48
	private Tetromino currentPiece=new I(); //test drawing the tetromino piece shaped I, comment this line afterwards
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
    	g2.translate(22, 15);
    	drawGrid(g2);
    	drawCurrentPiece(g2);
    	//g2.drawImage(I, 0, 0, this); //test draw a block, comment this line after
    }
    
    //drawing the grids on the window
    private void drawGrid(Graphics2D g) {
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[i].length;j++) {
    			int x=j*GRID_SIZE; //getting x and y position of each cell
    			int y=i*GRID_SIZE;
    			Cell cell=grid[i][j];
    			if(cell==null) g.drawRect(x, y, GRID_SIZE, GRID_SIZE); //if empty, draw a square to represent the cell
    			else g.drawImage(cell.getImage(), x, y, this); // if not empty, then there's should be a tetromino block
    		}
    	}
    }
    
    //draw the current tetromino piece
    private void drawCurrentPiece(Graphics2D g) {
    	Cell[] cells=currentPiece.cells;
    	for(Cell cell:cells) {
    		int x=cell.getCol()*GRID_SIZE;
    		int y=cell.getRow()*GRID_SIZE;
    		g.drawImage(cell.getImage(), x, y, this);
    	}
    	
    }
    
    //draw the next tetromino piece
    private void drawNextPiece(Graphics2D g) {
    	
    }
    
    //game loop
    public void gameStart() {
    	
    }
    
	public static void main(String[] args) {
		//setting up the JFrame and game panel
		JFrame frame=new JFrame("Tetris Game");
		TetrisGame game=new TetrisGame();
		frame.add(game);
		frame.setVisible(true);
		frame.setSize(810,940); //let the window size equal to the background image size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start the game
		game.gameStart();
	}

}
