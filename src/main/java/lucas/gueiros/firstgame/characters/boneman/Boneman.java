package lucas.gueiros.firstgame.characters.boneman;

import lucas.gueiros.firstgame.items.Item;

public class Boneman {
  private int positionX;
  private int positionY;
  private int moveX;
  private int moveY;
  private int sizeX;
  private int sizeY;
  private Item itemDireito;

  public void move () {
    this.positionX += moveX;
    this.positionY += moveY;
    this.itemDireito.setX(itemDireito.getX() + moveX);
    this.itemDireito.setY(itemDireito.getY() + moveY);
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
	public Boneman(int positionX, int positionY, int size, int moveX, int moveY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
		this.moveX = moveX;
		this.moveY = moveY;
		this.sizeX = size;
		this.sizeY = size;
		this.itemDireito = itemDireito;
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

	/**
	* Returns value of itemDireito
	* @return
	*/
	public Item getItemDireito() {
		return itemDireito;
	}

	/**
	* Sets new value of itemDireito
	* @param
	*/
	public void setItemDireito(Item itemDireito) {
		this.itemDireito = itemDireito;
    this.itemDireito.setX(positionX + sizeX);
    this.itemDireito.setY(positionY + sizeY);
	}

  public boolean hasItemDireito() {
    return this.itemDireito != null;
  }
}
