package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// 登录窗口：包含验证码、登录/注册/忘记密码按钮
public class LoginFrame extends JFrame {
    private JTextField usernameField;    // 用户名输入框
    private JPasswordField passwordField;// 密码输入框（隐藏输入）
    private JTextField codeField;        // 验证码输入框
    private JLabel codeLabel;            // 验证码显示标签
    private VerificationCode verCode;    // 复用原有验证码工具

    public LoginFrame() {
        // 窗口基础配置
        setTitle("图书管理系统 - 登录");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中
        setLayout(new BorderLayout(10, 20));
        setResizable(false); // 禁止窗口缩放

        // 初始化验证码工具
        verCode = new VerificationCode();

        // 1. 标题区域
        JLabel titleLabel = new JLabel("图书管理系统", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 登录表单区域（用户名、密码、验证码）
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 25));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        
        // 用户名行
        JLabel userLabel = new JLabel("用户名：", SwingConstants.RIGHT);
        userLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        usernameField = new JTextField(15);
        usernameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        formPanel.add(userLabel);
        formPanel.add(usernameField);
        
        // 密码行
        JLabel pwdLabel = new JLabel("密码：", SwingConstants.RIGHT);
        pwdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        formPanel.add(pwdLabel);
        formPanel.add(passwordField);
        
        // 验证码行
        JLabel codeTipLabel = new JLabel("验证码：", SwingConstants.RIGHT);
        codeTipLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        JPanel codeRowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        codeField = new JTextField(6);
        codeField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        // 生成随机验证码并显示
        codeLabel = new JLabel(verCode.getCode());
        codeLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        codeLabel.setForeground(Color.RED);
        codeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // 点击验证码刷新
        codeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                codeLabel.setText(verCode.getCode());
            }
        });
        codeRowPanel.add(codeField);
        codeRowPanel.add(codeLabel);
        formPanel.add(codeTipLabel);
        formPanel.add(codeRowPanel);
        add(formPanel, BorderLayout.CENTER);

        // 3. 按钮区域（登录、注册、忘记密码）
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        JButton loginBtn = new JButton("登录");
        JButton registerBtn = new JButton("注册");
        JButton forgetBtn = new JButton("忘记密码");
        // 按钮样式
        loginBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        registerBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        forgetBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        loginBtn.setPreferredSize(new Dimension(100, 30));
        registerBtn.setPreferredSize(new Dimension(100, 30));
        forgetBtn.setPreferredSize(new Dimension(100, 30));

        // 登录按钮事件（复用原有Login类逻辑）
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String inputCode = codeField.getText().trim();

                // 1. 基础验证
                if (username.isEmpty() || password.isEmpty() || inputCode.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // 2. 验证码验证
                if (!inputCode.equals(codeLabel.getText())) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "验证码错误！", "提示", JOptionPane.ERROR_MESSAGE);
                    codeLabel.setText(verCode.getCode()); // 刷新验证码
                    codeField.setText("");
                    return;
                }

                // 3. 调用原有Login类的登录逻辑（模拟Scanner输入）
                Login login = new Login();
                Scanner mockSc = new Scanner(username + "\n" + password + "\n" + inputCode);
                boolean loginSuccess = login.login(mockSc, GUIApp.userList);

                if (loginSuccess) {
                    JOptionPane.showMessageDialog(LoginFrame.this, "登录成功！");
                    // 打开图书管理主窗口，关闭当前登录窗口
                    new BookMainFrame().setVisible(true);
                    LoginFrame.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误！", "提示", JOptionPane.ERROR_MESSAGE);
                    codeLabel.setText(verCode.getCode());
                    passwordField.setText("");
                    codeField.setText("");
                }
            }
        });

        // 注册按钮事件（打开注册弹窗）
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterDialog(LoginFrame.this).setVisible(true);
            }
        });

        // 忘记密码按钮事件（打开忘记密码弹窗）
        forgetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ForgetDialog(LoginFrame.this).setVisible(true);
            }
        });

        btnPanel.add(loginBtn);
        btnPanel.add(registerBtn);
        btnPanel.add(forgetBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
