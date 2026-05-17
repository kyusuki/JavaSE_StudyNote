其实这两个都可以使用，区别取决于代码的可维护性，一致性和是否存在额外逻辑。
如果`getXXX()`只是简单返回变量值，如
    `private String name;`
    `public String getName(){`
        `return name;`
    `}`
    这时内部直接使用`name`或`getName()`完全等价。推荐直接使用`name`，因为更简洁，还可减少冗余代码。
但如果`getXXX()`存在额外逻辑，如
    `private int count;`
    `public int getCount(){`
        `return count+1;`
    `}`
    那这时就必须通过`getXXX()`访问，否则会导致逻辑不一致。