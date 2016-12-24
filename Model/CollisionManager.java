package Model;

public class CollisionManager {

	public boolean checkCollision(GameBody GameBody1, GameBody GameBody2, GameEngine engine) {
		boolean isDestroyed = false;
		if( GameBody1 instanceof Bullet) {
			if ( GameBody2 instanceof SteelWall) {
				return false;
			}
			else if ( GameBody2 instanceof BrickWall) {
				if( ((Bullet)GameBody1).getShooter() == 1){
					engine.addScore( ((BrickWall) GameBody2).getScore() );
				}
				return ((BrickWall)GameBody2).getDestroyed(engine);
			}
			else if ( GameBody2 instanceof IronWall){ // && ((IronWall) GameBody2).getHitsToDestroy() == 1){
				if( ((Bullet)GameBody1).getShooter() == 1){
					engine.addScore( ((IronWall) GameBody2).getScore() ); // ------->>  at each shot takes 25 points.
				}

				return ((IronWall)GameBody2).getDestroyed(engine);
			}
			else if ( GameBody2 instanceof EnemyTank){
				if( ((Bullet)GameBody1).getShooter() == 1){
					engine.addScore( ((EnemyTank) GameBody2).getScoreGiven() );
					isDestroyed = ((EnemyTank)GameBody2).getDestroyed(engine);
				}
				return isDestroyed;
			}
			else if ( GameBody2 instanceof SacredObject){
				System.out.println("The sacred object is hit! Game over.");
				engine.isGameOver = true; //!(((SacredObject)GameBody2).getIsDestroyed());
				engine.cleanMap();
				return ((SacredObject)GameBody2).getDestroyed(engine);
			}
			else if (GameBody2 instanceof PlayerTank) {
				System.out.println("You are hit! Remaining lives: " + engine.getPlayerTank().getCurrentLives());
				if (engine.getPlayerTank().getCurrentLives() == 0 && engine.getPlayerTank().getShield() == 0) {
					engine.isGameOver = true;
					engine.cleanMap();
				}
				return ((PlayerTank) GameBody2).getDestroyed(engine);
			}
			else if (GameBody2 instanceof PowerUp) {
				return ((PowerUp)GameBody2).getDestroyed(engine);
			}
		}
		else if (GameBody1 instanceof PlayerTank) {
			if (GameBody2 instanceof PowerUp) {
				System.out.println("PowerUp picked!");
				return ((PowerUp)GameBody2).getDestroyed(engine);
			}
		}

		return false;
	}

}