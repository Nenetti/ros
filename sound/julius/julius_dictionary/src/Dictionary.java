import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Dictionary{
	
	
	private HashMap<String, String> wordMap=new HashMap<>();
	
	public Dictionary(String sentence, String word) throws Exception{
		File sentence_file=new File(sentence);
		
		
	}
	
	private void readWord(String path) throws Exception{
		File file=new File(path);
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String line;
		while((line=reader.readLine())!=null) {
			String[] splits=line.split("\t");
			if(splits.length)
		}
	}
	
	
	
}