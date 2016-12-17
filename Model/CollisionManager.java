package Model;

public class CollisionManager {

	public boolean checkCollision(GameBody GameBody1, GameBody GameBody2, GameEngine engine) {

		if( GameBody1 instanceof Bullet) {
			if ( GameBody2 instanceof SteelWall) {
				return false;
			} else if ( GameBody2 instanceof BrickWall) {
				return ((BrickWall)GameBody2).getDestroyed(engine);
			} else if ( GameBody2 instanceof IronWall){
				return ((IronWall)GameBody2).getDestroyed(engine);
			}
		}

		return false;
	}

}