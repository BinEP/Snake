package com.Stoffel.snakeColor;

import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;

public class EndGameScreen implements Screen {

	public Snake game;
	public int score;
	
	public EndGameScreen(Snake gam, int score) {
		game = gam;
		this.score = score;
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		game.setBitmapFont("joystix.ttf", 40);
		game.g.setColor(Color.WHITE);
		CenteredText.draw(String.valueOf(score), 450, game);

		game.setBitmapFont("joystix.ttf", 60);

		CenteredText.draw("You Lose!", 170, game);

		game.setBitmapFont("joystix.ttf", 26);

		CenteredText.draw("Enter to Restart", 320, game);
		
		if (Gdx.input.isKeyPressed(Keys.ENTER)) {
			
			game.setScreen(new TitleScreen(game));
			dispose();
		}
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
