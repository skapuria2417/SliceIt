import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.MovingComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable{
	
	ArrayList<String> fruits =new ArrayList<String>();
	

	public GameScreen(int width, int height) {
		super(width, height);
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("orange");
		fruits.add("pineapple");
		fruits.add("kiwi");
		fruits.add("tomamto");
		fruits.add("guava");
		fruits.add("mango");
		fruits.add("durian");
		fruits.add("jackfruit");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
	} 
	
}
