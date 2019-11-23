package arraysAndString;

public class CTCI_1_8_1 {
	void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] collum = new boolean[matrix[0].length];
		
		//find the rows and collums which have zeros 
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j] == 0) {
					row[i] = true;
					collum[j] = true;
				}
			}
		}
		
		for(int i=0;i<row.length;i++) {
			if(row[i] == true) {
				nullifyRows(matrix, i);
			}
		}
		
		for(int j=0; j<collum.length; j++) {
			if(collum[j] == true) {
				nullifyCollums(matrix, j);
			}
		}
	}
	
	void nullifyRows(int[][] matrix, int row) {
		for(int i=0; i<matrix[0].length;i++) {
			matrix[row][i] = 0;
		}
	}
	
	void nullifyCollums(int[][] matrix, int collum) {
		for(int i=0; i<matrix.length; i++) {
			matrix[i][collum] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{11,12,13,14},
				  		  {15, 0,17,18},
				  		  {19,20, 0,22},
				  		  {23,24,25,26}
				};

		CTCI_1_8_1 a = new CTCI_1_8_1();

		System.out.println("Matrix before set Zeros");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Matrix after 90 degree rotation");
		
		a.setZeros(matrix);

		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
