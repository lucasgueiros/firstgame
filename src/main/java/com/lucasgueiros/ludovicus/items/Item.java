package com.lucasgueiros.ludovicus.items;

import com.lucasgueiros.ludovicus.generics.Positionable;
import com.lucasgueiros.ludovicus.generics.Pair;

public abstract class Item extends Positionable {
  public abstract void doAction();
  public abstract void undoAction();
  public abstract boolean isDoingAction();
  public abstract void setPositionByHandPosition(Pair handPosition);

  public Positionable father;
  public void setFather(Positionable positionable) {
    this.father = father;
  }
  public Positionable getFather() {
    return this.father;
  }

  public Item(Pair position, Pair size) {
    super(position, size);
  }
}
