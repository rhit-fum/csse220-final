package Tetris;

import javax.imageio.ImageIO;

public class L extends Tetromino{
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.L);
        cells[1] = new Cell(1,3, TetrisGame.L);
        cells[2] = new Cell(1,5, TetrisGame.L);
        cells[3] = new Cell(2,3, TetrisGame.L);
	}
	
	public L() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
