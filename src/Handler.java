import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> objectList = new LinkedList<GameObject>();
	
	
	// TICK FOR INDIVIDUAL OBJECT IN THE LIST
	public void tick(){
		for (int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			
			tempObject.tick();
		}
	}
	
	// REDNER FOR INDIVIDUAL OBJECT IN THE LIST
	public void render(Graphics g){
		for(int i = 0; i < objectList.size(); i++){
			GameObject tempObject = objectList.get(i);
			
			tempObject.render(g);
		}
	}
	
	// ADD OBJECT TO LIST METHOD
	public void addObject(GameObject object){
		this.objectList.add(object);
		
	// REMOVING OBJECT FROM THE LIST METHOD
	}
	public void removeObject(GameObject object){
		this.objectList.remove(object);
	}
	
	
}
