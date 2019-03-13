
package game.logic.actor;
 
import game.logic.*;
import javafx.scene.image.*;

public abstract class Actor extends ImageView{
	
	private Direction moving = null;

	public Actor(Image image) {
		super.setImage(image);
	}

	public void spawn() {
		Engine.actors.add(this);
	}

	public void spawn(int x, int y) {
		super.setTranslateX(x);
		super.setTranslateY(y);
		spawn();
	}
	
	public Direction getMoveDir() {
		return moving;
	}
	
	public boolean isMoving() {
		return moving != null;
	}
	
	public enum Direction {
		LEFT, RIGHT, UP, DOWN;
	}
}
