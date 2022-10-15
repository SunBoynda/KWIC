package KWIC.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : Description  //类名
 * @Description : 文字描述类  //描述
 * @Author : wangyujie //作者
 * @Date: 2022/10/15  17:03
 */
public class Description {
    static List<String> descList = new ArrayList<>();
    static {
        descList.add("主程序—子程序体系结构是较简单的结构，其组件是主程序和子程序，连接件是调用返回机制");
        descList.add(" 连接件是对象之间通过功能与函数调用实现交互。\n" +
                "对象是通过函数和过程的调用-返回机制来交互的，而类是通过定义对象，再采用调用-返回机制进行交互。");
        descList.add("能够激活对象功能的动作\n" +
                "发生后给所涉及的对象发送一个消息\n" +
                "对象接收消息后执行相应的功能");
        descList.add("据流传输的管道视为连接件。管道将一个过滤器的输出传给另一个过滤器的输入。\n" +
                "特点：一个过滤器必须完全独立于其他的过滤器（零耦合）----独立的实体。");
    }
}
