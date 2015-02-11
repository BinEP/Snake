package com.Stoffel.snakeColor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Snake extends Game {

	public SpriteBatch batch;
	public ShapeRenderer g;
	public BitmapFont font;
	
	public int score;
	public int width = Window.WIDTH;
	public int height = Window.HEIGHT;
	
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		g = new ShapeRenderer();
		g.setAutoShapeType(true);
		font = new BitmapFont();
		setBitmapFont("joystix.ttf");
		
		this.setScreen(new TitleScreen(this));
	}
	
	public void setBitmapFont(String ttfFile) {
		
		FreeTypeFontGenerator fontGen = new FreeTypeFontGenerator(Gdx.files.internal(ttfFile));
		FreeTypeFontParameter fontPar = new FreeTypeFontParameter();
		
		font = fontGen.generateFont(fontPar);
		fontGen.dispose();
	}
	
	public void setBitmapFont(String ttfFile, int size) {
		
		FreeTypeFontGenerator fontGen = new FreeTypeFontGenerator(Gdx.files.internal(ttfFile));
		FreeTypeFontParameter fontPar = new FreeTypeFontParameter();
		
		fontPar.size = size;
		
		font = fontGen.generateFont(fontPar);
		fontGen.dispose();		
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose() {
		
		batch.dispose();
		g.dispose();
		font.dispose();
	}
}
