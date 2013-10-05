
public class RandomPointDisplacement {
	
	public static void main(String args[]){
		int height = 100;
		int width = 100;
		int seed = 1234567;
		MapPoint[] rawPoints = HeightmapGeneration.createMap(0.001f, width, height, seed);
		MapPoint[] widthOrdered = MapPointSorterSearcher.sortX(rawPoints);
		MapPoint[] heightOrdered = MapPointSorterSearcher.sortY(rawPoints);
		
		for(int i = 0; i < width ; i++){
			
			for(int j = 0; j < height; j++){
				
				System.out.print("[" + ((Float)(HeightmapGeneration.getPoint(i,  j, widthOrdered, heightOrdered, seed))).toString().substring(0, 4) + "]");
			}
			
			System.out.println();
		}
	}
}
