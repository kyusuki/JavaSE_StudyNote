# 定义Java编译器和编译选项
JC = javac
JFLAGS = -g  # 生成调试信息（可选）

# 定义需要编译的所有.java文件（按需添加）
CLASSES = Book.java BookManager.java BookTest.java BorrowRecord.java LibraryGUI.java

# 默认目标：编译所有类
default: classes

# 隐式规则：将.java文件编译为.class文件
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# 目标：编译所有CLASSES对应的.class文件
classes: $(CLASSES:.java=.class)

# 清理生成的.class文件
clean:
	rm -f *.class