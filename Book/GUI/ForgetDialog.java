package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// 忘记密码弹窗（模态）：复用原有Forget类逻辑
public class ForgetDialog extends JDialog {
    private JTextField usernameField;
    private JTextField idField;
    private JTextField phoneField;
    private JPasswordField newPwdField;
    private JFrame parentFrame;

    public ForgetDialog(JFrame parentFrame) {
        super(parentFrame, "忘记密码", true);
        this.parentFrame = parentFrame;
        setSize(500, 400);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 20));
        setResizable(false);

        // 1. 标题
        JLabel titleLabel = new JLabel("密码重置", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 重置表单
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 25));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        Font labelFont = new Font("微软雅黑", Font.PLAIN, 14);
        Font fieldFont = new Font("微软雅黑", Font.PLAIN, 14);

        // 用户名
        JLabel userLabel = new JLabel("用户名：", SwingConstants.RIGHT);
        userLabel.setFont(labelFont);
        usernameField = new JTextField(15);
        usernameField.setFont(fieldFont);
        formPanel.add(userLabel);
        formPanel.add(usernameField);

        // 身份证号
        JLabel idLabel = new JLabel("身份证号：", SwingConstants.RIGHT);
        idLabel.setFont(labelFont);
        idField = new JTextField(15);
        idField.setFont(fieldFont);
        formPanel.add(idLabel);
        formPanel.add(idField);

        // 手机号
        JLabel phoneLabel = new JLabel("手机号：", SwingConstants.RIGHT);
        phoneLabel.setFont(labelFont);
        phoneField = new JTextField(15);
        phoneField.setFont(fieldFont);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);

        // 新密码
        JLabel newPwdLabel = new JLabel("新密码：", SwingConstants.RIGHT);
        newPwdLabel.setFont(labelFont);
        newPwdField = new JPasswordField(15);
        newPwdField.setFont(fieldFont);
        formPanel.add(newPwdLabel);
        formPanel.add(newPwdField);
        add(formPanel, BorderLayout.CENTER);

        // 3. 确认/取消按钮
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JButton confirmBtn = new JButton("确认重置");
        JButton cancelBtn = new JButton("取消");
        confirmBtn.setFont(fieldFont);
        cancelBtn.setFont(fieldFont);
        confirmBtn.setPreferredSize(new Dimension(120, 30));
        cancelBtn.setPreferredSize(new Dimension(120, 30));

        // 确认重置逻辑（复用原有Forget类）
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String id = idField.getText().trim();
                String phone = phoneField.getText().trim();
                String newPwd = new String(newPwdField.getPassword()).trim();

                // 1. 基础验证
                if (username.isEmpty() || id.isEmpty() || phone.isEmpty() || newPwd.isEmpty()) {
                    JOptionPane.showMessageDialog(ForgetDialog.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 2. 调用原有Forget类的重置逻辑
                Forget forget = new Forget();
                Scanner mockSc = new Scanner(username + "\n" + id + "\n" + phone + "\n" + newPwd);
                forget.forget(mockSc, GUIApp.userList);

                // 3. 验证密码是否重置成功
                User targetUser = null;
                for (User u : GUIApp.userList) {
                    if (u.getUsername().equals(username)) {
                        targetUser = u;
                        break;
                    }
                }
                if (targetUser != null && targetUser.getPassword().equals(newPwd)) {
                    JOptionPane.showMessageDialog(ForgetDialog.this, "密码重置成功！");
                    ForgetDialog.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(ForgetDialog.this, "账号信息不一致，重置失败！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 取消按钮
        cancelBtn.addActionListener(e -> ForgetDialog.this.dispose());

        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
