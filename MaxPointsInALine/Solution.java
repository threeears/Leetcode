// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.



import java.util.HashMap;
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
  
 
public class Solution {
    //my solution, O(n*n)
    // pair-wise comparison, take care of the duplicates
    public int maxPoints(Point[] points) {
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int flag=0;
        if(points.length==0) return 0;
        int max=1;
        
        for(int i=0; i<points.length;i++){
            //what if all the points are the same? duplicate calculation every round.
            map.clear();//clear the previous ks and its numbers
            flag=0;
            int cur=1;
            map.put((double)Integer.MAX_VALUE,1);
            for(int j=0;j<points.length;j++){
                if(i==j) continue;// same points
                if(points[i].x==points[j].x){// K=~
                	if(points[i].y==points[j].y)
                	{
                		//same point, every slop has to increase one
                		flag++;
                		continue;
                	}
                	int count = map.get((double)Integer.MAX_VALUE);
                    	count++;
                        map.put((double)Integer.MAX_VALUE,count);
                        cur=Math.max(count,cur);
                   
                }
                else{//regular k
                    double k = 1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
                     if(map.get(k)!=null){
                    	int count = map.get(k);
                    	count++;
                        map.put(k,count);
                        cur=Math.max(map.get(k),cur);
                    }
                    else{
                        map.put(k,2);
                        cur=Math.max(map.get(k),cur);
                    }
                }
                
            }
            // add flag to each key
            cur=cur+flag;
            max=Math.max(cur, max);
        }
        return max;
    }

    // from ninechapter, not the best time complexity though.
      public  int maxPoints2(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }  

        HashMap<Double, Integer> map=new HashMap<Double, Integer>();
        int max = 1;

        for(int i = 0 ; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);

            int dup = 0;
            for(int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key=points[j].x - points[i].x == 0 ? 
                    Integer.MAX_VALUE :
                    0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }

            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }

        }
        return max;
    }
}