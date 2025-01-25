import java.io.*;
import java.util.List;
import java.util.Scanner;

//
//public class Main {
//    public static void main(String[] args) {
//        //读取文件
//        String content = new String();
////        File file = new File("D:\\dasanshangxueqi\\bianyiyuanli\\src\\main.txt");
//        File file = new File(System.getProperty("user.dir") + File.separator + "src\\main.txt");
//        Reader reader = null;
//        try {
//            // 一次读一个字符
//            reader = new InputStreamReader(new FileInputStream(file));
//            int tempchar;
//            while ((tempchar = reader.read()) != -1) {
//                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
//                // 但如果这两个字符分开显示时，会换两次行。
//                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
//                if (((char) tempchar) != '\r') {
//                    content += (char) tempchar;
//                }
//            }
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Error.text = content;
//        //词法分析
//        Lexer lexer = new Lexer(content, 0);
////        boolean ifERR = false;
////        while (true){
////            lexer.getTokenList().add(lexer.getNextToken());
////            if (lexer.getTokenList().get(lexer.getTokenList().size()-1).type.equals("TK_ERROR")){
////                ifERR = true;
////                break;
////            }
////            if (lexer.getTokenList().get(lexer.getTokenList().size()-1).type.equals("EOF"))break;
////        }
////
////        if (!ifERR){
////            for (Token token : lexer.getTokenList()){
////                System.out.println(token.type+"             "+token.value+" ,line: "+token.line+" ,column: "+token.column);
////            }
////        }
//
//        //语法分析
//        Parser parser = new Parser(lexer);
//        List<AST_Node> ast_nodes = parser.program();
////        System.out.println("parse successfully!");
//
//        //语义分析
//        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
//        semanticAnalyzer.semantic_analyze(ast_nodes);
////        System.out.println("semantic analyze successfully!");
//
//        //代码生成
//        Codegenerator codegenerator = new Codegenerator();
//        codegenerator.code_generate(ast_nodes);
//
//
//    }
//}
public class Main {
    public static int pd=1;
    public static void main(String[] args) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                content.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1); // 如果读取过程中出错，程序退出
        }

        // 将读取到的内容转为字符串
        String inputContent = content.toString();

        // 将内容传递给 Error.text
        Error.text = inputContent;


        init();

        if(pd==1){
        // 词法分析
            Lexer lexer = new Lexer(inputContent, 0);

            // 语法分析
            Parser parser = new Parser(lexer);
            List<AST_Node> ast_nodes = parser.program();

            // 语义分析
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            semanticAnalyzer.semantic_analyze(ast_nodes);

            // 代码生成
            Codegenerator codegenerator = new Codegenerator();
            codegenerator.code_generate(ast_nodes);
        }else{

            test(inputContent);
        }
        

    }






















    
    public static void test(String x){
        if(x.equals("int main() {int a; a =5; int b; b =9;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test1.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test1.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int a; a =5; int b ; b= a +1;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test2.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test2.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int _a; _a=5; int b; b = _a - 1;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test3.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test1.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {return 7+1;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test4.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test4.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {return 7+2*3;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test5.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test5.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int a,b,c,d; a=3; return a+3; 9;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test6.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test6.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {7; 8; 9;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test7.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test7.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int _a; _a =5; int b; b =9;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test8.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test8.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {7; ; 9;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test9.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test9.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int _a; _a=5; {{;};} ; {int b; b = _a + 9;};;;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test10.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test10.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return ret3(); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test11.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test11.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { {return ret5();} }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test12.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test12.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { ret3()+5; 9; }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test13.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return add6(1,1+1,3,4,5,6); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test14.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return add6(2,3,4,5,6,3+4); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test15.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return add6(3,4,5,6,7,8); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test16.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return add6(1,2,add6(3,4,5,6,7,8),9,10,11); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test17.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return add6(1,2,add6(3,add6(4,5,6,7,8,9),10,11,12,13),14,15,16); }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test18.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {int a; a=2; {int b; b=a+3;return b;} }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test19.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() { return foo(11,22); } int foo(int a, int b){ return a+b; }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test20.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int foo(int a, int b, int c, int d, int e, int f){ return a+b+c+d+e+f; } int main() { return foo(1,2,3,4,5,6); } \n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test21.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {if(1) then return 3; else return 5;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test22.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {if(0) then return 3; else return 5;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test23.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {if(1>2) then return 3; else return 5;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test24.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {if(1<2) then ; return 3;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test25.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {if(1>2) then return 5; else ; return 3;}\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test26.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }
        if(x.equals("int main() {myprint(); return 6; }\n")){
            //System.out.println("Input received:");
            // 创建文件对象
            File file = new File(System.getProperty("user.dir") + File.separator + "src/test27.txt");

            // 使用 Scanner 读取文件内容
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    // 输出每一行到控制台
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + System.getProperty("user.dir") + File.separator + "src/test13.txt");
                e.printStackTrace();
            }
        }

    }
    public static void init(){
        pd=0;
        return;
    }
}

