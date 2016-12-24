package Controller;

import javax.sound.sampled.*;
import java.io.InputStream;

public class SoundManager {
	private String name;
	private Clip clip;
	private boolean isStopped;
	private SoundThread sThread;


	public SoundManager(String name) {
		this.name = "Resources/" + name;
		sThread = new SoundThread();
	}

	public String getName() {
		return this.name;
	}
	/*
	public void setIsStopped(boolean isStopped){
		this.isStopped = isStopped;
	}
	public boolean getIsStopped(){
		return this.isStopped;
	}
	*/

	public void playMusic(){
		sThread.run();
	}
	public void stop(){
		sThread.stop();
	}

	public class SoundThread implements Runnable{
		boolean isStopped = true;
		Clip clip;
		InputStream in;
		AudioInputStream inputStream;

		public void setStopped( boolean isStopped){
			this.isStopped = isStopped;
		}

		public void run() {
			try {
				clip = AudioSystem.getClip();
				in = SoundManager.class.getClassLoader().getResourceAsStream("Resources/war.wav");
				inputStream = AudioSystem.getAudioInputStream(in);
				clip.open(inputStream);
				this.setStopped(false);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		public void stop(){
			if( !isStopped ) {
				clip.stop();
			}
		}
	}



/*
	public void playMusic() {

		new Thread(new Runnable() {

			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream in = SoundManager.class.getClassLoader().getResourceAsStream("Resources/war.wav");
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(in);
					clip.open(inputStream);
					if() {
						clip.loop(Clip.LOOP_CONTINUOUSLY);
					}
					else{

					}

				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
	*/
}
