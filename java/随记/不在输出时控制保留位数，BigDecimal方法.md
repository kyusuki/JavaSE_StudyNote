首先两个头文件
    `import java.math.BigDecimal;`
    `import java.math.RoundingMode;`
其次
    `BigDecimal num=new BigDecimal(123.456789);`
    `num=num.setScale(2,RoundingMode.HALF_UP); //舍入模式为四舍五入`
    `num.doubleValue(); //执行前两行num是BigDecimal类型，而非double类型，这里是修改num的数据类型`
    `System.out.println(num); //123.46`

ps. `RoundingMode`是`Java`中本身独立存在的一个枚举类，只是在实际开发中，`RoundingMode`最常见的场景就是配合`BigDecimal`的`setScale()`方法实现高精度数值的舍入