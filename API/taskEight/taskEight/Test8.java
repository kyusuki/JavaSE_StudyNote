package taskEight;

public class Test8 {
    public static void main(String[] args){
        /*
         * 需求1：判断一个字符串的开始字符和结束字符是否一致，单个字符
         * 例如：a123a、b123b、c123c
         *   \\组号  表示把某个分组的内容再次使用
         */
        String regex1="(.).+\\1";
        System.out.println("a123a".matches(regex1)); //true
        System.out.println("a123b".matches(regex1)); //false
        System.out.println("-----------------");
        /*
         * 需求2：判断一个字符串的开始部分和结束部分是否一致，多个字符
         * 例如：abc123abc、123789123、b123b、&!@abc&!@
         */
        String regex2="(.+).+\\1";
        System.out.println("abc123abc".matches(regex2)); //true
        System.out.println("123789122".matches(regex2)); //false
        System.out.println("-----------------");
        /*
         * 需求3：判断一个字符串的开始部分和结束部分是否一致，包括开始部分内部的字符
         * 例如：aaa123aaa、111789111、&&abc&&
         */
        String regex3="((.)\\2*).+\\1";
        System.out.println("aaa123aaa".matches(regex3)); //true
        System.out.println("111789112".matches(regex3)); //false
    }
}
