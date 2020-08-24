package lucas.gueiros.firstgame.board;

import java.awt.Graphics;
import javax.swing.JPanel;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.event.KeyAdapter;
import java.awt.Color;

  public class Board extends JPanel implements Runnable {

  final static Logger logger = LogManager.getLogger(Board.class);
  public List<Drawable> drawables;

  public Board() {
    initBoard();
    drawables = new ArrayList<>();
  }

  private void addKeyListener (KeyAdapter keyAdapter) {
    addKeyListener(keyAdapter);
  }

  private void initBoard() {
    setPreferredSize(new Dimension(900,500));
  }

  public void addDrawble(Drawable drawable) {
    this.drawables.add(drawable);
  }

  public void cycle() {
    for(Drawable drawable : drawables) {
      drawable.update();
    }
  }

  @Override
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(new Color(0,255,0));
    g2d.fillRect(0,0,900,500);
    for(Drawable drawable : drawables) {
      drawable.draw(g2d);
    }
  }

  // coppied from http://zetcode.com/javagames/animation/
  private final int B_WIDTH = 350;
  private final int B_HEIGHT = 350;
  private final int INITIAL_X = -40;
  private final int INITIAL_Y = -40;
  private final int DELAY = 25;
  private Thread animator;

  @Override
  public void addNotify() {
      super.addNotify();

      animator = new Thread(this);
      animator.start();
  }

  @Override
  public void run() {

      long beforeTime, timeDiff, sleep;

      beforeTime = System.currentTimeMillis();

      while (true) {

          cycle();
          repaint();

          timeDiff = System.currentTimeMillis() - beforeTime;
          sleep = DELAY - timeDiff;

          if (sleep < 0) {
              sleep = 2;
          }

          try {
              Thread.sleep(sleep);
          } catch (InterruptedException e) {

              String msg = String.format("Thread interrupted: %s", e.getMessage());
              logger.atError().log(msg);
          }

          beforeTime = System.currentTimeMillis();
      }
  }

}
