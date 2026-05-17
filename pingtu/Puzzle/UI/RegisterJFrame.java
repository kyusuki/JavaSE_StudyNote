package UI;
import javax.swing.*;
public class RegisterJFrame extends JFrame{
    public RegisterJFrame(){
        //初始化界面
        initJFrame();

        this.setVisible(true);
    }
    private void initJFrame(){
        //设置界面宽高
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图游戏 V1.0 注册");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭状态
        this.setDefaultCloseOperation(3);
    }
}
