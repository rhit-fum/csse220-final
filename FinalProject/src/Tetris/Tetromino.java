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
	
	//Method for placing a piece at the initial tile. Important for having pieces spawn at the top after being stored
	public void restartPiece() {
		
	}
	
	//generate tetromino pieces randomly
	public static Tetromino randomPiece() {
        int num = (int) (Math.random() * 7);
        Tetromino tetromino = null;
        switch (num) {
            case 0:
                tetromino = new I();
                break;
            case 1:
                tetromino = new J();
                break;
            case 2:
                tetromino = new L();
                break;
            case 3:
                tetromino = new O();
                break;
            case 4:
                tetromino = new S();
                break;
            case 5:
                tetromino = new T();
                break;
            case 6:
                tetromino = new Z();
                break;
        }

        return tetromino;
    }
	
	public void rotate() {
		for (Cell cell:cells) {
			if (!cell.equals(cells[0])) {
				int dx = cell.getCol() - cells[0].getCol();
				int dy = cell.getRow() - cells[0].getRow();
				int dx2 = -dy;
				int dy2 = dx;
				cell.setCol(cells[0].getCol() + dx2);
				cell.setRow(cells[0].getRow() + dy2);
			}
		}
	}
	
	public void cancelRotate() {
		for (Cell cell:cells) {
			if (!cell.equals(cells[0])) {
				int dx = cell.getCol() - cells[0].getCol();
				int dy = cell.getRow() - cells[0].getRow();
				int dx2 = -dy;
				int dy2 = dx;
				cell.setCol(cells[0].getCol() - dx2);
				cell.setRow(cells[0].getRow() - dy2);
			}
		}
    }
	
}
    
