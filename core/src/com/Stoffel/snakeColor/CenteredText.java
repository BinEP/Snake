package com.Stoffel.snakeColor;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;

/*
 *  this seems like an odd way to go about this.
 *  I'd expect something more like GuiUtil.centerText(String text, Graphics g).
 *  Or just use a JLabel and set its horizontal alignment.
 */
public class CenteredText {
	
	public static void draw(String text, int yVal, Snake game) {

		int width = Window.WIDTH;
		int height = Window.HEIGHT;
		
		TextBounds fontInfo =  game.font.getBounds(text);
		
		int textWidth = (int) fontInfo.width;
		int textHeight = (int) fontInfo.height;

		int x = (width - textWidth) / 2;
		int y = (height - textHeight) / 2;
		
		game.font.draw(game.batch, text, x, yVal);

	}
	
	public static void draw(String text, Rectangle r, Snake game) {

		TextBounds fontInfo =  game.font.getBounds(text);
		
		int textWidth = (int) fontInfo.width;
		int textHeight = (int) fontInfo.height;

		int x = r.x + (r.width - textWidth) / 2;
		int y = r.y + (r.height - textHeight) / 2;
		
		game.font.draw(game.batch, text, x, y);

	}
	
	

}
