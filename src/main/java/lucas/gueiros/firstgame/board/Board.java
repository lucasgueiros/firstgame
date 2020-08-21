package lucas.gueiros.firstgame.board;

import java.awt.Graphics;
import javax.swing.JPanel;
import lucas.gueiros.firstgame.characters.boneman.ViewBoneman;

public class Board extends JPanel {

  public ViewBoneman view;

  public Board() {
    initBoard();
  }

  private void initBoard() {
    view = new ViewBoneman();
    setPreferredSize(view.getSize(this));
  }

  @Override
  public void paintComponent (Graphics g) {
    g.drawImage(view.getImage(), 0, 0, null);
  }

}
