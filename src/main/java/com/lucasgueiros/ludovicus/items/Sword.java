package com.lucasgueiros.ludovicus.items;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lucasgueiros.ludovicus.generics.Pair;
import com.lucasgueiros.ludovicus.generics.Drawing;
import com.lucasgueiros.ludovicus.generics.Triple;
import com.lucasgueiros.ludovicus.generics.PositionedDrawing;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Sword extends Item {

  public static enum SwordStatus {HANDLE,ATTACK};

  private final static Logger logger = LogManager.getLogger(Sword.class);
  private static final BufferedImage SWORD = getResource("/com/lucasgueiros/ludovicus/items/sword-handle.png");
  private static final BufferedImage SWORD_ATTACK =  getResource("/com/lucasgueiros/ludovicus/items/sword-attack.png");

  public SwordStatus status = SwordStatus.HANDLE;

  public Sword(PositionedDrawing father) {
    super(new Triple(0,0,0),new Triple(16,6,8),father);
    super.setName("Sword");
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

  public void draw(Graphics2D g, Pair relativeTo) {
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
    Pair relativePosition = super.viewPosition.relative(relativeTo);
    logger.atTrace().log("relativePosition of " + this.getName() + " : "+relativePosition);
    g.drawImage(image, relativePosition.x, relativePosition.y, null);
  }
  public void update() {

  }

  public void doAction() {
    this.setStatus(SwordStatus.ATTACK);
  }

  public void undoAction() {
    this.setStatus(SwordStatus.HANDLE);
  }

  public void setPositionByHandPosition(Triple handPosition) {
    this.position = handPosition.sum(this.isDoingAction() ? new Triple(1,-2,0) : new Triple(-1,-12,0));
    logger.atTrace().log("position of " + this.getName() + " : "+position);
    copyPosition();
  }

}
