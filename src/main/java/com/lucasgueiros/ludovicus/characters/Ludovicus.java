package com.lucasgueiros.ludovicus.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Position;

public class Ludovicus extends Character {
  final static Logger logger = LogManager.getLogger(Ludovicus.class);

  public Ludovicus(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super(positionX, positionY, sizeX, sizeY, moveX, moveY);
  }
  protected BufferedImage getImage() {
    try {
      return ImageIO.read(Ludovicus.class.getResourceAsStream("/com/lucasgueiros/ludovicus/characters/ludovicus.png"));
    } catch (IOException e) {
      logger.atError().log(e);
    }
    return null;
  }

  protected Position getHandPosition(){
    return new Position(super.getPositionX() + 21, super.getPositionY() + 16);
  }

}
