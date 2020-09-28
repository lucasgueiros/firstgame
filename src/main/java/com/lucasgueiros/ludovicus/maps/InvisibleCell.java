package com.lucasgueiros.ludovicus.maps;

import com.lucasgueiros.ludovicus.generics.Drawable;
import com.lucasgueiros.ludovicus.generics.Pair;
import java.awt.Graphics2D;

public class InvisibleCell extends Drawable {
  public void draw(Graphics2D g, Pair relativeTo) {
  }

  public void update() {
    
  }

  public InvisibleCell (Pair position){
    super(position,new Pair(25,25));
  }
}
