package 综合案例1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// 角色类保持不变
class Role {
    private String name;
    private int blood;
    
    public Role(){}
    
    public Role(String name,int blood){
        this.name = name;
        this.blood = blood;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getBlood(){
        return blood;
    }
    
    public void setBlood(int blood){
        this.blood = blood;
    }
    
    // 攻击方法，返回攻击信息
    public String attack(Role r){
        Random r1 = new Random();
        int damage = r1.nextInt(20) + 1;
        int remain = r.getBlood() - damage;
        remain = remain < 0 ? 0 : remain;
        r.setBlood(remain);
        
        return this.getName() + "攻击了" + r.getName() + ",造成了" + damage + "点伤害" + 
               "，" + r.getName() + "剩余" + r.getBlood() + "点血量";
    }
}

// 可视化界面类
public class RoleBattleGUI extends JFrame {
    private Role role1;
    private Role role2;
    
    // UI组件
    private JProgressBar bloodBar1;
    private JProgressBar bloodBar2;
    private JTextArea battleLog;
    private JButton startButton;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel bloodLabel1;
    private JLabel bloodLabel2;
    
    public RoleBattleGUI() {
        // 初始化角色
        role1 = new Role("高音哥", 100);
        role2 = new Role("波澜哥", 100);
        
        // 初始化UI
        initUI();
        
        // 设置窗口属性
        setTitle("角色对战游戏");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示
        setResizable(false);
    }
    
    private void initUI() {
        // 主面板
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // 角色信息面板
        JPanel rolesPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // 角色1信息
        JPanel role1Panel = new JPanel(new BorderLayout(10, 5));
        nameLabel1 = new JLabel(role1.getName());
        nameLabel1.setFont(new Font("宋体", Font.BOLD, 16));
        bloodLabel1 = new JLabel("血量: 100/100");
        
        bloodBar1 = new JProgressBar(0, 100);
        bloodBar1.setValue(100);
        bloodBar1.setStringPainted(false);
        bloodBar1.setBackground(Color.RED);
        bloodBar1.setForeground(Color.GREEN);
        
        role1Panel.add(nameLabel1, BorderLayout.WEST);
        role1Panel.add(bloodLabel1, BorderLayout.EAST);
        role1Panel.add(bloodBar1, BorderLayout.SOUTH);
        
        // 角色2信息
        JPanel role2Panel = new JPanel(new BorderLayout(10, 5));
        nameLabel2 = new JLabel(role2.getName());
        nameLabel2.setFont(new Font("宋体", Font.BOLD, 16));
        bloodLabel2 = new JLabel("血量: 100/100");
        
        bloodBar2 = new JProgressBar(0, 100);
        bloodBar2.setValue(100);
        bloodBar2.setStringPainted(false);
        bloodBar2.setBackground(Color.RED);
        bloodBar2.setForeground(Color.GREEN);
        
        role2Panel.add(nameLabel2, BorderLayout.WEST);
        role2Panel.add(bloodLabel2, BorderLayout.EAST);
        role2Panel.add(bloodBar2, BorderLayout.SOUTH);
        
        rolesPanel.add(role1Panel);
        rolesPanel.add(role2Panel);
        
        // 战斗日志区域
        JPanel logPanel = new JPanel(new BorderLayout());
        JLabel logLabel = new JLabel("战斗日志");
        logLabel.setFont(new Font("宋体", Font.BOLD, 14));
        
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(battleLog);
        
        logPanel.add(logLabel, BorderLayout.NORTH);
        logPanel.add(scrollPane, BorderLayout.CENTER);
        
        // 按钮面板
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("开始战斗");
        startButton.setFont(new Font("宋体", Font.PLAIN, 14));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startBattle();
            }
        });
        buttonPanel.add(startButton);
        
        // 组装主面板
        mainPanel.add(rolesPanel, BorderLayout.NORTH);
        mainPanel.add(logPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    // 开始战斗
    private void startBattle() {
        // 禁用按钮防止重复点击
        startButton.setEnabled(false);
        // 清空日志
        battleLog.setText("");
        
        // 重置角色状态
        role1.setBlood(100);
        role2.setBlood(100);
        updateBloodUI();
        
        // 开启新线程执行战斗逻辑，避免UI卡顿
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 角色1攻击角色2
                    String log1 = role1.attack(role2);
                    addToLog(log1);
                    updateBloodUI();
                    
                    // 检查是否有角色死亡
                    if (role2.getBlood() == 0) {
                        addToLog(role1.getName() + "击败了" + role2.getName() + "，战斗结束！");
                        break;
                    }
                    
                    // 延迟一下，让战斗过程看得清楚
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    
                    // 角色2攻击角色1
                    String log2 = role2.attack(role1);
                    addToLog(log2);
                    updateBloodUI();
                    
                    if (role1.getBlood() == 0) {
                        addToLog(role2.getName() + "击败了" + role1.getName() + "，战斗结束！");
                        break;
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                // 战斗结束后重新启用按钮
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        startButton.setEnabled(true);
                        startButton.setText("重新开始");
                    }
                });
            }
        }).start();
    }
    
    // 更新血量显示
    private void updateBloodUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                bloodBar1.setValue(role1.getBlood());
                bloodBar2.setValue(role2.getBlood());
                bloodLabel1.setText("血量: " + role1.getBlood() + "/100");
                bloodLabel2.setText("血量: " + role2.getBlood() + "/100");
                
                // 根据血量改变颜色
                if (role1.getBlood() < 30) {
                    bloodBar1.setForeground(Color.RED);
                } else {
                    bloodBar1.setForeground(Color.GREEN);
                }
                
                if (role2.getBlood() < 30) {
                    bloodBar2.setForeground(Color.RED);
                } else {
                    bloodBar2.setForeground(Color.GREEN);
                }
            }
        });
    }
    
    // 添加日志到文本区域
    private void addToLog(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                battleLog.append(text + "\n");
                // 自动滚动到最后一行
                battleLog.setCaretPosition(battleLog.getDocument().getLength());
            }
        });
    }
    
    public static void main(String[] args) {
        // 在事件调度线程中启动UI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoleBattleGUI().setVisible(true);
            }
        });
    }
}
    