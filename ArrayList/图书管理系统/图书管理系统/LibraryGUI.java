package 图书管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LibraryGUI extends JFrame {
    private BookManager manager = new BookManager();
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public LibraryGUI() {
        // 窗口基本设置
        setTitle("图书管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());

        // 顶部功能按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        String[] buttonNames = {
            "添加图书", "修改图书", "删除图书", 
            "查询图书", "借阅图书", "归还图书", 
            "显示所有", "统计信息"
        };
        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            btn.addActionListener(new ButtonActionListener());
            buttonPanel.add(btn);
        }
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        // 中间表格区域（显示图书列表）
        String[] columnNames = {"ISBN", "书名", "作者", "出版社", "出版日期", "总藏书量", "可借数量", "状态"};
        tableModel = new DefaultTableModel(columnNames, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 底部状态标签
        JLabel statusLabel = new JLabel("就绪");
        mainPanel.add(statusLabel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    // 按钮点击事件处理器
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            switch (action) {
                case "添加图书":
                    showAddBookDialog();
                    break;
                case "修改图书":
                    showUpdateBookDialog();
                    break;
                case "删除图书":
                    showDeleteBookDialog();
                    break;
                case "查询图书":
                    showSearchDialog();
                    break;
                case "借阅图书":
                    showBorrowDialog();
                    break;
                case "归还图书":
                    showReturnDialog();
                    break;
                case "显示所有":
                    refreshBookTable(manager.getBookList());
                    break;
                case "统计信息":
                    showStatisticsDialog();
                    break;
            }
        }
    }

    // 刷新表格数据
    private void refreshBookTable(List<Book> books) {
        tableModel.setRowCount(0); // 清空表格
        for (Book book : books) {
            Object[] row = {
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublishDate(),
                book.getTotalCount(),
                book.getAvailableCount(),
                book.getAvailableCount() > 0 ? "可借" : "已借出"
            };
            tableModel.addRow(row);
        }
    }

    // 添加图书对话框
    private void showAddBookDialog() {
        JDialog dialog = new JDialog(this, "添加图书", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(8, 2, 10, 10));
        dialog.add(new JLabel("ISBN号:"));
        JTextField isbnField = new JTextField();
        dialog.add(isbnField);

        dialog.add(new JLabel("书名:"));
        JTextField titleField = new JTextField();
        dialog.add(titleField);

        dialog.add(new JLabel("作者:"));
        JTextField authorField = new JTextField();
        dialog.add(authorField);

        dialog.add(new JLabel("出版社:"));
        JTextField publisherField = new JTextField();
        dialog.add(publisherField);

        dialog.add(new JLabel("出版日期(YYYY-MM-DD):"));
        JTextField dateField = new JTextField();
        dialog.add(dateField);

        dialog.add(new JLabel("总藏书量:"));
        JTextField totalField = new JTextField();
        dialog.add(totalField);

        dialog.add(new JLabel("可借数量:"));
        JTextField availableField = new JTextField();
        dialog.add(availableField);

        JButton confirmBtn = new JButton("确认添加");
        confirmBtn.addActionListener(e -> {
            try {
                String isbn = isbnField.getText().trim();
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String publisher = publisherField.getText().trim();
                String date = dateField.getText().trim();
                int total = Integer.parseInt(totalField.getText().trim());
                int available = Integer.parseInt(availableField.getText().trim());

                if (total < 0 || available < 0 || available > total) {
                    JOptionPane.showMessageDialog(dialog, "数量输入无效！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Book book = new Book(isbn, title, author, publisher, date, total, available);
                if (manager.addBook(book)) {
                    JOptionPane.showMessageDialog(dialog, "添加成功！");
                    dialog.dispose();
                    refreshBookTable(manager.getBookList());
                } else {
                    JOptionPane.showMessageDialog(dialog, "ISBN已存在！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(confirmBtn);

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());
        dialog.add(cancelBtn);

        dialog.setVisible(true);
    }

    // 修改图书对话框
    private void showUpdateBookDialog() {
        String isbn = JOptionPane.showInputDialog(this, "请输入要修改的图书ISBN:");
        if (isbn == null || isbn.trim().isEmpty()) return;

        List<Book> books = manager.searchBook(isbn, true);
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "未找到该ISBN的图书！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Book oldBook = books.get(0);

        JDialog dialog = new JDialog(this, "修改图书", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(8, 2, 10, 10));

        dialog.add(new JLabel("ISBN号(不可修改):"));
        JTextField isbnField = new JTextField(isbn);
        isbnField.setEditable(false);
        dialog.add(isbnField);

        dialog.add(new JLabel("书名:"));
        JTextField titleField = new JTextField(oldBook.getTitle());
        dialog.add(titleField);

        dialog.add(new JLabel("作者:"));
        JTextField authorField = new JTextField(oldBook.getAuthor());
        dialog.add(authorField);

        dialog.add(new JLabel("出版社:"));
        JTextField publisherField = new JTextField(oldBook.getPublisher());
        dialog.add(publisherField);

        dialog.add(new JLabel("出版日期(YYYY-MM-DD):"));
        JTextField dateField = new JTextField(oldBook.getPublishDate());
        dialog.add(dateField);

        dialog.add(new JLabel("总藏书量:"));
        JTextField totalField = new JTextField(String.valueOf(oldBook.getTotalCount()));
        dialog.add(totalField);

        dialog.add(new JLabel("可借数量:"));
        JTextField availableField = new JTextField(String.valueOf(oldBook.getAvailableCount()));
        dialog.add(availableField);

        JButton confirmBtn = new JButton("确认修改");
        confirmBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String publisher = publisherField.getText().trim();
                String date = dateField.getText().trim();
                int total = Integer.parseInt(totalField.getText().trim());
                int available = Integer.parseInt(availableField.getText().trim());

                if (total < 0 || available < 0 || available > total) {
                    JOptionPane.showMessageDialog(dialog, "数量输入无效！", "错误", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Book newBook = new Book(isbn, title, author, publisher, date, total, available);
                if (manager.updateBook(isbn, newBook)) {
                    JOptionPane.showMessageDialog(dialog, "修改成功！");
                    dialog.dispose();
                    refreshBookTable(manager.getBookList());
                } else {
                    JOptionPane.showMessageDialog(dialog, "修改失败！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "请输入有效的数字！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(confirmBtn);

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());
        dialog.add(cancelBtn);

        dialog.setVisible(true);
    }

    // 删除图书对话框
    private void showDeleteBookDialog() {
        String isbn = JOptionPane.showInputDialog(this, "请输入要删除的图书ISBN:");
        if (isbn == null || isbn.trim().isEmpty()) return;

        List<Book> books = manager.searchBook(isbn, true);
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "未找到该ISBN的图书！", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "确定要删除《" + books.get(0).getTitle() + "》吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (manager.deleteBook(isbn)) {
                JOptionPane.showMessageDialog(this, "删除成功！");
                refreshBookTable(manager.getBookList());
            } else {
                JOptionPane.showMessageDialog(this, "删除失败！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 查询图书对话框
    private void showSearchDialog() {
        String[] options = {"按ISBN查询", "按书名查询"};
        int choice = JOptionPane.showOptionDialog(this, "请选择查询方式", "查询图书",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) { // 按ISBN
            String isbn = JOptionPane.showInputDialog(this, "请输入ISBN号:");
            if (isbn == null) return;
            List<Book> result = manager.searchBook(isbn, true);
            refreshBookTable(result);
            JOptionPane.showMessageDialog(this, "找到" + result.size() + "本图书");
        } else if (choice == 1) { // 按书名
            String title = JOptionPane.showInputDialog(this, "请输入书名关键词:");
            if (title == null) return;
            List<Book> result = manager.searchBook(title, false);
            refreshBookTable(result);
            JOptionPane.showMessageDialog(this, "找到" + result.size() + "本图书");
        }
    }

    // 借阅图书对话框
    private void showBorrowDialog() {
        JDialog dialog = new JDialog(this, "借阅图书", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));

        dialog.add(new JLabel("图书ISBN:"));
        JTextField isbnField = new JTextField();
        dialog.add(isbnField);

        dialog.add(new JLabel("借阅人姓名:"));
        JTextField nameField = new JTextField();
        dialog.add(nameField);

        dialog.add(new JLabel("借阅人学号:"));
        JTextField idField = new JTextField();
        dialog.add(idField);

        JButton confirmBtn = new JButton("确认借阅");
        confirmBtn.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            String name = nameField.getText().trim();
            String id = idField.getText().trim();

            if (isbn.isEmpty() || name.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "请填写完整信息！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean success = manager.borrowBook(isbn, name, id);
            if (success) {
                JOptionPane.showMessageDialog(dialog, "借阅成功！");
                dialog.dispose();
                refreshBookTable(manager.getBookList());
            } else {
                List<Book> books = manager.searchBook(isbn, true);
                if (books.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "未找到该图书！", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(dialog, "图书已全部借出！", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dialog.add(confirmBtn);

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());
        dialog.add(cancelBtn);

        dialog.setVisible(true);
    }

    // 归还图书对话框
    private void showReturnDialog() {
        JDialog dialog = new JDialog(this, "归还图书", true);
        dialog.setSize(300, 150);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new GridLayout(3, 2, 10, 10));

        dialog.add(new JLabel("图书ISBN:"));
        JTextField isbnField = new JTextField();
        dialog.add(isbnField);

        dialog.add(new JLabel("借阅人学号:"));
        JTextField idField = new JTextField();
        dialog.add(idField);

        JButton confirmBtn = new JButton("确认归还");
        confirmBtn.addActionListener(e -> {
            String isbn = isbnField.getText().trim();
            String id = idField.getText().trim();

            if (isbn.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "请填写完整信息！", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (manager.returnBook(isbn, id)) {
                JOptionPane.showMessageDialog(dialog, "归还成功！");
                dialog.dispose();
                refreshBookTable(manager.getBookList());
            } else {
                JOptionPane.showMessageDialog(dialog, "归还失败，未找到匹配记录！", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });
        dialog.add(confirmBtn);

        JButton cancelBtn = new JButton("取消");
        cancelBtn.addActionListener(e -> dialog.dispose());
        dialog.add(cancelBtn);

        dialog.setVisible(true);
    }

    // 统计信息对话框
    private void showStatisticsDialog() {
        List<Book> books = manager.getBookList();
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "系统中暂无图书记录！");
            return;
        }

        int totalTypes = books.size();
        int totalCopies = 0;
        int availableCopies = 0;
        for (Book book : books) {
            totalCopies += book.getTotalCount();
            availableCopies += book.getAvailableCount();
        }
        int borrowedCopies = totalCopies - availableCopies;

        String stats = String.format(
            "总图书种类：%d 种\n" +
            "总藏书量：%d 本\n" +
            "当前借出：%d 本\n" +
            "当前在馆：%d 本",
            totalTypes, totalCopies, borrowedCopies, availableCopies
        );
        JOptionPane.showMessageDialog(this, stats, "图书统计信息", JOptionPane.INFORMATION_MESSAGE);
    }

    // 主方法启动界面
    public static void main(String[] args) {
        // 在事件调度线程中启动GUI，确保线程安全
        SwingUtilities.invokeLater(LibraryGUI::new);
    }
}