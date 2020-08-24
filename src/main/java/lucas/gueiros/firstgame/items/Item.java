package lucas.gueiros.firstgame.items;

import lucas.gueiros.firstgame.util.Drawable;

public interface Item extends Drawable {
  public int getX();
  public int getY();
  public void setX(int x);
  public void setY(int y);
}
