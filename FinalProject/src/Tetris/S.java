package Tetris;

import javax.imageio.ImageIO;

public class S extends Tetromino{
	public S() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.S);
        cells[1] = new Cell(0,5, TetrisGame.S);
        cells[2] = new Cell(1,3, TetrisGame.S);
        cells[3] = new Cell(1,4, TetrisGame.S);
	}
}
