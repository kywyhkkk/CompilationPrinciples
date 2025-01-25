用java写的，处理后面多行输入的时候实在有些困难，修改了一下输入，把下面的多行输入放在一行里面里面的。
已经用javac -d out src/*.java命令编译出了out文件夹，可以直接用这个，大概是可以直接执行的。
或者再执行一遍javac -d out src/*.java
可以直接用test.sh来运行试验，在里面使用echo "$input" | java -cp out Main > tmp.s命令。但是java版本问题可能导致报错，我是用java8写的，如果版本太高或者太低都会报错。

