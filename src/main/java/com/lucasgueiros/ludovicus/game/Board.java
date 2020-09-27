package com.lucasgueiros.ludovicus.game;

import java.awt.Graphics;
import javax.swing.JPanel;
import com.lucasgueiros.ludovicus.generics.PositionedDrawing;
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
import java.util.Collections;

import com.lucasgueiros.ludovicus.maps.Map;
import com.lucasgueiros.ludovicus.generics.Pair;

public class Board extends JPanel  {

  final static Logger logger = LogManager.getLogger(Board.class);
  private List<PositionedDrawing> drawings;
  private Map world;
  private PositionedDrawing ludovicus;

  private Pair viewSize = new Pair(900,500);
  private Pair zero = null;
  private Pair inic = new Pair(50,50);
  private Pair fini = new Pair(850,450);

  public Board() {
    initBoard();
    drawings = new ArrayList<>();
  }

  public void setWorld(Map world) {
    this.world = world;
    this.zero = this.world.getInicZero();
    synchronized(drawings) {
      this.drawings.addAll(world.getObjects());
    }
  }

  private void addKeyListener (KeyAdapter keyAdapter) {
    addKeyListener(keyAdapter);
  }

  private void initBoard() {
    setPreferredSize(new Dimension(viewSize.x,viewSize.y));
  }

  public void addDrawble(PositionedDrawing drawing) {
    synchronized(drawings) {
      this.drawings.add(drawing);
    }
  }

  public void cycle() {
    synchronized (drawings) {
      for(PositionedDrawing viewPositionedDrawing : drawings) {
        viewPositionedDrawing.update();
      }
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

    synchronized (drawings) {
      Collections.sort(drawings);
      for(PositionedDrawing drawing : drawings) {
        drawing.draw(g2d,zero);
      }
    }

  }


  public void setLudovicus(PositionedDrawing ludovicus) {
    this.ludovicus = ludovicus;
  }
}
