package lucas.gueiros.firstgame.application;

import javax.swing.JFrame;
import lucas.gueiros.firstgame.board.Board;
import lucas.gueiros.firstgame.items.Sword;
import lucas.gueiros.firstgame.characters.boneman.ViewBoneman;
import lucas.gueiros.firstgame.characters.boneman.Boneman;
import lucas.gueiros.firstgame.characters.boneman.SpriteBoneman;

public class App extends JFrame
{
  public App () {
    initUi();
  }

  private void initUi() {
    ViewBoneman ludovicus = new ViewBoneman(100,100,10,20,0,0);
    Sword sword = new Sword(50,50,5);
    ludovicus.setItemDireito(sword);

    Board board = new Board();
    board.addDrawble(ludovicus);
    addKeyListener(new SpriteBoneman(ludovicus));
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
