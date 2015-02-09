package com.Stoffel.snakeColor.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.Stoffel.snakeColor.Snake;
import com.Stoffel.snakeColor.Window;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Window.WEB_WIDTH, Window.WEB_HEIGHT);
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new Snake();
        }
}