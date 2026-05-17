package UI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class LoginJFrame extends JFrame implements ActionListener{
    /*
    *static ArrayList<User> userList=new ArrayList<>(); //静态用户列表，所有实例共享
    *static{
    *   userList.add(new User("zhangsan","321"));
    *   userList.add(new User("lisi","456"));
    *}
    */
    static User user=new User("iKun","114514");
    private JButton login; //成员位置，便于后期调用
    private JButton register; //成员位置，便于后期调用
    private JTextField username; //成员位置，便于后期调用
    private JTextField password; //成员位置，便于后期调用
    public LoginJFrame(){
        //初始化界面
        initJFrame();
        
        //初始化图片
        initView();

        this.setVisible(true);
    }
    private void initJFrame(){
        //设置界面宽高
        this.setSize(488,430);
        //设置界面标题
        this.setTitle("拼图游戏 V1.0 登录");
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
        //添加用户名文字
        ImageIcon userImage=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\用户名.png");
        JLabel userjLabel=new JLabel(userImage);
        userjLabel.setBounds(116,135,47,17);
        this.getContentPane().add(userjLabel);
        //添加用户名输入框
        username=new JTextField();
        username.setBounds(195,134,200,30);
        this.getContentPane().add(username);
        //添加密码文字
        ImageIcon passwordImage=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\密码.png");
        JLabel passwordjLabel=new JLabel(passwordImage);
        passwordjLabel.setBounds(130,195,32,16);
        this.getContentPane().add(passwordjLabel);
        //添加密码输入框
        password=new JPasswordField();
        password.setBounds(195,195,200,30);
        this.getContentPane().add(password);
        //验证码提示
        ImageIcon codeImage=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\验证码.png");
        JLabel codejLabel=new JLabel(codeImage);
        codejLabel.setBounds(133,256,50,30);
        this.getContentPane().add(codejLabel);
        //验证码输入框
        JTextField code=new JTextField();
        code.setBounds(195,256,100,30);
        this.getContentPane().add(code);
        String verCode=new CodeUtil().getVerification();
        JLabel resultCode=new JLabel();
        resultCode.setText(verCode);
        resultCode.setBounds(300,256,50,30);
        this.getContentPane().add(resultCode);
        //登录按钮
        login=new JButton();
        login.setBounds(123,310,128,47);
        ImageIcon loginImage=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\登录按钮.png");
        login.setIcon(loginImage);
        //去除按钮边框
        login.setBorderPainted(false);
        //去除按钮背景
        login.setContentAreaFilled(false);
        //绑定登录按钮监听事件
        login.addActionListener(this);
        this.getContentPane().add(login);
        //注册按钮
        register=new JButton();
        register.setBounds(256,310,128,47);
        ImageIcon registerImage=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\注册按钮.png");
        register.setIcon(registerImage);
        //去除按钮边框
        register.setBorderPainted(false);
        //去除按钮背景
        register.setContentAreaFilled(false);
        //绑定注册按钮监听事件
        register.addActionListener(this);
        this.getContentPane().add(register);
        //添加背景图片
        ImageIcon image=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\background.png");
        JLabel jFrame=new JLabel(image);
        jFrame.setBounds(9,10,470,390);
        this.getContentPane().add(jFrame);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==login){
            //移除所有组件
            this.getContentPane().removeAll();
            //重绘界面
            ImageIcon image=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\登录按下.png");
            JLabel jLabel=new JLabel(image);
            jLabel.setBounds(123,310,128,47);
            this.getContentPane().add(jLabel);
            //刷新界面
            this.getContentPane().repaint();
            if(username.getText().isEmpty()||password.getText().isEmpty()){
                //调用提示方法
                showJDialog("用户名或密码不能为空");
                return;
            }
            if(!(username.getText().equals(user.getUsername())&&password.getText().equals(user.getPassword()))){
                //调用提示方法
                showJDialog("用户名或密码错误");
                return;
            }
            //关闭当前登录界面
            this.setVisible(false);
            //打开游戏界面
            new GameJFrame(); //创建游戏界面对象
        }
        else if(obj==register){
            //移除所有组件
            this.getContentPane().removeAll();
            //重绘界面
            ImageIcon image=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\login\\登录按下.png");
            JLabel jLabel=new JLabel(image);
            jLabel.setBounds(123,310,128,47);
            this.getContentPane().add(jLabel);
            //刷新界面
            this.getContentPane().repaint();
            //关闭当前登录界面
            this.setVisible(false);
            //打开注册界面
            new RegisterJFrame(); //创建登录界面对象
        }
    }
    //提示用户名或密码错误
    private void showJDialog(String content){
        //创建一个弹框对象
        JDialog jDialog=new JDialog();
        jDialog.setSize(200,150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        //弹窗未关闭前无法操作下面界面
        jDialog.setModal(true);
        //创建JLabel对象管理文字并添加到弹框中
        JLabel jLabel=new JLabel(content);
        jLabel.setBounds(0,0,200,150);
        jDialog.getContentPane().add(jLabel);
        //弹框显示
        jDialog.setVisible(true);
    }
}
