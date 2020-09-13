package com.lucasgueiros.ludovicus.characters;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import com.lucasgueiros.ludovicus.generics.Drawable;
import java.awt.BasicStroke;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Sprite;

import com.lucasgueiros.ludovicus.generics.Position;

public abstract class Character extends Sprite {

  protected abstract BufferedImage getImage();

  protected abstract Position getHandPosition();

  public void update() {
    super.update();
  }
  public void draw(Graphics2D g) {
    g = (Graphics2D) g.create();

    BufferedImage image = this.getImage();
    g.drawImage(image, super.getPositionX(), super.getPositionY(), null);

    if(this.itemDireito != null) {
      this.itemDireito.setPositionByHandPosition(this.getHandPosition());
      this.itemDireito.draw(g);
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

  public Character(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super(positionX, positionY, sizeX, sizeY, moveX, moveY);
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


  public void setMoveX(int moveX){
    super.setMoveX(moveX);
  }
  public void setMoveY(int moveY){
    super.setMoveY(moveY);
  }

}
