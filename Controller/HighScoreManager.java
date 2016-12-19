package Controller;

import java.io.*;
import java.util.*;

public class HighScoreManager {

	private ArrayList<Integer> scoreList;
	private File file;
	
	public HighScoreManager(){
		scoreList = new ArrayList<Integer>();
		file = new File("C:/Users/HP/Downloads/test.txt"); //must be changed
	}
	
	//takes the score when the game ends and adds it to the high scores if it is in the top 5
	public void registerHighScore(int score) {
		
		this.readHighScore();
		boolean added = false;
		if(scoreList.size() != 0)
			for(int s : scoreList){
				if(s == score)
					break;
				if(score > s){
					scoreList.add(scoreList.indexOf(s), score);
					if(scoreList.size() == 6)
						scoreList.remove(5); //since only the 5 highest scores will be kept
					added = true;
					break;
				}
			}
		else {
			scoreList.add(score);
			added = true;
		}
		if(added){
	
			try{
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject( scoreList );
				oos.close();
				fos.close();

			}
			catch (IOException e){}
		}
	}
	
	//returns the high scores
	public ArrayList<Integer> showHighScore() {
		this.readHighScore();
		return scoreList;
	}
	
	//for updating scoreList each time
	private void readHighScore(){
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			try {
				scoreList = (ArrayList<Integer>) ois.readObject();
			}
			catch (ClassNotFoundException a){}
		
			ois.close();
		}
		
		catch (IOException e){}
		
	}
	
}
