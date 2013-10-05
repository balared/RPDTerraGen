import java.util.ArrayList;
import java.util.Arrays;


public abstract class MapPointSorterSearcher {

	public static MapPoint[] sortX(MapPoint[] preSort){
		if(preSort.length <= 1)
			return preSort;
		
		ArrayList<MapPoint> left = new ArrayList<MapPoint>();
		ArrayList<MapPoint> right = new ArrayList<MapPoint>();		
		MapPoint[] postSort = preSort.clone();
		
		int pivot = (postSort.length - 1) / 2;

		for(MapPoint n : preSort){
			if(n != postSort[pivot]){
				if(MapPointComparator.compareX(n, postSort[pivot]) > 0)
					right.add(n);
				else
					left.add(n);
			}
		}

		MapPoint[] leftArray = new MapPoint[left.size()];
		sortX(left.toArray(leftArray));
		MapPoint[] rightArray = new MapPoint[right.size()];
		sortX(right.toArray(rightArray));
		
		MapPoint[] sortedArray = new MapPoint[leftArray.length + rightArray.length + 1];
		System.arraycopy(leftArray, 0, sortedArray, 0, leftArray.length);
		sortedArray[pivot] = postSort[pivot];
		System.arraycopy(rightArray, 0, sortedArray, leftArray.length + 1, rightArray.length);
		
		return sortedArray;
	}

	public static MapPoint[] sortY(MapPoint[] preSort){
		if(preSort.length <= 1)
			return preSort;
		
		ArrayList<MapPoint> left = new ArrayList<MapPoint>();
		ArrayList<MapPoint> right = new ArrayList<MapPoint>();		
		MapPoint[] postSort = preSort.clone();
		
		int pivot = (postSort.length - 1) / 2;

		for(MapPoint n : preSort){
			if(MapPointComparator.compareY(n, postSort[pivot]) > 0)
				right.add(n);
			else
				left.add(n);
		}

		MapPoint[] leftArray = new MapPoint[left.size()];
		sortX(left.toArray(leftArray));
		MapPoint[] rightArray = new MapPoint[right.size()];
		sortX(right.toArray(rightArray));
		
		MapPoint[] sortedArray = new MapPoint[leftArray.length + rightArray.length + 1];
		System.arraycopy(leftArray, 0, sortedArray, 0, leftArray.length);
		sortedArray[pivot] = postSort[pivot];
		System.arraycopy(rightArray, 0, sortedArray, leftArray.length + 1, rightArray.length);
		
		return sortedArray;
	}
	
	public static int linearSearchX(MapPoint[] keys, int desired){
		for(int i = 0; i < keys.length; i++)
			if(keys[i].getX() > desired)
				return i;
		
		return keys.length - 1;
	}
	
	public static int linearSearchY(MapPoint[] keys, int desired){
		for(int i = 0; i < keys.length; i++)
			if(keys[i].getY() > desired)
				return i;
		
		return keys.length - 1;
	}
}
