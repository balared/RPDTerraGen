import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class HeightmapGeneration {
	
	public static MapPoint[] createMap(float densityFactor, int width, int height, int seed){
		return seedPoints(densityFactor, width, height, seed);
	}
	
	private static MapPoint[] seedPoints(float densityFactor, int width, int height, int seed){
		
		ArrayList<MapPoint> points = new ArrayList<MapPoint>();
		int numPoints = (int) (width * height * densityFactor); 
		
		for(int i = 0; i < numPoints; i++){
			points.add(new MapPoint(width, height, seed));
		}
		
		return points.toArray(new MapPoint[points.size()]);
	}
	
	public static float getPoint(int x, int y, MapPoint[] keysByX, MapPoint[] keysByY, int seed){
		int xBefore = MapPointSorterSearcher.linearSearchX(keysByX, x);
		int xAfter = xBefore + 1;
		int yBefore = MapPointSorterSearcher.linearSearchY(keysByY, y);;
		int yAfter = yBefore + 1;
		Random r = new Random(seed);
		
		return (keysByX[xBefore].getMagnitude() + 
				keysByX[xAfter].getMagnitude() + 
				keysByY[yBefore].getMagnitude() + 
				keysByY[yAfter].getMagnitude()) / 4f
				* (r.nextFloat() / 10f + 0.95f);
	}
	
}
