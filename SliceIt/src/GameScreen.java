import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.MovingComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable {

	private String[] fruits;
	private TextLabel fruitDisplay;
	private int random;
	private boolean d;
	private ClickableGraphic pineapple;

	public GameScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void run() {
		while (d) {
			try {
				Thread.sleep(1000);
				random = (int) (Math.random() * fruits.length);
				String chosenFruit=fruits[random];
				fruitDisplay.setText(chosenFruit);
				update();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		d=true;
		String[] setUp  = { "apple", "banana", "orange", "pineapple", "kiwi", "tomamto", "guava,", "mango",
				"durian", "jackfruit" };
		fruits = setUp;
		random = (int) (Math.random() * fruits.length);
		fruitDisplay = new TextLabel(100, 25, 100, 100, fruits[random]);
		viewObjects.add(fruitDisplay);
		
		pineapple=new ClickableGraphic(250,250,70,90,"Resources/pineapple.png");
		viewObjects.add(pineapple);
	}

}
