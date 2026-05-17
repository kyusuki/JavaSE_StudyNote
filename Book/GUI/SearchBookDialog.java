package 图书管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchBookDialog extends JDialog {
    private JTextField keywordField;
    private JRadioButton isbnRadio;
    private JRadioButton titleRadio;
    private DefaultTableModel resultTableModel;
    private JTable resultTable;

    public SearchBookDialog(BookMainFrame parentFrame) {
        super(parentFrame, "查询图书", true);
        setSize(800, 500);
        setLocationRelativeTo(parentFrame);
        setLayout(new BorderLayout(10, 15));
        setResizable(false);

        // 1. 查询条件区域
        JPanel conditionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        JLabel keywordLabel = new JLabel("查询关键词：");
        keywordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        keywordField = new JTextField(20);
        keywordField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        // 单选按钮（ISBN/书名）
        isbnRadio = new JRadioButton("按ISBN查询");
        titleRadio = new JRadioButton("按书名查询", true); // 默认按书名
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(isbnRadio);
        radioGroup.add(titleRadio);
        isbnRadio.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        titleRadio.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        // 查询按钮
        JButton searchBtn = new JButton("查询");
        searchBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchBtn.setPreferredSize(new Dimension(80, 30));

        // 查询按钮事件
        searchBtn.addActionListener(e -> doSearch());

        conditionPanel.add(keywordLabel);
        conditionPanel.add(keywordField);
        conditionPanel.add(Box.createHorizontalStrut(20));
        conditionPanel.add(isbnRadio);
        conditionPanel.add(titleRadio);
        conditionPanel.add(Box.createHorizontalStrut(20));
        conditionPanel.add(searchBtn);
        add(conditionPanel, BorderLayout.NORTH);

        // 2. 查询结果表格
        String[] tableHeaders = {"ISBN号", "书名", "作者", "出版社", "出版日期", "总藏书量", "当前库存", "状态"};
        resultTableModel = new DefaultTableModel(tableHeaders, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultTable = new JTable(resultTableModel);
        // 表格样式
        resultTable.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        resultTable.setRowHeight(25);
        resultTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 13));
        // 内容居中
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableHeaders.length; i++) {
            resultTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        // 滚动条
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    // 执行查询逻辑
    private void doSearch() {
        String keyword = keywordField.getText().trim();
        boolean isIsbnSearch = isbnRadio.isSelected(); // true=按ISBN，false=按书名

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入查询关键词！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 调用BookManager查询图书
        List<Book> resultList = GUIApp.bookManager.searchBook(keyword, isIsbnSearch);
        // 更新结果表格
        resultTableModel.setRowCount(0);
        if (resultList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "未找到匹配的图书！", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (Book book : resultList) {
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
            resultTableModel.addRow(rowData);
        }
    }
}
