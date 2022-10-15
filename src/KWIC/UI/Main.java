package KWIC.UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import KWIC.model4.*;
import KWIC.model3.*;
import KWIC.model2.*;
import KWIC.model1.*;
/**
 * @author wangyujie
 */
public class Main {
	static ArrayList<String> UrlList = new ArrayList<>();
	public static  String filePath = "";
	static {
		UrlList.add("src/KWIC/UI/1.png");
		UrlList.add("src/KWIC/UI/2.png");
		UrlList.add("src/KWIC/UI/3.png");
		UrlList.add("src/KWIC/UI/4.png");
	}

	public static void main(String[] args){


		JFrame frame = new JFrame("软件体系结构");

		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);

		JTabbedPane table = new JTabbedPane();
		//分别设置四种panel的样式，大同小异，可以通过同一个模板产生
		JComponent one = create(TypeEnum.ONE_TYPE.getType());
		JComponent two = create(TypeEnum.TOW_TYPE.getType());
		JComponent three = create(TypeEnum.THERE_TYPE.getType());
		JComponent fourth = create(TypeEnum.FOURTH_TYPE.getType());

		table.add("主程序-子程序",one);
		table.add("面向对象",two);
		table.add("事件系统",three);
		table.add("管道-过滤",fourth);
		table.setSelectedIndex(0);
		frame.setContentPane(table);
		frame.setVisible(true);
	}
	private static JComponent create(Integer type) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		String desc = "";
		String url = "";
		String code = "";
		if(type.equals(TypeEnum.ONE_TYPE.getType())) {
			desc = Description.descList.get(type);
			url = UrlList.get(type);
			code = CodeUtil.codeList.get(type);
		}
		else if(type.equals(TypeEnum.TOW_TYPE.getType())) {
			desc = Description.descList.get(type);
			url = UrlList.get(type);
			code = CodeUtil.codeList.get(type);
		}
		else if(type.equals(TypeEnum.THERE_TYPE.getType())) {
			desc = Description.descList.get(type);
			url = UrlList.get(type);
			code = CodeUtil.codeList.get(type);
		}
		else if(type.equals(TypeEnum.FOURTH_TYPE.getType())) {
			desc = Description.descList.get(type);
			url = UrlList.get(type);
			code = CodeUtil.codeList.get(type);
		}
		else {
			return null;
		}
		//文字说明
		JTextArea description = new JTextArea(desc);
		JScrollPane scroll_desc = new JScrollPane(description);
		scroll_desc.setFont(new Font(null, Font.PLAIN, 100));
		GridBagConstraints gridBagConstraintsOne = createContainer(0);
		panel.add(scroll_desc,gridBagConstraintsOne);
		//图片
		ImageIcon img = new ImageIcon(url);
		//注意对每张图片改变一定的比例
		img.setImage(img.getImage().getScaledInstance(500, 300, 0));
		JLabel label = new JLabel(img);
		GridBagConstraints gridBagConstraintsTwo =createContainer(1);
		panel.add(label,gridBagConstraintsTwo);

		//运行结果
		final JTextArea result = new JTextArea("运行结果");
		JScrollPane scroll_result = new JScrollPane(result);
		scroll_result.setFont(new Font(null, Font.PLAIN, 100));
		GridBagConstraints gridBagConstraintsThree = createContainer(2);
		panel.add(scroll_result,gridBagConstraintsThree);
		//核心代码
		JTextArea contentCode = new JTextArea(code);
		JScrollPane scroll_code = new JScrollPane(contentCode);
		scroll_result.setFont(new Font(null, Font.PLAIN, 100));
		GridBagConstraints gridBagConstraintsFour = createContainer(3);
		panel.add(scroll_code,gridBagConstraintsFour);
		//按钮
		JButton button = new JButton("点击运行");
		GridBagConstraints gridBagConstraintsFive = createContainer(4);
		button.setFont(new Font(null, Font.BOLD, 20));
		button.setForeground(Color.BLACK);
		button.setBackground(Color.white);
		panel.add(button,gridBagConstraintsFive);
		addListener(type,button,result);
		//获取文件路径的按钮
		JButton fileButton = new JButton("获取文件路径按钮");
		GridBagConstraints gridBagConstraintsSix = createContainer(5);
		fileButton.setFont(new Font(null, Font.BOLD, 20));
		fileButton.setForeground(Color.BLACK);
		fileButton.setBackground(Color.white);
		fileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();             //设置选择器
				chooser.setMultiSelectionEnabled(true);             //设为多选
				int returnVal = chooser.showOpenDialog(button);        //是否打开文件选择框


				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
					//获取路径
					Main.filePath = filepath;

				}

			}
		});
		panel.add(fileButton,gridBagConstraintsSix);

		return panel;
	}

	public static void addListener(Integer type,JButton button,JTextArea result) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("运行结果为");
				clearFile();//清空文件内容
				if (type.equals(TypeEnum.ONE_TYPE.getType())) {
					KWIC.model1.demo1.main(null);
				}else if (type.equals(TypeEnum.TOW_TYPE.getType())) {
					KWIC.model2.Main.main(null);
				}else if (type.equals(TypeEnum.THERE_TYPE.getType())) {
					KWIC.model3.Main.main(null);
				}else {
					try {
						KWIC.model4.Main.main(null);
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
				//读取文件，显示结果
				String result_content = getFileContent();
				result.append(result_content);
			}
		});
	}


	public static String getFileContent(){
		File file = new File("D:\\output.txt");
	    StringBuilder result = new StringBuilder();
	    try{
	      BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
	      String res = null;
	      while((res = bufferedreader.readLine())!=null){
	        result.append(System.lineSeparator()+res);
	      }
	      bufferedreader.close();  
	    }catch(Exception e){
	      e.printStackTrace();
	    }
	    return result.toString();
	  }

	public static void clearFile(){
		File file = new File("D:\\output.txt");
		FileWriter filewriter;
		try {
			filewriter = new FileWriter (file);
			filewriter.write("");
			filewriter.flush();
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static GridBagConstraints createContainer(int index) {
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridy = index;//行
		bagConstraints.gridx = 0;//列
		bagConstraints.weightx = 0.3;
		bagConstraints.weighty = 0.3;
		if (index == 1) {
			bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		}else{
			bagConstraints.fill = GridBagConstraints.BOTH;
		}
		return bagConstraints;
	}
}