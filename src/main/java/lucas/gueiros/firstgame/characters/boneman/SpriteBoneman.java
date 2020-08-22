package lucas.gueiros.firstgame.characters.boneman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SpriteBoneman extends KeyAdapter {
  private Boneman boneman;
  public SpriteBoneman (Boneman boneman) {
    this.boneman = boneman;
  }
  public void setBoneman(Boneman boneman){
    this.boneman = boneman;
  }
  // copied from http://zetcode.com/javagames/movingsprites/
  public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.boneman.setMoveX(-2);
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.boneman.setMoveX(2);
        }

        if (key == KeyEvent.VK_UP) {
            this.boneman.setMoveY(-2);
        }

        if (key == KeyEvent.VK_DOWN) {
            this.boneman.setMoveY(2);
        }


    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.boneman.setMoveX(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.boneman.setMoveX(0);
        }

        if (key == KeyEvent.VK_UP) {
            this.boneman.setMoveY(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            this.boneman.setMoveY(0);
        }
    }

}
