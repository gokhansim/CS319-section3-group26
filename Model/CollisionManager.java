package Model;

public class CollisionManager {

	public boolean checkCollision(GameBody GameBody1, GameBody GameBody2) {

		if( GameBody1 instanceof Bullet) {
			if ( GameBody2 instanceof SteelWall) {
				return false;
			} else if (GameBody2 instanceof BrickWall) {
				GameBody2.getDestroyed();
				return true;
			} else if ( GameBody2 instanceof IronWall){
				if( GameBody2.getScoreIron() == 0 ){
					GameBody2.getDestoyed();
				}
			}
		}

	}

}