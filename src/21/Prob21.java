import java.util.Scanner;

public class Prob21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double sx, sy, cx, cy, bs, bw;
        double ms = 0;
        double mw = 0;
        double[] wallsx, wallsy, wallcx, wallcy;
        for (int t = Integer.parseInt(in.nextLine()); t > 0; t--) {
            boolean seen = true;
            sx = in.nextInt();
            sy = in.nextInt();
            cx = in.nextInt();
            cy = in.nextInt();
            boolean vertsc = sx == cx;
            if (!vertsc) ms = (cy - sy) / (cx - sx);
            bs = sy - ms * sx;
            wallsx = new double[in.nextInt()];
            wallsy = new double[wallsx.length];
            wallcx = new double[wallsx.length];
            wallcy = new double[wallsx.length];
            for (int i = 0; i < wallsx.length; i++) {
                wallsx[i] = in.nextInt();
                wallsy[i] = in.nextInt();
                wallcx[i] = in.nextInt();
                wallcy[i] = in.nextInt();
            }
            for (int i = 0; seen && i < wallsx.length; i++) {
                double xi, yi;
                if (wallsx[i] == wallcx[i]) {
                    if (vertsc) {
                        seen = !(sx == wallsx[i] && in(wallsy[i], sy, cy));
                        continue;
                    }
                    xi = wallsx[i];
                    yi = ms * xi + bs;
                } else {
                    mw = (wallcy[i] - wallsy[i]) / (wallcx[i] - wallsx[i]);
                    bw = wallsy[i] - mw * wallsx[i];
                    if (ms == mw && !vertsc) {
                        seen = !(Math.abs(bw - bs) < 0.001 && in(wallsx[i], sx, cx));
                        continue;
                    }
                    xi = (vertsc ? sx : ((bw - bs) / (ms - mw)));
                    yi = mw * xi + bw;
                }
                //System.err.format("(%d:%d) %f %f\n", t, i, xi, yi);
                seen = !(in(xi, sx, cx) && in(yi, sy, cy) &&
                    in(xi, wallsx[i], wallcx[i]) &&
                    in(yi, wallsy[i], wallcy[i]));
            }
            System.out.println(seen ? "YES" : "NO");
        }

        in.close();
    }

    static boolean in(double x, double a, double b) {
        if (b > a) {
            return x >= a && x <= b;
        }
        return x >= b && x <= a;
    }
}
