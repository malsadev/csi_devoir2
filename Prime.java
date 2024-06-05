class Prime {

    public static void main(String[] args) throws InterruptedException {

        ComputePrime cp = new ComputePrime(Integer.parseInt(args[0]));

        Thread t1 = new Thread(cp);
        t1.start();
        t1.join();

    }

    static class ComputePrime implements Runnable {

        private int higherBound;

        public ComputePrime(Integer higherBound) {
            this.higherBound = higherBound;
        }

        @Override
        public void run() {
            
            boolean[] multiples = new boolean[higherBound + 1];

            for (int i = 2; i <= higherBound; i++) {

                if (multiples[i] == false) {
                    System.out.println(i);
                    for (int j = 1; j * i < multiples.length; j++) {
                        multiples[j * i] = true;
                    }

                } else {
                    continue;
                }
            }
        }
    }
}