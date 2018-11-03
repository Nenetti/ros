package dictionary;


public class Dictionary_ja{
	
	//何を言われるか事前に状況をある程度固定分岐させるほうがよさそう？
	//質問が来るのか
	//自身の質問に対する回答か
	//それによって構文を構成するほうが賢い気がする？
	//ここで文を分割しておいて、辞書には

	
	public static enum SentenceType{
		肯定文,
		疑問文,
		否定文,
		命令文,
		システム文
	}
	
	public static enum Parameter{
		
	}
	
	public static enum dictionary{
		
		Yes("イエス", "いえす", "肯定文"),
		No("ノー", "のー", "否定文"),
		
		
		
		
		
		;
		//private String[] parameter;
		private String word;
		private String yomi;
		private SentenceType sentenceType;
		private dictionary(String text, String yomi, String sentenceType, String... parameter) {
			//this.parameter=parameter;
			this.word=text;
			this.yomi=yomi;
			this.sentenceType=getSentenceType(sentenceType);
		}

		
		public String getWord() {
			return word;
		}
		public String getYomi() {
			return yomi;
		}
		public SentenceType getSentenceType() {
			return sentenceType;
		}
		private SentenceType getSentenceType(String sentenceType) {
			if(sentenceType!=null) {
				for(SentenceType s:SentenceType.values()) {
					if(sentenceType.equals(s.toString())) {
						return s;
					}
				}
			}
			return null;
		}
	}
}