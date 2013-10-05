import java.util.Random;


public class MapPoint {
	private float[] coords;
	private float mag;


	public float[] getCoordinates() {
		return coords;
	}
	
	public float getX(){
		return coords[0];
	}
	
	public float getY(){
		return coords[1];
	}
	
	public void setX(float newX){
		coords[0] = newX;
	}
	
	public void getY(float newY){
		coords[1] = newY;
	}

	public void setCoordinates(float[] coordinates) {
		this.coords = coordinates;
	}

	public float getMagnitude() {
		return mag;
	}

	public void setMagnitude(float magnitude) {
		this.mag = magnitude;
	}

	public MapPoint(float[] coordinates, float magnitude){
		coords = coordinates;
		mag = magnitude;
	}

	public MapPoint(float x, float y, float magnitude){
		coords = new float[]{x,y};
		mag = magnitude;
	}

	public MapPoint(int width, int height, int seed){
		Random r = new Random(seed);
		coords = new float[]{r.nextFloat(), r.nextFloat()};
		mag = r.nextFloat();
	}
}
