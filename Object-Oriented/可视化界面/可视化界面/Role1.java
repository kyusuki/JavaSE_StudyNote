package 可视化界面;

import java.util.Random;

public class Role1 {
    private String name;
    private int blood;
    private char gender;
    private String face; // 随机长相
    
    String[] boyfaces = {"风流俊雅", "气宇轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞"};
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材姣好", "相貌平平", "相貌丑陋", "惨不忍睹"};

    String[] attack_desc = {
        "%s使出了一招【背心钉】，转到对方身后，一掌向%s背心的灵台穴拍去。",
        "%s使出了一招【游空探爪】，飞起身形自半空中变掌为爪锁向%s。",
        "%s大喝一声，身形下伏，一招【霹雷坠地】，捶向%s双腿。",
        "%s运气与掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
        "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
        "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };
    
    String[] injured_desc = {
        "结果%s退了半步，毫发无伤",
        "结果给%s造成一处瘀伤",
        "结果一击致命，%s痛的弯下腰",
        "结果%s痛苦的闷哼一声，显然受了点内伤",
        "结果%s摇摇晃晃，一脚跌倒在地",
        "结果%s脸色一下变得惨白，连退好几步",
        "结果（轰）的一声，%s口中鲜血狂喷而出",
        "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public Role1() {}
    
    public Role1(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
    }
    
    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setBlood(int blood) {
        this.blood = blood;
    }
    
    public int getBlood() {
        return blood;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setFace(char gender) {
        Random r = new Random();
        // 根据性别随机长相
        if (gender == '男') {
            int index = r.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        } else if (gender == '女') {
            int index = r.nextInt(girlfaces.length);
            this.face = girlfaces[index];
        } else {
            this.face = "非人类";
        }
    }
    
    public String getFace() {
        return face;
    }
    
    public String attack(Role1 r) {
        Random r2 = new Random();
        int index = r2.nextInt(attack_desc.length);
        String desc = String.format(attack_desc[index], this.getName(), r.getName());
        
        // 计算伤害
        int damage = r2.nextInt(20) + 1;
        // 剩余血量
        int remain = r.getBlood() - damage;
        // 血量为负时，修改为0
        remain = remain < 0 ? 0 : remain;
        // 修改被攻击者的血量
        r.setBlood(remain);
        
        // 输出受伤结果
        String injuryDesc;
        if (remain >= 90) {
            injuryDesc = String.format(injured_desc[0], r.getName());
        } else if (remain >= 80) {
            injuryDesc = String.format(injured_desc[1], r.getName());
        } else if (remain >= 70) {
            injuryDesc = String.format(injured_desc[2], r.getName());
        } else if (remain >= 60) {
            injuryDesc = String.format(injured_desc[3], r.getName());
        } else if (remain >= 40) {
            injuryDesc = String.format(injured_desc[4], r.getName());
        } else if (remain >= 20) {
            injuryDesc = String.format(injured_desc[5], r.getName());
        } else if (remain >= 10) {
            injuryDesc = String.format(injured_desc[6], r.getName());
        } else {
            injuryDesc = String.format(injured_desc[7], r.getName());
        }
        
        return desc + "\n" + injuryDesc + "\n";
    }
    
    public String getRoleInfo() {
        return "姓名：" + getName() + "\n" +
               "性别：" + getGender() + "\n" +
               "长相：" + getFace() + "\n" +
               "血量：" + getBlood() + "\n";
    }
}

