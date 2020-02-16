package sg;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame implements MouseListener {
    private Graph graph = new Graph();
    private int posX[]=new int[20];
    private int posY[]=new int[20];
    private static final int SIZE_OF_X=600;
    private static final int SIZE_OF_Y=600;
    private static final int MAX_RANDOM=500;
    private static final String FRAME_NAME="Space Game!";
    private int rocketQuantity =1;
    private int width;
    private int height;
    private Random rand = new Random();
    private Main(String name, int width, int height){
        super(name);
        this.width=width;
        this.height=height;
        posX[0] = rand.nextInt(MAX_RANDOM);
        posY[0] = rand.nextInt(MAX_RANDOM);
        setSize(width,height);
        addMouseListener(this);
        setFocusable(true);
        add(graph);
        setVisible(true);
    }
    private void updateVariables(){
        graph.loopNumber= rocketQuantity;
        for(int i = 0; i< rocketQuantity; i++){
            graph.posX2[i]=posX[i];
            graph.posY2[i]=posY[i];
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        for(int i = 0; i< rocketQuantity; i++){
            if((x>posX[i] && x<posX[i]+100)&&(y>posY[i] && y<posY[i]+100)){
                posX[i] = rand.nextInt(MAX_RANDOM);
                posY[i] = rand.nextInt(MAX_RANDOM);
            }
            repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e){ }
    @Override
    public void mouseExited(MouseEvent e){ }
    public static void main(String[] args) {
        Main m = new Main(FRAME_NAME,SIZE_OF_X,SIZE_OF_Y);
        while(true){
            try{
                for(int i = 0; i<m.rocketQuantity; i++){
                    if(m.posX[i]>SIZE_OF_X-30){
                        m.posX[i]=-70;
                        m.rocketQuantity++;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                    m.posX[i]++;
                }
                m.updateVariables();
                m.repaint();
            }catch(Exception e){ }
        }
    }
}

