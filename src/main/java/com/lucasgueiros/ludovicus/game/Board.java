package com.lucasgueiros.ludovicus.game;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.lucasgueiros.ludovicus.generics.Drawable;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.TexturePaint;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.io.IOException;

import com.lucasgueiros.ludovicus.maps.Map;
import com.lucasgueiros.ludovicus.generics.Pair;

public class Board extends JPanel implements Runnable {

  final static Logger logger = LogManager.getLogger(Board.class);
  public List<Drawable> drawables;
  private Map world;
  private Drawable ludovicus;

  private Pair size = new Pair(900,500);
  private Pair zero = null;
  private Pair inic = new Pair(50,50);
  private Pair fini = new Pair(850,450);

  public Board() {
    initBoard();
    drawables = new ArrayList<>();
  }

  public void setWorld(Map world) {
    this.world = world;
    this.zero = this.world.getInicZero();
    this.drawables.addAll(world.getObjects());
  }

  private void addKeyListener (KeyAdapter keyAdapter) {
    addKeyListener(keyAdapter);
  }

  private void initBoard() {
    setPreferredSize(new Dimension(size.x,size.y));
  }

  public void addDrawble(Drawable drawable) {
    this.drawables.add(drawable);
  }

  public void cycle() {
    for(Drawable drawable : drawables) {
      drawable.update();
    }
  }

  private Pair calcZero() {
    Pair lp = ludovicus.getPosition().relative(zero);
    Pair result = lp.outOfBounds(inic,fini);
    Pair sum = zero.sum(result);
    return sum;
  }

  @Override
  public void paintComponent (Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    zero = calcZero();
    world.draw(g2d,zero);
    for(Drawable drawable : drawables) {
      drawable.draw(g2d,zero);
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
  public void setLudovicus(Drawable ludovicus) {
    this.ludovicus = ludovicus;
  }
}
