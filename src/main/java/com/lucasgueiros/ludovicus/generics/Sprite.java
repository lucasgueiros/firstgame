package com.lucasgueiros.ludovicus.generics;

import com.lucasgueiros.ludovicus.items.Item;

public abstract class Sprite extends Drawable {

  private Pair move;

  public void update () {
    super.position = super.position.sum(move);
  }

	// generated code

	/**
	* Default empty Sprite constructor
	*/
	public Sprite() {
		super();
	}

	/**
	* Default Sprite constructor
	*/
	public Sprite(Pair move) {
		super();
		this.move = move;
	}

	/**
	* Returns value of move
	* @return
	*/
	public Pair getMove() {
		return move;
	}

	/**
	* Sets new value of move
	* @param
	*/
	public void setMove(Pair move) {
		this.move = move;
	}
}
