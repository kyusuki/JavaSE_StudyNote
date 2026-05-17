package Test2;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class t1 extends JFrame implements MouseListener{
    JButton j=new JButton("按钮");
    public t1(){
        this.setSize(603,680);
        this.setTitle("测试2");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        j.setBounds(0,0,100,50);
        j.addMouseListener(this);
        this.getContentPane().add(j);
        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("单击");
    }
    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("按下");
    }
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("释放");
    }
    @Override
    public void mouseEntered(MouseEvent e){
        System.out.println("进入");
    }
    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("退出");
    }
}
