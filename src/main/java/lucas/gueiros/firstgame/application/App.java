package lucas.gueiros.firstgame.application;

import javax.swing.JFrame;
import lucas.gueiros.firstgame.board.Board;
import lucas.gueiros.firstgame.characters.boneman.ViewBoneman;

public class App extends JFrame
{
  public App () {
    initUi();
  }

  private void initUi() {
    Board board = new Board();
    board.addDrawble(new ViewBoneman());
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
