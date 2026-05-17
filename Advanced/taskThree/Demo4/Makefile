# 定义Java编译器和编译选项
JC = javac
JFLAGS = -g  # 生成调试信息（可选）

# 定义需要编译的所有.java文件（顺序建议把被依赖的类放前面）
CLASSES = Animal.java Dog.java Chicken.java Man.java Test.java

# 默认目标：编译所有类
default: classes

# 隐式规则：将.java文件编译为.class文件
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# 显式指定依赖关系 ↓↓↓ 核心修改点 ↓↓↓
# Dog.class 依赖 Animal.class（因为 Dog 继承 Animal）
Dog.class: Animal.class

# Chicken.class 依赖 Animal.class（因为 Chicken 继承 Animal）
Chicken.class: Animal.class

# Man.class 依赖 Animal.class（因为 Man 操作 Dog/Chicken，而 Dog/Chicken 依赖 Animal）
Man.class: Animal.class

# Test.class 依赖 Dog.class、Chicken.class、Man.class（因为 Test 调用这些类）
Test.class: Dog.class Chicken.class Man.class

# 目标：编译所有CLASSES对应的.class文件
classes: $(CLASSES:.java=.class)

# 清理生成的.class文件
clean:
	rm -f *.class