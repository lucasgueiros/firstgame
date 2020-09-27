package com.lucasgueiros.ludovicus.generics;

public class Triple {
  public final int x;
  public final int y;
  public final int z;

  public Triple(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public String toString() {
    return "(" + x + "," + y + "," + z + ")";
  }

  public Triple sum(Triple sum) {
    return new Triple(this.x + sum.x, this.y + sum.y, this.z + sum.z);
  }

  public Triple setX(int x) {
    return new Triple(x, this.y, this.z);
  }
  public Triple setY(int y) {
    return new Triple(this.x, y, this.z);
  }
  public Triple setZ(int z) {
    return new Triple(this.x, this.y, z);
  }

}
