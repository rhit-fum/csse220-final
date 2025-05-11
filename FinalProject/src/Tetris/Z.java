package Tetris;

import javax.imageio.ImageIO;

public class Z extends Tetromino{
	public Z() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(1,4, TetrisGame.Z);
        cells[1] = new Cell(0,3, TetrisGame.Z);
        cells[2] = new Cell(1,5, TetrisGame.Z);
        cells[3] = new Cell(0,4, TetrisGame.Z);
	}
}
