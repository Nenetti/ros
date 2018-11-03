package dictionary;
public class Dictionary_en{
	public enum dictionary{
		
		;
		private String text;
		private String yomi;
		private dictionary(String text, String yomi) {
			this.yomi=yomi;
		}
		public String getText() {
			return text;
		}
		public String getYomi() {
			return yomi;
		}
	}
}