//package assignment_bvllr5;

//import assignment_bvllr5.GaussianElimination;

public class EquationSolver {
        public static void main(String[] args) {
            if (args.length == 0) {
                System.out.println("No equations provided.");
                return;
            }

            String[] equationStrings = args[0].split(" ");
            double[][] matrix = new double[equationStrings.length][];

            for (int i = 0; i < equationStrings.length; i++) {
                String[] equationCoefficients = equationStrings[i].split(",");
                matrix[i] = stringsToDoubles(equationCoefficients);
            }

            GaussianElimination gaussianElimination = new GaussianElimination(matrix.length, matrix[0].length - 1, matrix);
            gaussianElimination.printEquations();

            gaussianElimination.rowEchelonForm();
            gaussianElimination.printEquations();

            gaussianElimination.backSubstitution();
            gaussianElimination.printEquations();
        }

        private static double[] stringsToDoubles(String[] strings) {
            double[] doubles = new double[strings.length];
            for (int i = 0; i < strings.length; i++) {
                doubles[i] = Double.parseDouble(strings[i]);
            }
            return doubles;
        }
    }