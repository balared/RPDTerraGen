import java.util.Comparator;


public abstract class MapPointComparator{

	public static int compareX(MapPoint mp1, MapPoint mp2){
		return ((Float)(mp1.getX())).compareTo(mp2.getX());
	}
	
	public static int compareY(MapPoint mp1, MapPoint mp2){
		return ((Float)(mp1.getY())).compareTo(mp2.getY());
	}

}
