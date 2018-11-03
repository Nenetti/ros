import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.Character.UnicodeBlock;
import java.util.HashMap;

import javafx.scene.shape.Line;

public class Yomi2Voca {

	private static UnicodeBlock Alphabet=UnicodeBlock.BASIC_LATIN;
	private static UnicodeBlock HIRAGANA=UnicodeBlock.HIRAGANA;
	private static UnicodeBlock KATAKANA=UnicodeBlock.KATAKANA;
	private static UnicodeBlock CJK_UNIFIED_IDEOGRAPHS=UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;

	private KanwaDict dict = KakasiDictReader.load("dict/kakasidict");
	private HashMap<String, String> english_dictionary;
	
	public Yomi2Voca(String dic_dir) throws Exception{
		File inFile=new File(dic_dir);
		BufferedReader reader=new BufferedReader(new FileReader(inFile));
		String line;
		while((line=reader.readLine())!=null) {
			String[] splits=line.split("\t");
			english_dictionary.put(splits[0], splits[1]);
		}
		reader.close();
	}
	
	public String toYomi(String text) {
		UnicodeBlock unicode=getUnicode(text);
		if(HIRAGANA) {
			return text;
		}
		if()
		text+=" ";
		int index=0;
		int length=2;
		String result="";
		for(int i=0;i<length;i++) {
			if(length<=text.length()) {
				Phoneme phoneme=Phoneme.getPhoneme(text.substring(index, length));
				if(phoneme!=null) {
					result+=phoneme.phoneme;
					index=length;
					length=index+2;
				}else {
					length--;
				}
			}
		}
		return result;
	}
	
	private String katakana_to_hiragana(String text) {
		KanwaDict dict = KakasiDictReader.load("dict/kakasidict");
	    Kanhira kakasi = new Kanhira(dict);
	    System.out.println(kakasi.convert("roslaunch"));*/
		//new Yomi2Voca("/home/ubuntu/ros/sound/julius/yomi2voca.txt", "/home/ubuntu/ros/sound/julius/yomi2voca2.txt");
	}

	
	
	/*public Yomi2Voca(String in, String out) throws Exception{
		File inFile=new File(in);
		BufferedReader reader=new BufferedReader(new FileReader(inFile));
		//File outFile=new File(out);
		//BufferedWriter writer=new BufferedWriter(new FileWriter(outFile));
		String line;
		System.out.println(reader.readLine());
		while((line=reader.readLine())!=null) {
			line=line.trim();
			line=line.replaceAll("s/", "");
			line=line.replaceAll("/ ", "(\"");
			line=line.replaceAll("/g;", "\"),");
			System.out.println(line);
		}


		reader.close();
		//writer.close();
	}*/

	private UnicodeBlock getUnicode(String line) {
		for(char c:line.toCharArray()) {
			UnicodeBlock block=UnicodeBlock.of(c);
			if(block==Alphabet) {
				return Alphabet;
			}else if(block==KATAKANA) {
				return KATAKANA;
			}else if(block==CJK_UNIFIED_IDEOGRAPHS) {
				return CJK_UNIFIED_IDEOGRAPHS;
			}
		}
		return HIRAGANA;
	}


	public enum Phoneme{

		あ(" a"),
		い(" i"),
		う(" u"),
		え(" e"),
		お(" o"),
		か(" k a"),
		き(" k i"),
		く(" k u"),
		け(" k e"),
		こ(" k o"),
		さ(" s a"),
		し(" sh i"),
		す(" s u"),
		せ(" s e"),
		そ(" s o"),
		た(" t a"),
		ち(" ch i"),
		つ(" ts u"),
		て(" t e"),
		と(" t o"),
		な(" n a"),
		に(" n i"),
		ぬ(" n u"),
		ね(" n e"),
		の(" n o"),
		は(" h a"),
		ひ(" h i"),
		ふ(" f u"),
		へ(" h e"),
		ほ(" h o"),
		ま(" m a"),
		み(" m i"),
		む(" m u"),
		め(" m e"),
		も(" m o"),
		ら(" r a"),
		り(" r i"),
		る(" r u"),
		れ(" r e"),
		ろ(" r o"),
		が(" g a"),
		ぎ(" g i"),
		ぐ(" g u"),
		げ(" g e"),
		ご(" g o"),
		ざ(" z a"),
		じ(" j i"),
		ず(" z u"),
		ぜ(" z e"),
		ぞ(" z o"),
		だ(" d a"),
		ぢ(" j i"),
		づ(" z u"),
		で(" d e"),
		ど(" d o"),
		ば(" b a"),
		び(" b i"),
		ぶ(" b u"),
		べ(" b e"),
		ぼ(" b o"),
		ぱ(" p a"),
		ぴ(" p i"),
		ぷ(" p u"),
		ぺ(" p e"),
		ぽ(" p o"),
		や(" y a"),
		ゆ(" y u"),
		よ(" y o"),
		わ(" w a"),
		ゐ(" i"),
		ゑ(" e"),
		ん(" N"),

