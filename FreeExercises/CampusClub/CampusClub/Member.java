package CampusClub;

import java.util.List;
import java.util.Arrays;

public class Member {
    private String name;
    private String memberId;
    private int points=0; //默认零分
    private String status="活跃"; //默认活跃状态
    public Member(){}
    public Member(String name,String memberId){
        this.name=name;
        this.memberId=memberId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getMemberId(){
        return memberId;
    }
    public void setMemberId(String memberId){
        this.memberId=memberId;
    }
    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        if(points>=0){
            this.points=points;
        }
        else{
            return;
        }
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newStatus){
        List<String> allowList=Arrays.asList("活跃","请假","退社");
        if(allowList.contains(newStatus)){
            this.status=newStatus;
        }
        else{
            return;
        }
    }
    //积分查询功能
    public int checkPoints(){
        System.out.println("成员"+getName()+"当前积分："+getPoints()+"分");
        return points;
    } 
    //活动报名功能
    public boolean registerActivity(Activity activity,Club club){
        boolean result=club.registerActivity(this, activity);
        if(result){
            System.out.println("报名成功，活动"+activity.getTitle()+"等待开始");
        }
        else{
            System.out.println("报名失败，报名已中止");
        }
        return result;
    }
    //活动签到功能
    public boolean signInActivity(Activity activity,Club club){
        boolean result=club.signInCheck(this, activity);
        if(result){
            this.points+=activity.getPointsReward();
            System.out.println("签到成功，获得"+activity.getPointsReward()+"积分，当前积分："+this.points+"分");
            return true;
        }
        else{
            System.out.println("签到失败");
            return false;
        }
    }
}
