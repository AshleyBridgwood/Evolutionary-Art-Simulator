package main;

public class Line {
	//Start of the line
	int x1;
	int y1;
	//End of the line
	int x2;
	int y2;
	
	public Line(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public int getX1(){
		return x1;
	}
	
	public int getY1(){
		return y1;
	}
	
	public int getX2(){
		return x2;
	}
	
	public int getY2(){
		return y2;
	}
	
	public void setX1(int change){
		x1 = change;
	}
	
	public void setY1(int change){
		y1 = change;
	}
	
	public void setX2(int change){
		x2 = change;
	}
	
	public void setY2(int change){
		y2 = change;
	}
	
	public String toString(){
		return x1 + ", " + y1 + ", " + x2 + ", " + y2;
	}
}
