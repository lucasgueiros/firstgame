package com.lucasgueiros.ludovicus.maps;

import com.lucasgueiros.ludovicus.generics.Positionable;
import com.lucasgueiros.ludovicus.generics.Pair;

import java.awt.TexturePaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BasicStroke;


import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public enum Cell {
  GRASS("/com/lucasgueiros/ludovicus/maps/cells/grass.png",'G',true),
  WATER("/com/lucasgueiros/ludovicus/maps/cells/water.png",'W',false);

  private final TexturePaint texture;
  private final char c;
  private final boolean podePassar;
  private static final int SIZE = 25;

  private Cell(String url, char c, boolean podePassar){
    this.texture = new TexturePaint(getResource(url), new Rectangle(SIZE,SIZE));
    this.c = c;
    this.podePassar = podePassar;
  }

  public void draw(Graphics2D g2d, Pair position){
    g2d.setStroke(new BasicStroke(4.0F));
    g2d.setPaint(texture);
    g2d.fillRect(position.x,position.y,SIZE,SIZE);
  }

	/**
	* Returns value of texture
	* @return
	*/
	public TexturePaint getTexture() {
		return texture;
	}

	/**
	* Returns value of c
	* @return
	*/
	public char getC() {
		return c;
	}

	/**
	* Returns value of podePassar
	* @return
	*/
	public boolean isPodePassar() {
		return podePassar;
	}

	/**
	* Returns value of SIZE
	* @return
	*/
	public static int getSIZE() {
		return SIZE;
	}

}
