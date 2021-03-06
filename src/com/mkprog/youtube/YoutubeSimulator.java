package com.mkprog.youtube;

public class YoutubeSimulator {
	public static Video current;
	private static GamePlayer player = new GamePlayer("bob joe");
	public static final Youtube y = new Youtube();
	public static final GUI gui = new GUI();
	public static GameState state = GameState.VIDSTATS;
	public static GamePlayer getGamePlayer() {
		return player;
	}
	public static void main(String[] args) throws Exception {
		player.user.channels.add(new Channel("xBOBJOEx", player.user));
		Video video = new Video("My First Video", "My First Video", player.user.channels.get(0), Enums.VideoType.gaming);
		video.upload();
//		System.out.println(NameGetter.getName());
		
		gui.start();
		while (true) {
			for (int i = 0; i < 60 * 12; i++) {
				y.tick();
			}
			for (Video v : y.videos) {
				v.dayComplete();
			}
			y.day++;
		}
	}
}