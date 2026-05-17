首先必写的头文件 `javax.swing.* ;`

# 界面部分
**初始化界面部分**（`JFrame`）
  用来配置窗口的基础属性，确定敞口的外观，位置，关闭行为等，为后续添加菜单，图片提供容器基础
  实现步骤
```
    JFrame jFrame=new JFrame();
    this.setSize(105,150);
    this.setTitle("CS.GO");
    this.setAlwaysOnTop(true);
    this.setLocationRelativeTo(null)
    this.setDefaultCloseOperation(3);
    this.setLayout(null);
    this.setVisible(true);
```
    可实现继承 public class XXX extends JFrame(){} 这个时候就不用再单独创建对象了 

| 常使用代码                             | 作用说明                                  |
| --------------------------------- | ------------------------------------- |
| this.setSize(a,b);                | 设置窗口宽高（宽a，高b）                         |
| this.setTitle("XXX");             | 设置窗口标题，显示在窗口顶部标题栏                     |
| this.setAlwaysOnTop(true);        | 让窗口始终置顶，避免被其他窗口遮拦                     |
| this.setLocationRelativeTo(null)  | 让窗口在屏幕居中显示                            |
| this.setDefaultCloseOperation(3); | 设置窗口关闭模式（一般有1，2，3），3对应直接关闭窗口时直接退出整个程序 |
| this.setLayout(null);             | 禁用Swing默认布局管理器，便于后续手动指定位置和大小          |
| this.setVisible(true);            | 显示界面                                  |

# 菜单部分
**初始化菜单**（`JMenuBar`）
  创建窗口的菜单系统（顶部菜单栏），提供“重新开始”“重新登录”等功能入口，属于`Swing`交互组件的组装
  `JMenuBar`（菜单条）->`JMenu`（一级菜单）->`JMenuItem`（具体菜单项），需按从外到内的顺序组装
  实现步骤
```
    1.创建菜单条（作为所有菜单的顶层容器，后续通过this.setJMenuBar(jMenuBar)绑定到窗口）
    JMenuBar jMenuBar=new JMenuBar();
    2.创建一级菜单（定义菜单的一级分类，点击可展开下拉菜单项）
    JMenu functionMenu=new JMenu("功能");
    JMenu aboutMenu=new JMenu("关于");
    3.创建菜单项（定义具体的交互选项，点即可触发对应功能）
    JMenuItem replayItem=new JMenuItem("Replay");
    JMenuItem reLoginItem=new JMenuItem("ReLogin");
    JMenuItem closeItem=new JMenuItem("Close");
    JMenuItem accountItem=new JMenuItem("Us");
    
    functionMenu.add(replayItem);
    functionMenu.add(reLoginItem);
    functionMenu.add(closeItem);
    aboutMenu.add(accountItem);
    
    jMenuBar.add(functionMenu);
    jMenuBar.add(aboutMenu);
    
    this.setJMenuBar(jMenuBar);
```

# 图片导入部分
**初始化图片** （`Image`）
  实现对图像的排列，加载到窗口等功能
  实现步骤
```
    1.创建图片对象（需指定图片的存放路径）
    ImageIcon icon=new ImageIcon("D:\\...\\...\\1.jpg");
    2.创建标签（JLabel是Swing中承载图片的组件）
    JLabel jLabel=new JLabel(icon);
    3.手动指定标签位置和大小
    jLabel.setBounds(0,0,105,105); //bounds参数：x坐标,y坐标,宽,高  默认界面左上角为坐标原点
    4.将标签添加到窗口的内容面板
    this.getContentPane().add(jLabel);
```

# 事件部分
`Swing`中的事件处理是组件与用户交互的核心机制通过”监听器（`Listener`）“实现：当用户对组件执行操作时，会触发对应的”事件（`Event`）“，监听器捕获事件后执行预设逻辑
注：创建`Button`时切记要绑定按钮事件

**ActionListener**（动作事件监听器）
  处理”动作事件“（如按钮点击）
  核心接口与方法
    接口：`java.awt.event.ActionListener`
    必须重写的方法：`void actionPerformed(ActionEvent e)` 
  实现步骤
   1. 实现接口
```
    public class jFrame extends JFrame implements ActionListener{...}
```
   2. 重写事件处理方法
```
    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==j1){...} //j1被点击
        else if(source==j2){...} //j2被点击
    }
```
   3. 绑定监听器到事件源
```
    j1.addActionListener(this); //j1的点击事件由当前类处理
    j2.addActionListener(this); //j2的点击事件由当前类处理
```

**MouseListener**（鼠标事件监听器）
  处理与鼠标相关的事件（如鼠标单击，按下，释放，进入组件，离开组件）
  核心接口与方法
    接口：`java.awt.event.Mouselistener`
    必须重写的五个方法

