package sg;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

class Graph extends JPanel {
    private String src="C:\\Users\\dellLat01\\Downloads\\space.jpg";
    private String src2="C:\\Users\\dellLat01\\Downloads\\hiclipart.com.png";
    private BufferedImage img,img2 = null;
    int loopNumber;
    int posX2[]= new int[10];
    int posY2[]= new int[10];
    public Graph() {
        try {
            img = ImageIO.read(new File(src));
            img2 = ImageIO.read(new File(src2));

        } catch (Exception e) {}
    }
    public void paint(Graphics g){
        g.drawImage(img,0,0,600,600,null);

        for(int i=0; i<loopNumber;i++){
            g.drawImage(img2,posX2[i],posY2[i],100,100,null);
        }

    }
}