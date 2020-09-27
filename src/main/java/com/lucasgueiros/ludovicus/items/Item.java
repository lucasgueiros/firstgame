package com.lucasgueiros.ludovicus.items;

import com.lucasgueiros.ludovicus.generics.*;

public abstract class Item extends PositionedDrawing {
  public abstract void doAction();
  public abstract void undoAction();
  public abstract boolean isDoingAction();
  public abstract void setPositionByHandPosition(Triple handPosition);

  public PositionedDrawing father;
  public void setFather(PositionedDrawing viewPositionedDrawing) {
    this.father = father;
  }
  public PositionedDrawing getFather() {
    return this.father;
  }

  public Item(Triple position, Triple size) {
    super(position, size);
  }

  public Item(Triple position, Triple size, PositionedDrawing father) {
    super(position, size);
    this.father = father;
  }
}
