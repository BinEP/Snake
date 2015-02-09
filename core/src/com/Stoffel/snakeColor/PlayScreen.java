package com.Stoffel.snakeColor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PlayScreen implements Screen {

	public Snake game;
	
	public enum Fruits {
		
		apple (new Fruit(Gdx.files.internal("apple.png")), Color.RED), 
		orange (new Fruit(Gdx.files.internal("orange.png")), Color.ORANGE), 
		strawberry (new Fruit(Gdx.files.internal("strawberry.png")), Color.RED), 
		pear (new Fruit(Gdx.files.internal("pear.png")), Color.GREEN), 
		banana (new Fruit(Gdx.files.internal("banana.png")), Color.YELLOW), 
		watermelon (new Fruit(Gdx.files.internal("watermelon.png")), Color.GREEN);
		
		public Fruit fruit;
		
		private Fruits(Fruit f, Color c) {
			fruit = f;
			fruit.color = c;
		}
	}

	
	public PlayScreen(Snake gam) {

		game = gam;
		
		randFruitSetup();
		resetBody();
		// timer.start();

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		moves();

		game.batch.begin();
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(15));
		g2.drawRect(0, 0, 499, 477);
		g2.setStroke(new BasicStroke(2));

		if (playing || paused) {

			g.setFont(new Font("Joystix", Font.BOLD, 40));
			g.setColor(Color.WHITE);
			CenteredText score1 = new CenteredText(String.valueOf(score), 500,
					500, g, true, 450);
			int i = 0;
			for (Point body : snakeBody) {

				g.setColor(snakeColor.get(i));
				i++;
				g.fillRect(body.x, body.y, bodySize, bodySize);
				g.setColor(Color.BLACK);
				g.drawRect(body.x, body.y, bodySize, bodySize);

			}
			for (i = 0; i < fruitX.size(); i++) {
				g.setColor(Color.BLACK);
				int fx = fruitX.get(i);
				int fy = fruitY.get(i);
				g.drawRect(fx, fy, bodySize, bodySize);

				// g.setColor(Color.WHITE);
				g.setColor(fruitColor.get(i));

				g.fillRect(fx + 1, fy + 1, bodySize - 2, bodySize - 2);

			}
			if (paused) {
				g.setFont(new Font("Joystix", Font.BOLD, 60));
				g.setColor(Color.WHITE);
				CenteredText pause = new CenteredText("Paused", 500, 500, g,
						true, 200);

				drawColorOptions(g, 300);
			}

		}

		game.batch.end();

		if (Gdx.input.isKeyPressed(upKey)) up();
		if (Gdx.input.isKeyPressed(downKey)) down();
		if (Gdx.input.isKeyPressed(leftKey)) left();
		if (Gdx.input.isKeyPressed(rightKey)) right();
		
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {

			playing = !playing;
			paused = !paused;
		}

		if (Gdx.input.isKeyPressed(Keys.R))
			fruitColor.set(randFruitNum(), Color.RED);

		if (Gdx.input.isKeyPressed(Keys.G))
			fruitColor.set(randFruitNum(), Color.GREEN);

		if (Gdx.input.isKeyPressed(Keys.B))
			fruitColor.set(randFruitNum(), Color.CYAN);

		if (Gdx.input.isKeyPressed(Keys.Y))
			fruitColor.set(randFruitNum(), Color.YELLOW);

		if (Gdx.input.isKeyPressed(Keys.O))
			fruitColor.set(randFruitNum(), Color.ORANGE);

		if (Gdx.input.isKeyPressed(Keys.W))
			fruitColor.set(randFruitNum(), Color.WHITE);

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
	
	
	private boolean playing = false;
	private boolean paused = false;

	private ArrayList<Point> snakeBody = new ArrayList<Point>();
	private ArrayList<Color> snakeColor = new ArrayList<Color>();

	private Color[] Colors = { Color.CYAN, Color.RED, Color.GREEN,
			Color.YELLOW, Color.ORANGE, Color.WHITE };
	private int bodySize = 10;
	private Point head = new Point(250, 250);
	private int numOfFruits = 4;

	private ArrayList<Integer> fruitX = new ArrayList<Integer>();
	private ArrayList<Integer> fruitY = new ArrayList<Integer>();

	private ArrayList<Color> fruitColor = new ArrayList<Color>();
	
	private ArrayList<Fruit> fruits = new ArrayList<Fruit>();

	private int deltaX = 0;
	private int deltaY = -bodySize;

	private final Point LEFT = new Point(-bodySize, 0);
	private final Point RIGHT = new Point(bodySize, 0);
	private final Point UP = new Point(0, -bodySize);
	private final Point DOWN = new Point(0, bodySize);
	private Point direction = new Point(deltaX, deltaY);

	private Point nextHead = new Point(head.x + deltaX, head.y + deltaY);

	private int upKey = KeyEvent.VK_UP;
	private int downKey = KeyEvent.VK_DOWN;
	private int leftKey = KeyEvent.VK_LEFT;
	private int rightKey = KeyEvent.VK_RIGHT;

	private int[] keyMap = { KeyEvent.VK_UP, KeyEvent.VK_RIGHT,
			KeyEvent.VK_DOWN, KeyEvent.VK_LEFT };

	private int keyIndex = 0;

	// private Timer timer;
	private int origSpeed = bodySize;
	private double speed = origSpeed;

	private int score = 0;


	public void moves() {

		if (playing) {

			head.x += deltaX;
			head.y += deltaY;
			nextHead = new Point(head.x + deltaX, head.y + deltaY);

			for (int i = snakeBody.size() - 1; i > 0; i--) {

				if (head.x == snakeBody.get(i).x
						&& head.y == snakeBody.get(i).y) {
					playing = false;
				}
				snakeBody.set(i, snakeBody.get(i - 1));

			}

			snakeBody.set(0, new Point(head.x, head.y));

			for (int i = 0; i < fruitX.size(); i++) {
				int fx = fruitX.get(i);
				int fy = fruitY.get(i);
				if (Math.abs(head.x - fx) < 5 && Math.abs(head.y - fy) < 5) {
					addBodySquare(i);
				}
			}

			if (head.x < 1 || head.x > 485 || head.y < 8 || head.y > 465) {

				playing = false;
			}

		}
	}

	public void up() {

		if (deltaY != bodySize) {
			deltaX = 0;
			deltaY = -bodySize;
		}

		// allowedMoves(UP);

	}

	public void down() {

		if (deltaY != -bodySize) {
			deltaX = 0;
			deltaY = bodySize;
		}

		// allowedMoves(DOWN);
	}

	public void left() {

		if (deltaX != bodySize) {
			deltaX = -bodySize;
			deltaY = 0;
		}

		// allowedMoves(LEFT);

	}

	public void right() {

		if (deltaX != -bodySize) {
			deltaX = bodySize;
			deltaY = 0;
		}

		// allowedMoves(RIGHT);

	}

	public void upOrDown(int i) {

		if (i > 0) {

			up();

		} else {

			down();

		}
	}

	public void leftOrRight(int i) {

		if (i < 0) {

			right();

		} else {

			left();

		}
	}

	public void nextHeadSet() {

		nextHead = new Point(head.x + deltaX, head.y + deltaY);

	}

	public Point setDirection() {

		direction = new Point(deltaX, deltaY);
		return direction;
	}

	public void setDelta(Point p) {

		deltaX = p.x;
		deltaY = p.y;

	}

	public Point getDirection() {

		return new Point(deltaX, deltaY);
	}

	public void allowedMoves(Point d) {

		ArrayList<Point> invalidDirections = new ArrayList<Point>();

		// if (direction.equals(LEFT)) invalidDirections.add(RIGHT);
		// if (direction.equals(RIGHT)) invalidDirections.add(LEFT);
		// if (direction.equals(UP)) invalidDirections.add(DOWN);
		// if (direction.equals(DOWN)) invalidDirections.add(UP);

		Point head = this.head;

		// Check Up

		if (snakeBody.contains(new Point(head.x + UP.x, head.y + UP.y))) {

			invalidDirections.add(UP);

		}

		// Check Down

		if (snakeBody.contains(new Point(head.x + DOWN.x, head.y + DOWN.y))) {

			invalidDirections.add(DOWN);

		}

		// Check Left

		if (snakeBody.contains(new Point(head.x + LEFT.x, head.y + LEFT.y))) {

			invalidDirections.add(LEFT);

		}

		// Check Right

		if (snakeBody.contains(new Point(head.x + RIGHT.x, head.y + RIGHT.y))) {

			invalidDirections.add(RIGHT);

		}

		if (!invalidDirections.contains(d)) {

			setDelta(d);

		}

	}

	public void addBodySquare(int fruitIndex) {

		int lastBodyX = snakeBody.get(snakeBody.size() - 1).x;
		int lastBodyY = snakeBody.get(snakeBody.size() - 1).y;
		int secondLastBodyX = snakeBody.get(snakeBody.size() - 2).x;
		int secondLastBodyY = snakeBody.get(snakeBody.size() - 2).y;

		int changeX = lastBodyX - secondLastBodyX;
		int changeY = lastBodyY - secondLastBodyY;

		snakeBody.add(new Point(lastBodyX + changeX, lastBodyY + changeY));
		snakeColor.add(fruits.get(fruitIndex).color);
		
		addGoodFruit(fruitIndex);
		
		speed += .5;

		// TODO Auto-generated method stub

		//
		// timer.setDelay((int) (1000.0 / speed));
		//

		score++;

	}

	public void resetBody() {

		snakeBody.clear();
		snakeColor.clear();
		snakeBody.add(new Point(250, 250));
		snakeBody.add(new Point(250, 260));
		snakeBody.add(new Point(250, 270));
		snakeBody.add(new Point(250, 280));

		for (int i = 0; i < snakeBody.size(); i++) {
			// Whoop
			// snakeColor.add(randColor());
			snakeColor.add(Color.WHITE);

		}

		head.x = 250;
		head.y = 250;
		deltaY = -bodySize;
		deltaX = 0;
		speed = origSpeed;

		// TODO Auto-generated method stub

		//
		//
		// timer.setDelay((int) (1000.0 / speed));
		//

	}

	public void setKeys() {

		upKey = keyMap[0];
		rightKey = keyMap[1];
		downKey = keyMap[2];
		leftKey = keyMap[3];

	}

	public int randNum() {

		return ((int) (Math.random() * 45)) * 10 + 10;
	}

	public void randFruitSetup() {

		fruits.clear();
		for (int i = 0; i < numOfFruits; i++) {
			
			fruits.add(newRandomFruit());
			
		}

	}
	
	public Fruit newRandomFruit() {
		
		Fruit newFruit;
		int r = MathUtils.random(Fruits.values().length - 1);
		
		newFruit = Fruits.values()[r].fruit;
		
		newFruit.x = randNum();
		newFruit.y = randNum();
		
		return newFruit;
		
	}
	
public Fruit newRandomFruit(int x, int y) {
		
		Fruit newFruit;
		int r = MathUtils.random(Fruits.values().length - 1);
		
		newFruit = Fruits.values()[r].fruit;
		
		newFruit.x = x;
		newFruit.y = y;
		
		return newFruit;
		
	}

	public int randFruitNum() {

		return (int) (Math.random() * fruitColor.size());
	}

	public void addGoodFruit(int fruitIndex) {

		int x = randNum();
		int y = randNum();

		if (deltaX != 0 && head.y == y) {

			if (deltaX > 0) {

				while (x < head.x) {

					x = randNum();

				}

			} else {

				while (x > head.x) {

					x = randNum();

				}

			}

		} else if (deltaY != 0 && head.x == x) {

			if (deltaY > 0) {

				while (y < head.y) {

					y = randNum();

				}

			} else {

				while (y > head.x) {

					y = randNum();

				}

			}

		}

		fruits.set(fruitIndex, newRandomFruit(x, y));

	}

	public void drawColorOptions(Graphics g, int colorY) {

		g.setFont(new Font(Font.DIALOG, Font.BOLD, 45));
		g.setColor(Color.RED);
		g.drawString("R", 50, colorY);
		g.setColor(Color.GREEN);
		g.drawString("G", 140, colorY);
		g.setColor(Color.CYAN);
		g.drawString("B", 230, colorY);
		g.setColor(Color.YELLOW);
		g.drawString("Y", 315, colorY);
		g.setColor(Color.ORANGE);
		g.drawString("O", 410, colorY);
		// g.setColor(Color.BLACK);
		// g.drawString("W", 500, colorY);

		g.setColor(Color.WHITE);

	}

}
