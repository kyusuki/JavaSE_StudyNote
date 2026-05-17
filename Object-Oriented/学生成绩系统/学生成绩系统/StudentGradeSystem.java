package 学生成绩系统;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// 学生类
class Student {
    private int id;          // 学号
    private String name;     // 姓名
    private float math;      // 高数成绩
    private float english;   // 英语成绩

    public Student(int id, String name, float math, float english) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.english = english;
    }

    // getter和setter方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public float getMath() { return math; }
    public void setMath(float math) { this.math = math; }
    
    public float getEnglish() { return english; }
    public void setEnglish(float english) { this.english = english; }
}

// 主界面类
public class StudentGradeSystem extends JFrame {
    private static final int MAX_STU = 30;  // 最大学生数
    private ArrayList<Student> students;    // 存储学生的集合
    private JTabbedPane tabbedPane;         // 选项卡面板
    
    // 录入学生相关组件
    private JTextField idField, nameField, addMathField, addEnglishField;
    
    // 查找、修改、删除学生相关组件
    private JTextField findIdField, editIdField, deleteIdField;
    private JTextField editNameField, editMathField, editEnglishField;
    
    // 显示所有学生的表格
    private JTable studentTable;
    private StudentTableModel tableModel;

    public StudentGradeSystem() {
        students = new ArrayList<>();
        initUI();
        setTitle("学生成绩管理系统");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // 窗口居中显示
        setResizable(false);          // 禁止窗口缩放
    }

    // 初始化界面
    private void initUI() {
        tabbedPane = new JTabbedPane();
        
        // 添加各个功能面板
        tabbedPane.addTab("录入学生", createAddPanel());
        tabbedPane.addTab("显示所有", createShowPanel());
        tabbedPane.addTab("查找学生", createFindPanel());
        tabbedPane.addTab("修改成绩", createEditPanel());
        tabbedPane.addTab("删除学生", createDeletePanel());
        
        add(tabbedPane);
    }

    // 创建录入学生面板
    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 组件初始化
        JLabel idLabel = new JLabel("学号:");
        idField = new JTextField(10);
        
        JLabel nameLabel = new JLabel("姓名:");
        nameField = new JTextField(10);
        
        JLabel mathLabel = new JLabel("高数成绩:");
        addMathField = new JTextField(10);
        
        JLabel englishLabel = new JLabel("英语成绩:");
        addEnglishField = new JTextField(10);
        
        JButton addButton = new JButton("添加");
        addButton.addActionListener(e -> addStudent());

