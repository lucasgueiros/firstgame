package lucas.gueiros.firstgame.board;

import java.awt.Graphics;
import javax.swing.JPanel;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

public class Board extends JPanel {

  public List<Drawable> drawables;

  public Board() {
    initBoard();
    drawables = new ArrayList<>();
  }

  private void initBoard() {
    setPreferredSize(new Dimension(900,500));
  }

  public void addDrawble(Drawable drawable) {
    this.drawables.add(drawable);
  }

  @Override
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for(Drawable drawable : drawables) {
      drawable.draw(g2d);
    }
  }

}
