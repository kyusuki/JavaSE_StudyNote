package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookDialog extends JDialog {
    private JTextField isbnField;
    private JTextField idField;
    private BookMainFrame parentFrame;

    public ReturnBookDialog(BookMainFrame parentFrame) {
        super(parentFrame, "归还图书", true);
        this.parentFrame = parentFrame;
        setSize(500, 300);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 20));
        setResizable(false);

        // 1. 标题
        JLabel titleLabel = new JLabel("图书归还", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 归还表单
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 30));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        Font labelFont = new Font("微软雅黑", Font.PLAIN, 14);
        Font fieldFont = new Font("微软雅黑", Font.PLAIN, 14);

        // ISBN号
        JLabel isbnLabel = new JLabel("图书ISBN号：", SwingConstants.RIGHT);
        isbnLabel.setFont(labelFont);
        isbnField = new JTextField(15);
        isbnField.setFont(fieldFont);
        formPanel.add(isbnLabel);
        formPanel.add(isbnField);

        // 借阅人学号
        JLabel idLabel = new JLabel("借阅人学号：", SwingConstants.RIGHT);
        idLabel.setFont(labelFont);
        idField = new JTextField(15);
        idField.setFont(fieldFont);
        formPanel.add(idLabel);
        formPanel.add(idField);
        add(formPanel, BorderLayout.CENTER);

        // 3. 确认/取消按钮
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JButton confirmBtn = new JButton("确认归还");
        JButton cancelBtn = new JButton("取消");
        confirmBtn.setFont(fieldFont);
        cancelBtn.setFont(fieldFont);
        confirmBtn.setPreferredSize(new Dimension(120, 30));
        cancelBtn.setPreferredSize(new Dimension(120, 30));

        // 确认归还逻辑
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText().trim();
                String id = idField.getText().trim();

                if (isbn.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(ReturnBookDialog.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 调用BookManager归还图书
                boolean success = GUIApp.bookManager.returnBook(isbn, id);
                if (success) {
                    JOptionPane.showMessageDialog(ReturnBookDialog.this, "归还成功！");
                    ReturnBookDialog.this.dispose();
                    parentFrame.refreshBookTable();
                } else {
                    JOptionPane.showMessageDialog(ReturnBookDialog.this, "未找到该借阅记录，归还失败！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelBtn.addActionListener(e -> ReturnBookDialog.this.dispose());

        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
