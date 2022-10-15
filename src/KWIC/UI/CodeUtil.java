package KWIC.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : CodeUtil  //类名
 * @Description : 代码工具类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/15  16:48
 */
public class CodeUtil {
    static List<String> codeList = new ArrayList<>();
    static {
        codeList.add(" 核心代码\n public void shift() {\n" +
                "        //获取每个单词，存入tokens\n" +
                "        Iterator<String> it = lineTxt.iterator();\n" +
                "        while (it.hasNext()) {\n" +
                "            StringTokenizer token = new StringTokenizer(it.next());\n" +
                "            ArrayList<String> tokens = new ArrayList<String>();\n" +
                "            int i = 0;\n" +
                "            //循环添加单词\n" +
                "            int count = token.countTokens();\n" +
                "            while (i < count) {\n" +
                "                tokens.add(token.nextToken());\n" +
                "                i++;\n" +
                "            }\n" +
                "            //display(tokens);\n" +
                "            //切割各个单词，不断改变起始值和利用loop实现位移。\n" +
                "            for (i = 0; i < count; i++) {\n" +
                "                StringBuffer lineBuffer = new StringBuffer();\n" +
                "                int index = i;\n" +
                "                for (int f = 0; f < count; f++) {\n" +
                "                //从头继续位移\n" +
                "                    if (index >= count)\n" +
                "                        index = 0;\n" +
                "                //存入StringBuffer\n" +
                "                    lineBuffer.append(tokens.get(index));\n" +
                "                    lineBuffer.append(\" \");\n" +
                "                    index++;\n" +
                "                }\n" +
                "                String tmp = lineBuffer.toString();\n" +
                "                kwicList.add(tmp);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "    }");
        codeList.add("核心代码:\npublic class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Input input = new Input();\n" +
                "        input.input(\"D:\\\\input.txt\");\n" +
                "        Shift shift = new Shift(input.getLineTxt());\n" +
                "        shift.shift();\n" +
                "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "        alphabetizer.sort();\n" +
                "        Output output = new Output(alphabetizer.getKwicList());\n" +
                "        output.output(\"D:\\\\output.txt\");\n" +
                "\n" +
                "    }\n" +
                "}");
        codeList.add("核心代码:\npublic class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        //创建主题\n" +
                "        KWICSubject kwicSubject = new KWICSubject();\n" +
                "        //创建观察者\n" +
                "        Input input = new Input(\"D:\\\\input.txt\");\n" +
                "        Shift shift = new Shift(input.getLineTxt());\n" +
                "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "        Output output = new Output(alphabetizer.getKwicList(), \"D:\\\\output.txt\");\n" +
                "\n" +
                "        // 将观察者加入主题\n" +
                "        kwicSubject.addObserver(input);\n" +
                "        kwicSubject.addObserver(shift);\n" +
                "        kwicSubject.addObserver(alphabetizer);\n" +
                "        kwicSubject.addObserver(output);\n" +
                "        // 逐步调用各个观察者\n" +
                "        kwicSubject.startKWIC();\n" +
                "    }\n" +
                "}");
        codeList.add("核心代码:\npublic class Main {\n" +
                "    public static void main(String[] args) throws IOException {\n" +
                "        File inFile = new File(\"D:\\\\input.txt\");\n" +
                "        File outFile = new File(\"D:\\\\output.txt\");\n" +
                "        Pipe pipe1 = new Pipe();\n" +
                "        Pipe pipe2 = new Pipe();\n" +
                "        Pipe pipe3 = new Pipe();\n" +
                "        Input input = new Input(inFile, pipe1);\n" +
                "        Shift shift = new Shift(pipe1, pipe2);\n" +
                "        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\n" +
                "        Output output = new Output(outFile,pipe3);\n" +
                "        input.transform();\n" +
                "        shift.transform();\n" +
                "        alphabetizer.transform();\n" +
                "        output.transform();\n" +
                "    }\n" +
                "}");
    }
}
