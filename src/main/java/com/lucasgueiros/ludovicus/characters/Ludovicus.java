package com.lucasgueiros.ludovicus.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Pair;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Ludovicus extends Character {

  final static Logger logger = LogManager.getLogger(Ludovicus.class);
  private final static BufferedImage LUDOVICUS = getResource("/com/lucasgueiros/ludovicus/characters/ludovicus-front.png");

  public Ludovicus(Pair position, Pair size, Pair move) {
		super(position, size, move);
  }
  protected BufferedImage getImage() {
    return LUDOVICUS;
  }

  protected Pair getHandPosition(){
    return super.position.sum(new Pair(21,16));
  }

}
