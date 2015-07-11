import java.awt.Canvas;

// Same as "Game : Canvas" in C#
// Implements -> Using Runnable interface
public class Game extends Canvas implements Runnable{

	
	
	private static final long serialVersionUID = -1442798787354930462L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
	
	// Creating  Thread
	
	private Thread thread;
	private boolean running = false;
	
	
	
public Game(){
	new Window(WIDTH, HEIGHT, "Game ONE", this);
}
	
	
    // Thread START
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	
	// Thread STOP
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
	long  lastTime = System.nanoTime();		// Current time in nano.seconds
	double amountOfTicks = 60.0; 			// Frames per second
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis(); // Current time in mili.secenods
	int frames = 0;
	
		while(running){
			long now = System.nanoTime(); 	// Current time in nano.seconds
			delta += (now - lastTime) / ns;	// Difference between "now" and "LastTime"
			lastTime = now;					// 
			
			while (delta>=1){
				tick();
				delta--;
			}
			
			
			if (running)
				render();
			
		}
	}
	
	
	
	public static void main(String args[]){
		new Game();
	
	}
	
	
	
	
	
	
	
}