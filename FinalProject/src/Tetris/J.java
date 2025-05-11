package Tetris;

import javax.imageio.ImageIO;

public class J extends Tetromino{
	public J() {
		//following cells stores the position information of the blocks
		cells[0] = new Cell(0,4, TetrisGame.J);
        cells[1] = new Cell(0,3, TetrisGame.J);
        cells[2] = new Cell(0,5, TetrisGame.J);
        cells[3] = new Cell(1,5, TetrisGame.J);
	}
}
