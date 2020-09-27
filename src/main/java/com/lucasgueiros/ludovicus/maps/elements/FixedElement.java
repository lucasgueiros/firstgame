package com.lucasgueiros.ludovicus.maps.elements;

import com.lucasgueiros.ludovicus.generics.PositionedDrawing;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import com.lucasgueiros.ludovicus.generics.Pair;
import com.lucasgueiros.ludovicus.generics.Triple;
public abstract class FixedElement extends PositionedDrawing {

  protected abstract BufferedImage getImage();

  public void draw(Graphics2D g, Pair relativeTo) {
    g = (Graphics2D) g.create();

    BufferedImage image = this.getImage();
    Pair relativePosition = super.viewPosition.relative(relativeTo);
    g.drawImage(image, relativePosition.x, relativePosition.y, null);
  }

  public FixedElement (Triple position, Triple size){
    super(position, size);
  }

}
