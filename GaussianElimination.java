//package assignment_bvllr5;

public class GaussianElimination {
    private int rows;
    private int columns;
    private double[][] matrix;

    public GaussianElimination(int rows, int columns, double[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        if (matrix.length != rows || matrix[0].length != columns) {
            throw new IllegalArgumentException("Invalid matrix dimensions");
        }
        this.matrix = matrix;
    }

    public void rowEchelonForm() {
        for (int pivot = 0; pivot < rows; pivot++) {
            int maxRowIndex = argMax(pivot, pivot);
            swapRows(pivot, maxRowIndex);

            multiplyRow(pivot, pivot);

            for (int row = pivot + 1; row < rows; row++) {
                multiplyAndAddRow(row, pivot, pivot);
            }
        }
    }

    private int argMax(int startRow, int column) {
        int maxRowIndex = startRow;
        double maxValue = Math.abs(matrix[startRow][column]);

        for (int row = startRow + 1; row < rows; row++) {
            double value = Math.abs(matrix[row][column]);
            if (value > maxValue) {
                maxRowIndex = row;
                maxValue = value;
            }
        }

        return maxRowIndex;
    }

    private void swapRows(int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
        double ratio = matrix[addRow][colIndex] / matrix[mulRow][colIndex];

        for (int col = 0; col < columns; col++) {
            matrix[addRow][col] -= ratio * matrix[mulRow][col];
        }
    }

    private void multiplyRow(int rowIndex, int colIndex) {
        double factor = matrix[rowIndex][colIndex];

        for (int col = 0; col < columns; col++) {
            matrix[rowIndex][col] /= factor;
        }
    }

    public void backSubstitution() throws IllegalArgumentException{
        
        //int rows = matrix.length;

        for (int row = rows - 1; row >= 0; row--) {
            if (matrix[row][row] == 0) {
                // System.out.println("Setting diagonal element to zero: matrix[" + row + "][" + row + "]");
                // matrix[row][row] = 0;
                throw new IllegalArgumentException("System of equations has no unique solution");
            }
            else
            {
                for (int i = row - 1; i >= 0; i--) 
                {
                    multiplyAndAddRow(i, row, row);
                }
            }

           
        }
    }

    public void printEquations() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns - 1; col++) {
                System.out.print(matrix[row][col] + "x" + col + " + ");
            }
            System.out.println(matrix[row][columns - 1] + "x" + (columns - 1) + " = " + matrix[row][columns]);
        }
    }
}
