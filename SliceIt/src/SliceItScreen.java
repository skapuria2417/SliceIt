import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;





public class SliceItScreen extends ClickableScreen implements Runnable {
	
	private TextLabel intro;
	private TextLabel author;
	private Button startGame;

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
		intro = new TextLabel(300,200,400,400,"Slice It");
		intro.setSize(70);
		viewObjects.add(intro);
		
		author = new TextLabel(600,700,400,400,"By Sammyajit Kapuria.");
		author.setSize(12);
		viewObjects.add(author);
		
		startGame=new Button(400,400,120,40,"Start Game", Color.green, new Action(){
			
			@Override
			public void act() {
				viewObjects.remove(intro);
				viewObjects.remove(author);
				remove(startGame);
				
			}
			
		});
		viewObjects.add(startGame);
	}

}





