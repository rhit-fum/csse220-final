package Tetris;
import java.awt.image.BufferedImage;
/**
 * @author mingkun fu, Drake Bauernfeind
 * purpose: This class is used for storing the information of the game board. A cell can either be empty(null), or filled with one of the blocks of a tetromino piece.
 * when a tetromino piece  is landed on the ground, the corresponding cells will store the blocks of that piece.
 */
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
	/**
	 * ensures: get the current row of this particular cell
	 * @return row
	 */
	public int getRow() {
		return this.row;
	}
	/**
	 * ensures: set the current row of this particular cell
	 * @param row
	 */
	public void setRow(int row) {
		this.row=row;
	}
	/**
	 * ensures: get the current column of this particular cell
	 * @return col
	 */
	public int getCol() {
		return this.col;
	}
	/**
	 * ensures: set the current column of this particular cell
	 * @param col
	 */
	public void setCol(int col) {
		this.col=col;
	}
	/**
	 * ensure: get the texture for this cell
	 * @return image
	 */
	public BufferedImage getImage() {
		return image;
	}
	/**
	 * ensures: set the texture for this cell
	 * @param image
	 */
	public void setImage(BufferedImage image) {
		this.image=image;
	}
	
	
	//movements
	/**
	 * ensures: move this cell leftwards
	 */
	public void left() {
		col--;
	}
	/**
	 * ensures: move this cell rightwards
	 */
	public void right() {
		col++;
	}
	/**
	 * ensures: move this cell downwards
	 */
	public void down() {
		row++;
	}
	//since in Tetris the tetromino pieces are not able to go upwards, so only down() required
	
}
