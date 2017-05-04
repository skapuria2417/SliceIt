import gui6.GUIApplication;

public class SliceItMain extends GUIApplication {
	
	public SliceItMain(int width, int height){
		super(width,height);
	}

	public static void main(String[] args) {
		SliceItMain slc= new SliceItMain(800,100);
		
	}

	@Override
	public void initScreen() {
		SliceItScreen slice = new SliceItScreen(getWidth(),getHeight());
		setScreen(slice);
	}

}