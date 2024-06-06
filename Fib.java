import java.util.ArrayList;

public class Fib {

    private static ArrayList<Integer> fibs = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        final Integer nFib = Integer.parseInt(args[0]);
        // final Integer nFib = Integer.parseInt("some number"); testing

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < nFib; i++) {

                    if (i < 2) {
                        fibs.add(i);
                    } else {
                        fibs.add(fibs.get(i - 1) + fibs.get(i - 2));
                    }

                }
            }

        });

        t1.start();
        t1.join();

        fibs.forEach((e) -> System.out.print(e + " "));
        System.out.println();

    }

}
