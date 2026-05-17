package CampusClub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Club {
    private String clubName;
    private ArrayList<Member> memberList=new ArrayList<>();
    private ArrayList<Activity> activityList=new ArrayList<>();
    private Map<Member,Activity> recordList=new HashMap<>();
    public Club(){}
    public Club(String clubName){
        this.clubName=clubName;
    }
    public String getClubName(){
        return clubName;
    }
    public void setClubName(String clubName){
        this.clubName=clubName;
    }
    public ArrayList<Member> getMemberList(){
        return memberList;
    }
    public void sedMemberList(ArrayList<Member> memberList){
        this.memberList=memberList;
    }
    public ArrayList<Activity> getActivityList(){
        return activityList;
    }
    public void setActivityList(ArrayList<Activity> activityList){
        this.activityList=activityList;
    }
    public Map<Member,Activity> getRecordList(){
        return recordList;
    }
    public void setRecordList(Map<Member,Activity> recordList){
        this.recordList=recordList;
    }
    //成员加入功能
    public void addMember(Member member){
        for(Member m:memberList){
            if(m.getMemberId().equals(member.getMemberId())){
                System.out.println("成员ID"+member.getMemberId()+"已存在，加入失败");
                return;
            }
            memberList.add(member);
            System.out.println("成员"+member.getName()+"加入"+this.clubName+"成功");
        }
    }
    //活动发布功能
    public boolean publishActivity(AdminMember admin,Activity activity){
        if((!(admin.getStatus().equals("活跃")))&&admin.getPosition().equals("干事")){
            System.out.println("无发布权限");
            return false;
        }
        for(Activity a:activityList){
            if(a.getActivityId().equals(activity.getActivityId())){
                System.out.println("活动ID"+activity.getActivityId()+"已存在");
                return false;
            }
        }
        activityList.add(activity);
        activity.setStatus("未开始");
        System.out.println("活动"+activity.getTitle()+"发布成功");
        return true;
    }
    //报名检验
    public boolean registerActivity(Member member,Activity activity){
        if(!(member.getStatus().equals("活跃"))){
            System.out.println("成员状态异常，无法报名");
            return false;
        }
        if(!(activity.getStatus().equals("未开始"))){
            System.out.println("活动已截止报名");
            return false;
        }
        recordList.put(member,activity);
        return true;
    }
    //签到校验
    public boolean signInCheck(Member member,Activity activity){
        if(!(activity.getStatus().equals("进行中"))){
            System.out.println("活动未开始或已结束");
            return false;
        }
        if(!(recordList.containsKey(member))){
            System.out.println("未报名该活动，无法签到");
            return false;
        }
        recordList.get(member).setStatus("进行中");
        return true;
    }
    //积分排名查询功能
    public void getPointsRanking(){ 
        Integer[] points=new Integer[memberList.size()];
        for(int i=0;i<memberList.size();i++){
            points[i]=memberList.get(i).getPoints();
        }
        Arrays.sort(points,(o1,o2)->o2-o1);
        System.out.print(this.clubName+"积分排名：");
        for(int i=0;i<points.length;i++){
            System.out.print((i+1)+"."+memberList.get(i).getName()+"-"+points[i]+"分"+" ");
        }
    }
}
