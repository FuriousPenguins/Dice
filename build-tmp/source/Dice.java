import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int sizeXY = 80;
int sum;
int ellipseSize = 10;
int center = sizeXY/2;
public void setup()
{
	size(500,600);
	noLoop();
}
public void draw()
{
	background(255);
	sum = 0;
	for(int x=50;x<=500;x+=150) {
		Die newDie = new Die(x,50);
		newDie.show();
		newDie.roll();
	}
	for(int x=50;x<=500;x+=150) {
		Die newDie = new Die(x,200);
		newDie.show();
		newDie.roll();
	}
	for(int x=50;x<=500;x+=150) {
		Die newDie = new Die(x,350);
		newDie.show();
		newDie.roll();
	}
	textSize(32);
	fill(0);
	text("The Sum:" + sum,150,550);


}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int initialX;
	int initialY;
	
	int randomN;
	int spotX;
	int spotY;
	//variable declarations here
	Die(int x, int y) //constructor
	{
		initialX = x;
		initialY = y;
		//variable initializations here
	}
	public void roll()
	{
		randomN = ((int)((Math.random()*6)+1));
		sum += randomN;
		// randomN = 6;
		strokeWeight(3);
		stroke((int)((Math.random()*251)+50),(int)((Math.random()*251)+50),(int)((Math.random()*251)+50));
		if (randomN == 1) {
			spotX = initialX + center;
			spotY = initialY + center;
			ellipse(spotX,spotY,ellipseSize,ellipseSize);
		}
		else if (randomN == 2) {
			for(int i=1;i < 4; i+=2){
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*i);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
		}
		else if (randomN == 3) {
			for(int i=1; i<4; i++) {
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*i);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
		}
		else if (randomN == 4) {
			for(int i=1; i<4; i+=2){
				spotX = initialX + ((center/2)*i);
				spotY = initialY + (center/2);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
			for(int i=1; i<4; i+=2) {
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*3);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
		}
		else if (randomN == 5) {
			for(int i=1; i<4; i+=2){
				spotX = initialX + ((center/2)*i);
				spotY = initialY + (center/2);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
			for(int i=1; i<4; i+=2) {
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*3);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
			spotX = initialX + center;
			spotY = initialY + center;
			ellipse(spotX,spotY,ellipseSize,ellipseSize);
		}
		else if (randomN == 6) {
			for(int i=1; i<4; i+=2){
				spotX = initialX + ((center/2)*i);
				spotY = initialY + (center/2);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
			for(int i=1; i<4; i+=2) {
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*3);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
			for(int i=1;i<4;i+=2) {
				spotX = initialX + ((center/2)*i);
				spotY = initialY + ((center/2)*2);
				ellipse(spotX,spotY,ellipseSize,ellipseSize);
			}
		}
	}
	public void show()
	{
		fill((int)((Math.random()*251)+50),(int)((Math.random()*251)+50),(int)((Math.random()*251)+50));
		rect(initialX, initialY, sizeXY, sizeXY);
		//your code here
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
