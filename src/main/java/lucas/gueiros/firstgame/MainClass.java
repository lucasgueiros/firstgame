package lucas.gueiros.firstgame;

import java.awt.EventQueue;
import lucas.gueiros.firstgame.application.App;

public class MainClass {
  public static void main (String [] args) {
    EventQueue.invokeLater(() -> {
            App ex = new App();
            ex.setVisible(true);
        });
  }
}
