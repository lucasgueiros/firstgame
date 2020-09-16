package com.lucasgueiros.ludovicus.generics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class Drawable {
  private final static Logger logger = LogManager.getLogger(Drawable.class);

  protected Pair position;
  protected Pair size;

  public abstract void draw(Graphics2D g);
  public abstract void update();

  public Position getCenter() {
    return new Position(position.x + (size.x / 2), position.y + (size.y / 2));
  }

  // GENERATED CODE

	/**
	* Default empty Drawable constructor
	*/
	public Drawable() {
		super();
	}

	/**
	* Default Drawable constructor
	*/
	public Drawable(Pair position, Pair size) {
		super();
		this.position = position;
		this.size = size;
	}

	/**
	* Returns value of position
	* @return
	*/
	public Pair getPosition() {
		return position;
	}

	/**
	* Sets new value of position
	* @param
	*/
	public void setPosition(Pair position) {
		this.position = position;
	}

	/**
	* Returns value of size
	* @return
	*/
	public Pair getSize() {
		return size;
	}

	/**
	* Sets new value of size
	* @param
	*/
	public void setSize(Pair size) {
		this.size = size;
	}

}
