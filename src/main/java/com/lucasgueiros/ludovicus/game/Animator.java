package com.lucasgueiros.ludovicus.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Animator implements Runnable {

  private Board board;

  final static Logger logger = LogManager.getLogger(Animator.class);

  // coppied from http://zetcode.com/javagames/animation/
  private final int DELAY = 25;

  @Override
  public void run() {

      long beforeTime, timeDiff, sleep;

      beforeTime = System.currentTimeMillis();

      while (true) {

          board.cycle();
          board.repaint();

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


	/**
	* Default empty Animator constructor
	*/
	public Animator() {
		super();
	}

	/**
	* Default Animator constructor
	*/
	public Animator(Board board) {
		super();
		this.board = board;
	}

	/**
	* Returns value of board
	* @return
	*/
	public Board getBoard() {
		return board;
	}

	/**
	* Sets new value of board
	* @param
	*/
	public void setBoard(Board board) {
		this.board = board;
	}
}
