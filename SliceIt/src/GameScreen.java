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
	private int random3;
	private int random4;

	private boolean imagePopped = false;

	private double counter;

	private ClickableGraphic fruitPics;
	private ClickableGraphic fruitPics2;
	private ClickableGraphic fruitPics3;

	
	private int score = 0;
	private TextLabel scoreD;

	private double timeRemaining = 60.0;
	private TextLabel time;

	private String chosenPic;
	private String chosenFruit;

	public GameScreen(int width, int height) {
		super(width, height);

	}

	@Override
	public void run() {
		Timer();
		fruitAppear();
		fruitAppear2();
		fruitAppear3();
		fruitDisplayAppear();
		while (timeRemaining > 0) {

			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			update();
		}
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		String[] setUp = { "apple", "banana", "orange", "pineapple", "kiwi", "tomato", "guava", "mango", "durian",
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
		fruitPics.setAction(new Action() {

			@Override
			public void act() {

					if (getChosenPic().contains(chosenFruit)) {
						score += 10;
						scoreD.setText("Score: " + (score));
					}else if (getChosenPic().contains("bomb")) {
						score -= 10;
						scoreD.setText("Score: " + (score));
						System.out.println("bomb ");
					} else {
						score -=5;
						scoreD.setText("Score: " + (score));
						System.out.println("wrong fruit ");
					}
				}
			

		});
		viewObjects.add(fruitPics2);
		
//		random3 = (int) (Math.random() * fruits.length);
		fruitPics2 = new ClickableGraphic(250, 250, 70, 90, picArray[random3]);
		fruitPics2.setAction(new Action() {

			@Override
			public void act() {

					if (getChosenPic().contains(chosenFruit)) {
						score += 10;
						scoreD.setText("Score: " + (score));
					}else if (getChosenPic().contains("bomb")) {
						score -= 10;
						scoreD.setText("Score: " + (score));
						System.out.println("bomb ");
					} else {
						score -=5;
						scoreD.setText("Score: " + (score));
						System.out.println("wrong fruit ");
					}
				}
			

		});
		viewObjects.add(fruitPics2);
		
		random4 = (int) (Math.random() * fruits.length);
		fruitPics3 = new ClickableGraphic(250, 250, 70, 90, picArray[random4]);
		fruitPics3.setAction(new Action() {

			@Override
			public void act() {

					if (getChosenPic().contains(chosenFruit)) {
						score += 10;
						scoreD.setText("Score: " + (score));
					}else if (getChosenPic().contains("bomb")) {
						score -= 10;
						scoreD.setText("Score: " + (score));
						System.out.println("bomb ");
					} else {
						score -=5;
						scoreD.setText("Score: " + (score));
						System.out.println("wrong fruit ");
					}
				}
			

		});
		viewObjects.add(fruitPics3);


		scoreD = new TextLabel(100, 100, 150, 50, "Score: " + score);
		viewObjects.add(scoreD);

		time = new TextLabel(300, 150, 150, 150, "Time:" + timeRemaining);
		viewObjects.add(time);
	}

	private void Timer() {
		Thread timer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (timeRemaining > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					timeRemaining -= .1;
					counter += .1;
					time.setText("Time: " + (int) (timeRemaining * 10) / 10.0);
					// TODO Auto-generated method stub
				}
			}
		});
		timer.start();

	}

	private String getChosenPic() {
		return chosenPic;
	}

	private void fruitAppear() {
		Thread timer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (timeRemaining > 0) {
					random2 = (int) (Math.random() * picArray.length);
					fruitPics.setX((int) (Math.random() * getWidth()));
					fruitPics.setY((int) (Math.random() * getWidth()));
					chosenPic = picArray[random2];
					fruitPics.changeGraphic(chosenPic);
					try {
						Thread.sleep(900);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		timer.start();
		//timer.start();
		

	}
	
	private void fruitAppear2() {
		Thread timer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (timeRemaining > 0) {
//					random3 = (int) (Math.random() * picArray.length);
					fruitPics2.setX((int) (Math.random() * getWidth()));
					fruitPics2.setY((int) (Math.random() * getWidth()));
					chosenPic = picArray[random3];
					fruitPics.changeGraphic(chosenPic);
					try {
						Thread.sleep(900);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		timer.start();
		//timer.start();
		

	}
	
	private void fruitAppear3() {
		Thread timer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (timeRemaining > 0) {
//					random4 = (int) (Math.random() * picArray.length);
					fruitPics3.setX((int) (Math.random() * getWidth()));
					fruitPics3.setY((int) (Math.random() * getWidth()));
					chosenPic = picArray[random4];
					fruitPics.changeGraphic(chosenPic);
					try {
						Thread.sleep(900);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		timer.start();
		//timer.start();
		

	}


	private void fruitDisplayAppear() {

		Thread timer = new Thread(new Runnable() {

			@Override
			public void run() {
				while (timeRemaining > 0) {
					random = (int) (Math.random() * fruits.length);
					chosenFruit = fruits[random];
					fruitDisplay.setText(chosenFruit);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		timer.start();

	}
}
