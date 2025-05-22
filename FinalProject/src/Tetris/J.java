package Tetris;

import javax.imageio.ImageIO;

public class J extends Tetromino{
	public void restartPiece() {
		cells[0] = new Cell(1,4, TetrisGame.J);
        cells[1] = new Cell(1,3, TetrisGame.J);
        cells[2] = new Cell(1,5, TetrisGame.J);
        cells[3] = new Cell(2,5, TetrisGame.J);
	}
	
	public J() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
