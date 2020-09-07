package lucas.gueiros.firstgame;

import java.awt.EventQueue;
import com.lucasgueiros.ludovicus.game.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {
  final static Logger logger = LogManager.getLogger(MainClass.class);

  public static void main (String [] args) {
    logger.atInfo().log("Iniciando o jogo");
    EventQueue.invokeLater(() -> {
            Game ex = new Game();
            ex.setVisible(true);
        });
  }
}
