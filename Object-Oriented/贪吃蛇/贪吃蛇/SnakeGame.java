package 贪吃蛇;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame {
    // 游戏面板
    private GamePanel gamePanel;
    
    public SnakeGame() {
        // 设置窗口标题
        super("贪吃蛇游戏");
        
        // 创建游戏面板
        gamePanel = new GamePanel();
        
        // 添加面板到窗口
        add(gamePanel);
        
        // 设置窗口大小
        pack();
        
        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 窗口居中显示
        setLocationRelativeTo(null);
        
        // 窗口不可调整大小
        setResizable(false);
        
        // 显示窗口
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // 在事件调度线程中创建并显示GUI
        SwingUtilities.invokeLater(SnakeGame::new);
    }
    
    // 游戏面板类，负责绘制游戏元素和处理游戏逻辑
    class GamePanel extends JPanel implements ActionListener, KeyListener {
        // 游戏区域大小
        private final int WIDTH = 800;
        private final int HEIGHT = 600;
        // 每个格子的大小
        private final int UNIT_SIZE = 20;
        // 格子数量
        private final int GAME_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        // 游戏速度（毫秒）
        private final int DELAY = 100;
        
        // 蛇的身体坐标
        private final ArrayList<Integer> x = new ArrayList<>();
        private final ArrayList<Integer> y = new ArrayList<>();
        
        // 食物坐标
        private int foodX;
        private int foodY;
        
        // 蛇的移动方向
        private char direction = 'R'; // 初始向右
        private boolean running = false;
        
        // 计时器，控制游戏循环
        private Timer timer;
        // 随机数生成器，用于生成食物位置
        private Random random;
        
        // 分数
        private int score;
        
        public GamePanel() {
            random = new Random();
            // 设置面板大小
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            // 设置背景颜色
            setBackground(Color.BLACK);
            // 允许获得焦点，以接收键盘事件
            setFocusable(true);
            // 添加键盘监听器
            addKeyListener(this);
            
            // 初始化游戏
            startGame();
        }
        
        // 初始化游戏
        public void startGame() {
            // 重置蛇的位置和长度
            x.clear();
            y.clear();
            x.add(0);
            y.add(0);
            
            // 生成初始食物
            generateFood();
            
            // 重置分数
            score = 0;
            
            // 设置游戏状态为运行中
            running = true;
            
            // 启动计时器
            timer = new Timer(DELAY, this);
            timer.start();
        }
        
        // 绘制游戏元素
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }
        
        // 绘制方法
        public void draw(Graphics g) {
            if (running) {
                // 绘制食物
                g.setColor(Color.RED);
                g.fillOval(foodX, foodY, UNIT_SIZE, UNIT_SIZE);
                
                // 绘制蛇
                for (int i = 0; i < x.size(); i++) {
                    // 蛇头颜色不同
                    if (i == 0) {
                        g.setColor(Color.GREEN);
                    } else {
                        g.setColor(new Color(45, 180, 0));
                    }
                    g.fillRect(x.get(i), y.get(i), UNIT_SIZE, UNIT_SIZE);
                }
                
                // 绘制分数
                g.setColor(Color.WHITE);
                g.setFont(new Font("Ink Free", Font.BOLD, 40));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("分数: " + score, (WIDTH - metrics.stringWidth("分数: " + score)) / 2, g.getFont().getSize());
            } else {
                // 游戏结束画面
                gameOver(g);
            }
        }
        
        // 生成食物
        public void generateFood() {
            // 随机生成食物位置，确保食物落在格子上
            foodX = random.nextInt((int) (WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            foodY = random.nextInt((int) (HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
            
            // 确保食物不会出现在蛇身上
            for (int i = 0; i < x.size(); i++) {
                if (x.get(i) == foodX && y.get(i) == foodY) {
                    generateFood();
                    break;
                }
            }
        }
        
        // 移动蛇
        public void move() {
            // 移动身体部分，后面的部分跟随前面的部分
            for (int i = x.size() - 1; i > 0; i--) {
                x.set(i, x.get(i - 1));
                y.set(i, y.get(i - 1));
            }
            
            // 根据方向移动蛇头
            switch (direction) {
                case 'U':
                    y.set(0, y.get(0) - UNIT_SIZE);
                    break;
                case 'D':
                    y.set(0, y.get(0) + UNIT_SIZE);
                    break;
                case 'L':
                    x.set(0, x.get(0) - UNIT_SIZE);
                    break;
                case 'R':
                    x.set(0, x.get(0) + UNIT_SIZE);
                    break;
            }
        }
        
        // 检查是否吃到食物
        public void checkFood() {
            if (x.get(0) == foodX && y.get(0) == foodY) {
                // 增加蛇的长度
                x.add(x.get(x.size() - 1));
                y.add(y.get(y.size() - 1));
                
                // 生成新的食物
                generateFood();
                
                // 增加分数
                score += 10;
                
                // 随着分数增加，提高游戏速度
                if (score % 50 == 0 && DELAY > 50) {
                    timer.setDelay(DELAY - 10);
                }
            }
        }
        
        // 检查碰撞
        public void checkCollisions() {
            // 检查是否撞到自己的身体
            for (int i = 1; i < x.size(); i++) {
                if (x.get(0) == x.get(i) && y.get(0) == y.get(i)) {
                    running = false;
                    break;
                }
            }
            
            // 检查是否撞到左边界
            if (x.get(0) < 0) {
                running = false;
            }
            
            // 检查是否撞到右边界
            if (x.get(0) >= WIDTH) {
                running = false;
            }
            
            // 检查是否撞到上边界
            if (y.get(0) < 0) {
                running = false;
            }
            
            // 检查是否撞到下边界
            if (y.get(0) >= HEIGHT) {
                running = false;
            }
            
            // 如果游戏结束，停止计时器
            if (!running) {
                timer.stop();
            }
        }
        
        // 游戏结束画面
        public void gameOver(Graphics g) {
            // 显示分数
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("分数: " + score, (WIDTH - metrics1.stringWidth("分数: " + score)) / 2, g.getFont().getSize());
            
            // 显示游戏结束文字
            g.setColor(Color.RED);
            g.setFont(new Font("Ink Free", Font.BOLD, 75));
            FontMetrics metrics2 = getFontMetrics(g.getFont());
            g.drawString("游戏结束", (WIDTH - metrics2.stringWidth("游戏结束")) / 2, HEIGHT / 2);
            
            // 显示重新开始提示
            g.setColor(Color.WHITE);
            g.setFont(new Font("Ink Free", Font.BOLD, 30));
            FontMetrics metrics3 = getFontMetrics(g.getFont());
            g.drawString("按R键重新开始", (WIDTH - metrics3.stringWidth("按R键重新开始")) / 2, HEIGHT / 2 + 50);
        }
        
        // 游戏循环
        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkFood();
                checkCollisions();
            }
            // 重绘界面
            repaint();
        }
        
        // 处理键盘按键按下事件
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_R:
                    if (!running) {
                        startGame();
                    }
                    break;
            }
        }
        
        // 未使用的键盘事件方法
        @Override
        public void keyReleased(KeyEvent e) {}
        
        @Override
        public void keyTyped(KeyEvent e) {}
    }
}

