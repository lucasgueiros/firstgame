package com.lucasgueiros.ludovicus.game;

import javax.swing.JFrame;
import com.lucasgueiros.ludovicus.game.Board;
import com.lucasgueiros.ludovicus.items.Sword;
import com.lucasgueiros.ludovicus.characters.Ludovicus;
import com.lucasgueiros.ludovicus.controls.CharacterUserController;
import com.lucasgueiros.ludovicus.generics.Pair;
import com.lucasgueiros.ludovicus.generics.Triple;
import com.lucasgueiros.ludovicus.maps.Map;

public class Game extends JFrame
{
  public Game () {
    initUi();
  }

  private void initUi() {
    Map world = new Map("/com/lucasgueiros/ludovicus/maps/world.xml");
    Ludovicus ludovicus = new Ludovicus(new Triple(300,300,0));
    Sword sword = new Sword(ludovicus);
    ludovicus.setItemDireito(sword);

    Board board = new Board();
    board.setWorld(world);
    board.addDrawble(ludovicus);
    board.setLudovicus(ludovicus);
    addKeyListener(new CharacterUserController(ludovicus));
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    new Thread(new Animator(board)).start();
  }


}
