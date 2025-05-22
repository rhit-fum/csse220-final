package Tetris;

import javax.imageio.ImageIO;

public class O extends Tetromino{
	@Override
	public void rotate() {}
	
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
