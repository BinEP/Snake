package com.Stoffel.snakeColor;

import java.awt.Color;
import java.awt.Font;

import com.badlogic.gdx.Screen;

public class EndGameScreen implements Screen {

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		g.setFont(new Font("Joystix", Font.BOLD, 40));
		g.setColor(Color.WHITE);
		CenteredText score1 = new CenteredText(String.valueOf(score), 500,
				500, g, true, 450);

		g.setFont(new Font("Joystix", Font.BOLD, 60));

		CenteredText lose = new CenteredText("You Lose!", 500, 500, g,
				true, 170);

		g.setFont(new Font("Joystix", Font.BOLD, 26));

		CenteredText restart = new CenteredText("Enter to Restart", 500,
				500, g, true, 320);
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
