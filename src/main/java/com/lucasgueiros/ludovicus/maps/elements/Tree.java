package com.lucasgueiros.ludovicus.maps.elements;

import java.awt.image.BufferedImage;

import com.lucasgueiros.ludovicus.generics.Pair;

import static com.lucasgueiros.ludovicus.services.ImageResources.getResource;

public class Tree extends FixedElement {
  private enum TreeStatus {
    WHOLE("/com/lucasgueiros/ludovicus/maps/elements/tree.png"),CUTTED("/com/lucasgueiros/ludovicus/maps/elements/tree-cutted.png"),BURNING("/com/lucasgueiros/ludovicus/maps/elements/tree-burning.png");
    public final BufferedImage image;
    private TreeStatus(String url) {
      image = getResource(url);
    }
    public BufferedImage getImage() {
      return image;
    }
  }

  public Tree (Pair position){
    super(position, new Pair(51,66));
  }

  private TreeStatus status = TreeStatus.WHOLE;

  public void update(){
  }

  protected BufferedImage getImage() {
    return status.getImage();
  }

}
