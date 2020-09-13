package com.lucasgueiros.ludovicus.items;

import com.lucasgueiros.ludovicus.generics.Drawable;
import com.lucasgueiros.ludovicus.generics.Position;

public abstract class Item extends Drawable {
  public abstract void doAction();
  public abstract void undoAction();
  public abstract boolean isDoingAction();
  public abstract void setPositionByHandPosition(Position handPosition);

  public Drawable father;
  public void setFather(Drawable drawable) {
    this.father = father;
  }
  public Drawable getFather() {
    return this.father;
  }

  public Item(int positionX, int positionY, int sizeX, int sizeY) {
    super(positionX, positionY, sizeX, sizeY);
  }
}
