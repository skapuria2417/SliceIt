import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;





public class SliceItScreen extends ClickableScreen implements Runnable {

	private TextLabel intro;
	private TextLabel author;
	private Button startGame;
	private TextArea instructions;
	private Button next;
	private SliceItMain game;
	private ClickableGraphic background;

	
	public SliceItScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		/*background =new ClickableGraphic(0, 0, 800, 800,"Resources/background.jpg");
		viewObjects.add(background);
//		
*/		intro = new TextLabel(300,200,400,400,"Slice It");
		intro.setSize(70);
		viewObjects.add(intro);

		author = new TextLabel(600,700,400,400,"By Sammyajit Kapuria.");
		author.setSize(12);
		viewObjects.add(author);

		instructions = new TextArea(150,80,500,750,"Click on the correct food to get points. Avoid the bombs!");
		
		startGame=new Button(400,400,120,40,"Start Game", Color.green, new Action(){

			@Override
			public void act() {
				
				viewObjects.remove(intro);
				viewObjects.remove(author);
				remove(startGame);
				viewObjects.add(instructions);
				instructions.setSize(75);

				next = new Button(650,700,120,40,"Next",Color.green,new Action(){

					@Override
					public void act() {
						GameScreen game = new GameScreen(getWidth(), getHeight());
						SliceItMain.g.setScreen(game);
						Thread t = new Thread(game);
						t.start();

						//						viewObjects.remove(instructions);
						//						remove(next);
						//						random = (int) (Math.random() * fruits.length);
						//						fruitDisplay = new TextLabel(100, 25, 100, 100, fruits[random]);
						//						viewObjects.add(fruitDisplay);

					}		
					//					
					//				})
					//				
				});addObject(next);
				
			}
		});
		viewObjects.add(startGame);
	}
}





