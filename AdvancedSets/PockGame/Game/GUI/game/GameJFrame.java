package PockGame.Game.GUI.game;

import PockGame.Game.GUI.Information.Pock;

import java.awt.Point;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameJFrame extends JFrame implements ActionListener{
    /*
     * 四个集合，分别存放牌盒，底牌，玩家手中的牌，玩家打出的牌
     * 注：玩家手中的牌和玩家打出的牌用嵌套集合，就是用一个大集合存放三个小集合
     * 游戏提示，一个JLabel对象
     * 两个数组，分别存放是否抢地主，是否出牌
     */
    ArrayList<Pock> pockList=new ArrayList<>(); //牌盒
    ArrayList<Pock> lordList=new ArrayList<>(); //底牌
    ArrayList<ArrayList<Pock>> playerList=new ArrayList<>(); //玩家手中的牌
    ArrayList<ArrayList<Pock>> currentList=new ArrayList<>(); //玩家打出的牌
    JButton[] landLord=new JButton[2]; //两个抢地主按钮，一个抢地主，一个不抢
    JButton[] publishCard=new JButton[2]; //两个出牌按钮，一个出牌，一个不要
    JTextField[] time=new JTextField[3]; //三个记录时间的文本框
    JLabel dizhu; //提前声明一个地主标签

    public GameJFrame(){
        //设置任务栏图标
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java\\AdvancedSets\\PockGame\\image\\poker\\dizhu.png"));
        //设置界面
        initJFrame();
        //设置组件
        initView();
        //界面显示
        this.setVisible(true);

        /*
         * 初始化牌
         * 准备牌，洗牌，发牌，排序
         */
        initCard();
        
        /*
         * 开始游戏的准备
         * 抢地主与不抢按钮，再创建三个集合存放准备要出的牌
         */
        initGame();
    }
    
    public void initCard(){
        for(int i=0;i<3;i++){
            playerList.add(new ArrayList<Pock>());
        }
        String[] color={"1","2","3","4"};
        String[] number={"1","2","3","4","5","6","7","8","9","10","11","12","13"};
        for(String c:color){
            for(String n:number){
                Pock p=new Pock(c+"-"+n,false);
                p.setLocation(350,150);
                pockList.add(p);
                this.getContentPane().add(p);
            }
        }
        Pock p1=new Pock("5-1",false);
        p1.setLocation(350,150);
        pockList.add(p1);
        this.getContentPane().add(p1);
        Pock p2=new Pock("5-2",false);
        p2.setLocation(350,150);
        pockList.add(p2);
        this.getContentPane().add(p2);

        PokeGame();
    }
    //洗发看
    public void PokeGame(){
        //洗牌
        Collections.shuffle(pockList);
        //发牌
        for(int i=0;i<pockList.size();i++){
            Pock p=pockList.get(i);
            if(i<3){
                lordList.add(p);
                common.move(p,p.getLocation(),new Point(270+(75*i),10));
                continue;
            }
            else if(i%3==0){
                common.move(p,p.getLocation(),new Point(50,60+i*5));
                playerList.get(0).add(p);
            }
            else if(i%3==1){
                common.move(p,p.getLocation(),new Point(100+i*7,450));
                playerList.get(1).add(p);
                p.turnFront();
            }
            else if(i%3==2){
                common.move(p,p.getLocation(),new Point(700,60+i*5));
                playerList.get(2).add(p);
            }
            this.setComponentZOrder(p, 0);
        }
        //排序
        for(int i=0;i<3;i++){
            sortPock(playerList.get(i));
            common.rePosition(this,playerList.get(i),i);
        }
    }
    //排序
    public void sortPock(ArrayList<Pock> pockList){
        //先比较数值，再比较花色
        Collections.sort(pockList,new Comparator<Pock>() {
            @Override
            public int compare(Pock o1,Pock o2){
                //花色
                int temp1=Integer.parseInt(o1.getSuit().substring(0,1));
                int temp2=Integer.parseInt(o2.getSuit().substring(0,1));
                //数值
                int temp3=Integer.parseInt(o1.getSuit().substring(2));
                int temp4=Integer.parseInt(o2.getSuit().substring(2));
                if(temp1==5){
                    temp3=50;
                }
                if(temp2==5){
                    temp4=50;
                }
                int result=temp3-temp4;
                if(result==0){
                    result=temp1-temp2;
                    return result;
                }
                return result;
            } 
        });
    }

    private void initGame(){
        //用三个集合存放三个玩家准备要出的牌
        for(int i=0;i<3;i++){
            ArrayList<Pock> current=new ArrayList<>();
            currentList.add(current);
        }
        //展示抢地主还是不抢按钮
        landLord[0].setVisible(true);
        landLord[1].setVisible(true);
        //展示倒计时
        for(JTextField t:time){
            t.setText("倒计时30秒");
            t.setVisible(true);
        }
    }

    //初始化界面
    public void initJFrame(){
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(3);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认的居中放置
        this.setLayout(null);
        //设置背景颜色
        this.setBackground(Color.LIGHT_GRAY);
    }

    //添加组件
    public void initView(){
        //创建抢地主按钮，并存入landLord数组中
        JButton robBut=new JButton("抢地主");
        robBut.setBounds(320,400,75,20);
        robBut.addActionListener(this);
        robBut.setVisible(false);
        landLord[0]=robBut;
        this.getContentPane().add(robBut);
        //创建不抢地主按钮，并存入landLord数组中
        JButton notRobBut=new JButton("不抢");
        notRobBut.setBounds(420,400,75,20);
        notRobBut.addActionListener(this);
        notRobBut.setVisible(false);
        landLord[1]=notRobBut;
        this.getContentPane().add(notRobBut);
        
        //创建出牌按钮，并存入publishCard数组中
        JButton outCard=new JButton("出牌");
        outCard.setBounds(320,400,60,20);
        outCard.addActionListener(this);
        outCard.setVisible(false);
        publishCard[0]=outCard;
        this.getContentPane().add(outCard);
        //创建不要按钮，并存入publishCard数组中
        JButton notOutCard=new JButton("不要");
        notOutCard.setBounds(420,400,60,20);
        notOutCard.addActionListener(this);
        notOutCard.setVisible(false);
        publishCard[1]=notOutCard;
        this.getContentPane().add(notOutCard);

        //创建提示文字
        for(int i=0;i<3;i++){
            time[i]=new JTextField("倒计时");
            time[i].setEditable(false); //设置为不可编辑
            time[i].setVisible(false);
            this.getContentPane().add(time[i]);
        }
        time[0].setBounds(140,230,60,20);
        time[1].setBounds(374,360,60,20);
        time[2].setBounds(620,230,60,20);

        //创建地主图标
        ImageIcon dizhuIcon=new ImageIcon("D:\\java\\AdvancedSets\\PockGame\\image\\poker\\dizhu.png");
        dizhu=new JLabel(dizhuIcon);
        dizhu.setVisible(false);
        dizhu.setSize(40,40);
        this.getContentPane().add(dizhu);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source=e.getSource();
        if(source==landLord[0]){
            
        }
        else if(source==landLord[1]){

        }
        else if(source==publishCard[0]){

        }
        else if(source==publishCard[1]){

        }
    }
}
