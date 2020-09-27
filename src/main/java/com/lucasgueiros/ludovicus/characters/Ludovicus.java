package com.lucasgueiros.ludovicus.characters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import com.lucasgueiros.ludovicus.items.Item;
import com.lucasgueiros.ludovicus.generics.Pair;
import com.lucasgueiros.ludovicus.generics.Triple;
import com.lucasgueiros.ludovicus.generics.Drawing;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Ludovicus extends Character {

  private final static Logger logger = LogManager.getLogger(Ludovicus.class);
  private final static BufferedImage LUDOVICUS = getResource("/com/lucasgueiros/ludovicus/characters/ludovicus-front.png");

  public Ludovicus(Triple position) {
		super(position,new Triple(10,20,20));
    super.setName("Ludovicus");
  }
  protected BufferedImage getImage() {
    return LUDOVICUS;
  }

  protected Triple getHandPosition(){
    Triple handPosition = super.position.sum(new Triple(21,29,29));
    logger.atTrace().log("handPosition of " + this.getName() + " : " + handPosition);
    return handPosition;
  }

}
