package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;
// 注册弹窗（模态）：复用原有Register类的验证逻辑
public class RegisterDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField pwdField1;
    private JPasswordField pwdField2;
    private JTextField idField;
    private JTextField phoneField;
    private JFrame parentFrame; // 父窗口（登录窗口）

    public RegisterDialog(JFrame parentFrame) {
        super(parentFrame, "用户注册", true); // 模态弹窗：关闭前不能操作父窗口
        this.parentFrame = parentFrame;
        setSize(500, 450);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 20));
        setResizable(false);

        // 1. 标题
        JLabel titleLabel = new JLabel("新用户注册", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 注册表单
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 20));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        Font labelFont = new Font("微软雅黑", Font.PLAIN, 14);
        Font fieldFont = new Font("微软雅黑", Font.PLAIN, 14);

        // 用户名
        JLabel userLabel = new JLabel("用户名（3-15位，含字母）：", SwingConstants.RIGHT);
        userLabel.setFont(labelFont);
        usernameField = new JTextField(15);
        usernameField.setFont(fieldFont);
        formPanel.add(userLabel);
        formPanel.add(usernameField);

        // 密码
        JLabel pwdLabel1 = new JLabel("密码：", SwingConstants.RIGHT);
        pwdLabel1.setFont(labelFont);
        pwdField1 = new JPasswordField(15);
        pwdField1.setFont(fieldFont);
        formPanel.add(pwdLabel1);
        formPanel.add(pwdField1);

        // 确认密码
        JLabel pwdLabel2 = new JLabel("确认密码：", SwingConstants.RIGHT);
        pwdLabel2.setFont(labelFont);
        pwdField2 = new JPasswordField(15);
        pwdField2.setFont(fieldFont);
        formPanel.add(pwdLabel2);
        formPanel.add(pwdField2);

        // 身份证号
        JLabel idLabel = new JLabel("身份证号（18位）：", SwingConstants.RIGHT);
        idLabel.setFont(labelFont);
        idField = new JTextField(15);
        idField.setFont(fieldFont);
        formPanel.add(idLabel);
        formPanel.add(idField);

        // 手机号
        JLabel phoneLabel = new JLabel("手机号（11位）：", SwingConstants.RIGHT);
        phoneLabel.setFont(labelFont);
        phoneField = new JTextField(15);
        phoneField.setFont(fieldFont);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        add(formPanel, BorderLayout.CENTER);

        // 3. 注册/取消按钮
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JButton registerBtn = new JButton("注册");
        JButton cancelBtn = new JButton("取消");
        registerBtn.setFont(fieldFont);
        cancelBtn.setFont(fieldFont);
        registerBtn.setPreferredSize(new Dimension(100, 30));
        cancelBtn.setPreferredSize(new Dimension(100, 30));

        // 注册逻辑（复用原有Register类）
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String pwd1 = new String(pwdField1.getPassword()).trim();
                String pwd2 = new String(pwdField2.getPassword()).trim();
                String id = idField.getText().trim();
                String phone = phoneField.getText().trim();

                // 1. 前端基础验证
                if (!pwd1.equals(pwd2)) {
                    JOptionPane.showMessageDialog(RegisterDialog.this, "两次密码不一致！", "提示", JOptionPane.ERROR_MESSAGE);
                    pwdField1.setText("");
                    pwdField2.setText("");
                    return;
                }
                if (username.isEmpty() || pwd1.isEmpty() || id.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterDialog.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 2. 调用原有Register类的注册逻辑（模拟Scanner输入）
                Register register = new Register();
                Scanner mockSc = new Scanner(
                        username + "\n" + pwd1 + "\n" + pwd2 + "\n" + id + "\n" + phone
                );
                // 临时列表接收注册结果（避免直接修改全局列表时的并发问题）
                ArrayList<User> tempList = new ArrayList<>(GUIApp.userList);
                register.register(mockSc, tempList);

                // 3. 验证注册是否成功（判断用户名是否新增）
                boolean isRegistered = tempList.size() > GUIApp.userList.size();
                if (isRegistered) {
                    GUIApp.userList.clear();
                    GUIApp.userList.addAll(tempList); // 更新全局用户列表
                    JOptionPane.showMessageDialog(RegisterDialog.this, "注册成功！");
                    RegisterDialog.this.dispose(); // 关闭弹窗
                } else {
                    // 复用Register类的验证逻辑，提示具体错误
                    if (username.length() < 3 || username.length() > 15) {
                        JOptionPane.showMessageDialog(RegisterDialog.this, "用户名长度必须在3-15之间！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (!Register.isLetterDigit(username)) {
                        JOptionPane.showMessageDialog(RegisterDialog.this, "用户名只能包含字母或数字！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (Register.isExist(GUIApp.userList, username)) {
                        JOptionPane.showMessageDialog(RegisterDialog.this, "用户名已存在！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (!Register.isId(id)) {
                        JOptionPane.showMessageDialog(RegisterDialog.this, "身份证号格式错误！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else if (!Register.isPhone(phone)) {
                        JOptionPane.showMessageDialog(RegisterDialog.this, "手机号格式错误！", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // 取消按钮：关闭弹窗
        cancelBtn.addActionListener(e -> RegisterDialog.this.dispose());

        btnPanel.add(registerBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
