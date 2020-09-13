package com.lucasgueiros.ludovicus.items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lucasgueiros.ludovicus.generics.Position;

public class Sword extends Item {

  public enum SwordStatus {HANDLE,ATTACK};

  public SwordStatus status = SwordStatus.HANDLE;
  private final static Logger logger = LogManager.getLogger(Sword.class);

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
    try {
      BufferedImage image;
      switch(status) {
        case HANDLE:
          image = ImageIO.read(Sword.class.getResourceAsStream("/com/lucasgueiros/ludovicus/items/sword.png"));
          break;
        case ATTACK:
          image = ImageIO.read(Sword.class.getResourceAsStream("/com/lucasgueiros/ludovicus/items/sword-attack.png"));
          break;
        default:
          image = ImageIO.read(Sword.class.getResourceAsStream("/com/lucasgueiros/ludovicus/items/sword.png"));
      }
      g.drawImage(image, positionX, positionY, null);
    } catch (IOException e) {
      logger.error(e.toString());
    }

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
