package 图书管理系统;

import javax.swing.*;
import java.util.ArrayList;

// GUI主入口：初始化数据并启动登录窗口
public class GUIApp {
    // 全局共享数据（与原有逻辑一致）
    public static ArrayList<User> userList = new ArrayList<>();
    public static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        // Swing必须在事件调度线程中启动，避免线程安全问题
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
}
