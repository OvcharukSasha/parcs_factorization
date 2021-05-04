import parcs.*;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class Main implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("TheAlgorithm.jar");
        (new Main()).run(new AMInfo(curtask, (channel) null));
        curtask.end();
    }

    public void run(AMInfo amInfo) {
        System.out.print("Enter number for factorization: ");
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        System.out.println("N is: " + n);
        try {
            point p = amInfo.createPoint();
            channel c = p.createChannel();
            p.execute("TheAlgorithm");
            c.write(n.toString());
            System.out.println("Waiting for result......");
            Result res = (Result) (c.readObject());
            for (BigInteger num : res.getList()) {
                System.out.print(num + " ");
            }
            System.out.println(" ");


        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