		あぁ(" a a"),
		いぃ(" i i"),
		いぇ(" i e"),
		いゃ(" y a"),
		うぅ(" u:"),
		えぇ(" e e"),
		おぉ(" o:"),
		かぁ(" k a:"),
		きぃ(" k i:"),
		くぅ(" k u:"),
		けぇ(" k e:"),
		こぉ(" k o:"),
		がぁ(" g a:"),
		ぎぃ(" g i:"),
		ぐぅ(" g u:"),
		げぇ(" g e:"),
		ごぉ(" g o:"),
		さぁ(" s a:"),
		しぃ(" sh i:"),
		すぅ(" s u:"),
		せぇ(" s e:"),
		そぉ(" s o:"),
		ざぁ(" z a:"),
		じぃ(" j i:"),
		ずぅ(" z u:"),
		ぜぇ(" z e:"),
		ぞぉ(" z o:"),
		たぁ(" t a:"),
		ちぃ(" ch i:"),
		つぁ(" ts a"),
		つぃ(" ts i"),
		つぅ(" ts u:"),
		つぇ(" ts e"),
		つぉ(" ts o"),
		てぇ(" t e:"),
		とぉ(" t o:"),
		だぁ(" d a:"),
		ぢぃ(" j i:"),
		づぅ(" d u:"),
		でぇ(" d e:"),
		どぉ(" d o:"),
		なぁ(" n a:"),
		にぃ(" n i:"),
		ぬぅ(" n u:"),
		ねぇ(" n e:"),
		のぉ(" n o:"),
		はぁ(" h a:"),
		ひぃ(" h i:"),
		ふぅ(" f u:"),
		へぇ(" h e:"),
		ほぉ(" h o:"),
		ばぁ(" b a:"),
		びぃ(" b i:"),
		ぶぅ(" b u:"),
		べぇ(" b e:"),
		ぼぉ(" b o:"),
		ぱぁ(" p a:"),
		ぴぃ(" p i:"),
		ぷぅ(" p u:"),
		ぺぇ(" p e:"),
		ぽぉ(" p o:"),
		まぁ(" m a:"),
		みぃ(" m i:"),
		むぅ(" m u:"),
		めぇ(" m e:"),
		もぉ(" m o:"),
		やぁ(" y a:"),
		ゆぅ(" y u:"),
		よぉ(" y o:"),
		らぁ(" r a:"),
		りぃ(" r i:"),
		るぅ(" r u:"),
		れぇ(" r e:"),
		ろぉ(" r o:"),
		わぁ(" w a:"),
		をぉ(" o:"),

		でぃ(" d i"),
		でゃ(" dy a"),
		でゅ(" dy u"),
		でょ(" dy o"),
		てぃ(" t i"),
		てゃ(" ty a"),
		てゅ(" ty u"),
		てょ(" ty o"),
		すぃ(" s i"),
		ずぁ(" z u a"),
		ずぃ(" z i"),
		ずゃ(" zy a"),
		ずゅ(" zy u"),
		ずょ(" zy o"),
		ずぇ(" z e"),
		ずぉ(" z o"),
		きゃ(" ky a"),
		きゅ(" ky u"),
		きょ(" ky o"),
		しゃ(" sh a"),
		しゅ(" sh u"),
		しぇ(" sh e"),
		しょ(" sh o"),
		ちゃ(" ch a"),
		ちゅ(" ch u"),
		ちぇ(" ch e"),
		ちょ(" ch o"),
		とぅ(" t u"),
		とゃ(" ty a"),
		とゅ(" ty u"),
		とょ(" ty o"),
		どぁ(" d o a"),
		どぅ(" d u"),
		どゃ(" dy a"),
		どゅ(" dy u"),
		どょ(" dy o"),
		にゃ(" ny a"),
		にゅ(" ny u"),
		にょ(" ny o"),
		ひゃ(" hy a"),
		ひゅ(" hy u"),
		ひょ(" hy o"),
		みゃ(" my a"),
		みゅ(" my u"),
		みょ(" my o"),
		りゃ(" ry a"),
		りゅ(" ry u"),
		りょ(" ry o"),
		ぎゃ(" gy a"),
		ぎゅ(" gy u"),
		ぎょ(" gy o"),
		ぢぇ(" j e"),
		ぢゃ(" j a"),
		ぢゅ(" j u"),
		ぢょ(" j o"),
		じぇ(" j e"),
		じゃ(" j a"),
		じゅ(" j u"),
		じょ(" j o"),
		びゃ(" by a"),
		びゅ(" by u"),
		びょ(" by o"),
		ぴゃ(" py a"),
		ぴゅ(" py u"),
		ぴょ(" py o"),
		うぁ(" u a"),
		うぃ(" w i"),
		うぇ(" w e"),
		うぉ(" w o"),
		ふぁ(" f a"),
		ふぃ(" f i"),
		ふゃ(" hy a"),
		ふゅ(" hy u"),
		ふょ(" hy o"),
		ふぇ(" f e"),
		ふぉ(" f o"),

		っ(" q"),
		ぁ(" a"),
		ぃ(" i"),
		ぅ(" u"),
		ぇ(" e"),
		ぉ(" o"),
		ゎ(" w a"),
		を(" o"),

		ー(":");

		private String phoneme;
		private Phoneme (String phoneme){
			this.phoneme=phoneme;
		}

		public static Phoneme getPhoneme(String str) {
			for(Phoneme p:Phoneme.values()) {
				if(str.equals(p.toString())) {
					return p;
				}
			}
			return null;
		}

	}





}