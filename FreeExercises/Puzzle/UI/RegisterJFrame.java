package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class RegisterJFrame extends JFrame implements ActionListener{
    private JTextField username;
    private JPasswordField password;
    private JPasswordField confirmPassword;
    private JButton register;
    private JButton reset;

    public RegisterJFrame(){
        //初始化界面
        initJFrame();
        //初始化视图
        initView();

        this.setVisible(true);
    }
    private void initJFrame(){
        //设置界面宽高
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图游戏 V1.0 注册");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置关闭状态
        this.setDefaultCloseOperation(3);
        //取消默认布局
        this.setLayout(null);
    }

    private void initView(){
        this.setContentPane(new JLabel(loadIcon("image/register/background.png")));
        this.getContentPane().setLayout(null);

        JLabel usernameLabel=new JLabel(loadIcon("image/register/注册用户名.png"));
        usernameLabel.setBounds(100,135,80,20);
        this.getContentPane().add(usernameLabel);

        username=new JTextField();
        username.setBounds(190,130,180,30);
        this.getContentPane().add(username);

        JLabel passwordLabel=new JLabel(loadIcon("image/register/注册密码.png"));
        passwordLabel.setBounds(100,195,80,20);
        this.getContentPane().add(passwordLabel);

        password=new JPasswordField();
        password.setBounds(190,190,180,30);
        this.getContentPane().add(password);

        JLabel confirmLabel=new JLabel(loadIcon("image/register/再次输入密码.png"));
        confirmLabel.setBounds(66,255,120,20);
        this.getContentPane().add(confirmLabel);

        confirmPassword=new JPasswordField();
        confirmPassword.setBounds(190,250,180,30);
        this.getContentPane().add(confirmPassword);

        register=new JButton(loadIcon("image/register/注册按钮.png"));
        register.setBounds(123,320,128,47);
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addActionListener(this);
        this.getContentPane().add(register);

        reset=new JButton(loadIcon("image/register/重置按钮.png"));
        reset.setBounds(256,320,128,47);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addActionListener(this);
        this.getContentPane().add(reset);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==reset){
            username.setText("");
            password.setText("");
            confirmPassword.setText("");
            return;
        }

        if(source==register){
            String usernameText=username.getText();
            String passwordText=new String(password.getPassword());
            String confirmText=new String(confirmPassword.getPassword());

            if(usernameText.isEmpty()||passwordText.isEmpty()||confirmText.isEmpty()){
                showDialog("注册信息不能为空");
                return;
            }
            if(!passwordText.equals(confirmText)){
                showDialog("两次输入的密码不一致");
                return;
            }

            showDialog("注册成功，请返回登录");
            this.dispose();
            new LoginJFrame();
        }
    }

    private void showDialog(String message){
        JDialog dialog=new JDialog(this,"提示",true);
        dialog.setSize(240,140);
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(null);

        JLabel messageLabel=new JLabel(message,SwingConstants.CENTER);
        messageLabel.setBounds(10,20,210,40);
        dialog.getContentPane().add(messageLabel);

        dialog.setVisible(true);
    }

    private ImageIcon loadIcon(String relativePath){
        URL url=getClass().getResource("/Puzzle/"+relativePath);
        if(url!=null){
            return new ImageIcon(url);
        }
        return new ImageIcon("Puzzle/"+relativePath);
    }
}
