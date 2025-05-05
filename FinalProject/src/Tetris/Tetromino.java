package Tetris;

import java.awt.image.BufferedImage;

public class Tetromino {
	//cell array has the information of the position of blocks
	//each tetromino piece is consisted of 4 blocks, so an array of 4 elements
	public Cell[] cells=new Cell[4]; 
	
	//movement methods
	public void moveLeft() {
		for(Cell cell:cells) { //make all cells(AKA blocks) of the tetromino piece move left
			cell.left();
		}
	}
	
	public void moveRight() {
		for(Cell cell:cells) {
			cell.right();
		}
	}
	
	public void moveDown() {
		for (Cell cell:cells) {
			cell.down();
		}
	}
}
    
