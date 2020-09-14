package com.lucasgueiros.ludovicus.game;

import javax.swing.JFrame;
import com.lucasgueiros.ludovicus.game.Board;
import com.lucasgueiros.ludovicus.items.Sword;
import com.lucasgueiros.ludovicus.characters.Ludovicus;
import com.lucasgueiros.ludovicus.controls.CharacterUserController;

public class Game extends JFrame
{
  public Game () {
    initUi();
  }

  private void initUi() {
    Ludovicus ludovicus = new Ludovicus(100,100,10,20,0,0);
    Sword sword = new Sword(0,0,7,16);
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
