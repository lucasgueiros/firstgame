package com.lucasgueiros.ludovicus.world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.Graphics2D;

import java.util.Scanner;

import com.lucasgueiros.ludovicus.generics.Pair;

public class World {

  private static final Logger LOGGER = LogManager.getLogger(World.class);

  private static Pattern p = Pattern.compile("([\\d]+) ([\\d]+)");

  private Cell [][] world;

  public World(String fileUrl) {
    /*try {*/
    //BufferedReader reader = new BufferedReader(new InputStreamReader());
    Scanner scanner = new Scanner(World.class.getResourceAsStream(fileUrl));
    //String firstLine = reader.readLine();
    //LOGGER.atDebug().log(firstLine);
    //Matcher m = p.matcher(firstLine);
    //int x = Integer.parseInt(m.group(0));
    //int y = Integer.parseInt(m.group(1));
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    scanner.nextLine();
    world = new Cell [x][y];

    for(int i = 0 ; i < x; i++) {
      String string = scanner.nextLine();
      for(int j = 0; j <y; j++) {
        switch(string.charAt(j)) {
          case 'G':
            world[i][j] = Cell.GRASS;
          break;

          case 'W':
            world[i][j] = Cell.WATER;
          break;

          default:
            world[i][j] = Cell.GRASS;
        }
      }
    }
    /*} catch (FileNotFoundException e) {
      LOGGER.atError().log(e);
    } catch (IOException e) {
      LOGGER.atError().log(e);
    }*/
  }

  public void draw(Graphics2D g2d, Pair position){
    int cellx = 0, celly = 0;
    for(int i = 0; i < world.length; i++) {
      for(int j = 0; j < world.length; j++) {
        world[i][j].draw(g2d,cellx,celly);
        cellx += 25;
      }
      celly += 25;
      cellx = 0;
    }

  }

}
