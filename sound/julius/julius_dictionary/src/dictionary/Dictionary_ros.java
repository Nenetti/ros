package dictionary;
public class Dictionary_ros{
	public enum dictionary{

		
		
		turtlebot_brinup("roslaunch turtlebot_bringup minimal.launch", "たーとるぼっと ぶりんぐあっぷ"),
		rosbridge_websocket("roslaunch rosbridge_server rosbridge_websocket.launch", "ろすぶりっぢ "),
		roscore("roscore", "ろすこあ"),
		
		
		
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