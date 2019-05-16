package lab9;

public class Service {
        public double[] methodKramer(double[][] mat) {

            double det = (mat[1][1]*mat[2][2]*mat[3][3]) + (mat[1][3]*mat[2][1]*mat[3][2]) + (mat[3][1]*mat[1][2]*mat[2][3]) - (mat[1][3]*mat[2][2]*mat[3][1]) - (mat[1][1]*mat[3][2]*mat[2][3]) - (mat[3][3]*mat[1][2]*mat[2][1]);
            double detX = (mat[4][1]*mat[2][2]*mat[3][3]) + (mat[4][3]*mat[1][2]*mat[2][3]) + (mat[1][3]*mat[4][2]*mat[3][2]) - (mat[1][3]*mat[2][2]*mat[4][3]) -(mat[4][1]*mat[2][3]*mat[3][2]) - (mat[3][3]*mat[4][2]*mat[1][2]);
            double detY = (mat[1][1]*mat[4][2]*mat[3][3]) + (mat[2][1]*mat[4][3]*mat[1][3]) + (mat[4][1]*mat[2][3]*mat[3][1]) - (mat[1][3]*mat[4][2]*mat[3][1]) - (mat[1][1]*mat[2][3]*mat[4][3]) - (mat[3][3]*mat[4][1]*mat[2][1]);
            double detZ = (mat[1][1]*mat[2][2]*mat[4][3]) + (mat[3][1]*mat[1][2]*mat[4][2]) + (mat[4][1]*mat[2][1]*mat[3][2]) - (mat[4][1]*mat[2][2]*mat[3][1])- (mat[1][1]*mat[4][2]*mat[3][2]) - (mat[4][3]*mat[1][2]*mat[2][1]);
            double[] res = new double[3];
            res[0] = detX/det;
            res[1] = detY/det;
            res[2] = detZ/det;
            return  res;

        }

    public double[] linearApproximation(double[] x,double[] y)
    {
        double Mx = 0, My = 0, Mx2 = 0, Mxy = 0, Mx3 = 0, Mx4 =0, Mx2y=0;
        for (int i = 0; i < y.length; i++)
        {
            Mx = Mx + x[i];
            My = My + y[i];
            Mx2 = Mx2 + x[i] * x[i];
            Mxy = Mxy + x[i] * y[i];
            Mx3 = Mx3 + x[i] * x[i] * x[i];
            Mx4 = Mx4 + x[i] * x[i] * x[i] * x[i];
            Mx2y = Mx2y + x[i]* x[i] * y[i];
        }

        double[] ab = methodKramer(new double[][] {{0,0,0,0,0},{0, Mx4, Mx3, Mx2, 0}, {0 , Mx3, Mx2, Mx,0}, {0 , Mx2, Mx, x.length, 0 }, {0, Mx2y, Mxy, My, 0}});
        return ab;
    }
}
