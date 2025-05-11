package Tetris;

import javax.imageio.ImageIO;

public class L extends Tetromino{
	public L() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.L);
        cells[1] = new Cell(0,3, TetrisGame.L);
        cells[2] = new Cell(0,5, TetrisGame.L);
        cells[3] = new Cell(1,3, TetrisGame.L);
	}
}
