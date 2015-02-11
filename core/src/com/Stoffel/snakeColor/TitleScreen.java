package com.Stoffel.snakeColor;

import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class TitleScreen implements Screen {

	public Snake game;
	public OrthographicCamera camera;
	
	public TitleScreen(Snake gam) {
		game = gam;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.width, game.height);
		
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
		game.g.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		
//		game.font.draw(game.batch, "Ready to play Snake!", 100, 150);
//		game.font.draw(game.batch, "Tap to begin!", 100, 100);
//		
//		
		
		
		game.setBitmapFont("joystix.ttf", 80);
		CenteredText.draw("SNAKE!!", 320, game);
		drawColorOptions(415);
		game.setBitmapFont("joystix.ttf", 20);

		CenteredText.draw("Press Enter to", 200, game);
		CenteredText.draw("Start", 170, game);

		game.setBitmapFont("joystix.ttf", 12);

		CenteredText.draw("Press keys Up, Right, Down, Left to map new keys", 470, game);

		
		
		game.batch.end();
		
		if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER)) {
				game.setScreen(new PlayScreen(game));
				dispose();
		}
		
		
//		keyMap[keyIndex] = e.getKeyCode();
//		keyIndex++;
//		if (keyIndex > 3)
//			keyIndex = 0;

		
		
	}
	
	public void drawColorOptions(int colorY) {

		game.setBitmapFont("joystix.ttf", 45);
		
		game.g.setColor(Color.RED);
		game.font.draw(game.batch, "R", 50, colorY);
		game.g.setColor(Color.GREEN);
		game.font.draw(game.batch, "G", 140, colorY);
		game.g.setColor(Color.CYAN);
		game.font.draw(game.batch, "B", 230, colorY);
		game.g.setColor(Color.YELLOW);
		game.font.draw(game.batch, "Y", 315, colorY);
		game.g.setColor(Color.ORANGE);
		game.font.draw(game.batch, "O", 410, colorY);
		// game.g.setColor(Color.BLACK);
		// game.g.drawString("W", 500, colorY);

		game.g.setColor(Color.WHITE);

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
//		game.batch.dispose();
//		game.font.dispose();
//		game.g.dispose();
	}

}
