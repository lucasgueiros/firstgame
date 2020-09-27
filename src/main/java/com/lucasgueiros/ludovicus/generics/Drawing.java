package com.lucasgueiros.ludovicus.generics;
import java.awt.Graphics2D;
public abstract class Drawing implements Comparable<Drawing> {

  protected String name;
  protected Triple position;
  protected Triple size;

  public abstract void update();

  public abstract void draw(Graphics2D g, Pair relativeTo, Pair viewPosition);

  @Override
  public int compareTo(Drawing other) {
    if(this.position.z == other.position.z) {
      return this.position.y - other.position.y;
    } else {
      return this.position.z - other.position.z;
    }
  }

  public Drawing(Triple position, Triple size) {
    this.position = position;
    this.size = size;
  }

  public Drawing(Drawing drawing) {
    this.position = drawing.position;
    this.size = drawing.size;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName(){
    return name;
  }
}
