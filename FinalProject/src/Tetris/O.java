package Tetris;

import javax.imageio.ImageIO;
/**
 * @author mingkun fu, Drake Bauernfeind
 * purpose: The subclass of tetromino, each subclass represents a specific shape of tetromino piece
 */
public class O extends Tetromino{
	@Override
	/**
	 * ensures: does nothing since this type of tetromino piece remains the same after rotation
	 */
	public void rotate() {};
	
	/**
	 * ensures: set up the position of cells for this tetromino piece
	 */
	@Override
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.O);
        cells[1] = new Cell(1,3, TetrisGame.O);
        cells[2] = new Cell(2,3, TetrisGame.O);
        cells[3] = new Cell(2,4, TetrisGame.O);
	}
	
	public O() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
