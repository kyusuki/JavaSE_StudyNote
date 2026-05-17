package Test1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class t1 extends JFrame implements ActionListener{
    JButton j1=new JButton("按钮1");
    JButton j2=new JButton("按钮2");
    public t1(){
        this.setSize(603,680);
        this.setTitle("测试1");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        j1.setBounds(0,0,100,100);
        j1.addActionListener(this);
        j2.setBounds(100,0,100,100);
        j2.addActionListener(this);
        this.getContentPane().add(j1);
        this.getContentPane().add(j2);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        Random r=new Random();
        if(source==j1){
            j1.setLocation(r.nextInt(500),r.nextInt(500));
        }
        else if(source==j2){
            j2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
