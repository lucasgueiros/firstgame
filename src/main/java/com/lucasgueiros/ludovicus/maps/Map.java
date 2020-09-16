package com.lucasgueiros.ludovicus.maps;

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

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import com.lucasgueiros.ludovicus.generics.Pair;

public class Map {

  private static final Logger LOGGER = LogManager.getLogger(Map.class);

  private static Pattern p = Pattern.compile("([\\d]+) ([\\d]+)");

  private Cell [][] map;

  private Pair inicZero;

  public Map(String fileUrl) {
    try {
    //BufferedReader reader = new BufferedReader(new InputStreamReader());
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(Map.class.getResourceAsStream(fileUrl));

      Element size = (Element) doc.getElementsByTagName("size").item(0);
      int x = Integer.parseInt(size.getElementsByTagName("x").item(0).getTextContent());
      int y = Integer.parseInt(size.getElementsByTagName("y").item(0).getTextContent());
      map = new Cell [x][y];

      Element zero = (Element) doc.getElementsByTagName("zero").item(0);
      int inicZeroX = Integer.parseInt(zero.getElementsByTagName("x").item(0).getTextContent());
      int inicZeroY = Integer.parseInt(zero.getElementsByTagName("y").item(0).getTextContent());
      this.inicZero = new Pair(inicZeroX,inicZeroY);

      Element ground = (Element) doc.getElementsByTagName("ground").item(0);
      NodeList lines = ground.getElementsByTagName("line");
      for(int i = 0 ; i < x; i++) {
        String string = lines.item(i).getTextContent();
        for(int j = 0; j <y; j++) {
          switch(string.charAt(j)) {
            case 'G':
              map[i][j] = Cell.GRASS;
            break;

            case 'W':
              map[i][j] = Cell.WATER;
            break;

            default:
              map[i][j] = Cell.GRASS;
          }
        }
      }

      Node objects = doc.getElementsByTagName("objects").item(0);
    } catch (ParserConfigurationException e) {
      LOGGER.atError().log(e);
    } catch (SAXException  e) {
      LOGGER.atError().log(e);
    } catch (FileNotFoundException e) {
      LOGGER.atError().log(e);
    } catch (IOException e) {
      LOGGER.atError().log(e);
    }
  }

  public Pair getInicZero() {
    return inicZero;
  }

  public void draw(Graphics2D g2d, Pair relativeTo){
    int cellx = 0, celly = 0;
    for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[0].length; j++) {
        map[i][j].draw(g2d,new Pair(cellx,celly).relative(relativeTo));
        cellx += 25;
      }
      celly += 25;
      cellx = 0;
    }

  }

}
