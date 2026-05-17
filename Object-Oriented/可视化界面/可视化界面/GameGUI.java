package 可视化界面;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {
    private Role1 r1;
    private Role1 r2;
    private JTextArea battleLog;
    private JTextArea role1Info;
    private JTextArea role2Info;
    private JButton startButton;
    private JButton nextButton;
    private BattlePanel battlePanel; // 火柴人战斗面板
    private boolean isGameStarted;

    public GameGUI() {
        // 1. 初始化角色与游戏状态
        r1 = new Role1("特朗普", 100, '男');
        r2 = new Role1("哈里斯", 100, '女');
        isGameStarted = false;

        // 2. 窗口基础设置（扩大窗口尺寸以容纳火柴人）
        setTitle("角色对战游戏（带火柴人动画）");
        setSize(900, 700); // 窗口扩大为900x700
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 窗口居中
        setLayout(new BorderLayout(10, 10)); // 各区域间距10px

        // 3. 顶部控制面板（不变）
        JPanel controlPanel = new JPanel();
        startButton = new JButton("开始游戏");
        nextButton = new JButton("下一步");
        nextButton.setEnabled(false);
        controlPanel.add(startButton);
        controlPanel.add(nextButton);
        add(controlPanel, BorderLayout.NORTH);

        // 4. 中间核心区域（拆分：上=角色信息，下=火柴人战斗）
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        
        // 4.1 角色信息面板（原infoPanel，缩小高度）
        JPanel infoPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        infoPanel.setPreferredSize(new Dimension(0, 150)); // 固定高度150，留出火柴人空间
        
        // 角色1信息
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(BorderFactory.createTitledBorder("【攻击者】" + r1.getName()));
        role1Info = new JTextArea();
        role1Info.setEditable(false);
        role1Info.setFont(new Font("SimHei", Font.PLAIN, 14));
        panel1.add(new JScrollPane(role1Info), BorderLayout.CENTER);
        
        // 角色2信息
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createTitledBorder("【防御者】" + r2.getName()));
        role2Info = new JTextArea();
        role2Info.setEditable(false);
        role2Info.setFont(new Font("SimHei", Font.PLAIN, 14));
        panel2.add(new JScrollPane(role2Info), BorderLayout.CENTER);
        
        infoPanel.add(panel1);
        infoPanel.add(panel2);
        centerPanel.add(infoPanel, BorderLayout.NORTH);

        // 4.2 火柴人战斗面板（新增，占中间主要空间）
        battlePanel = new BattlePanel();
        battlePanel.setBorder(BorderFactory.createTitledBorder("战斗场景"));
        centerPanel.add(battlePanel, BorderLayout.CENTER);
        
        add(centerPanel, BorderLayout.CENTER);

        // 5. 底部战斗日志（扩大区域）
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.setBorder(BorderFactory.createTitledBorder("战斗日志（滚动查看）"));
        battleLog = new JTextArea();
        battleLog.setEditable(false);
        battleLog.setFont(new Font("SimHei", Font.PLAIN, 14));
        battleLog.setRows(12); // 固定12行高度，比原来多5行
        // 日志面板优先垂直扩展
        logPanel.add(new JScrollPane(battleLog), BorderLayout.CENTER);
        add(logPanel, BorderLayout.SOUTH);

        // 6. 初始化显示
        updateRoleInfo();
        addButtonListeners();
    }

    // 按钮事件监听
    private void addButtonListeners() {
        startButton.addActionListener(e -> startGame());
        nextButton.addActionListener(e -> nextTurn());
    }

    // 开始游戏（重置状态）
    private void startGame() {
        r1 = new Role1("特朗普", 100, '男');
        r2 = new Role1("哈里斯", 100, '女');
        battleLog.setText("=== 新游戏开始 ===\n");
        battlePanel.reset(); // 重置火柴人状态
        updateRoleInfo();
        // 按钮状态切换
        startButton.setEnabled(false);
        nextButton.setEnabled(true);
        isGameStarted = true;
    }

    // 下一回合（攻击逻辑+动画触发）
    private void nextTurn() {
        if (!isGameStarted) return;

        // 1. 左角色（r1）攻击右角色（r2）→ 触发左火柴人动画
        battleLog.append("【" + r1.getName() + "的回合】\n");
        battleLog.append(r1.attack(r2));
        battlePanel.leftAttack(); // 左火柴人挥拳
        updateRoleInfo();
        // 检查右角色是否死亡
        if (r2.getBlood() == 0) {
            battleLog.append(r1.getName() + "击败了" + r2.getName() + "！\n");
            endGame();
            return;
        }

        // 2. 右角色（r2）攻击左角色（r1）→ 触发右火柴人动画
        battleLog.append("【" + r2.getName() + "的回合】\n");
        battleLog.append(r2.attack(r1));
        battlePanel.rightAttack(); // 右火柴人挥拳
        updateRoleInfo();
        // 检查左角色是否死亡
        if (r1.getBlood() == 0) {
            battleLog.append(r2.getName() + "击败了" + r1.getName() + "！\n");
            endGame();
        }

        // 日志滚动到最新内容
        battleLog.setCaretPosition(battleLog.getDocument().getLength());
    }

    // 游戏结束（重置按钮）
    private void endGame() {
        isGameStarted = false;
        nextButton.setEnabled(false);
        startButton.setEnabled(true);
        battleLog.append("=== 游戏结束 ===\n");
    }

    // 更新角色信息显示
    private void updateRoleInfo() {
        role1Info.setText(r1.getRoleInfo());
        role2Info.setText(r2.getRoleInfo());
    }

    // 自定义面板：绘制带动画的火柴人
    class BattlePanel extends JPanel {
        private boolean leftAttacking; // 左火柴人是否攻击
        private boolean rightAttacking; // 右火柴人是否攻击
        private double leftArmAngle; // 左火柴人手臂角度（弧度）
        private double rightArmAngle; // 右火柴人手臂角度（弧度）
        private Timer animTimer; // 动画定时器（控制帧）

        public BattlePanel() {
            // 初始状态：手臂垂直向下（角度0）
            leftArmAngle = 0;
            rightArmAngle = 0;
            leftAttacking = false;
            rightAttacking = false;

            // 动画定时器：50ms一帧（流畅度适中）
            animTimer = new Timer(50, e -> updateAnimation());
            animTimer.start(); // 持续运行，监听攻击状态
        }

        // 左火柴人攻击触发
        public void leftAttack() {
            leftAttacking = true;
        }

        // 右火柴人攻击触发
        public void rightAttack() {
            rightAttacking = true;
        }

        // 重置火柴人状态
        public void reset() {
            leftAttacking = false;
            rightAttacking = false;
            leftArmAngle = 0;
            rightArmAngle = 0;
            repaint();
        }

        // 动画更新（控制手臂角度变化）
        private void updateAnimation() {
            // 左火柴人攻击：手臂从0→-60度（向左挥拳）→恢复0度
            if (leftAttacking) {
                if (leftArmAngle > -Math.PI / 3) { // -60度（弧度）
                    leftArmAngle -= 0.1; // 每帧角度减小（挥拳）
                } else {
                    leftArmAngle += 0.1; // 角度恢复（收拳）
                    if (leftArmAngle >= 0) {
                        leftArmAngle = 0;
                        leftAttacking = false; // 攻击结束
                    }
                }
                repaint(); // 触发重绘
            }

            // 右火柴人攻击：手臂从0→60度（向右挥拳）→恢复0度
            if (rightAttacking) {
                if (rightArmAngle < Math.PI / 3) { // 60度（弧度）
                    rightArmAngle += 0.1; // 每帧角度增大（挥拳）
                } else {
                    rightArmAngle -= 0.1; // 角度恢复（收拳）
                    if (rightArmAngle <= 0) {
                        rightArmAngle = 0;
                        rightAttacking = false; // 攻击结束
                    }
                }
                repaint(); // 触发重绘
            }
        }

        // 绘制火柴人（核心方法）
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3)); // 线条加粗（更清晰）
            int panelWidth = getWidth();
            int panelHeight = getHeight();
            int stickManSize = 80; // 火柴人大小（统一缩放）

            // 1. 绘制左火柴人（对应r1）
            int leftX = panelWidth / 4; // 左火柴人x坐标（面板1/4处）
            int topY = panelHeight / 2; // 火柴人顶部y坐标（面板中间）
            drawStickMan(g2, leftX, topY, stickManSize, leftArmAngle, Color.BLUE);

            // 2. 绘制右火柴人（对应r2）
            int rightX = 3 * panelWidth / 4; // 右火柴人x坐标（面板3/4处）
            drawStickMan(g2, rightX, topY, stickManSize, rightArmAngle, Color.RED);

            // 3. 绘制中间分隔线（区分双方）
            g2.setColor(Color.LIGHT_GRAY);
            g2.drawLine(panelWidth / 2, topY - stickManSize, panelWidth / 2, topY + stickManSize);
        }

        // 绘制单个火柴人（通用方法）
        private void drawStickMan(Graphics2D g2, int x, int y, int size, double armAngle, Color color) {
            g2.setColor(color);
            int headRadius = size / 4; // 头部半径
            int bodyLength = size / 2; // 身体长度
            int limbLength = size / 3; // 手臂/腿长度

            // 1. 头部（圆形）
            g2.fillOval(x - headRadius, y - headRadius, 2 * headRadius, 2 * headRadius);

            // 2. 身体（竖直线）
            int bodyTopY = y + headRadius;
            int bodyBottomY = bodyTopY + bodyLength;
            g2.drawLine(x, bodyTopY, x, bodyBottomY);

            // 3. 手臂（根据角度绘制）
            // 左臂起点：身体顶部左侧
            int leftArmStartX = x - headRadius / 2;
            int leftArmStartY = bodyTopY + headRadius / 2;
            // 左臂终点：根据角度计算（x=起点x - 长度*sin(角度)，y=起点y + 长度*cos(角度)）
            int leftArmEndX = leftArmStartX - (int) (limbLength * Math.sin(armAngle));
            int leftArmEndY = leftArmStartY + (int) (limbLength * Math.cos(armAngle));
            g2.drawLine(leftArmStartX, leftArmStartY, leftArmEndX, leftArmEndY);

            // 右臂（对称，角度取反）
            int rightArmStartX = x + headRadius / 2;
            int rightArmStartY = bodyTopY + headRadius / 2;
            int rightArmEndX = rightArmStartX + (int) (limbLength * Math.sin(armAngle));
            int rightArmEndY = rightArmStartY + (int) (limbLength * Math.cos(armAngle));
            g2.drawLine(rightArmStartX, rightArmStartY, rightArmEndX, rightArmEndY);

            // 4. 腿（固定角度，向外张开）
            int legAngle = 15; // 腿张开角度（度）
            double legRad = Math.toRadians(legAngle);
            // 左腿终点
            int leftLegEndX = x - (int) (limbLength * Math.sin(legRad));
            int leftLegEndY = bodyBottomY + (int) (limbLength * Math.cos(legRad));
            // 右腿终点
            int rightLegEndX = x + (int) (limbLength * Math.sin(legRad));
            int rightLegEndY = bodyBottomY + (int) (limbLength * Math.cos(legRad));
            g2.drawLine(x, bodyBottomY, leftLegEndX, leftLegEndY);
            g2.drawLine(x, bodyBottomY, rightLegEndX, rightLegEndY);
        }
    }

    // 启动程序
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI().setVisible(true));
    }
}

    