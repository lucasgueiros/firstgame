package com.lucasgueiros.ludovicus.generics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class Drawable {
  private final static Logger logger = LogManager.getLogger(Drawable.class);
  public static BufferedImage getResource(String url) {
    try {
      return ImageIO.read(Drawable.class.getResourceAsStream(url));
    } catch (IOException e) {
      logger.error(e.toString());
    }
    return null;
  }

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
