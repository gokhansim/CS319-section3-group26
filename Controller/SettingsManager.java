package Controller;


public class SettingsManager {

	private Game game;

	public SettingsManager( Game game){
		this.game = game;
	}

	public void changeLevel(int level) {
		game.startLevel(level);
	}


	public void changeVolume(int volume) {
		
	}

}