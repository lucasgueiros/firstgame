package lucas.gueiros.firstgame.characters.boneman;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import lucas.gueiros.firstgame.util.Drawable;
import java.awt.BasicStroke;
import java.awt.Toolkit;

public class ViewBoneman implements Drawable {
  private Image image;

  private Boneman boneman;

  // esse ponto é o topo do pescoco
  private int positionX;
  private int positionY;

  public ViewBoneman () {
    ImageIcon ii = new ImageIcon("src/main/resources/characters/boneman/boneman-relaxado.png");
    image = ii.getImage();
    positionX = 100;
    positionY = 100;
  }
  public Image getImage() {
    return image;
  }
  public Dimension getSize(ImageObserver observer) {
    return new Dimension (image.getHeight(observer), image.getWidth(observer));
  }
  public void update() {
    this.positionX = this.positionX + 2;
    this.positionY = this.positionY + 2;
  }
  public void draw(Graphics2D g) {
    g = (Graphics2D) g.create();
    BasicStroke bs1 = new BasicStroke(4, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
    g.setStroke(bs1);

    int positionYvirilia = positionY + 45;
    int legY = 20;
    int legX = 20;
    int raio = 10;
    // tronco
    g.drawLine(positionX,positionY,positionX, positionYvirilia);
    // perna esquerda
    g.drawLine(positionX,positionYvirilia, positionX - legX, positionYvirilia + legY);
    // perna direita
    g.drawLine(positionX,positionYvirilia, positionX + legX, positionYvirilia + legY);
    // braco esquerdo
    g.drawLine(positionX,positionY, positionX - legX, positionY + legY);
    // braco direito
    g.drawLine(positionX,positionY, positionX + legX, positionY + legY);
    // cabeca
    g.fillOval(positionX - raio, positionY - (2 *raio), 2 * raio, 2 * raio);
    Toolkit.getDefaultToolkit().sync();
  }
}
