package lucas.gueiros.firstgame.util;

import java.awt.Graphics2D;

public interface Drawable {
  public int getPositionX();
  public int getPositionY();
  public void setPositionX(int x);
  public void setPositionY(int y);
  public void draw(Graphics2D g);
  public void update();
  public void setFather(Drawable drawable);
  public Drawable getFather();
}
