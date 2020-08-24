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

public class ViewBoneman implements Drawable {
  private Boneman boneman;
  private Color color = new Color(100,100,100);


  public void update() {
    this.boneman.move();
  }
  public void draw(Graphics2D g) {
    g = (Graphics2D) g.create();
    g.setColor(getColor());
    BasicStroke bs1 = new BasicStroke(6, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
    g.setStroke(bs1);
    int halfSizeX = boneman.getSizeX() / 2;
    int halfSizeY = boneman.getSizeY() / 2;
    int pescoco = boneman.getSizeY() / 8;
    int legY = halfSizeX;
    int legX = halfSizeY;
    int raio = halfSizeX / 2;
    int positionX = boneman.getPositionX() + legX;
    int positionY = boneman.getPositionY() + legY;
    int positionYvirilia = positionY + (5 * raio) + pescoco;

    // tronco
    //g.drawLine(positionX,positionY,positionX, positionYvirilia);
    drawTronco(g, positionX, positionY, positionYvirilia);
    // cabeca
    drawCabeca(g, positionX, positionY, raio);

    // perna esquerda
    drawPernaEsquerda(g, positionX, positionY, legX, legY, positionYvirilia);
    // perna direita
    drawPernaDireita(g, positionX, positionY, legX, legY, positionYvirilia);
    // corrigir pescoco
    positionY += pescoco;
    // braco esquerdo
    drawBracoEsquerdo(g, positionX, positionY, legX, legY);
    // braco direito
    if(boneman.hasItemDireito()){
      drawBracoDireitoComItem(g, positionX, positionY, legX, legY);
      boneman.getItemDireito().draw(g);
    } else {
      drawBracoDireito(g, positionX, positionY, legX, legY);
    }


    Toolkit.getDefaultToolkit().sync();
  }

  public void drawTronco(Graphics2D g, int positionX, int positionY, int positionYvirilia) {
    g.drawLine(positionX,positionY,positionX, positionYvirilia);
  }

  public void drawBracoDireito(Graphics2D g, int positionX, int positionY, int legX, int legY) {
    g.drawLine(positionX,positionY, positionX + legX, positionY + legY);
  }

  public void drawBracoDireitoComItem(Graphics2D g, int positionX, int positionY, int legX, int legY) {
    g.drawLine(positionX,positionY, positionX + legX, positionY - legY);
  }

  public void drawBracoEsquerdo(Graphics2D g, int positionX, int positionY, int legX, int legY) {
    g.drawLine(positionX,positionY, positionX - legX, positionY + legY);
  }

  public void drawPernaDireita(Graphics2D g, int positionX, int positionY, int legX, int legY, int positionYvirilia) {
    g.drawLine(positionX,positionYvirilia, positionX + legX, positionYvirilia + legY);
  }

  public void drawPernaEsquerda(Graphics2D g, int positionX, int positionY, int legX, int legY, int positionYvirilia) {
    g.drawLine(positionX,positionYvirilia, positionX - legX, positionYvirilia + legY);
  }

  public void drawCabeca(Graphics2D g, int positionX, int positionY, int raio) {
    g.fillOval(positionX - raio, positionY - (2 * raio), 2 * raio, 2 * raio);
  }

  public void setColor(int r, int g, int b) {
    this.color = new Color(r,g,b);
  }


	/**
	* Default empty ViewBoneman constructor
	*/
	public ViewBoneman() {
		super();
	}

	/**
	* Default ViewBoneman constructor
	*/
	public ViewBoneman(Boneman boneman, Color color) {
		super();
		this.boneman = boneman;
		this.color = color;
	}

	/**
	* Returns value of boneman
	* @return
	*/
	public Boneman getBoneman() {
		return boneman;
	}

	/**
	* Sets new value of boneman
	* @param
	*/
	public void setBoneman(Boneman boneman) {
		this.boneman = boneman;
	}

	/**
	* Returns value of color
	* @return
	*/
	public Color getColor() {
		return color;
	}

	/**
	* Sets new value of color
	* @param
	*/
	public void setColor(Color color) {
		this.color = color;
	}
}
