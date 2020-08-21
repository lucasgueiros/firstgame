package lucas.gueiros.firstgame.application;

import javax.swing.JFrame;
import lucas.gueiros.firstgame.board.Board;

public class App extends JFrame
{
  public App () {
    initUi();
  }

  private void initUi() {
    add(new Board());
    setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
