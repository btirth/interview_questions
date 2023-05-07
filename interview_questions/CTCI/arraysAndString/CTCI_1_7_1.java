 // rotate the matrix 90 degree


package arraysAndString;

public class CTCI_1_7_1 {
	
	int[][] rotateMatrix(int[][] matrix){
		int n = matrix.length;
		
		for(int layer=0;layer<n/2;layer++) {
			
			int first = layer;
			int last = n-1-layer;
			
			for(int i=first; i<last; i++) {
				
				int offset = i-first;
				
				//save top
				int top = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last-offset][first] = matrix[last-offset][last];
				
				//right -> bottom
				matrix[last-offset][last] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top;
			}
		}
		
		return matrix;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{11,12,13,14},
						  {15,16,17,18},
						  {19,20,21,22},
						  {23,24,25,26}
						};
		
		CTCI_1_7_1 a = new CTCI_1_7_1();
		
		System.out.println("Matrix before rotation");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Matrix after 90 degree rotation");
		int[][] rotateMatrix = a.rotateMatrix(matrix);
		
		for(int i=0;i<rotateMatrix.length;i++) {
			for(int j=0;j<rotateMatrix.length;j++) {
				System.out.print(rotateMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
