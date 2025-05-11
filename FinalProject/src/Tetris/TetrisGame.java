package Tetris;
/**
 * @author mingkun fu
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisGame extends JPanel{
	private int gameState; //gamestate: pause,continue, replay
	private Cell[][] grid=new Cell[18][9]; //the grids in the window. the window have 18*9 grids
	private final int GRID_SIZE=48; //grid size is 48*48
	private Tetromino currentPiece=new T(); //test drawing the tetromino piece shaped I, comment this line afterwards
	//define game states:
	public final int PLAYING=0;
	public final int PAUSE=1;
	public final int GAMEOVER=2;
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
    	g2.drawImage(background, 0, 0, this); //setup the background image
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
    private Tetromino drawNextPiece() {
    	Tetromino currentPiece = new J();
    	return currentPiece;
    }
    
    //movements
    private void autoFallDown() {
    	Timer animationTimer = new Timer(700, e -> Fall()); //setting up a timer, each 700 ms fall down a unit
    	animationTimer.start();
    }
    
    private void fastAutoFall() {
    	Timer animationTimer = new Timer(300, e -> Fall());
    	animationTimer.start();
    }
    
    
    private void Fall() {
		// done Auto-generated method stub
    	if (canFall()) {
    		currentPiece.moveDown();
    	}
    	else {
    		currentPiece = drawNextPiece();
    	}
	}
    
    private void moveLeft() {
    	if (canMoveLeft()) {
    		currentPiece.moveLeft();
    	}
    }
    
    private void moveRight() {
    	if (canMoveRight()) {
    		currentPiece.moveRight();
    	}
    }
    
    private void rotate() {
    	currentPiece.rotate();
    }
    
    private boolean canFall() { //detect whether the current piece will collide with the land or other locked pieces
    	boolean a = true;
    	for (Cell i : currentPiece.cells) {
    		if (i.getRow() == 17) {
    			a = false;
    		}
    	}
    	return a;
    }
    
    private boolean canMoveLeft() { //detect whether the current piece will collide with the land or other locked pieces
    	boolean a = true;
    	for (Cell i : currentPiece.cells) {
    		if (i.getCol() == 0) {
    			a = false;
    		}
    	}
    	return a;
    }
    
    private boolean canMoveRight() { //detect whether the current piece will collide with the land or other locked pieces
    	boolean a = true;
    	for (Cell i : currentPiece.cells) {
    		if (i.getCol() == 8) {
    			a = false;
    		}
    	}
    	return a;
    }

	//game loop
    public void gameStart() {
    	this.requestFocus(); //focus on the window
    	if(canFall()) {
    		autoFallDown();
    	}
    	while(true) {
    		if(gameState==PLAYING) {
    			
    		}
    		repaint();
    	}
    }
    
	public static void main(String[] args) {
		//setting up the JFrame and game panel
		JFrame frame=new JFrame("Tetris Game");
		TetrisGame game=new TetrisGame();
		frame.add(game);
		
		game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
              switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:  game.moveLeft(); break;
                case KeyEvent.VK_RIGHT: game.moveRight(); break;
                case KeyEvent.VK_UP: 	game.rotate(); break;
                case KeyEvent.VK_DOWN:  game.fastAutoFall(); break;
              }
            }
            
            public void keyRemoved(KeyEvent e) {
            	switch (e.getKeyCode()) {
	                case KeyEvent.VK_DOWN:  game.autoFallDown(); break;
              }
            }
            
          });
		
		frame.setVisible(true);
		frame.setSize(810,940); //let the window size equal to the background image size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//start the game
		game.gameStart();
	}

}
