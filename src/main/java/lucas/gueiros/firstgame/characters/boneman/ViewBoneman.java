package lucas.gueiros.firstgame.characters.boneman;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.BasicStroke;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import lucas.gueiros.firstgame.items.Item;

public class ViewBoneman extends Boneman implements Drawable {
  private Drawable father;

  public Drawable getFather() {
    return father;
  }
  public void setFather(Drawable father ){
    this.father = father;
  }
  public void update() {
    super.move();
  }
  public void draw(Graphics2D g) {
    g = (Graphics2D) g.create();

    try {
      BufferedImage image = ImageIO.read(ViewBoneman.class.getResourceAsStream("/characters/ludovicus.png"));
      g.drawImage(image, super.getPositionX(), super.getPositionY(), null);
    } catch (IOException e) {
      g.setColor(new Color(0,255,0));
    }

    if(this.itemDireito.isDoingAction()) {
      this.itemDireito.setPositionX(super.getPositionX() + 22);
      this.itemDireito.setPositionY(super.getPositionY() + 14);
    } else {
      this.itemDireito.setPositionX(super.getPositionX() + 20);
      this.itemDireito.setPositionY(super.getPositionY() + 4);
    }

    this.itemDireito.draw(g);
    Toolkit.getDefaultToolkit().sync();
  }

  private Item itemDireito;
	/**
	* Returns value of itemDireito
	* @return
	*/
	public Item getItemDireito() {
		return itemDireito;
	}

  public ViewBoneman(int positionX, int positionY, int sizeX, int sizeY, int moveX, int moveY) {
		super(positionX, positionY, sizeX, sizeY, moveX, moveY);
  }

	/**
	* Sets new value of itemDireito
	* @param
	*/
	public void setItemDireito(Item itemDireito) {
		this.itemDireito = itemDireito;
	}

  public boolean hasItemDireito() {
    return this.itemDireito != null;
  }


  public void setMoveX(int moveX){
    super.setMoveX(moveX);
  }
  public void setMoveY(int moveY){
    super.setMoveY(moveY);
  }

}
