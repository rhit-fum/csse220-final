package Tetris;

import javax.imageio.ImageIO;

public class T extends Tetromino{
	public T() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.T);
        cells[1] = new Cell(0,5, TetrisGame.T);
        cells[2] = new Cell(0,3, TetrisGame.T);
        cells[3] = new Cell(1,4, TetrisGame.T);
	}
}
