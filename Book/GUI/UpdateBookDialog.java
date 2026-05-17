package 图书管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UpdateBookDialog extends JDialog {
    private JTextField isbnField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField publisherField;
    private JTextField dateField;
    private JTextField totalField;
    private JTextField availableField;
    private BookMainFrame parentFrame;
    private String targetIsbn; // 要修改的图书ISBN

    public UpdateBookDialog(BookMainFrame parentFrame, String targetIsbn) {
        super(parentFrame, "修改图书", true);
        this.parentFrame = parentFrame;
        this.targetIsbn = targetIsbn;
        setSize(550, 450);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 20));
        setResizable(false);

        // 1. 标题
        JLabel titleLabel = new JLabel("修改图书信息", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // 2. 修改表单（预填原有信息）
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 18));
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        Font labelFont = new Font("微软雅黑", Font.PLAIN, 14);
        Font fieldFont = new Font("微软雅黑", Font.PLAIN, 14);

        // 获取要修改的图书信息
        Book targetBook = null;
        List<Book> bookList = GUIApp.bookManager.getBookList();
        for (Book book : bookList) {
            if (book.getIsbn().equals(targetIsbn)) {
                targetBook = book;
                break;
            }
        }
        if (targetBook == null) {
            JOptionPane.showMessageDialog(this, "未找到该图书！", "提示", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        }

        // ISBN（不可修改）
        JLabel isbnLabel = new JLabel("ISBN号（不可修改）：", SwingConstants.RIGHT);
        isbnLabel.setFont(labelFont);
        isbnField = new JTextField(targetBook.getIsbn());
        isbnField.setFont(fieldFont);
        isbnField.setEditable(false); // 禁用编辑
        formPanel.add(isbnLabel);
        formPanel.add(isbnField);

        // 书名
        JLabel bookTitleLabel = new JLabel("书名：", SwingConstants.RIGHT);
        bookTitleLabel.setFont(labelFont);
        titleField = new JTextField(targetBook.getTitle());
        titleField.setFont(fieldFont);
        formPanel.add(bookTitleLabel);
        formPanel.add(titleField);

        // 作者
        JLabel authorLabel = new JLabel("作者：", SwingConstants.RIGHT);
        authorLabel.setFont(labelFont);
        authorField = new JTextField(targetBook.getAuthor());
        authorField.setFont(fieldFont);
        formPanel.add(authorLabel);
        formPanel.add(authorField);

        // 出版社
        JLabel publisherLabel = new JLabel("出版社：", SwingConstants.RIGHT);
        publisherLabel.setFont(labelFont);
        publisherField = new JTextField(targetBook.getPublisher());
        publisherField.setFont(fieldFont);
        formPanel.add(publisherLabel);
        formPanel.add(publisherField);

        // 出版日期
        JLabel dateLabel = new JLabel("出版日期（YYYY-MM-DD）：", SwingConstants.RIGHT);
        dateLabel.setFont(labelFont);
        dateField = new JTextField(targetBook.getPublishDate());
        dateField.setFont(fieldFont);
        formPanel.add(dateLabel);
        formPanel.add(dateField);

        // 总藏书量
        JLabel totalLabel = new JLabel("总藏书量（正整数）：", SwingConstants.RIGHT);
        totalLabel.setFont(labelFont);
        totalField = new JTextField(String.valueOf(targetBook.getTotalCount()));
        totalField.setFont(fieldFont);
        formPanel.add(totalLabel);
        formPanel.add(totalField);

        // 当前库存
        JLabel availableLabel = new JLabel("当前库存（正整数）：", SwingConstants.RIGHT);
        availableLabel.setFont(labelFont);
        availableField = new JTextField(String.valueOf(targetBook.getAvailableCount()));
        availableField.setFont(fieldFont);
        formPanel.add(availableLabel);
        formPanel.add(availableField);
        add(formPanel, BorderLayout.CENTER);

        // 3. 确认/取消按钮
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        JButton confirmBtn = new JButton("确认修改");
        JButton cancelBtn = new JButton("取消");
        confirmBtn.setFont(fieldFont);
        cancelBtn.setFont(fieldFont);
        confirmBtn.setPreferredSize(new Dimension(120, 30));
        cancelBtn.setPreferredSize(new Dimension(120, 30));

        // 确认修改逻辑
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 获取修改后的数据
                    String title = titleField.getText().trim();
                    String author = authorField.getText().trim();
                    String publisher = publisherField.getText().trim();
                    String date = dateField.getText().trim();
                    int total = Integer.parseInt(totalField.getText().trim());
                    int available = Integer.parseInt(availableField.getText().trim());

                    // 验证
                    if (title.isEmpty() || author.isEmpty() || publisher.isEmpty() || date.isEmpty()) {
                        JOptionPane.showMessageDialog(UpdateBookDialog.this, "请填写完整信息！", "提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (total <= 0 || available < 0 || available > total) {
                        JOptionPane.showMessageDialog(UpdateBookDialog.this, "库存需为非负整数，且不超过总藏书量！", "提示", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // 调用BookManager修改图书
                    Book updatedBook = new Book(targetIsbn, title, author, publisher, date, total, available);
                    boolean success = GUIApp.bookManager.updateBook(targetIsbn, updatedBook);
                    if (success) {
                        JOptionPane.showMessageDialog(UpdateBookDialog.this, "修改成功！");
                        UpdateBookDialog.this.dispose();
                        parentFrame.refreshBookTable();
                    } else {
                        JOptionPane.showMessageDialog(UpdateBookDialog.this, "修改失败！", "提示", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(UpdateBookDialog.this, "总藏书量/库存请输入数字！", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelBtn.addActionListener(e -> UpdateBookDialog.this.dispose());

        btnPanel.add(confirmBtn);
        btnPanel.add(cancelBtn);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
