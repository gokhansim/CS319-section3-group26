public class GameBody {
	private Place location;
	//image object will be here	

	public GameBody(Place p){ //it will also take an image as a parameter
		location = p;
		//image = i;
	}
	
	public Place getLocation(){
		return location;
	}

	public void setLocation(Place loc){
		location = loc;
	}
}