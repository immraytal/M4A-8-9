package lab8;

import java.util.Scanner;

public class spline {


            public static double f (double x)
            {
                return Math.sqrt(x);
            }
            public static double[][] Spline(double[] X, double[] Y)
            {
                int n = X.length - 1;
                double[] a1 = new double[X.length];
                double[] a2 = new double[X.length];
                a1[0] = (Y[1] - Y[0]) / (X[1] - X[0]);
                for (int i = 0; i < n; i++)
                {
                    a1[i + 1] = 2 * (Y[i + 1] - Y[i]) / (X[i + 1] - X[i]) - a1[i];
                    a2[i] = (a1[i + 1] - a1[i]) / 2 * (X[i + 1] - X[i]);
                }
                a2[n - 1] = (Y[n] - Y[n - 1] - a1[n - 1] * (X[n] - X[n - 1])) / Math.pow((X[n] - X[n - 1]), 2);


                double[][] result = {a1, a2};
                return result;
            }

            public static void main(String[] args) {
                               double[] X = {9.00, 9.30, 9.60, 9.90, 10.20, 10.50, 10.80, 11.10, 11.40, 11.70};
                double[] Y = {3.00 ,3.05 ,3.10 ,3.15 ,3.19 ,3.24 ,3.29 ,3.33 ,3.38 ,3.42};
                double[] A1;
                double[] A2;

                double[][] res = Spline(X, Y);
                A1 = res[0];
                A2 = res[1];


                    System.out.println("ENTER X");
                    double x = Double.parseDouble(new Scanner(System.in).nextLine());
                    for (int i = 0; i < X.length; i++) {
                        if (x <= X[i + 1]) {
                            double sum = Y[i] + A1[i] * (x - X[i]) + A2[i] * Math.pow((x - X[i]), 2);
                            System.out.println("A1[" + i + "]=" + A1[i]);
                            System.out.println("A2[" + i + "]=" + A2[i]);
                            System.out.println("S(x)=" + sum);
                            break;
                        }
                    }

                for (int i = 0; i < X.length; i++) {
                    double sum = Y[i] + A1[i] * (X[i] - X[i]) + A2[i] * Math.pow((X[i] - X[i]), 2);
                    System.out.println("f(x" + i+ ") =" + f(X[i]) + "\tP(x" + i + ") = " + sum + "\t|f(x" + i + ") - P(x" + i + ")| = " + Math.abs(f(X[i]) - sum));
                }

            }

}
