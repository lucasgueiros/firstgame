package lucas.gueiros.firstgame.items;

import java.awt.Color;
import java.awt.Graphics2D;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.BasicStroke;

public class Ring implements Item {

  public int x;
  public int y;
  public int size;
  public Color color = new Color(212,175,55);

  public void draw(Graphics2D g) {
    BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
    g.setStroke(bs1);
    g.setColor(color);
    g.drawOval(x,y,size,size);
  }
  public void update() {

  }



	/**
	* Returns value of x
	* @return
	*/
	public int getX() {
		return x;
	}

	/**
	* Sets new value of x
	* @param
	*/
	public void setX(int x) {
		this.x = x;
	}

	/**
	* Returns value of y
	* @return
	*/
	public int getY() {
		return y;
	}

	/**
	* Sets new value of y
	* @param
	*/
	public void setY(int y) {
		this.y = y;
	}

	/**
	* Returns value of size
	* @return
	*/
	public int getSize() {
		return size;
	}

	/**
	* Sets new value of size
	* @param
	*/
	public void setSize(int size) {
		this.size = size;
	}

	/**
	* Default empty Ring constructor
	*/
	public Ring() {
		super();
	}

  /**
	* Default Ring constructor
	*/
	public Ring(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.size = 5;
	}

	/**
	* Default Ring constructor
	*/
	public Ring(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
