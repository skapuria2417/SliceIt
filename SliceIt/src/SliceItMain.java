import guiTeacher.GUIApplication;

public class SliceItMain extends GUIApplication {
	
	public static GameScreen game;
	public static SliceItMain g;
	
	public SliceItMain(int width, int height){
		super(width,height);
	}

	public static void main(String[] args) {
		g= new SliceItMain(800,800);
		Thread game = new Thread(g);
		game.start();
	}

	@Override
	public void initScreen() {
		SliceItScreen slice = new SliceItScreen(getWidth(),getHeight());
		setScreen(slice);
		 game = new GameScreen(800,800);
	}

}
