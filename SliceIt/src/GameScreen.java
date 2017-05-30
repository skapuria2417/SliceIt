import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.MovingComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class GameScreen extends ClickableScreen implements Runnable {

	private String[] fruits;
	private TextLabel fruitDisplay;
	private String[] picArray;
	private int random;
	private int random2;
	private boolean d;

	private int imageCount;

	private Button rectangle;

	private ClickableGraphic fruitPics;

	private int score = 0;
	private TextLabel scoreD;

	private double timeRemaining = 30.0;
	private TextLabel time;

	public GameScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void run() {
		while (timeRemaining > 0) {
			Timer();

			fruitAppear();
			fruitDisplayAppear();
			update();

		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		d = true;
		String[] setUp = { "apple", "banana", "orange", "pineapple", "kiwi", "tomato", "guava,", "mango", "durian",
				"jackfruit" };

		String[] picArray = { "Resources/pineapple.png", "Resources/banana.png", "Resources/orange.png",
				"Resources/apple.png", "Resources/kiwi.png", "Resources/tomato.png", "Resources/guava.png",
				"Resources/mango.png", "Resources/durian.png", "Resources/jackfruit.png", "Resources/bomb.png" };
		this.picArray = picArray;
		fruits = setUp;
		random = (int) (Math.random() * fruits.length);
		fruitDisplay = new TextLabel(100, 25, 100, 100, fruits[random]);
		viewObjects.add(fruitDisplay);

		random2 = (int) (Math.random() * fruits.length);
		fruitPics = new ClickableGraphic(250, 250, 70, 90, picArray[random2]);
		viewObjects.add(fruitPics);

		scoreD = new TextLabel(100, 100, 150, 50, "Score: ");
		viewObjects.add(scoreD);

		time = new TextLabel(300, 150, 150, 150, "Time:" + timeRemaining);
		viewObjects.add(time);

		// rectangle=new Button(5,250,750,510,"",Color.white, new Action(){
		//
		// @Override
		// public void act() {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		// viewObjects.add(rectangle);
	}

	private void Timer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timeRemaining -= .1;
		time.setText("Time: " + (int) (timeRemaining * 10) / 10.0);

	}

	private void fruitAppear() {
		// try {
		// ;

		random2 = (int) (Math.random() * picArray.length);
		fruitPics.setX((int) (Math.random() * getWidth()));
		fruitPics.setY((int) (Math.random() * getWidth()));
		String chosenPic = picArray[random2];
		fruitPics.changeGraphic(chosenPic);
		imageCount++;

		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private void fruitDisplayAppear() {
		// try {
		// Thread.sleep(5000);
		random = (int) (Math.random() * fruits.length);
		String chosenFruit = fruits[random];
		fruitDisplay.setText(chosenFruit);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
