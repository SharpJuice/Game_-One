import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	// ABSTRACT -> so every instance of GameObject has its separate tick() and render() and they must use them ofc
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	
	// x -> GET, SET
	public void setX(int x){
		this.x = x;
	}
	
	public int getX(){
		return x;
	}
	// y -> GET, SET
	public void setY(int y){
		this.y = y;
	}
	
	public int getY(){
		return y;
	}
	
	// velX -> GET, SET
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public int getVelX(){
		return velX;
	}
	
	// velY -> GET, SET
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public int getVelY(){
		return velY;
	}
	
	// id -> GET, SET
	public void setId(ID id){
		this.id = id;
	}
	
	public ID getId(){
		return id;
	}
	
	
	
	
}
