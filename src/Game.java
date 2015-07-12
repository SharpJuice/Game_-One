import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

// Same as "Game : Canvas" in C#
// Implements -> Using Runnable interface
public class Game extends Canvas implements Runnable{

	
	
	private static final long serialVersionUID = -1442798787354930462L;   

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
	// FINAL VARIABLE 	-> default read-only, constant, initialized only once
	// FINAL METHOD 	-> can not be overridden in sub-class. Constant behavior, faster the non-final methods
	// FINAL CLASS		-> can not be sub-classed like e.g. String, Integer ++ ExampleClass extends FinalClass -> compilation error: cannot inherit from final class
	
	
	
	// Creating  Thread
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private HUD hud;
	
	// GAME CONSTRUCTOR
public Game(){
	
	handler = new Handler();
	this.addKeyListener(new KeyInput(handler));
	
	
	new Window(WIDTH, HEIGHT, "Game ONE", this); // new Window is created without a reference because we don't need it

	hud = new HUD();

	
	handler.addObject(new Player( WIDTH/2, HEIGHT/2, ID.Player));
	handler.addObject(new BasicEnemy( WIDTH/2 + 20, HEIGHT/2 + 20, ID.BasicEnemy));;
}
	
	
    // Thread START
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	// Thread STOP -> always surrounded by try{} catch(){}
	public synchronized void stop(){
	try{
	thread.join();
	running = false;
		
	}catch(Exception e){
		e.printStackTrace();
	}
		
	}
	
	
	// RUN METHOD
public void run(){
	long  lastTime = System.nanoTime();		// Current time in nano.seconds ?? Found article that says it is buggy
	double fps = 60.0; 						// Frames per second
	double ns = 1000000000 / fps;			// Time passed between each frames @@ 166666.(6)
	double delta = 0;
	long timer = System.currentTimeMillis();// Current time in mili.secenods
	int frames = 0;
	long now;
	
	// GAME LOOP
		while(running){
			now = System.nanoTime(); 		// Current time in nano.seconds
			delta += (now - lastTime) / ns;	// If (now - lastTime) >= ns it will be more then 1 meaning while loop will execute 
			lastTime = now;					// 
			
			while (delta>=1){
				tick();
				delta--;
			
			}
			
			
			if (running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
	}
	
// TICK METHOD
private void tick(){
	
	handler.tick();
	hud.tick();
}
	
// RENDER METHOD
private void render(){
	BufferStrategy bs = this.getBufferStrategy();
	if(bs == null){
		this.createBufferStrategy(3);
		return;
	}
	
	Graphics g = bs.getDrawGraphics(); // Creates a graphics context for the drawing buffer

	
	// Order of rendering does matter - last object is rendered last so it is on top of all -> in this example hud will be front layer as it should
	g.setColor(Color.black);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	handler.render(g);
	hud.render(g);
	
	
	g.dispose();//Disposes of this graphics context and releases any system resources that it is using. A Graphics object cannot be used after dispose has been called. 
	bs.show(); 	//Makes the next available buffer visible by either copying the memory (blitting) or changing the display pointer (flipping).
				// without it we won'y see anything on the screen
}


	//  CLAMP METHOD
	public static int clamp(int var, int min, int max){
		if(var >= max)
			return var = max;
		else if( var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main(String args[]){
		new Game(); // new Game is created without a reference because we don't need it
	
	}
	
	
	
	
	
	
	
}
