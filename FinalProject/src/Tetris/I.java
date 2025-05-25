package Tetris;

import javax.imageio.ImageIO;
/**
 * @author mingkun fu, Drake Bauernfeind
 * purpose: The subclass of tetromino, each subclass represents a specific shape of tetromino piece
 */
public class I extends Tetromino{
	/**
	 * ensures: set up the position of cells for this tetromino piece
	 */
	@Override
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.I);
        cells[1] = new Cell(1,3, TetrisGame.I);
        cells[2] = new Cell(1,5, TetrisGame.I);
        cells[3] = new Cell(1,6, TetrisGame.I);
	}
	
	public I() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
