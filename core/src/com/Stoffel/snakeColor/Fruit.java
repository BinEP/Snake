package com.Stoffel.snakeColor;

//import java.awt.Color;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Fruit extends Texture {

	public int x;
	public int y;
	
	public Rectangle r = new Rectangle(x, y, 10, 10);
	
	public Color color;
	
	
	public Fruit(FileHandle file) {
		super(file);
		// TODO Auto-generated constructor stub
	
	}
	
	public Fruit(FileHandle file, Color c) {
		super(file);
		color = c;
		// TODO Auto-generated constructor stub
	
	}
	
	public Fruit(FileHandle file, int x, int y, Color color) {
		super(file);
		this.x = x;
		this.y = y;
		r.x = x;
		r.y = y;
		this.color = color;
		
	}
	
}
