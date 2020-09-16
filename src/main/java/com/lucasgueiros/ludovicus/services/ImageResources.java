package com.lucasgueiros.ludovicus.services;

import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageResources {

  private final static Logger logger = LogManager.getLogger(ImageResources.class);

  public static BufferedImage getResource(String url) {
    try {
      BufferedImage bi = ImageIO.read(ImageResources.class.getResourceAsStream(url));
      bi = imageToBufferedImage(makeColorTransparent(bi, new Color(255, 255, 254)), bi.getWidth(), bi.getHeight());
      return bi;
    } catch (IOException e) {
      logger.error(e.toString());
    }
    return null;
  }

  public static Image makeColorTransparent(BufferedImage im, final Color color) {
      ImageFilter filter = new RGBImageFilter() {

          // the color we are looking for... Alpha bits are set to opaque
          public int markerRGB = color.getRGB() | 0xFF000000;

          public final int filterRGB(int x, int y, int rgb) {
              if ((rgb | 0xFF000000) == markerRGB) {
                  // Mark the alpha bits as zero - transparent
                  return 0x00FFFFFF & rgb;
              } else {
                  // nothing to do
                  return rgb;
              }
          }
      };

      ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
      return Toolkit.getDefaultToolkit().createImage(ip);
  }
  private static BufferedImage imageToBufferedImage(Image image, int width, int height)
  {
    BufferedImage dest = new BufferedImage(
        width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = dest.createGraphics();
    g2.drawImage(image, 0, 0, null);
    g2.dispose();
    return dest;
  }
}
