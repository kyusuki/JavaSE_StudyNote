package PockGame.Game.GUI.Information;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pock extends JLabel implements MouseListener{
    /*
     * 牌的四个属性
     * 花色；显示正面，显示反面；是否可以被点击；是否已经被点击
     */
    private String suit; //花色
    private boolean isUp; //正反面
    private boolean canClicked=false; //是否可以被点击
    private boolean isClicked=false; //是否已经被点击
    public Pock(String suit,boolean isUp){
        this.suit=suit;
        this.isUp=isUp;
        this.setSize(71,96); //设置牌的大小
        if(isUp){
            turnFront();
        }
        else{
            ImageIcon icon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\poker\\rear.png");
            this.setIcon(icon);
            isUp=false;
        }
        this.setVisible(true); //让牌可见
        this.addMouseListener(this); //绑定牌的点击事件
    }

    public void turnFront(){
        ImageIcon icon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\poker\\"+suit+".png");
        this.setIcon(icon);
        isUp=true;
    }
    public String getSuit(){
        return suit;
    }
    public boolean getIsUp(){
        return isUp;
    }
    public boolean getIsClicked(){
        return isClicked;
    }
    public boolean getCanClicked(){
        return canClicked;
    }
    public void setSuit(String suit){
        this.suit=suit;
    }
    public void setIsUp(boolean isUp){
        this.isUp=isUp;
    }
    public void setCanClicked(boolean canClicked){
        this.canClicked=canClicked;
    }
    public void setIsClicked(boolean isClicked){
        this.isClicked=isClicked;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if(canClicked==true){
            int height=0; //牌当前高度
            //若该牌已经被点击，则下降
            if(!isClicked){
                height-=20; //下降20个像素
            }
            //若该牌没有被点击，则上升
            else{
                height+=20; //上升20个像素
            }
            //设置牌的新位置
            Point from=new Point(this.getLocation()); //获取牌当前位置
            this.setLocation(from.x,from.y+height); //更新牌的新位置
        }
    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override
    public void mouseExited(MouseEvent e){

    }
}
