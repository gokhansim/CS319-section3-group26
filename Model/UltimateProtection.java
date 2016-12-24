package Model;

public class UltimateProtection extends PowerUp {
	public UltimateProtection(int x, int y) {
		super(x,y);
		this.id = 26;
	}

	@Override
	public boolean getDestroyed(GameEngine engine) {
		engine.destroyGameBody(this);
		int x = 0;
		int y = 0;
		for ( int i = 0; i < engine.getMapSize(); i++) {
			for ( int j = 0; j < engine.getMapSize(); j++) {
				if ( engine.intMap[i][j] == 6) {
					x = i;
					y = j;
				}	
			}
		}
		
		for ( int i = x-1; i <= x+1 && i <=9 && i >= 0; i++) {
			for ( int j = y-1; j <= y+1 && j <=9 && j >=0; j++) {
				if (engine.getIntMap()[i][j] != -1) {
					if(!(i == x && j == y)) {
						engine.destroyGameBody(engine.getMapItem(i, j));
						engine.createGameBody(new IronWall(i,j), i,j);
					}
				}
			}
		}
		return false;
	}
	
}