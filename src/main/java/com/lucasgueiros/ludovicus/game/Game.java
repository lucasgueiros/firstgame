package com.lucasgueiros.ludovicus.game;

import javax.swing.JFrame;
import com.lucasgueiros.ludovicus.game.Board;
import com.lucasgueiros.ludovicus.items.Sword;
import com.lucasgueiros.ludovicus.characters.Ludovicus;
import com.lucasgueiros.ludovicus.controls.CharacterUserController;
import com.lucasgueiros.ludovicus.generics.Pair;

public class Game extends JFrame
{
  public Game () {
    initUi();
  }

  private void initUi() {
    Ludovicus ludovicus = new Ludovicus(new Pair(100,100), new Pair(10,20), new Pair(0,0));
    Sword sword = new Sword(new Pair(0,0),new Pair(7,16));
    ludovicus.setItemDireito(sword);

    Board board = new Board();
    board.addDrawble(ludovicus);
    board.setLudovicus(ludovicus);
    addKeyListener(new CharacterUserController(ludovicus));
    add(board);
    pack();
    //setSize(250,200);
    setTitle("My first java game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
  }


}
