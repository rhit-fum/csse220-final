package Tetris;

import javax.imageio.ImageIO;

public class T extends Tetromino{
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.T);
        cells[1] = new Cell(1,5, TetrisGame.T);
        cells[2] = new Cell(1,3, TetrisGame.T);
        cells[3] = new Cell(2,4, TetrisGame.T);
	}
	public T() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
