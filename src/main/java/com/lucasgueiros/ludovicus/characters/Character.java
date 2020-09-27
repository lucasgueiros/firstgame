package com.lucasgueiros.ludovicus.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import com.lucasgueiros.ludovicus.generics.PositionedDrawing;
import java.awt.BasicStroke;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Sprite;

import com.lucasgueiros.ludovicus.generics.Pair;
import com.lucasgueiros.ludovicus.generics.Triple;
import com.lucasgueiros.ludovicus.generics.Drawing;

public abstract class Character extends Sprite {

  protected abstract BufferedImage getImage();

  private final static Logger logger = LogManager.getLogger(Character.class);

  protected abstract Triple getHandPosition();

  public void update() {
    super.update();
  }
  public void draw(Graphics2D g, Pair relativeTo) {
    g = (Graphics2D) g.create();
    logger.atTrace().log("position:  of " + this.getName() + " : " + this.position);
    BufferedImage image = this.getImage();
    copyPosition();
    logger.atTrace().log("view position:  of " + this.getName() + " : " + this.viewPosition);
    logger.atTrace().log("relative to:  of " + this.getName() + " : " + relativeTo);
    Pair relativePosition = super.viewPosition.relative(relativeTo);
    logger.atTrace().log("relativePosition:  of " + this.getName() + " : " + relativePosition);
    g.drawImage(image, relativePosition.x, relativePosition.y, null);

    if(this.itemDireito != null) {
      this.itemDireito.setPositionByHandPosition(this.getHandPosition());
      this.itemDireito.draw(g, relativeTo);
    }

    Toolkit.getDefaultToolkit().sync();
  }

  private Item itemDireito;
	/**
	* Returns value of itemDireito
	* @return
	*/
	public Item getItemDireito() {
		return itemDireito;
	}

  public Character(Triple position, Triple size) {
		super(position, size, new Triple(0,0,0));
  }

	/**
	* Sets new value of itemDireito
	* @param
	*/
	public void setItemDireito(Item itemDireito) {
		this.itemDireito = itemDireito;
	}

  public boolean hasItemDireito() {
    return this.itemDireito != null;
  }

}
