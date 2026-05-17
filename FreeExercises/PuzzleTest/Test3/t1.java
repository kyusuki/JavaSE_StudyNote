package Test3;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class t1 extends JFrame implements KeyListener{
    public t1(){
        this.setSize(603,680);
        this.setTitle("测试3");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        
        //调用者this：当前的界面对象，表示要给整个界面添加键盘监听
        //addKeyListener：表示要给本界面添加键盘监听
        //参数this：表示当事件被触发后，会执行本类中的对应代码
        this.addKeyListener(this);
        
        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e){

    }
    //注：如果一直按着某键，会重复触发keyPressed方法
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println("按下按键");
    }
    @Override
    public void keyReleased(KeyEvent e){
        System.out.println("松开按键");
        int code=e.getKeyCode();
        System.out.println(code);
    }
}
