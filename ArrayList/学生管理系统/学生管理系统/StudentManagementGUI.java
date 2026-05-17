package 学生管理系统;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentManagementGUI extends JFrame {
    private ArrayList<student> studentList;
    private DefaultTableModel tableModel;
    private JTable studentTable;

    public StudentManagementGUI() {
        studentList = new ArrayList<>();
        initUI(); // 初始化界面
    }

    // 初始化图形界面
    private void initUI() {
        setTitle("学生管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中

        // 1. 初始化表格模型（列名：学号、姓名、年龄、家庭住址）
        String[] columnNames = {"学号", "姓名", "年龄", "家庭住址"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // 2. 初始化按钮面板
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("添加学生");
        JButton deleteBtn = new JButton("删除学生");
        JButton updateBtn = new JButton("修改学生");
        JButton queryBtn = new JButton("查询学生");
        JButton exitBtn = new JButton("退出系统");

        buttonPanel.add(addBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(queryBtn);
        buttonPanel.add(exitBtn);

        // 3. 为按钮绑定事件
        addBtn.addActionListener(e -> addStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        updateBtn.addActionListener(e -> updateStudent());
        queryBtn.addActionListener(e -> refreshTable());
        exitBtn.addActionListener(e -> System.exit(0));

        // 4. 设置界面布局（北：按钮面板，中：表格滚动面板）
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // ---------- 功能1：添加学生 ----------
    private void addStudent() {
        JDialog dialog = new JDialog(this, "添加学生", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel idLabel = new JLabel("学号：");
        JTextField idField = new JTextField();
        JLabel nameLabel = new JLabel("姓名：");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("年龄：");
        JTextField ageField = new JTextField();
        JLabel addressLabel = new JLabel("家庭住址：");
        JTextField addressField = new JTextField();
        JButton confirmBtn = new JButton("确认");
        JButton cancelBtn = new JButton("取消");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(confirmBtn);
        panel.add(cancelBtn);

        // 确认按钮逻辑：校验输入 + 添加学生
        confirmBtn.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String address = addressField.getText().trim();

            // 非空校验
            if (id.isEmpty() || name.isEmpty() || ageText.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "所有字段必须填写！");
                return;
            }

            // 年龄格式校验
            int age;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "年龄必须是整数！");
                return;
            }

            // 学号唯一性校验
            if (isExist(studentList, id)) {
                JOptionPane.showMessageDialog(dialog, "该学号已存在！");
                return;
            }

            // 添加学生到列表和表格
            student stu = new student(id, name, age, address);
            studentList.add(stu);
            tableModel.addRow(new Object[]{id, name, age, address});
            dialog.dispose(); // 关闭对话框
            JOptionPane.showMessageDialog(StudentManagementGUI.this, "添加成功！");
        });

        // 取消按钮逻辑：关闭对话框
        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.add(panel);
        dialog.setVisible(true);
    }

    // ---------- 功能2：删除学生 ----------
    private void deleteStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) { // 未选中行
            JOptionPane.showMessageDialog(this, "请先选中要删除的学生！");
            return;
        }

        // 获取选中行的学号
        String id = (String) tableModel.getValueAt(selectedRow, 0);
        int index = getIndex(studentList, id);

        if (index != -1) { // 找到对应学生
            studentList.remove(index);
            tableModel.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "删除成功！");
        } else {
            JOptionPane.showMessageDialog(this, "学号不存在，删除失败！");
        }
    }

    // ---------- 功能3：修改学生 ----------
    private void updateStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) { // 未选中行
            JOptionPane.showMessageDialog(this, "请先选中要修改的学生！");
            return;
        }

        // 获取选中行的学号和学生对象
        String oldId = (String) tableModel.getValueAt(selectedRow, 0);
        int index = getIndex(studentList, oldId);
        if (index == -1) { // 学号不存在
            JOptionPane.showMessageDialog(this, "该学号不存在，修改失败！");
            return;
        }
        student oldStu = studentList.get(index);

        // 弹出修改对话框
        JDialog dialog = new JDialog(this, "修改学生", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        JLabel idLabel = new JLabel("学号：");
        JTextField idField = new JTextField(oldId);
        idField.setEditable(false); // 学号不可修改
        JLabel nameLabel = new JLabel("姓名：");
        JTextField nameField = new JTextField(oldStu.getName());
        JLabel ageLabel = new JLabel("年龄：");
        JTextField ageField = new JTextField(String.valueOf(oldStu.getAge()));
        JLabel addressLabel = new JLabel("家庭住址：");
        JTextField addressField = new JTextField(oldStu.getAddress());
        JButton confirmBtn = new JButton("确认");
        JButton cancelBtn = new JButton("取消");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(confirmBtn);
        panel.add(cancelBtn);

        // 确认按钮逻辑：更新学生信息
        confirmBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String address = addressField.getText().trim();

            // 非空校验
            if (name.isEmpty() || ageText.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "姓名、年龄、家庭住址必须填写！");
                return;
            }

            // 年龄格式校验
            int age;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "年龄必须是整数！");
                return;
            }

            // 更新学生对象和表格
            oldStu.setName(name);
            oldStu.setAge(age);
            oldStu.setAddress(address);
            tableModel.setValueAt(name, selectedRow, 1);
            tableModel.setValueAt(age, selectedRow, 2);
            tableModel.setValueAt(address, selectedRow, 3);

            dialog.dispose();
            JOptionPane.showMessageDialog(StudentManagementGUI.this, "修改成功！");
        });

        // 取消按钮逻辑：关闭对话框
        cancelBtn.addActionListener(e -> dialog.dispose());

        dialog.add(panel);
        dialog.setVisible(true);
    }

    // ---------- 功能4：查询学生（刷新表格） ----------
    private void refreshTable() {
        tableModel.setRowCount(0); // 清空表格
        // 重新加载所有学生数据到表格
        for (student stu : studentList) {
            tableModel.addRow(new Object[]{
                    stu.getId(), stu.getName(), stu.getAge(), stu.getAddress()
            });
        }
        JOptionPane.showMessageDialog(this, "查询成功，共 " + studentList.size() + " 条记录！");
    }

    // ---------- 工具方法：学号是否存在 ----------
    private boolean isExist(ArrayList<student> list, String id) {
        for (student stu : list) {
            if (stu.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // ---------- 工具方法：通过学号获取索引 ----------
    private int getIndex(ArrayList<student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // 程序入口：在事件调度线程中启动GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementGUI().setVisible(true));
    }
}
