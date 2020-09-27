package com.lucasgueiros.ludovicus.maps.elements;

import com.lucasgueiros.ludovicus.generics.PositionedDrawing;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import com.lucasgueiros.ludovicus.generics.Pair;
public abstract class FixedElement extends PositionedDrawing {

  protected abstract BufferedImage getImage();

  public void draw(Graphics2D g, Pair relativeTo) {
    g = (Graphics2D) g.create();

    BufferedImage image = this.getImage();
    Pair relativePosition = super.position.relative(relativeTo);
    g.drawImage(image, relativePosition.x, relativePosition.y, null);
  }

  public FixedElement (Pair position, Pair size){
    super(position,size);
  }

}
