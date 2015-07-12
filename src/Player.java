import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	
	
	
	
	

	public Player(int x, int y, ID id) {
		super(x, y, id);
	

		
	}


	public void tick() {
		
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 36);
		y = Game.clamp(y, 0, Game.HEIGHT - 54);
		
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(x, y, 30, 30);
		
	}

	
	
	
	
	
	
	
}
