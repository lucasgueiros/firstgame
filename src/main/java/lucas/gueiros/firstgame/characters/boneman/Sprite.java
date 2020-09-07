package lucas.gueiros.firstgame.characters.boneman;

import lucas.gueiros.firstgame.items.Item;
import lucas.gueiros.firstgame.util.Drawable;

public abstract class Sprite extends Drawable {

  private int moveX;
  private int moveY;

  public void update () {
    super.positionX += moveX;
    super.positionY += moveY;
  }

	/**
	* Default Boneman constructor
	*/
	public Sprite(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super(positionX, positionY, sizeX, sizeY);
		this.moveX = moveX;
		this.moveY = moveY;
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

}
