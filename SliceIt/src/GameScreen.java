import java.util.List;

import guiTeacher.components.MovingComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable{
	
	private MovingComponent ball;

	public GameScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		ball = new MovingComponent(0,0,50,50);
		viewObjects.add(ball);
	} 
	
}
