package lucas.gueiros.firstgame.application;

import javax.swing.JFrame;
import lucas.gueiros.firstgame.board.Board;
import lucas.gueiros.firstgame.characters.hobbits.Hobbit;
import lucas.gueiros.firstgame.items.Ring;

public class App extends JFrame
{
  public App () {
    initUi();
  }

  private void initUi() {
    Hobbit frodo = new Hobbit(400,100);
    Ring ring = new Ring(100,100,5);
    frodo.getBoneman().setItemDireito(ring);
    Board board = new Board();
    board.addDrawble(frodo);
    board.addDrawble(ring);
    //addKeyListener(new SpriteBoneman(boneman));
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
