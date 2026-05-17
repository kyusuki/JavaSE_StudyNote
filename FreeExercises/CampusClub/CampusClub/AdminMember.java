package CampusClub;

import java.util.List;
import java.util.Arrays;

public class AdminMember extends Member{
    private String position="干事"; //默认干事职务
    public AdminMember(){}
    public AdminMember(String name,String memberId,String position){
        super(name,memberId);
        this.position=position;
    }    
    public String getPosition(){
        return position;
    }
    public void setPosition(String newPosition){
        List<String> allowList=Arrays.asList("社长","部长","干事");
        if(allowList.contains(newPosition)){
            this.position=newPosition;
        }
        else{
            return;
        }
    }
    @Override
    public boolean signInActivity(Activity activity,Club club){
        boolean result=club.signInCheck(this, activity);
        if(result){
            this.setPoints(this.getPoints()+activity.getPointsReward());
            System.out.println("管理员"+this.getName()+"完成签到");
            return true;
        }
        else{
            System.out.println("管理员"+this.getName()+"签到失败");
            return false;
        }
    }
}
