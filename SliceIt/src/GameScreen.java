import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.MovingComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable {

	private String [] fruits={"apple","banana","orange","pineapple","kiwi","tomamto","guava,","mango","durian","jackfruit"};
	private TextLabel fruitDisplay;
	private int random;

	public GameScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		System.out.println(fruits.length);
		random = (int) (Math.random() * fruits.length);
		fruitDisplay = new TextLabel(100, 25, 100, 100, fruits[random]);
		System.out.print("sdjklfhsjkfhnjks");
		viewObjects.add(fruitDisplay);

	}

}
