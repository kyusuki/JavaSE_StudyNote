package PockGame.Game.GUI.game;

import PockGame.Game.GUI.Information.User;
import PockGame.Game.GUI.Util.VerificationCode;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class LoginJFrame extends JFrame implements MouseListener{
    static ArrayList<User> userList=new ArrayList<>();
    static{
        userList.add(new User("Jee","123456"));
        userList.add(new User("danking","666666"));
    }
    JButton login=new JButton(); //登录按键
    JButton register=new JButton(); //注册按键
    JTextField username=new JTextField(); //用户名输入框
    JPasswordField password=new JPasswordField(); //密码输入框
    JTextField code=new JTextField(); //验证码输入框
    JLabel rightCode=new JLabel(); //验证码显示
    
    //登录界面
    public LoginJFrame(){
        //初始化界面
        initJFrame();
        //初始化组件
        initView();
        //显示界面
        this.setVisible(true);
    }

    //初始化界面
    public void initJFrame(){
        this.setSize(633,423); //设置宽高
        this.setTitle("super斗地主 登录"); //设置标题
        this.setDefaultCloseOperation(3); //设置关闭模式
        this.setLocationRelativeTo(null); //界面居中
        this.setAlwaysOnTop(true); //界面置顶
        this.setLayout(null); //取消默认布局
    }

    //初始化组件
    public void initView(){
        //添加用户名文字
        Font font=new Font(null,1,16); //字体设置
        JLabel usernameText=new JLabel("用户名"); //用户名文字
        usernameText.setForeground(Color.white); //文字颜色
        usernameText.setFont(font); //文字字体
        usernameText.setBounds(140,55,55,22); //文字位置
        this.getContentPane().add(usernameText); //添加用户名文字到界面

        //添加用户名输入框
        username.setBounds(223,46,200,30); //输入框位置
        this.getContentPane().add(username); //添加用户名输入框到界面

        //添加密码文字
        JLabel passwordText=new JLabel("密码"); //密码文字
        passwordText.setForeground(Color.white); //文字颜色
        passwordText.setFont(font); //文字颜色
        passwordText.setBounds(140,95,40,22); //文字位置
        this.getContentPane().add(passwordText); //添加密码文字到界面

        //添加密码输入框
        password.setBounds(223,87,160,30); //输入框位置
        this.getContentPane().add(password); //添加密码输入框到界面

        //添加验证码文字
        JLabel codeText=new JLabel("验证码"); //验证码文字
        codeText.setForeground(Color.white); //文字颜色
        codeText.setFont(font); //文字字体
        codeText.setBounds(140,142,55,22); //文字设置
        this.getContentPane().add(codeText); //添加验证码文字到界面

        //添加验证码输入框
        code.setBounds(223,133,100,30); //输入框位置
        this.getContentPane().add(code); //添加验证码输入框到界面

        //获取验证码
        String codeStr=VerificationCode.code();
        rightCode.setForeground(Color.RED); //验证码颜色
        rightCode.setFont(new Font(null,1,15)); //验证码字体
        rightCode.setText(codeStr); //将获取的验证码添加到标签中
        rightCode.addMouseListener(this); //绑定鼠标事件
        rightCode.setBounds(332,133,100,30); //验证码位置
        this.getContentPane().add(rightCode); //添加验证码到界面

        //添加登录按钮
        login.setBounds(188,310,128,47); //登录按钮位置
        ImageIcon loginIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\登录按钮.png"); //创建登录按钮图标对象
        login.setIcon(loginIcon); //设置登录按钮图标
        login.setBorderPainted(false); //去除按钮边框
        login.setContentAreaFilled(false); //去除按钮背景
        login.addMouseListener(this); //绑定登录按钮鼠标事件
        this.getContentPane().add(login); //添加登录按钮到界面

        //添加注册按钮
        register.setBounds(321,310,128,47); //注册按钮位置
        ImageIcon registerIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\注册按钮.png"); //创建注册按钮图标对象
        register.setIcon(registerIcon); //设置注册按钮图标
        register.setBorderPainted(false); //去除按钮边框
        register.setContentAreaFilled(false); //去除按钮背景
        register.addMouseListener(this); //绑定注册按钮鼠标事件
        this.getContentPane().add(register); //添加注册按钮到界面
 
        //登录界面背景
        ImageIcon backgroundIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\background.png"); //创建背景图片对象
        JLabel backgroundJL=new JLabel(backgroundIcon); //创建背景标签对象
        backgroundJL.setBounds(0,0,633,423); //设置背景位置
        this.getContentPane().add(backgroundJL); //添加背景到界面

    }

    //点击按钮
    @Override
    public void mouseClicked(MouseEvent e){
        Object content=e.getSource(); //获取点击事件
        if(content==login){
            String userName=username.getText(); //获取输入的用户名
            String passWord=new String(password.getPassword()); //获取输入的密码，（getText方法已过时，应使用getPassword方法）
            String inputCode=code.getText(); //获取输入的验证码
            if(userName.isEmpty()||passWord.isEmpty()||inputCode.isEmpty()){
                showJDialog("输入不能为空");
                return;
            }
            if(!(inputCode.equals(rightCode.getText()))){
                showJDialog("验证码错误");
                return;
            }
            boolean islogin=false;
            for(User u:userList){
                if(u.getUsername().equals(userName)&&u.getPassword().equals(passWord)){
                    islogin=true;
                    break;
                }
            }
            if(islogin){
                new GameJFrame(); //调用游戏界面
                this.dispose(); //关闭登录界面
            }
            else{
                showJDialog("登录失败，用户名或密码错误");
            }
        }
        else if(content==register){
            showJDialog("注册功能持续更新中");
        }
        else if(content==rightCode){
            String code=VerificationCode.code(); //重新获取验证码
            rightCode.setText(code); //将新验证码覆盖掉旧码
        }
    }

    //按下按钮不松
    @Override
    public void mousePressed(MouseEvent e){
        Object content=e.getSource(); //获取点击事件
        if(content==login){
            ImageIcon loginIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\登录按下.png");
            login.setIcon(loginIcon); //覆盖前一个按钮图标
        }
        else if(content==register){
            ImageIcon registerIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\注册按下.png");
            register.setIcon(registerIcon); //覆盖前一个按钮图标
        }
    }

    //按下按钮释放
    @Override
    public void mouseReleased(MouseEvent e){
        Object content=e.getSource(); //获取点击事件
        if(content==login){
            ImageIcon loginIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\登录按钮.png");
            login.setIcon(loginIcon); //再次覆盖前一个按钮图标
        }
        else if(content==register){
            ImageIcon registerIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\login\\注册按钮.png");
            register.setIcon(registerIcon); //再次覆盖前一个按钮图标
        }
    }

    //鼠标划入
    @Override
    public void mouseEntered(MouseEvent e){

    }
    //鼠标划出
    @Override
    public void mouseExited(MouseEvent e){

    }

    //弹窗
    public void showJDialog(String content){
        JDialog jd=new JDialog(); //创建弹窗对象
        jd.setSize(200,150); //设置弹窗大小
        jd.setAlwaysOnTop(true); //弹窗置顶
        jd.setLocationRelativeTo(null); //弹窗居中
        jd.setModal(true); //保证弹窗在上方时，下面的界面无法操作

        //添加文字到弹窗
        JLabel jl=new JLabel(content); //创建错误提示标签对象，参数为传入的内容
        jl.setBounds(0,0,200,250); //标签位置
        jd.getContentPane().add(jl); //添加标签到弹窗中
        jd.setVisible(true); //弹窗可视
    }
}
