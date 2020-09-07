package lucas.gueiros.firstgame.items;

import lucas.gueiros.firstgame.util.Drawable;

public interface Item extends Drawable {
  public void doAction();
  public void undoAction();
  public boolean isDoingAction();
}
