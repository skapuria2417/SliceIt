import guiTeacher.GUIApplication;

public class SliceItMain extends GUIApplication {
	
	public SliceItMain(int width, int height){
		super(width,height);
	}

	public static void main(String[] args) {
		SliceItMain slc= new SliceItMain(800,800);
		Thread game = new Thread(slc);
		game.start();
	}

	@Override
	public void initScreen() {
		SliceItScreen slice = new SliceItScreen(getWidth(),getHeight());
		setScreen(slice);
	}

}
