package 图书管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// 图书管理主窗口：包含所有图书操作入口和图书列表展示
public class BookMainFrame extends JFrame {
    private DefaultTableModel bookTableModel; // 图书表格模型（控制表格数据）
    private JTable bookTable;                 // 图书展示表格

    public BookMainFrame() {
        // 窗口基础配置
        setTitle("图书管理系统 - 主界面");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. 功能按钮区域（顶部）
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JButton addBtn = new JButton("添加图书");
        JButton updateBtn = new JButton("修改图书");
        JButton deleteBtn = new JButton("删除图书");
        JButton borrowBtn = new JButton("借阅图书");
        JButton returnBtn = new JButton("归还图书");
        JButton searchBtn = new JButton("查询图书");
        JButton statBtn = new JButton("图书统计");
        JButton logoutBtn = new JButton("退出登录");
        // 按钮样式
        Font btnFont = new Font("微软雅黑", Font.PLAIN, 14);
        addBtn.setFont(btnFont);
        updateBtn.setFont(btnFont);
        deleteBtn.setFont(btnFont);
        borrowBtn.setFont(btnFont);
        returnBtn.setFont(btnFont);
        searchBtn.setFont(btnFont);
        statBtn.setFont(btnFont);
        logoutBtn.setFont(btnFont);
        // 按钮尺寸统一
        Dimension btnSize = new Dimension(110, 35);
        addBtn.setPreferredSize(btnSize);
        updateBtn.setPreferredSize(btnSize);
        deleteBtn.setPreferredSize(btnSize);
        borrowBtn.setPreferredSize(btnSize);
        returnBtn.setPreferredSize(btnSize);
        searchBtn.setPreferredSize(btnSize);
        statBtn.setPreferredSize(btnSize);
        logoutBtn.setPreferredSize(btnSize);

        // 按钮事件绑定
        addBtn.addActionListener(e -> new AddBookDialog(this).setVisible(true));
        updateBtn.addActionListener(e -> openUpdateDialog());
        deleteBtn.addActionListener(e -> deleteBook());
        borrowBtn.addActionListener(e -> new BorrowBookDialog(this).setVisible(true));
        returnBtn.addActionListener(e -> new ReturnBookDialog(this).setVisible(true));
        searchBtn.addActionListener(e -> new SearchBookDialog(this).setVisible(true));
        statBtn.addActionListener(e -> showBookStat());
        logoutBtn.addActionListener(e -> logout());

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(borrowBtn);
        btnPanel.add(returnBtn);
        btnPanel.add(searchBtn);
        btnPanel.add(statBtn);
        // 退出按钮右对齐
        btnPanel.add(Box.createHorizontalGlue());
        btnPanel.add(logoutBtn);
        add(btnPanel, BorderLayout.NORTH);

        // 2. 图书表格区域（中间，带滚动条）
        String[] tableHeaders = {"ISBN号", "书名", "作者", "出版社", "出版日期", "总藏书量", "当前库存", "状态"};
        bookTableModel = new DefaultTableModel(tableHeaders, 0) {
            // 表格单元格不可编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bookTable = new JTable(bookTableModel);
        // 表格样式优化
        bookTable.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        bookTable.setRowHeight(28); // 行高
        bookTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 13));
        // 单元格内容居中
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableHeaders.length; i++) {
            bookTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // 表格添加滚动条
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        // 初始化加载图书列表
        refreshBookTable();
    }

    // 刷新图书表格（从BookManager获取最新数据）
    public void refreshBookTable() {
        // 清空原有数据
        bookTableModel.setRowCount(0);
        // 加载新数据
        List<Book> bookList = GUIApp.bookManager.getBookList();
        for (Book book : bookList) {
            Object[] rowData = {
                    book.getIsbn(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPublisher(),
                    book.getPublishDate(),
                    book.getTotalCount(),
                    book.getAvailableCount(),
                    book.getAvailableCount() > 0 ? "可借" : "已借完"
            };
            bookTableModel.addRow(rowData);
        }
    }

    // 打开修改图书弹窗（需先选中一行）
    private void openUpdateDialog() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选中要修改的图书！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // 获取选中图书的ISBN（唯一标识）
        String isbn = (String) bookTableModel.getValueAt(selectedRow, 0);
        new UpdateBookDialog(this, isbn).setVisible(true);
    }

    // 删除图书（需先选中一行）
    private void deleteBook() {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "请选中要删除的图书！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String isbn = (String) bookTableModel.getValueAt(selectedRow, 0);
        String title = (String) bookTableModel.getValueAt(selectedRow, 1);
        // 二次确认
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "确定要删除《" + title + "》（ISBN：" + isbn + "）吗？",
                "确认删除",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = GUIApp.bookManager.deleteBook(isbn);
            if (success) {
                JOptionPane.showMessageDialog(this, "删除成功！");
                refreshBookTable();
            } else {
                JOptionPane.showMessageDialog(this, "删除失败，未找到该图书！", "提示", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 图书统计（复用原有逻辑）
    private void showBookStat() {
        List<Book> bookList = GUIApp.bookManager.getBookList();
        int totalCount = bookList.size();
        int availableCount = 0;
        for (Book book : bookList) {
            if (book.getAvailableCount() > 0) {
                availableCount++;
            }
        }
        int borrowedCount = totalCount - availableCount;
        // 显示统计结果
        String statMsg = String.format(
                "图书统计结果：\n" +
                "总图书数量：%d 本\n" +
                "可借图书数量：%d 本\n" +
                "已借出图书数量：%d 本",
                totalCount, availableCount, borrowedCount
        );
        JOptionPane.showMessageDialog(this, statMsg, "图书统计", JOptionPane.INFORMATION_MESSAGE);
    }

    // 退出登录（返回登录窗口）
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "确定要退出登录吗？", "确认退出", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new LoginFrame().setVisible(true);
            this.dispose();
        }
    }
}
