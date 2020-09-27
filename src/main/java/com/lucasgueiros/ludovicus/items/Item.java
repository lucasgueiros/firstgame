package com.lucasgueiros.ludovicus.items;

import com.lucasgueiros.ludovicus.generics.PositionedDrawing;
import com.lucasgueiros.ludovicus.generics.Pair;

public abstract class Item extends PositionedDrawing {
  public abstract void doAction();
  public abstract void undoAction();
  public abstract boolean isDoingAction();
  public abstract void setPositionByHandPosition(Pair handPosition);

  public PositionedDrawing father;
  public void setFather(PositionedDrawing positionedDrawing) {
    this.father = father;
  }
  public PositionedDrawing getFather() {
    return this.father;
  }

  public Item(Pair position, Pair size) {
    super(position, size);
  }
}
