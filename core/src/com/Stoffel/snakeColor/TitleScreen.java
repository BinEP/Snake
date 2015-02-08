package com.Stoffel.snakeColor;

import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class TitleScreen implements Screen {

	public Snake game;
	public OrthographicCamera camera;
	
	public TitleScreen(Snake gam) {
		game = gam;
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		
		game.font.draw(game.batch, "Ready to play Snake!", 100, 150);
		game.font.draw(game.batch, "Tap to begin!", 100, 100);
		
		
		
		
		g.setFont(new Font("Joystix", Font.BOLD, 80));
		CenteredText title1 = new CenteredText("SNAKE!!", 500, 500, g,
				true, 180);
		drawColorOptions(g, 415);
		g.setFont(new Font("Joystix", Font.BOLD, 20));

		CenteredText start1 = new CenteredText("Press Enter to", 500, 500,
				g, true, 300);
		CenteredText start2 = new CenteredText("Start", 500, 500, g, true,
				330);

		g.setFont(new Font("Joystix", Font.BOLD, 12));

		CenteredText keyMapInstruct = new CenteredText(
				"Press keys Up, Right, Down, Left to map new keys", 500,
				500, g, true, 30);

		
		
		game.batch.end();
		
		if (Gdx.input.isTouched()) {
				game.setScreen(new PlayScreen(game));
				dispose();
		}
		
		keyMap[keyIndex] = e.getKeyCode();
		keyIndex++;
		if (keyIndex > 3)
			keyIndex = 0;

		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
