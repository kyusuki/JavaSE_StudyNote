package UI;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.net.URL;
public class GameJFrame extends JFrame implements KeyListener,ActionListener{
    //记录图片位置
    int[][] arr2=new int[4][4];
    //记录正确数组
    int[][] win=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    //记录空格位置
    int x=0,y=0;
    //记录路径
    String path="image/animal/animal1/";
    //记录步数
    int step=0;
    //创建功能菜单条目（放在成员位置，便于后期直接使用）
    JMenuItem replayItem=new JMenuItem("重新开始");
    JMenuItem reLoginItem=new JMenuItem("重新登录");
    JMenuItem closeItem=new JMenuItem("关闭游戏");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem girl=new JMenuItem("美女");
    JMenuItem sport=new JMenuItem("运动");
    JMenuItem man=new JMenuItem("诗人");
    JMenuItem accountItem=new JMenuItem("公众号");
    public GameJFrame(){
        //初始化界面
        initJFrame();
        
        //初始化菜单
        initJMenuBar();
        
        //初始化数据
        initDate();
        
        //初始化图片
        initImage();

        this.setVisible(true);
    }
    private void initJFrame(){
        //设置界面宽高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图游戏 V1.0");
        //设置界面置上
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //取消默认居中
        this.setLayout(null);
        //添加键盘监听事件
        this.addKeyListener(this);
    }
    private void initJMenuBar(){
        //创建整个菜单对象
        JMenuBar jMenuBar=new JMenuBar();
        //创建功能菜单
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");
        JMenu changeJMenu=new JMenu("更换图片");
        //添加到选项中去
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        changeJMenu.add(animal);
        changeJMenu.add(girl);
        changeJMenu.add(sport);
        changeJMenu.add(man);
        functionJMenu.add(changeJMenu);
        aboutJMenu.add(accountItem);
        //给条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        animal.addActionListener(this);
        girl.addActionListener(this);
        sport.addActionListener(this);
        man.addActionListener(this);
        //添加到菜单去
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //设置菜单
        this.setJMenuBar(jMenuBar);
    }
    private void initDate(){
        Random r=new Random();
        int[] arr1={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        for(int i=0;i<arr1.length;i++){
            int index=r.nextInt(arr1.length);
            int temp=arr1[i];
            arr1[i]=arr1[index];
            arr1[index]=temp;
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(arr1[4*i+j]==0){
                    x=i;
                    y=j;
                }
                arr2[i][j]=arr1[4*i+j]; //不放在else里面，否则0不会赋值
            }
        }
    }
    private void initImage(){
        /*
        //创建一个图片ImageIcon对象
        ImageIcon icon=new ImageIcon("D:\\java\\FreeExercises\\Puzzle\\image\\girl\\girl1\\10.jpg");
        //创建一个JLabel对象（管理容器）
        JLabel jLabel=new JLabel(icon);
        //指定图片位置
        jLabel.setBounds(0,0,105,105);
        //将管理容器添加到界面中
        //this.add(JLabel);
        this.getContentPane().add(jLabel);
        */
        //先加载图片在上方，后加载图片在下方

        //先移除所有组件
        this.getContentPane().removeAll();

        JLabel backgroundLabel=new JLabel(loadIcon("image/background.png"));
        backgroundLabel.setBounds(40,40,508,560);
        this.getContentPane().add(backgroundLabel);

        if(isVictor()){
            //显示胜利图标
            ImageIcon winImage=loadIcon("image/win.png");
            JLabel winjLabel=new JLabel(winImage);
            winjLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winjLabel);
        }
        //显示步数
        JLabel stepjLabel=new JLabel("步数："+step);
        stepjLabel.setBounds(50,30,100,20);
        this.getContentPane().add(stepjLabel);
        //加载图片
        int number=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                number=arr2[i][j];
                //创建一个图片ImageIcon对象
                ImageIcon icon=loadIcon(path+number+".jpg");
                //创建一个JLabel对象（管理容器）
                JLabel jLabel=new JLabel(icon);
                //指定图片位置
                jLabel.setBounds(j*105+83,i*105+134,105,105);
                //给图片添加边框
                //传递值 0：让图片凸起来
                //传递值 1：让图片凹下去
                //创建一个边框对象
                BevelBorder b=new BevelBorder(1);
                //设置边框
                jLabel.setBorder(b); //或者jLabel.setBorder(new BevelBorder(0));
                //将管理容器添加到界面中
                this.getContentPane().add(jLabel); 
            }
        }

        this.getContentPane().setComponentZOrder(backgroundLabel,this.getContentPane().getComponentCount()-1);
        //刷新界面
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    @Override
    public void keyTyped(KeyEvent e){

    }
    //按下不松会重复调用
    @Override
    public void keyPressed(KeyEvent e){
        int code=e.getKeyCode();
        if(code==65){
            //移除所有组件
            this.getContentPane().removeAll();

            JLabel backgroundLabel=new JLabel(loadIcon("image/background.png"));
            backgroundLabel.setBounds(40,40,508,560);
            this.getContentPane().add(backgroundLabel);

            //加载完整图片
            ImageIcon all=loadIcon(path+"all.jpg");
            JLabel jLabel=new JLabel(all);
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);

            this.getContentPane().setComponentZOrder(backgroundLabel,this.getContentPane().getComponentCount()-1);
            //刷新界面
            this.getContentPane().revalidate();
            this.getContentPane().repaint();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        //胜利后不在响应按键
        if(isVictor()){
            return;
        }
        //上：38 下：40 左：37 右：39
        int code=e.getKeyCode();
        if(code==37){
            //边界判断
            if(y==3){
                return;
            }
            //交换左右
            arr2[x][y]=arr2[x][y+1];
            arr2[x][y+1]=0;
            //更新空格位置
            y++;
            //步数加一
            step++;
            //更新图片位置
            initImage();
        }
        else if(code==38){
            //边界判断
            if(x==3){
                return;
            }
            //交换上下
            arr2[x][y]=arr2[x+1][y];
            arr2[x+1][y]=0;
            //更新空格位置
            x++;
            //步数加一
            step++;
            //更新图片位置
            initImage();
        }
        else if(code==39){
            //边界判断
            if(y==0){
                return;
            }
            //交换右左
            arr2[x][y]=arr2[x][y-1];
            arr2[x][y-1]=0;
            //更新空格位置
            y--;
            //步数加一
            step++;
            //更新图片位置
            initImage();
        }
        else if(code==40){
            //边界判断
            if(x==0){
                return;
            }
            //交换下上
            arr2[x][y]=arr2[x-1][y];
            arr2[x-1][y]=0;
            //更新空格位置
            x--;
            //步数加一
            step++;
            //更新图片位置
            initImage();
        }
        else if(code==65){
            //松开后重新调用，恢复原状态
            initImage();
        }
        else if(code==87){
            arr2=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
            initImage();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==replayItem){ //注意顺序
            //重计步数
            step=0;
            //重新初始化数据
            initDate();
            //重新加载图片
            initImage();
        }
        else if(obj==reLoginItem){
            //关闭当前游戏界面
            this.dispose();
            //弹出登录界面
            new LoginJFrame();
        }
        else if(obj==closeItem){
            System.exit(0);
        }
        else if(obj==animal){
            Random r=new Random();
            int index=r.nextInt(8)+1;
            path="image/animal/animal"+index+"/";
            //重计步数
            step=0;
            //重新初始化数据
            initDate();
            //重新加载图片
            initImage();
        }
        else if(obj==girl){
            Random r=new Random();
            int index=r.nextInt(11)+1;
            path="image/girl/girl"+index+"/";
            //重计步数
            step=0;
            //重新初始化数据
            initDate();
            //重新加载图片
            initImage();
        }
        else if(obj==man){
            Random r=new Random();
            int index=r.nextInt(10)+1;
            path="image/man/man"+index+"/";
            //重计步数
            step=0;
            //重新初始化数据
            initDate();
            //重新加载图片
            initImage();
        }
        else if(obj==sport){
            Random r=new Random();
            int index=r.nextInt(10)+1;
            path="image/sport/sport"+index+"/";
            //重计步数
            step=0;
            //重新初始化数据
            initDate();
            //重新加载图片
            initImage();
        }
        else if(obj==accountItem){
            //创建一个弹窗对象
            JDialog jDialog=new JDialog();
            //创建图片对象
            ImageIcon image=loadIcon("image/about.png");
            //创建图图片的管理容器
            JLabel jLabel=new JLabel(image);
            //设置位置宽高
            jLabel.setBounds(0,0,576,576);
            //设置图片到弹窗上
            jDialog.getContentPane().add(jLabel);
            //设置弹窗宽高
            jDialog.setSize(344,344);
            //永在顶部
            jDialog.setAlwaysOnTop(true);
            //设置居中
            jDialog.setLocationRelativeTo(null);
            //设置为模态对话框，阻塞下面（弹窗不关闭则无法操作下面界面）
            jDialog.setModal(true); 
            //弹窗显示
            jDialog.setVisible(true);
        }
    }

    private ImageIcon loadIcon(String relativePath){
        URL url=getClass().getResource("/Puzzle/"+relativePath);
        if(url!=null){
            return new ImageIcon(url);
        }
        return new ImageIcon("Puzzle/"+relativePath);
    }

    //判断arr2是否与win相同
    public boolean isVictor(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(!(arr2[i][j]==win[i][j])){
                    return false;
                }
            }
        }
        return true;
    }
}
