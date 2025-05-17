package Tetris;
/**
 * @author mingkun fu, Drake Bauernfeind
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisGame extends JPanel{
	private int gameState; //gamestate: pause,continue, replay
	private Cell[][] grid=new Cell[18][9]; //the grids in the window. the window have 18*9 grids
	private final int GRID_SIZE=48; //grid size is 48*48
	//private Tetromino currentPiece=new T(); //test drawing the tetromino piece shaped I, comment this line afterwards
	private Tetromino currentPiece=Tetromino.randomPiece(); //current piece
	private Tetromino nextPiece=Tetromino.randomPiece(); //next piece
	//timer
	Timer animationTimer;
	//define game states:
	public final int START=0;
	public final int PLAYING=1;
	public final int PAUSE=2;
	public final int GAMEOVER=3;
	//Score and game level
	private int level=1;
	private int totalScore=0;
	private int linesEliminated=0;
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
    	drawNextPiece(g2);
    	drawScore(g2);
    	drawState(g2);
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
    	Cell[] cells=nextPiece.cells;
    	for(Cell cell:cells) {
    		int x=cell.getCol()*GRID_SIZE+370;
    		int y= cell.getRow()*GRID_SIZE+25;
    		g.drawImage(cell.getImage(), x, y, this);
    	}
    }
    //show game level and score on the window
    private void drawScore(Graphics2D g) {
    	g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
    	g.drawString("Score: "+totalScore, 500, 250);
    	g.drawString("Game Level:"+1, 500,430);
    }
    //show game state
    private void drawState(Graphics2D g) {
    	if(gameState==START) {
    		g.setColor(Color.GREEN);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
            g.drawString("PRESS SPACE TO START!", 0, 400);
    	}else if(gameState==PLAYING) {
    		g.drawString("P (Pause)", 500, 660);
    	}else if(gameState==PAUSE) {
    		g.drawString("C (Continue)", 500, 660);
    	}else if(gameState==GAMEOVER){
    		g.drawString("R (Restart)", 500, 660);
            g.setColor(Color.RED);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
            g.drawString("GAME OVER!", 30, 400);
    	}
    }
    //movements---------------------------------------------------------------------------------------------------
    private void autoFallDown() {
    	animationTimer = new Timer(700, e -> Fall()); //setting up a timer, each 700 ms fall down a unit
    	animationTimer.start();
    	repaint();
    }
    
    private void fastAutoFall() {
    	Timer animationTimer = new Timer(200, e -> Fall());
    	animationTimer.start();
    }
    
    private boolean canRotate() { //determine whether next rotation is valid or not (collision with the bound or other blocks)
    	Cell[] cells=this.currentPiece.cells;
    	for(Cell cell:cells) { //collision with left and right bound
    		int col=cell.getCol();
    		int row=cell.getRow();
    		if(row<0||row>grid.length-1||col<0||col>grid[0].length-1) {
    			return true;
    		}
    	}
    	for (Cell cell : cells) { //collision with other locked pieces
            int row = cell.getRow();
            int col = cell.getCol();
            if (grid[row][col] != null) {
                return true;
            }
        }
    	return false;
    }
    private void Fall() { //let tetromino piece fall down a unit
		// done Auto-generated method stub
    	if(canFall()) { //if can fall down
    		currentPiece.moveDown();
    	}else {
    		lockPiece();
    		
    		if(isGameOver()) {
    			gameState=GAMEOVER;
    		}else {
    			currentPiece=nextPiece;
    			nextPiece=Tetromino.randomPiece();
    		}
    	}
    	
	}
    private void lockPiece() { //lock the landed pieces to the gameboard
    	Cell[] cells=currentPiece.cells;
    	for(Cell cell:cells) {
    		int row=cell.getRow();
    		int col=cell.getCol();
    		grid[row][col]=cell;
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
    	if(canRotate()) {
    		currentPiece.cancelRotate();
    	}
    }
    
    private boolean canFall() { //detect whether the current piece will collide with the land or other locked pieces
    	for (Cell i : currentPiece.cells) {
    		int row = i.getRow();
            int col = i.getCol();
    		if (i.getRow() == 17) {//if touches bottom
    			return false;
    		}
    		else if(grid[row+1][col]!=null) {// if touches locked pieces
    			return false;
    		}
    	}
    	return true;
    }
     
    private boolean canMoveLeft() { //detect whether the current piece can go left
    	for (Cell i : currentPiece.cells) {
    		int row = i.getRow();
    		int col = i.getCol();
    		if (i.getCol() == 0) {
    			return false;
    		}
    		else if(grid[row][col-1]!=null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean canMoveRight() { //detect whether the current piece can go right
    	for (Cell i : currentPiece.cells) {
    		int row = i.getRow();
    		int col = i.getCol();
    		if (i.getCol() == 8) {
    			return false;
    		}
    		else if(grid[row][col+1]!=null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private boolean checkRow(int row) {
    	for (int i = 0; i < 9; i++) {
    		if (grid[row][i] == null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private void eliminateLine(int row) { //eliminate the line after a line is fulled
    	System.out.println(row);
    	int line=0;
    	for (Cell i : grid[row]) {
    		grid[row][i.getCol()] = null;
    	}
    	for (int i = row; i >= 1; i--) {
    		for (int j = 0; j < 9; j++) {
    			grid[i][j] = grid[i-1][j];
    		}
    	}
    	for (int j = 0; j < 9; j++) {
    		grid[0][j] = null;
    	}
    }
	//game loop-------------------------------------------------------------------------------------------------------
    public boolean isGameOver() { //determine whether gameovers or not
    	Cell[] cells = nextPiece.cells;
        for (Cell cell : cells) {
            int row = cell.getRow();
            int col = cell.getCol();
            if (grid[row][col] != null) {
                return true;
            }
        }
        return false;
    }
    public void gameStart() {
    	gameState=START;
    	KeyListener l=new KeyAdapter() { //capture player input
    		@Override
    		public void keyPressed(KeyEvent e) {
    			int key=e.getKeyCode();
    			switch(key) {
    				case KeyEvent.VK_SPACE:
    					if(gameState==START||gameState==GAMEOVER) {
    						autoFallDown();
    						gameState=PLAYING;
    					}
    				case KeyEvent.VK_DOWN:
    					if(gameState==PLAYING) {
    						Fall();
    					}
    					break;
    				case KeyEvent.VK_LEFT:
    					if(gameState==PLAYING) {
    						moveLeft();
    					}
    					break;
    				case KeyEvent.VK_RIGHT:
    					if(gameState==PLAYING) {
    						moveRight();
    					}
    					break;
    				case KeyEvent.VK_UP:
    					if(gameState==PLAYING) {
    						rotate();
    					}
    					break;
    				case KeyEvent.VK_P:
    					if(gameState==PLAYING) {
    						gameState=PAUSE;
    						animationTimer.stop();
    					}
    					break;
    				case KeyEvent.VK_C:
    					if(gameState==PAUSE) {
    						gameState=PLAYING;
    						animationTimer.restart();
    					}
    					break;
    				case KeyEvent.VK_R:
    					//restart and initialize everything
    					gameState=PLAYING;
    					grid=new Cell[18][9];
    					currentPiece=Tetromino.randomPiece();
    					nextPiece=Tetromino.randomPiece();
    					totalScore=0;
    					linesEliminated=0;
    					level=1;
    					break;
    			}
    		}
    	};
    	
    	this.addKeyListener(l);
    	this.requestFocus(); //focus on the window
    	while(true) {
    		if(this.gameState==PLAYING) {
        		if(canFall()) {
        			
        		}else {
        			lockPiece();
        			for (int i = 17; i >= 0; i--) {
        				System.out.println(i);
            			if(checkRow(i)) {
            				linesEliminated++;
            				totalScore+=100;
            				eliminateLine(i);
            				i++;
            			}
            		}
        			if(isGameOver()) { //if game overs
        				gameState=GAMEOVER;
        			}else {
        				currentPiece=nextPiece;
        				nextPiece=Tetromino.randomPiece(); //generate next piece
        			}
        		}
        	}
    		repaint();
    	}
    }
    //game UI-----------------------------------------------------------------------------------------------------------------
    private void drawStartScreenUI(Graphics2D g) {
    	//TODO
    }
    private void drawPauseScreenUI(Graphics2D g) {
    	//TODO
    }
    private void drawGameOverScreenUI(Graphics2D g) {
    	//TODO
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
