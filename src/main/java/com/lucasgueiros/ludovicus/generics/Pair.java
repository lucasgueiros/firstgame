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

  public Pair setX(int x) {
    return new Pair(x, this.y);
  }
  public Pair setY(int y) {
    return new Pair(this.x, y);
  }

  public Pair relative(Pair to) {
    return new Pair(this.x - to.x, this.y - to.y);
  }
}
