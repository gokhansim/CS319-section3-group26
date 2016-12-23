package Controller;

import javax.sound.sampled.*;
import java.io.InputStream;

public class SoundManager {
	private String name;
	private Clip clip;

	public SoundManager(String name) {
		this.name = "Resources/" + name;
	}

	public String getName() {
		return this.name;
	}

	public void playMusic() {

		new Thread(new Runnable() {

			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					InputStream in = SoundManager.class.getClassLoader().getResourceAsStream("Resources/war.wav");
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(in);
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
}


		/*
		this.clip = null;
		try {
			System.out.println(this.name);
			InputStream in = SoundManager.class.getClassLoader().getResourceAsStream(this.name);
			if (in != null) {
				AudioInputStream inputStr = AudioSystem.getAudioInputStream(in);
				AudioFormat format = inputStr.getFormat();
				DataLine.Info info = new DataLine.Info(Clip.class, format);
				this.clip = (Clip)AudioSystem.getLine(info);
				this.clip.open(inputStr);
				this.clip.loop(0);
				do {
					try {
						Thread.sleep(100);
						continue;
					}
					catch (InterruptedException var5_8) {
					}
				} while (this.clip.isRunning());
			}
		}
		catch (Exception e) {
		}
		finally {
			try {
				if (this.clip != null) {
					this.clip.close();
				}
			}
			catch (Exception x) {
				x.printStackTrace(System.out);
			}
		}

	}

}
*/
