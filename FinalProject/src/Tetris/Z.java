package Tetris;

import javax.imageio.ImageIO;

public class Z extends Tetromino{
	public void restartPiece() {
		cells[0] = new Cell(2,4, TetrisGame.Z);
        cells[1] = new Cell(1,3, TetrisGame.Z);
        cells[2] = new Cell(2,5, TetrisGame.Z);
        cells[3] = new Cell(1,4, TetrisGame.Z);
	}
	public Z() {
		//following cells stores the position information of the blocks
		restartPiece();
	}
}
