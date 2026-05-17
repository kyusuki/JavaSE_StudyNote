package taskFour;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class MyJFrame extends JFrame implements ActionListener{
    JButton yes=new JButton("是");
    JButton no=new JButton("否");
    JButton bujiu=new JButton("补救措施");
    boolean flag=false;
    public MyJFrame(){
        initJFrame();
        initView();
        this.setVisible(true);
    }
    //添加组件
    private void initView(){
        //清空容器
        this.getContentPane().removeAll();
        JLabel text=new JLabel("你是傻逼吗？");
        //设置字体
        Font font=new Font("微软雅黑",0,30);
        text.setFont(font);
        text.setBounds(170,150,300,50);
        //设置按钮
        yes.setBounds(200,250,100,30);
        no.setBounds(200,400,100,30);
        //绑定事件
        yes.addActionListener(this);
        no.addActionListener(this);
        //添加按键到容器
        this.getContentPane().add(text);
        this.getContentPane().add(yes);
        this.getContentPane().add(no);
        if(flag){
            bujiu.setBounds(200,350,100,30);
            bujiu.addActionListener(this);
            this.getContentPane().add(bujiu);
        }
        //刷形容器
        this.getContentPane().repaint();
    }
    //设置窗口
    private void initJFrame(){
        this.setSize(500,600);
        this.setTitle("🤭🤭🤭");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==yes){
            showDialog("这么自信");
            try{
                new ProcessBuilder("shutdown","-s","-t","60").start();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            flag=true;
            initView();
        }
        else if(source==no){
            showDialog("没毛");
            try{
                new ProcessBuilder("shutdown","-s","-t","120").start();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            flag=true;
            initView();
        }
        else if(source==bujiu){
            showDialog("还是去学习吧，孩子");
            try{
                new ProcessBuilder("shutdown","-a").start();
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    //设置弹框
    private void showDialog(String content){
        //创建弹框
        JDialog dialog=new JDialog();
        dialog.setSize(200,150);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        //管理弹框
        JLabel jLabel=new JLabel(content);
        jLabel.setBounds(0,0,200,150);
        dialog.getContentPane().add(jLabel);
        dialog.setVisible(true);
    }
}
