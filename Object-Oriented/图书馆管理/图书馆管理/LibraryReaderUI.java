package 图书馆管理;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryReaderUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private SearchPanel searchPanel;
    private RecordPanel recordPanel;
    private ProfilePanel profilePanel;

    public LibraryReaderUI() {
        // 窗口基本设置
        setTitle("图书馆读者系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中显示

        // 顶部导航栏（切换功能面板）
        JPanel navPanel = new JPanel();
        JButton searchBtn = new JButton("查书");
        JButton recordBtn = new JButton("我的记录");
        JButton profileBtn = new JButton("个人中心");
        navPanel.add(searchBtn);
        navPanel.add(recordBtn);
        navPanel.add(profileBtn);

        // 卡片布局：用于切换不同功能面板
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 初始化三个功能面板
        searchPanel = new SearchPanel();
        recordPanel = new RecordPanel();
        profilePanel = new ProfilePanel();

        // 将面板加入卡片容器
        cardPanel.add(searchPanel, "search");
        cardPanel.add(recordPanel, "record");
        cardPanel.add(profilePanel, "profile");

        // 导航按钮绑定“切换面板”事件
        searchBtn.addActionListener(e -> cardLayout.show(cardPanel, "search"));
        recordBtn.addActionListener(e -> cardLayout.show(cardPanel, "record"));
        profileBtn.addActionListener(e -> cardLayout.show(cardPanel, "profile"));

        // 组装窗口（北：导航栏；中：卡片面板）
        add(navPanel, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);

        setVisible(true); // 显示窗口
    }

    public static void main(String[] args) {
        //  Swing 线程安全启动
        SwingUtilities.invokeLater(LibraryReaderUI::new);
    }
}

// --------------- 子面板1：查书功能 ---------------
class SearchPanel extends JPanel {
    public SearchPanel() {
        setLayout(new BorderLayout());

        // 搜索区域（标签 + 输入框 + 按钮）
        JPanel searchArea = new JPanel();
        JTextField searchField = new JTextField(20);
        JButton searchBtn = new JButton("搜索");
        searchArea.add(new JLabel("书名/作者:"));
        searchArea.add(searchField);
        searchArea.add(searchBtn);

        // 结果显示（表格模拟图书列表）
        String[] columns = {"书名", "作者", "库存状态", "书架位置"};
        Object[][] data = {
                {"Java编程思想", "Bruce Eckel", "可借", "A区1排"},
                {"数据结构与算法", "严蔚敏", "已借出", "B区2排"}
        };
        JTable resultTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(resultTable);

        // 组装面板
        add(searchArea, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // 搜索按钮点击事件（示例：弹窗提示，实际需连数据库查询）
        searchBtn.addActionListener(e -> {
            String keyword = searchField.getText();
            JOptionPane.showMessageDialog(this, "搜索关键词: " + keyword);
            // 实际开发：此处需通过 JDBC 查询数据库，动态更新表格数据
        });
    }
}

// --------------- 子面板2：我的借阅记录 ---------------
class RecordPanel extends JPanel {
    public RecordPanel() {
        setLayout(new BorderLayout());

        // 借阅记录表格
        String[] columns = {"书名", "借阅日期", "到期日期", "状态"};
        Object[][] data = {
                {"Java编程思想", "2025-08-01", "2025-08-31", "正常"},
                {"数据结构与算法", "2025-07-15", "2025-08-14", "已逾期1天"}
        };
        JTable recordTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(recordTable);

        add(scrollPane, BorderLayout.CENTER);
    }
}

// --------------- 子面板3：个人中心（改密码等） ---------------
class ProfilePanel extends JPanel {
    public ProfilePanel() {
        setLayout(new GridLayout(4, 2, 10, 10)); // 4行2列，间距10
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 内边距

        // 显示用户信息 + 改密码功能
        add(new JLabel("用户名:"));
        add(new JLabel("reader001")); // 模拟用户名

        add(new JLabel("注册时间:"));
        add(new JLabel("2025-01-01")); // 模拟注册时间

        add(new JLabel("新密码:"));
        JPasswordField newPwd = new JPasswordField();
        add(newPwd);

        JButton saveBtn = new JButton("保存密码");
        add(new JLabel()); // 占位（保持布局对齐）
        add(saveBtn);

        // 保存密码事件（示例：简单校验）
        saveBtn.addActionListener(e -> {
            String pwd = new String(newPwd.getPassword());
            if (pwd.length() < 6) {
                JOptionPane.showMessageDialog(this, "密码长度不能小于6位");
            } else {
                JOptionPane.showMessageDialog(this, "密码修改成功");
                newPwd.setText(""); // 清空输入框
            }
        });
    }
}
//public class 可视化界面 {
    
//}
