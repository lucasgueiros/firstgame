package lucas.gueiros.firstgame.characters.boneman;

public class Boneman {
  // esse ponto é o topo do pescoco
  private int positionX;
  private int positionY;
  private int moveX;
  private int moveY;
  public Boneman(int positionX, int positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.moveX = 0;
    this.moveY = 0;
  }
  public void move () {
    this.positionX += moveX;
    this.positionY += moveY;
  }
  public void setMoveX (int x) {
    this.moveX = x;
  }
  public void setMoveY (int y) {
    this.moveY = y;
  }
  public int getMoveX () {
    return this.moveX;
  }
  public int getMoveY () {
    return this.moveY;
  }
  public int getPositionX() {
    return positionX;
  }
  public int getPositionY() {
    return positionY;
  }
  public void setPositionY(int y) {
    this.positionY = y;
  }
  public void setPositionX(int x) {
    this.positionX = x;
  }
}
