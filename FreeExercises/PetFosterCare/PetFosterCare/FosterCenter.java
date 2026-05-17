package PetFosterCare;
import java.util.ArrayList;
public class FosterCenter {
    private String centerName;
    private int maxCapacity;
    private ArrayList<Pet> fosteringPets=new ArrayList<Pet>();
    private ArrayList<String> fosterRecords=new ArrayList<String>();
    public FosterCenter(){}
    public FosterCenter(String centerName,int maxCapacity,ArrayList<Pet> fosteringPets,ArrayList<String> fosterRecords){
        this.centerName=centerName;
        this.maxCapacity=maxCapacity;
        this.fosteringPets=fosteringPets;
        this.fosterRecords=fosterRecords;
    }
    public String getCenterName(){
        return centerName;
    }
    public void setCenterName(String centerName){
        this.centerName=centerName;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity=maxCapacity;
    }
    public ArrayList<Pet> getFosteringPets(){
        return fosteringPets;
    }
    public void setFosteringPets(ArrayList<Pet> fosteringPets){
        boolean isFostering=true;
        for(int i=0;i<getFosteringPets().size();i++){
            Pet p=getFosteringPets().get(i);
            if(!(p.getFosterStatus().equals("寄养中"))){
                isFostering=false;
                break;
            }
        }
        if(isFostering){
            this.fosteringPets=fosteringPets;
        }
        else{
            System.out.println("添加列表失败，只能添加寄养中的宠物");
        }
    }
    public ArrayList<String> getFosterRecords(){
        return fosterRecords;
    }
    public void setFosterRecords(ArrayList<String> fosterRecords){
        this.fosterRecords=fosterRecords;
    }
    //初始化宠物列表
    public void init(){
        Pet pet=new Pet("1","1",1,1.0,"1","待寄养");
        getFosteringPets().add(pet);
    }
    //接收宠物寄养功能
    public boolean acceptPet(Pet pet,int days){
        //容量校验
        if(getFosteringPets().size()>=getMaxCapacity()){
            System.out.println("寄养中心已满，无法接收宠物"+pet.getNickname());
            return false;
        }
        //状态校验
        if(pet.getFosterStatus().equals("寄养中")){
            System.out.println("宠物"+pet.getNickname()+"已在寄养中");
            return false;
        }
        //ID唯一性校验
        for(int i=0;i<getFosteringPets().size();i++){
            String id=getFosteringPets().get(i).getPetId();
            if(pet.getPetId().equals(id)){
                System.out.println("宠物ID"+pet.getPetId()+"已注册，无法重复接收");
                return false;
            }
        }
        //成功处理流程
        double fee=pet.calculateFosterFee(days);
        pet.setFosterStatus("寄养中");
        getFosteringPets().add(pet);
        getFosterRecords().add(pet.getPetId()+" "+pet.getNickname()+" "+days+"天 "+fee+"元 ");
        System.out.println("接收成功，宠物"+pet.getNickname()+"寄养"+days+"天，费用："+fee+"元");
        return true;
    }
    //宠物接走登记功能
    public boolean pickUpPet(String petId){
        for(int i=0;i<getFosteringPets().size();i++){
            String id=getFosteringPets().get(i).getPetId();
            if(id.equals(petId)){
                getFosteringPets().get(i).setFosterStatus("已接走");
                getFosteringPets().remove(i);
                System.out.println("宠物"+petId+"已接走，感谢使用");
                return true;
            }
        }
        System.out.println("未找到宠物");
        return false;
    }
    //寄养宠物查询功能
    public void queryPets(String status){
        if(status==null){
            System.out.println("输入状态不能为空");
        }
        else if(status.equals("寄养中")){
            System.out.println("寄养中宠物列表：");
            if(getFosteringPets().isEmpty()){
                System.out.println("当前没有寄养中的宠物");
                return;
            }
            for(int i=0;i<getFosteringPets().size();i++){
                if(getFosteringPets().get(i) instanceof Dog d){
                    System.out.println("大狗叫："+d.getNickname()+"，宠物ID："+d.getPetId()+"，年龄："+d.getAge()+"，体重："+d.getWeight()+"，品种："+d.getBreed()+"，主人："+d.getOwnerContact());
                }
                else if(getFosteringPets().get(i) instanceof Cat c){
                    System.out.println("哈吉米："+c.getNickname()+"，宠物ID："+c.getPetId()+"，年龄："+c.getAge()+"，体重："+c.getWeight()+"，毛发："+c.getHairlength()+"，主人："+c.getOwnerContact());
                }
            }
        }
        else{
            System.out.println("只能查询寄养中的宠物，查询其它功能请联系客服");
        }
    }
}
