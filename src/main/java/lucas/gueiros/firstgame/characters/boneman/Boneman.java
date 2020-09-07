package lucas.gueiros.firstgame.characters.boneman;

import lucas.gueiros.firstgame.items.Item;

public class Boneman {
  private int positionX;
  private int positionY;
  private int moveX;
  private int moveY;
  private int sizeX;
  private int sizeY;

  public void move () {
    this.positionX += moveX;
    this.positionY += moveY;
  }

	/**
	* Default empty Boneman constructor
	*/
	public Boneman() {
		super();
	}

	/**
	* Default Boneman constructor
	*/
	public Boneman(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.moveX = moveX;
		this.moveY = moveY;
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
	* Returns value of moveX
	* @return
	*/
	public int getMoveX() {
		return moveX;
	}

	/**
	* Sets new value of moveX
	* @param
	*/
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	/**
	* Returns value of moveY
	* @return
	*/
	public int getMoveY() {
		return moveY;
	}

	/**
	* Sets new value of moveY
	* @param
	*/
	public void setMoveY(int moveY) {
		this.moveY = moveY;
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
