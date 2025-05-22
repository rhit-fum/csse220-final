package Tetris;

import javax.imageio.ImageIO;

public class I extends Tetromino{
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
