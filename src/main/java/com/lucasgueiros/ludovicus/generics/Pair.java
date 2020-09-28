package com.lucasgueiros.ludovicus.generics;

public class Pair {
  public final int x;
  public final int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }

  public Pair sum(Pair sum) {
    return new Pair(this.x + sum.x, this.y + sum.y);
  }

  public Pair subtract(Pair sum) {
    return new Pair(this.x - sum.x, this.y - sum.y);
  }

  public Pair setX(int x) {
    return new Pair(x, this.y);
  }
  public Pair setY(int y) {
    return new Pair(this.x, y);
  }

  public Pair relative(Pair to) {
    return new Pair(this.x - to.x, this.y - to.y);
  }

  public Pair outOfBounds(Pair inic, Pair fini) {
    int x = 0;
    int y = 0;
    if (this.x < inic.x) {
      x =  this.x - inic.x;
    } else if (this.x > fini.x) {
      x = this.x - fini.x;
    }
    if (this.y < inic.y){
      y = this.y - inic.y;
    } else if (this.y > fini.y) {
      y = this.y - fini.y;
    }
    return new Pair(x,y);
  }
}