| 方法名                         | 触发时机        |
| --------------------------- | ----------- |
| mouseClicked(MouseEvent e)  | 鼠标单击（按下并释放） |
| mousePressed(MouseEvent e)  | 鼠标按下（未释放）   |
| mouseReleased(MouseEvent e) | 鼠标释放（按下后抬起） |
| mouseEntered(MouseEvent e)  | 鼠标指针进入组件    |
| mouseExited(MouseEvent e)   | 鼠标指针离开组件    |

  实现步骤
   1. 实现接口
```
    public class jFrame extends JFrame implements MouseListener{...}
```
   2. 重写事件方法
```
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("单击");
    }
    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("按下");
    }
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("释放");
    }
    @Override
    public void mouseEntered(MouseEvent e){
        System.out.println("进入");
    }
    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("退出");
    }
```
   3. 绑定监听器到事件源
```
    j.addMouseListener(this);
    或者
    this.addMouselistener(this);
```

**Keylistener**（键盘事件监听器）
  处理与键盘相关的事件（如按键按下，松开，输入字符）
  核心接口与方法
    接口：`java.awt.event.KeyListener`
    必须重写的三个方法

| 方法名                     | 触发时机                     |
| ----------------------- | ------------------------ |
| keyTyped(KeyEvent e)    | 按键按下并释放（产生字符输入，如输入字母/数字） |
| keyPressed(KeyEvent e)  | 按键按下                     |
| keyReleased(KeyEvent e) | 按键松开                     |

  实现步骤
   1. 实现接口
```
    public class jFrame extends JFrame implements KeyListener{...}
```
   2. 重写事件方法
```
    @Override
    public void keyTyped(KeyEvent e){
  
    }
    //注：如果一直按着某键，会重复触发keyPressed方法
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println("按下按键");
    }
    @Override
    public void keyReleased(KeyEvent e){
        System.out.println("松开按键");
        int code=e.getKeyCode(); //获取按键
        System.out.println(code);
    }
```
   3. 绑定监听器到事件源
``` 
    //调用者this：当前的界面对象，表示要给整个界面添加键盘监听
    //addKeyListener：表示要给本界面添加键盘监听
    //参数this：表示当事件被触发后，会执行本类中的对应代码
    this.addKeylistener(this);
```

# 创建文本，创建弹框，创建按钮部分
一 、创建文本相关组件
  在`Swing`中，常用文本组件包括`JTextField`（文本输入框）和`JLabel`（文本/图片显示标签），分别用于就收用户输入和展示静态内容
  1. `JTextField`——接收用户输入
   核心作用：允许用户输入单行文本
   实现步骤
```
    1.声明为类的成员变量
    private JTextField XXX;
    2.实例化并设置属性
    XXX=new JTextField(); //创建输入框对象
    XXX.setBounds(12,34,56,78);
    this.getContentPane().add(XXX);
```
   常用方法
    `getText()`：获取输入框中的文本
    `setText()`：设置输入框默认文本
    `setBouns(x,y,width,height)`：设置位置和大小
    `setColumns(n)`：设置输入框宽度
   注意事项
    若需在事件监听（如登录按钮点击）中获取输入值，必须将`JTextField`声明为类的成员变量
    密码输入框建议使用`JPasswordField`（输入内容会被隐藏）
  2. `JLabel`——显示静态文本/图片
   核心作用：展示静态文本或图片，不支持用户输入
   实现步骤
    具体详见`D:\java\FreeExercises\Puzzle\UI`
二、创建弹框——显示提示信息
  `JDialog`是`Swing`中的弹窗组件，常用于显示提示，警告或交互信息，可阻塞父窗口操作
  核心作用：显示临时提示信息，支持“模糊”
  实现步骤
```
    private void showJDialog(String content){
        //创建JDialog对象
        JDialog jDialog=new JDialog();
        //设置弹框基本属性
        ...
        jDialog.setModal(true); //弹窗未关闭时，父窗口不可操作
        //添加内容
        JLabel jLabel=new JLabel(content); //创建显示文本的标签
        jLabel.setBounds(0,0,200,250);
        jDialog.getContentPane().add(jLabel);
        //显示弹窗
        jDialog.setVisible(true);
    }
```
三、创建按钮——点击交互
  `JButton`是`Swing`中用于响应用户点击操作的交互组件
  核心作用：接收点击事件，触发预设逻辑，展示按钮功能
  实现步骤
```
    1.成员位置申明
    private JButton XXX;
    2.实例化按钮
    XXX=new JButton();
    XXX.setBounds(x,y,width,height);
    3.设置按钮图片
    ImageIcon XXXImage=new ImageIcon("D:\\..");
    XXX.setIcon(XXXImage);
    4.美化按钮
    XXX.setBorderPainted(false); //去除按钮边框
    XXX.setContentAreaFilled(false); //去除按钮背景
    5.绑定事件监听器（MouseListener,KeyListener,ActionListener）
    XXX.addXXXListener(this);
    this.getContentPane().add(XXX);
```