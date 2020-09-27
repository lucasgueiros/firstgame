package com.lucasgueiros.ludovicus.generics;

import com.lucasgueiros.ludovicus.items.Item;

public abstract class Sprite extends PositionedDrawing {

  private Triple move;

  public void update () {
    super.position = super.position.sum(move);
    copyPosition();
  }

	// generated code

	/**
	* Default Sprite constructor
	*/
	public Sprite(Triple position, Triple size, Triple move) {
		super(position, size);
		this.move = move;
	}

	/**
	* Returns value of move
	* @return
	*/
	public Triple getMove() {
		return move;
	}

	/**
	* Sets new value of move
	* @param
	*/
	public void setMove(Triple move) {
		this.move = move;
	}
}
