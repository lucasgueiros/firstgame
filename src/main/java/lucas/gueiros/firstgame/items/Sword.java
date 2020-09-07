package lucas.gueiros.firstgame.items;

import java.awt.Color;
import java.awt.Graphics2D;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sword implements Item {

  public enum SwordStatus {HANDLE,ATTACK};

  public SwordStatus status = SwordStatus.HANDLE;
  public int x;
  public int y;
  public int size;
  public Drawable father;
  private final static Logger logger = LogManager.getLogger(Sword.class);

  public void setFather(Drawable drawable) {
    this.father = father;
  }
  public Drawable getFather() {
    return this.father;
  }

  public SwordStatus getStatus() {
    return status;
  }

  public void setStatus (SwordStatus status) {
    this.status = status;
  }
  public boolean isDoingAction() {
    return this.status == SwordStatus.ATTACK;
  }

  public void draw(Graphics2D g) {
    try {
      BufferedImage image;
      switch(status) {
        case HANDLE:
          image = ImageIO.read(Sword.class.getResourceAsStream("/itens/sword.png"));
          break;
        case ATTACK:
          image = ImageIO.read(Sword.class.getResourceAsStream("/itens/sword-attack.png"));
          break;
        default:
          image = ImageIO.read(Sword.class.getResourceAsStream("/itens/sword.png"));
      }
      g.drawImage(image, x, y, null);
    } catch (IOException e) {
      logger.error(e.toString());
    }

  }
  public void update() {

  }

	/**
	* Returns value of x
	* @return
	*/
	public int getPositionX() {
		return x;
	}

	/**
	* Sets new value of x
	* @param
	*/
	public void setPositionX(int x) {
		this.x = x;
	}

	/**
	* Returns value of y
	* @return
	*/
	public int getPositionY() {
		return y;
	}

	/**
	* Sets new value of y
	* @param
	*/
	public void setPositionY(int y) {
		this.y = y;
	}

	/**
	* Returns value of size
	* @return
	*/
	public int getSize() {
		return size;
	}

	/**
	* Sets new value of size
	* @param
	*/
	public void setSize(int size) {
		this.size = size;
	}

	/**
	* Default empty Ring constructor
	*/
	public Sword() {
		super();
	}

  /**
	* Default Ring constructor
	*/
	public Sword(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.size = 5;
	}

  public void doAction() {
    this.setStatus(SwordStatus.ATTACK);
  }

  public void undoAction() {
    this.setStatus(SwordStatus.HANDLE);
  }

	/**
	* Default Ring constructor
	*/
	public Sword(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
