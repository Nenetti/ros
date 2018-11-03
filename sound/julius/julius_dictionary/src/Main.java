import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import dictionary.Dictionary_ja;

public class Main {

	private static String path=System.getProperty("user.home")+"/ros/sound/julius/";
	private static String file_ja="word_ja";
	private static String file_en="word_en.yomi";
	
	
	
	
	public static void main(String[] args) throws Exception {
		writeFile();
		createDic();
	}
	
	
	private static void writeFile() throws Exception{
		File file=new File(path+file_ja+".yomi");
		BufferedWriter writer=new BufferedWriter(new FileWriter(file));
		for(Dictionary_ja.dictionary d: Dictionary_ja.dictionary.values()) {
			writer.write(d.getWord()+"\t"+d.getYomi());
			writer.newLine();
		}
		writer.close();
	}
	
	private static void createDic() throws Exception{
		ProcessBuilder builder=new ProcessBuilder(toProcessCommand("bash "+path+"make_dictionary.sh "+file_ja));
		builder.inheritIO();
		builder.start();
	}
	
	/******************************************************************************************
	 * 
	 * @param str
	 * @return
	 */
	private static List<String> toProcessCommand(String command){
		List<String> result=new ArrayList<>();
		String[] splits=command.split(" ");
		for(String str:splits) {
			result.add(str);
		}
		return result;
	}
	
	
	
}