        // 布局组件
        gbc.gridx = 0; gbc.gridy = 0; panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(idField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; panel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; panel.add(mathLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(addMathField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; panel.add(englishLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(addEnglishField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(addButton, gbc);

        return panel;
    }

    // 创建显示所有学生面板
    private JPanel createShowPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // 创建表格模型和表格
        String[] columnNames = {"学号", "姓名", "高数成绩", "英语成绩"};
        tableModel = new StudentTableModel(columnNames, students);
        studentTable = new JTable((TableModel)tableModel); // 明确转换为TableModel
        
        // 优化：成绩列右对齐
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        studentTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        studentTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        // 添加滚动面板
        JScrollPane scrollPane = new JScrollPane(studentTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // 添加刷新按钮
        JButton refreshButton = new JButton("刷新列表");
        refreshButton.addActionListener(e -> refreshTable());
        panel.add(refreshButton, BorderLayout.SOUTH);
        
        return panel;
    }

    // 创建查找学生面板
    private JPanel createFindPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel idLabel = new JLabel("输入学号:");
        findIdField = new JTextField(10);
        
        JButton findButton = new JButton("查找");
        
        // 结果显示区域
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        // 查找逻辑
        findButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(findIdField.getText().trim());
                Student student = findStudentById(id);
                
                if (student != null) {
                    resultArea.setText(String.format(
                        "找到学生:\n学号: %d\n姓名: %s\n高数成绩: %.1f\n英语成绩: %.1f",
                        student.getId(), student.getName(),
                        student.getMath(), student.getEnglish()
                    ));
                } else {
                    resultArea.setText("没有找到该学生");
                }
                findIdField.setText("");  // 查找后清空输入框
            } catch (NumberFormatException ex) {
                resultArea.setText("请输入有效的学号（数字）");
            }
        });

        // 布局组件
        gbc.gridx = 0; gbc.gridy = 0; panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(findIdField, gbc);
        gbc.gridx = 2; gbc.gridy = 0; panel.add(findButton, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 3; 
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        return panel;
    }

    // 创建修改学生面板
    private JPanel createEditPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel idLabel = new JLabel("输入学号:");
        editIdField = new JTextField(10);
        
        JButton findButton = new JButton("查找");
        
        JLabel nameLabel = new JLabel("姓名:");
        editNameField = new JTextField(10);
        editNameField.setEditable(false);  // 姓名不可修改
        
        JLabel mathLabel = new JLabel("高数成绩:");
        editMathField = new JTextField(10);
        
        JLabel englishLabel = new JLabel("英语成绩:");
        editEnglishField = new JTextField(10);
        
        JButton saveButton = new JButton("保存修改");

        // 查找待修改学生的逻辑
        findButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(editIdField.getText().trim());
                Student student = findStudentById(id);
                
                if (student != null) {
                    editNameField.setText(student.getName());
                    editMathField.setText(String.valueOf(student.getMath()));
                    editEnglishField.setText(String.valueOf(student.getEnglish()));
                    JOptionPane.showMessageDialog(this, "找到学生，可修改成绩");
                } else {
                    JOptionPane.showMessageDialog(this, "没有找到该学生");
                    // 清空输入框
                    editNameField.setText("");
                    editMathField.setText("");
                    editEnglishField.setText("");
                }
                editIdField.setText("");  // 查找后清空学号输入框
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的学号（数字）");
            }
        });

        // 保存修改的逻辑
        saveButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(editIdField.getText().trim());
                float math = Float.parseFloat(editMathField.getText().trim());
                float english = Float.parseFloat(editEnglishField.getText().trim());
                
                // 成绩合法性验证（0-100）
                if (math < 0 || math > 100 || english < 0 || english > 100) {
                    JOptionPane.showMessageDialog(this, "成绩必须在0-100之间");
                    return;
                }
                
                int index = findStudentIndexById(id);
                if (index != -1) {
                    students.get(index).setMath(math);
                    students.get(index).setEnglish(english);
                    JOptionPane.showMessageDialog(this, "修改成功");
                    refreshTable();
                    // 保存后清空输入框
                    editIdField.setText("");
                    editNameField.setText("");
                    editMathField.setText("");
                    editEnglishField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "请先通过学号查找学生");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的数据（学号：数字，成绩：数字）");
            }
        });

        // 布局组件
        gbc.gridx = 0; gbc.gridy = 0; panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(editIdField, gbc);
        gbc.gridx = 2; gbc.gridy = 0; panel.add(findButton, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; panel.add(nameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2; panel.add(editNameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; panel.add(mathLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(editMathField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; panel.add(englishLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(editEnglishField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 3; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(saveButton, gbc);

        return panel;
    }

    // 创建删除学生面板
    private JPanel createDeletePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel idLabel = new JLabel("输入学号:");
        deleteIdField = new JTextField(10);
        
        JButton deleteButton = new JButton("删除");
        deleteButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(deleteIdField.getText().trim());
                int index = findStudentIndexById(id);
                
                if (index != -1) {
                    int confirm = JOptionPane.showConfirmDialog(
                        this, 
                        "确定要删除学号为 " + id + " 的学生吗?",
                        "确认删除",
                        JOptionPane.YES_NO_OPTION
                    );
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        students.remove(index);
                        JOptionPane.showMessageDialog(this, "删除成功");
                        deleteIdField.setText("");  // 清空输入框
                        refreshTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "没有找到该学生");
                    deleteIdField.setText("");  // 清空输入框
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的学号（数字）");
            }
        });

        // 布局组件
        gbc.gridx = 0; gbc.gridy = 0; panel.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(deleteIdField, gbc);
        gbc.gridx = 2; gbc.gridy = 0; panel.add(deleteButton, gbc);

        return panel;
    }

    // 添加学生
    private void addStudent() {
        if (students.size() >= MAX_STU) {
            JOptionPane.showMessageDialog(this, "学生人数已达上限（" + MAX_STU + "人），无法添加");
            return;
        }

        try {
            // 学号验证：非空+数字
            String idStr = idField.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入学号");
                return;
            }
            int id = Integer.parseInt(idStr);
            
            // 学号唯一性验证
            if (findStudentById(id) != null) {
                JOptionPane.showMessageDialog(this, "该学号已存在，请更换学号");
                return;
            }
            
            // 姓名验证：非空（排除纯空格）
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "请输入姓名（不可为空格）");
                return;
            }
            
            // 成绩验证：非空+数字+0-100
            String mathStr = addMathField.getText().trim();
            String englishStr = addEnglishField.getText().trim();
            if (mathStr.isEmpty() || englishStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "高数和英语成绩不可为空");
                return;
            }
            float math = Float.parseFloat(mathStr);
            float english = Float.parseFloat(englishStr);
            if (math < 0 || math > 100 || english < 0 || english > 100) {
                JOptionPane.showMessageDialog(this, "成绩必须在0-100之间");
                return;
            }
            
            // 添加学生
            students.add(new Student(id, name, math, english));
            JOptionPane.showMessageDialog(this, 
                String.format("添加成功！当前共 %d 名学生（上限%d人）", 
                students.size(), MAX_STU));
            
            // 清空输入框
            idField.setText("");
            nameField.setText("");
            addMathField.setText("");
            addEnglishField.setText("");
            
            // 刷新表格
            refreshTable();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "请输入有效的数据：学号为整数，成绩为数字");
        }
    }

    // 查找学生（返回学生对象）
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // 查找学生（返回索引）
    private int findStudentIndexById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    // 刷新表格数据
    private void refreshTable() {
        tableModel.fireTableDataChanged();
    }

    // 主方法
    public static void main(String[] args) {
        // 在事件调度线程中运行GUI
        SwingUtilities.invokeLater(() -> {
            new StudentGradeSystem().setVisible(true);
        });
    }

    // 自定义表格模型
    class StudentTableModel extends AbstractTableModel {
        private String[] columnNames;
        private ArrayList<Student> data;

        public StudentTableModel(String[] columnNames, ArrayList<Student> data) {
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            Student student = data.get(row);
            switch (col) {
                case 0: return student.getId();
                case 1: return student.getName();
                case 2: return String.format("%.1f", student.getMath());
                case 3: return String.format("%.1f", student.getEnglish());
                default: return null;
            }
        }

        @Override
        public Class<?> getColumnClass(int c) {
            if (data.isEmpty()) {
                return Object.class;
            }
            return getValueAt(0, c).getClass();
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;  // 表格不可直接编辑
        }
    }
}