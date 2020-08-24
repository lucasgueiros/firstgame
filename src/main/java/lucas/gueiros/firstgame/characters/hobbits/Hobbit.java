package lucas.gueiros.firstgame.characters.hobbits;

import lucas.gueiros.firstgame.characters.boneman.Boneman;
import lucas.gueiros.firstgame.characters.boneman.ViewBoneman;

public class Hobbit extends ViewBoneman {

  public Hobbit(int positionX, int positionY) {
    super();
    super.setBoneman(new Boneman(positionX,positionY,18,0,0));
    super.setColor(255, 230, 176);
  }

}
