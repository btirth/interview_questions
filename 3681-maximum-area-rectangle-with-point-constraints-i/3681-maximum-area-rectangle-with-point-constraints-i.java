class Solution {
    public int maxRectangleArea(int[][] points) {
        int max = -1;
        int len = points.length;
        
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k=j+1; k<len; k++) {
                    for(int l=k+1; l<len; l++) {
                        if(!valid(points[i], points[j], points[k], points[l], points)) {
                            continue;
                        }
                        if(points[i][0] == points[j][0] && points[k][0] == points[l][0]) {
                            if(points[i][1] == points[k][1] && points[j][1] == points[l][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[j][1]) * 
                                               Math.abs(points[i][0] - points[k][0]));
                            } else if(points[i][1] == points[l][1] && points[j][1] == points[k][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[j][1]) * 
                                               Math.abs(points[i][0] - points[l][0]));
                            }
                        } else if(points[i][0] == points[k][0] && points[j][0] == points[l][0]) {
                            if(points[i][1] == points[j][1] && points[k][1] == points[l][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[k][1]) * 
                                               Math.abs(points[i][0] - points[j][0]));
                            } else if(points[i][1] == points[l][1] && points[j][1] == points[k][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[k][1]) * 
                                               Math.abs(points[i][0] - points[l][0]));
                            }
                        } else if(points[i][0] == points[l][0] && points[j][0] == points[k][0]) {
                            if(points[i][1] == points[k][1] && points[j][1] == points[l][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[l][1]) * 
                                               Math.abs(points[i][0] - points[k][0]));
                            } else if(points[i][1] == points[j][1] && points[l][1] == points[k][1]) {
                                max = Math.max(max, 
                                               Math.abs(points[i][1] - points[l][1]) * 
                                               Math.abs(points[i][0] - points[j][0]));
                            }
                        }
                    }
                }
            }
        }
        
                                               
       return max;
    }
    
    boolean valid(int[] a, int[] b, int[] c, int[] d, int[][] points) {
        int minX = Math.min(Math.min(a[0], b[0]), Math.min(c[0], d[0]));
        int maxX = Math.max(Math.max(a[0], b[0]), Math.max(c[0], d[0]));
        int minY = Math.min(Math.min(a[1], b[1]), Math.min(c[1], d[1]));
        int maxY = Math.max(Math.max(a[1], b[1]), Math.max(c[1], d[1]));
        
        for(int[] point: points) {
            if((point[0] == a[0] && point[1] == a[1]) ||
                (point[0] == b[0] && point[1] == b[1]) ||
                (point[0] == c[0] && point[1] == c[1]) ||
                (point[0] == d[0] && point[1] == d[1])
              ) {
                continue;
            } 
                
            if (point[0] >= minX && point[0] <= maxX && point[1] >= minY && point[1] <= maxY) {
                return false; 
            }            
        }
        
        return true;
    }
}