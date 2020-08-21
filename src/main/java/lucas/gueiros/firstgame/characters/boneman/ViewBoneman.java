package lucas.gueiros.firstgame.characters.boneman;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public class ViewBoneman {
  private Image image;
  private Boneman boneman;
  public ViewBoneman () {
    ImageIcon ii = new ImageIcon("src/main/resources/characters/boneman/boneman-relaxado.png");
    image = ii.getImage();
  }
  public Image getImage() {
    return image;
  }
  public Dimension getSize(ImageObserver observer) {
    return new Dimension (image.getHeight(observer), image.getWidth(observer));
  }
}
