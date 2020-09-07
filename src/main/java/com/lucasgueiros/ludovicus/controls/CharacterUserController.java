package com.lucasgueiros.ludovicus.controls;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.lucasgueiros.ludovicus.characters.Character;

public class CharacterUserController extends KeyAdapter {
  private Character character;
  public CharacterUserController (Character character) {
    this.character = character;
  }
  public void setCharacter(Character character){
    this.character = character;
  }
  public Character getCharacter() {
    return character;
  }
  // copied from http://zetcode.com/javagames/movingcharacters/
  public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.character.setMoveX(-2);
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.character.setMoveX(2);
        }

        if (key == KeyEvent.VK_UP) {
            this.character.setMoveY(-2);
        }

        if (key == KeyEvent.VK_DOWN) {
            this.character.setMoveY(2);
        }

        if (key == KeyEvent.VK_SPACE ){
          this.character.getItemDireito().doAction();
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.character.setMoveX(0);
        }

        if (key == KeyEvent.VK_RIGHT) {
            this.character.setMoveX(0);
        }

        if (key == KeyEvent.VK_UP) {
            this.character.setMoveY(0);
        }

        if (key == KeyEvent.VK_DOWN) {
            this.character.setMoveY(0);
        }

        if (key == KeyEvent.VK_SPACE ){
          this.character.getItemDireito().undoAction();
        }
    }

}
