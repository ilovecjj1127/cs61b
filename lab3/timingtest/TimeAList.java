package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> arr = new AList<Integer>();
        AList<Double> time = new AList<Double>();
        AList<Integer> opc = new AList<Integer>();
        for (int n = 1000; n < 128000; n = n * 2) {
            arr.addLast(n);
            int count = 0;
            Stopwatch sw = new Stopwatch();
            AList<Integer> temp = new AList<Integer>();
            for (int i = 0; i < n; i++) {
                temp.addLast(i);
                count++;
            }
            double timeInSeconds = sw.elapsedTime();
            time.addLast(timeInSeconds);
            opc.addLast(count);
        }
        printTimingTable(arr, time, opc);
    }
}
