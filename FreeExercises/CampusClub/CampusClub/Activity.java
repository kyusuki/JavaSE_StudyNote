package CampusClub;

import java.util.Arrays;
import java.util.List;

public class Activity {
    private String activityId;
    private String title;
    private String time;
    private String status="未开始"; //默认活动未开始
    private int pointsReward;
    public Activity(){}
    public Activity(String activityId,String title,String time,int pointsReward){
        this.activityId=activityId;
        this.title=title;
        this.time=time;
        this.pointsReward=pointsReward;
    }
    public String getActivityId(){
        return activityId;
    }
    public void setActivityId(String activityId){
        this.activityId=activityId;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time=time;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String newStatus){
        List<String> allowList=Arrays.asList("未开始","进行中","已结束");
        if(allowList.contains(newStatus)){
            System.out.println("活动"+this.getTitle()+"状态已更新为"+newStatus);
            this.status=newStatus;
        }
        else{
            System.out.println("无效活动状态");
            return;
        }
    }
    public int getPointsReward(){
        return pointsReward;
    }
    public void setPointsReward(int pointsReward){
        if(pointsReward>=1){
            this.pointsReward=pointsReward;
        }
        else{
            return;
        }
    }
}
