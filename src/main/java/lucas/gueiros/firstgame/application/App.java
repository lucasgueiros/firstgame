package lucas.gueiros.firstgame.application;

import javax.swing.JFrame;
import lucas.gueiros.firstgame.board.Board;
import lucas.gueiros.firstgame.characters.boneman.*;

public class App extends JFrame
{
  public App () {
    initUi();
  }

  private void initUi() {
    Boneman boneman = new Boneman(100,100);
    Board board = new Board();
    board.addDrawble(new ViewBoneman(boneman));
    addKeyListener(new SpriteBoneman(boneman));
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
