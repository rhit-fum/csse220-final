package Tetris;

import javax.imageio.ImageIO;

public class O extends Tetromino{
	@Override
	public void rotate() {}
	
	public O() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.O);
        cells[1] = new Cell(0,3, TetrisGame.O);
        cells[2] = new Cell(1,3, TetrisGame.O);
        cells[3] = new Cell(1,4, TetrisGame.O);
	}
}
