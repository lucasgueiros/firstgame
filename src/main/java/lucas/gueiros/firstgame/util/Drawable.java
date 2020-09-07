package lucas.gueiros.firstgame.util;

import java.awt.Graphics2D;

public abstract class Drawable {

  protected int positionX;
  protected int positionY;
  protected int sizeX;
  protected int sizeY;

  public abstract void draw(Graphics2D g);
  public abstract void update();

  public Drawable (int positionX, int positionY, int sizeX, int sizeY) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  /**
	* Returns value of positionX
	* @return
	*/
	public int getPositionX() {
		return positionX;
	}

	/**
	* Sets new value of positionX
	* @param
	*/
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	/**
	* Returns value of positionY
	* @return
	*/
	public int getPositionY() {
		return positionY;
	}

	/**
	* Sets new value of positionY
	* @param
	*/
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
  /**
	* Returns value of sizeX
	* @return
	*/
	public int getSizeX() {
		return sizeX;
	}

	/**
	* Sets new value of sizeX
	* @param
	*/
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	/**
	* Returns value of sizeY
	* @return
	*/
	public int getSizeY() {
		return sizeY;
	}

	/**
	* Sets new value of sizeY
	* @param
	*/
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
}
