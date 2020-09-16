package com.lucasgueiros.ludovicus.items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lucasgueiros.ludovicus.generics.Pair;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Sword extends Item {

  public static enum SwordStatus {HANDLE,ATTACK};

  private final static Logger logger = LogManager.getLogger(Sword.class);
  private static final BufferedImage SWORD = getResource("/com/lucasgueiros/ludovicus/items/sword-handle.png");
  private static final BufferedImage SWORD_ATTACK =  getResource("/com/lucasgueiros/ludovicus/items/sword-attack.png");

  public SwordStatus status = SwordStatus.HANDLE;

  public Sword(Pair position, Pair size) {
    super(position, size);
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

  public void setPositionByHandPosition(Position hand) {
    this.position = hand.sum(this.isDoingAction() ? new Pair(1,-2) : new Pair(-1,-12));
  }

}
