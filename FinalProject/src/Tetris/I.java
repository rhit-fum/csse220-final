package Tetris;

import javax.imageio.ImageIO;

public class I extends Tetromino{
	public I() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.I);
        cells[1] = new Cell(0,3, TetrisGame.I);
        cells[2] = new Cell(0,5, TetrisGame.I);
        cells[3] = new Cell(0,6, TetrisGame.I);
	}
}
