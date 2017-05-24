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
	private boolean d;
	
	private Button rectangle;
	
	private ClickableGraphic fruitPics;
	
	private int score;
	

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
				fruitDisplay.setX((int)(Math.random()*getWidth()));
				fruitDisplay.setY((int)(Math.random()*getHeight()));
				fruitDisplay.setText(chosenFruit);
				
				fruitPics.setX((int)(Math.random()*getWidth()));
				fruitPics.setY((int)(Math.random()*getWidth()));
				String chosenPic=picArray[random];
				fruitPics.changeGraphic(chosenPic);
				//System.out.print(getWidth());
				
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
		String[] setUp  = { "apple", "banana", "orange", "pineapple", "kiwi", "tomato", "guava,", "mango",
				"durian", "jackfruit" };
		
		String[] picArray={"Resources/pineapple.png","Resources/banana.png","Resources/orange.png","Resources/apple.png",
				"Resources/kiwi.png","Resources/tomato.png","Resources/guava.png","Resources/mango.png","Resources/durian.png"
				,"Resources/jackfruit.png"
				};
		this.picArray=picArray;
		fruits = setUp;
		random = (int) (Math.random() * fruits.length);
		fruitDisplay = new TextLabel(100, 25, 100, 100, fruits[random]);
		viewObjects.add(fruitDisplay);
		
		fruitPics=new ClickableGraphic(250,250,70,90,picArray[random]);
		viewObjects.add(fruitPics);
		
		rectangle=new Button(5,250,750,510,"",Color.white, new Action(){
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		viewObjects.add(rectangle);
	}

}
