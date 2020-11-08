package com.dhb.tank;

import java.awt.*;

public class Tank {
	public static final int SPEED = 10;
	private int x;
	private int y;
	private Dir dir = Dir.DOWN;

	private boolean living = true;

	public static final int WIDTH = ResourseMgr.tankD.getWidth();
	public static final int HEIGHT = ResourseMgr.tankD.getHeight();

	private boolean moveing = false;

	private TankFrame tf = null;


	public Tank(int x, int y,Dir dir,TankFrame tf) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}

	public void die() {
		this.living = false;
	}

	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
			return;
		}
		switch(dir){
			case LEFT:
				g.drawImage(ResourseMgr.tankL,x,y,null);
				break;
			case RIGHT:
				g.drawImage(ResourseMgr.tankR,x,y,null);
				break;
			case DOWN:
				g.drawImage(ResourseMgr.tankD,x,y,null);
				break;
			case UP:
				g.drawImage(ResourseMgr.tankU,x,y,null);
				break;

			default:
				break;
		}
		this.move();
	}

	public void fire() {
		int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		tf.bullets.add( new Bullet(bX,bY,this.dir,tf));
	}

	private void move() {
		if(isMoveing()) {
			switch (dir) {
				case LEFT:
					x -= SPEED;
					break;
				case RIGHT:
					x += SPEED;
					break;
				case UP:
					y -= SPEED;
					break;
				case DOWN:
					y += SPEED;
					break;
				default:
					break;
			}
		}
	}

	public boolean isMoveing() {
		return moveing;
	}

	public void setMoveing(boolean moveing) {
		this.moveing = moveing;
	}

	public static int getSPEED() {
		return SPEED;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}
}
