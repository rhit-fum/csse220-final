package Tetris;
import java.awt.image.BufferedImage;
public class Cell {
	private int row;
	private int col; //the row & col of the block
	private BufferedImage image; //image of the block
	public Cell(int row,int col,BufferedImage image) {
		this.row=row;
		this.col=col;
		this.image=image;
	}
	//getter and setter methods
	public int getRow() {
		return this.row;
	}
	public void setRow(int row) {
		this.row=row;
	}
	public int getCol() {
		return this.col;
	}
	public void setCol(int col) {
		this.col=col;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image=image;
	}
	
	
	//movements
	public void left() {
		col--;
	}
	public void right() {
		col++;
	}
	public void down() {
		row++;
	}
	//since in Tetris the tetromino pieces are not able to go upwards, so only down() required
	
}
