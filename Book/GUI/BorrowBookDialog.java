package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BorrowBookDialog extends JDialog {
    private JTextField isbnField;
    private JTextField nameField;
    private JTextField idField;
    private BookMainFrame parentFrame;

    public BorrowBookDialog(BookMainFrame parentFrame) {
        super(parentFrame, "借阅图书", true);
        this.parentFrame = parentFrame;
        setSize(500, 350);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 20));
        setResizable(false);

        // 1. 标题
        JLabel titleLabel = new JLabel("图书借阅", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 借阅表单
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 30));
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

        // 借阅人姓名
        JLabel nameLabel = new JLabel("借阅人姓名：", SwingConstants.RIGHT);
        nameLabel.setFont(labelFont);
        nameField = new JTextField(15);
        nameField.setFont(fieldFont);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

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
        JButton confirmBtn = new JButton("确认借阅");
        JButton cancelBtn = new JButton("取消");
        confirmBtn.setFont(fieldFont);
        cancelBtn.setFont(fieldFont);
        confirmBtn.setPreferredSize(new Dimension(120, 30));
        cancelBtn.setPreferredSize(new Dimension(120, 30));

        // 确认借阅逻辑
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText().trim();
                String name = nameField.getText().trim();
                String id = idField.getText().trim();

                // 基础验证
                if (isbn.isEmpty() || name.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(BorrowBookDialog.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 调用BookManager借阅图书
                boolean success = GUIApp.bookManager.borrowBook(isbn, name, id);
                if (success) {
                    JOptionPane.showMessageDialog(BorrowBookDialog.this, "借阅成功！");
                    BorrowBookDialog.this.dispose();
                    parentFrame.refreshBookTable();
                } else {
                    // 判断失败原因
                    List<Book> bookList = GUIApp.bookManager.searchBook(isbn, true);
                    if (bookList.isEmpty()) {
                        JOptionPane.showMessageDialog(BorrowBookDialog.this, "未找到该ISBN对应的图书！", "提示", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(BorrowBookDialog.this, "该书已被借完，借阅失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        cancelBtn.addActionListener(e -> BorrowBookDialog.this.dispose());

        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
