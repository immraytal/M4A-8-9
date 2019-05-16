package lab9;

import java.util.Scanner;

public class Mnk {
    public static void main(String[] args) {
        double[] x={1.000,
                1.050,
                1.100,
                1.150,
                1.200,
                1.250,
                1.300,
                1.350,
                1.400,
                1.450,
                1.500,
                1.550,
                1.600,
                1.650,
                1.700};
        double[] y={-12.00,
                -12.71,
                -13.45,
                -14.21,
                -15.00,
                -15.81,
                -16.65,
                -17.51,
                -18.40,
                -19.31,
                -20.25,
                -21.21,
                -22.20,
                -23.21,
                -24.25};

        double a, b;

        Service service=new Service();

        double[] ab=service.linearApproximation(x,y);

        double xin = 1.025;
        for(int i =0; i<x.length;i++)
        System.out.println("x[i] = " + x[i] + "  f[xi]" + y[i]  + "  S[i]" +  ( x[i]*x[i]*ab[0] + x[i]  *ab[1] + ab[2])    + "          razno = "  + (Math.abs((x[i]*x[i]*ab[0] + x[i]  *ab[1] + ab[2]) - y[i] )));

    }
}
