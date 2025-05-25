package Tetris;

import javax.imageio.ImageIO;
/**
 * @author mingkun fu, Drake Bauernfeind
 * purpose: The subclass of tetromino, each subclass represents a specific shape of tetromino piece
 */
public class S extends Tetromino{
	/**
	 * ensures: set up the position of cells for this tetromino piece
	 */
	@Override
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.S);
        cells[1] = new Cell(1,5, TetrisGame.S);
        cells[2] = new Cell(2,3, TetrisGame.S);
        cells[3] = new Cell(2,4, TetrisGame.S);
	}
	
	public S() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
