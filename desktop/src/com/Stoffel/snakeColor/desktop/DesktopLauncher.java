package com.Stoffel.snakeColor.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.Stoffel.snakeColor.Snake;
import com.Stoffel.snakeColor.Window;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
			config.title = "Snake";
	      config.width = Window.DESKTOP_WIDTH;
	      config.height = Window.DESKTOP_HEIGHT;
	      
		new LwjglApplication(new Snake(), config);
	}
}
