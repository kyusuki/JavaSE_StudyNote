package Inside;
import java.util.ArrayList;
public class Gym {
    private String gymName; //健身房名称
    private ArrayList<Course> courseList=new ArrayList<>(); //课程列表
    private ArrayList<Member> memberList=new ArrayList<>(); //会员列表
    public Gym(){}
    public Gym(String gymName,ArrayList<Course> courseList,ArrayList<Member> memberList){
        this.gymName=gymName;
        this.courseList=courseList;
        this.memberList=memberList;
    }
    public void setGymName(String gymName){
        this.gymName=gymName;
    }
    public String getGymName(){
        return gymName;
    }
    public void setCourseList(ArrayList<Course> courseList){
        this.courseList=courseList;
    }
    public ArrayList<Course> getCourseList(){
        return courseList;
    }
    public void setMemberList(ArrayList<Member> memberList){
        this.memberList=memberList;
    }
    public ArrayList<Member> getMemberList(){
        return memberList;
    }
    //添加课程
    public void addCourse(Course course){
        boolean flag=false;
        for(int i=0;i<courseList.size();i++){
            String courseid=courseList.get(i).getCourseId();
            if(courseid.equals(course.getCourseId())){
                flag=true;
                break;
            }
        }
        if(flag){
            System.out.println("课程ID"+course.getCourseId()+"已存在，添加失败");
        }
        else{
            courseList.add(course);
            System.out.println("课程"+course.getCourseName()+"添加成功");
        }
    }
    //更新课程库存
    public void updateCourseStock(String courseId,int changeNum){
        for(int i=0;i<courseList.size();i++){
            String courseId1=courseList.get(i).getCourseId();
            if(courseId.equals(courseId1)){
                System.out.println("课程ID"+courseId+"不存在");
                return;
            }
            else{
                int newStock=courseList.get(i).getStock()+changeNum;
                if(newStock<0){
                    System.out.println("库存不足，更新失败");
                    return;
                }
                courseList.get(i).setStock(newStock);
                System.out.println("课程"+courseList.get(i).getCourseName()+"库存更新为"+newStock);
            }
        }
    }
    //课程报名
    public boolean enrollCourse(Member member,Course course){
        if(course.getStock()<=0){
            System.out.println("课程"+course.getCourseName()+"库存不足，无法报名");
            return false;
        }
        else{
            if(!(course.getStatus().equals("待开课"))){
                System.out.println("课程"+course.getCourseName()+"状态为"+course.getStatus()+"，无法报名");
                return false;
            }
            else{
                if(member.getBalance()<course.getPrice()){
                    System.out.println("会员"+member.getName()+"余额不足，无法报名");
                    return false;
                }
                else{
                    updateCourseStock(course.getCourseId(), -1);
                    return true;
                }
            }
        }
    }
}
