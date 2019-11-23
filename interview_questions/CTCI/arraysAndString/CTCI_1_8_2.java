package arraysAndString;

public class CTCI_1_8_2 {
	void setZeros(int[][] matrix) {
		boolean firstRow = false;
		boolean firstCollum= false;
		
		//check if first row has zero
		for(int i=0; i<matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				firstRow = true;
				break;
			}
		}
		
		//check if first collum has zero
		for(int i=1; i<matrix.length; i++) {
			if(matrix[i][0] == 0) {
				firstCollum = true;
				break;
			}
		}
		
		for(int i=1; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j]==0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				nullifyCollums(matrix, i);
			}
		}
		
		for(int i=1; i<matrix.length; i++) {
			if(matrix[i][0] == 0) {
				nullifyRows(matrix, i);
			}
		}
		
		if(firstRow) {
			nullifyRows(matrix, 0);
		}
		
		if(firstCollum) {
			
			nullifyCollums(matrix, 0);
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
		  		  {0,24,25,26}
		};

		CTCI_1_8_2 a = new CTCI_1_8_2();

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
