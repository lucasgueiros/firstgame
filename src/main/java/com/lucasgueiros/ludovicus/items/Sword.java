package com.lucasgueiros.ludovicus.items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lucasgueiros.ludovicus.generics.Position;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Sword extends Item {

  public static enum SwordStatus {HANDLE,ATTACK};

  private final static Logger logger = LogManager.getLogger(Sword.class);
  private static final BufferedImage SWORD = getResource("/com/lucasgueiros/ludovicus/items/sword-handle.png");
  private static final BufferedImage SWORD_ATTACK =  getResource("/com/lucasgueiros/ludovicus/items/sword-attack.png");

  public SwordStatus status = SwordStatus.HANDLE;

  public Sword(int positionX, int positionY, int sizeX, int sizeY) {
    super(positionX, positionY, sizeX, sizeY);
  }

  public SwordStatus getStatus() {
    return status;
  }

  public void setStatus (SwordStatus status) {
    this.status = status;
  }
  public boolean isDoingAction() {
    return this.status == SwordStatus.ATTACK;
  }

  public void draw(Graphics2D g) {
    BufferedImage image;
    switch(status) {
      case HANDLE:
        image = SWORD;
        break;
      case ATTACK:
        image = SWORD_ATTACK;
        break;
      default:
        image = SWORD_ATTACK;
    }
    g.drawImage(image, positionX, positionY, null);
  }
  public void update() {

  }

  public void doAction() {
    this.setStatus(SwordStatus.ATTACK);
  }

  public void undoAction() {
    this.setStatus(SwordStatus.HANDLE);
  }

  public void setPositionByHandPosition(Position handPosition) {
    this.setPositionX(handPosition.x + ( this.isDoingAction() ? 1 : -1) );
    this.setPositionY(handPosition.y + ( this.isDoingAction() ? -2 : -12) );
  }

}
