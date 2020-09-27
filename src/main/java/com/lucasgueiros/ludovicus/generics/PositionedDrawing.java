package com.lucasgueiros.ludovicus.generics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class PositionedDrawing extends Drawing {
  private final static Logger logger = LogManager.getLogger(PositionedDrawing.class);

  protected Pair viewPosition; // X x Z~Y
  protected Pair viewSize; // width x viewSize

  public void draw(Graphics2D g, Pair relativeTo, Pair viewPosition){
    draw(g,relativeTo);
  }

  public abstract void draw(Graphics2D g, Pair relativeTo);

  public Pair getCenter() {
    return new Pair(viewPosition.x + (viewSize.x / 2), viewPosition.y + (viewSize.y / 2));
  }

  public void copyPosition() {
    int x = super.position.x;
    // desconsiderando a altura da viewPosition
    int y = super.position.y + this.viewSize.y;
    this.viewPosition = new Pair(x,y);
    logger.atTrace().log("viewSize:  of " + this.getName() + " : " + this.viewSize);
    logger.atTrace().log("viewPosition:  of " + this.getName() + " : " + this.viewPosition);
  }

  public PositionedDrawing(Triple position, Triple size) {
    super(position, size);
    this.viewSize = new Pair(size.x,(size.y/2)+(size.z/2));
    copyPosition();
  }

  // GENERATED CODE

	/**
	* Returns value of viewPosition
	* @return
	*/
	public Pair getPosition() {
		return viewPosition;
	}

	/**
	* Sets new value of viewPosition
	* @param
	*/
	public void setPosition(Pair viewPosition) {
		this.viewPosition = viewPosition;
	}

	/**
	* Returns value of viewSize
	* @return
	*/
	public Pair getSize() {
		return viewSize;
	}

	/**
	* Sets new value of viewSize
	* @param
	*/
	public void setSize(Pair viewSize) {
		this.viewSize = viewSize;
	}

}
