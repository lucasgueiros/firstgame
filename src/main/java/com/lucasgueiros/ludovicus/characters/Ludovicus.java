package com.lucasgueiros.ludovicus.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Position;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Ludovicus extends Character {

  final static Logger logger = LogManager.getLogger(Ludovicus.class);
  private final static BufferedImage LUDOVICUS = getResource("/com/lucasgueiros/ludovicus/characters/ludovicus-front.png");

  public Ludovicus(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super(positionX, positionY, sizeX, sizeY, moveX, moveY);
  }
  protected BufferedImage getImage() {
    return LUDOVICUS;
  }

  protected Position getHandPosition(){
    return new Position(super.getPositionX() + 21, super.getPositionY() + 16);
  }

}
