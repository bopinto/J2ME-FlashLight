package flashlight;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Main extends MIDlet implements CommandListener {

	private Command exit;
	private BgCanvas canvas;
	
	public Main() {
		// TODO Auto-generated constructor stub
		exit = new Command("Exit", Command.EXIT, 0);
		canvas = new BgCanvas();
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO clean everything
		notifyDestroyed();
	}

	protected void pauseApp() {
		// TODO store state
		notifyPaused();
	}

	protected void startApp() throws MIDletStateChangeException {
		// TODO Auto-generated method stub
		canvas.addCommand(exit);
		canvas.setCommandListener(this);
		
		Display.getDisplay(this).setCurrent(canvas);
	}

	public void commandAction(Command c, Displayable disp) {
		// TODO Auto-generated method stub
		if(c.equals(exit)) {
			try {
				this.destroyApp(false);
			} catch (MIDletStateChangeException e) {}
		}
	}
	
	private class BgCanvas extends Canvas {

		protected void paint(Graphics g) {
			int width = getWidth();
			int height = getHeight();
			
			g.setColor(0x00ffffff);
			g.fillRect(0, 0, width, height);
		}
		
	}

}
