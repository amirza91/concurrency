import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int [] array = new int[200_000_000];
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(10) + 1;

        }


        long timer = System.currentTimeMillis();
        System.out.println(sumOfRandom(array));
        long timerEnd = System.currentTimeMillis();
        System.out.println(timerEnd - timer + " milliseconds");

        timer = System.currentTimeMillis();
        System.out.println(multiThreads(array));
        timerEnd = System.currentTimeMillis();
        System.out.println(timerEnd - timer + " milliseconds");



    }
    public static int sumOfRandom(int[] total){
        int sum = 0;
        for(int i = 0; i < total.length; i++){
            sum += total[i];
            // sum = sum + total[i]
        }
        return sum;

    }

    public static int multiThreads(int[] total) throws InterruptedException {
        implement threadOne = new implement(0,100_000_000, total);

        implement threadTwo = new implement(100_000_000, 200_000_000, total);

        threadOne.start();
        threadTwo.start();
        try{
            threadOne.join();
            threadTwo.join();
        } catch(InterruptedException e){

        }
        int sumOne = threadOne.getSum();
        int sumTwo = threadTwo.getSum();

        return sumOne + sumTwo;





    }

    private static class implement extends Thread{
        int start;
        int end;
        int sum;
        int[] array;
        public implement(int s, int e, int[] array){
            start = s;
            end = e;
            sum = 0;
            this.array = array;



        }
        public void run(){
            for(int i = start; i < end; i++){
                sum += array[i];

            }
        }
        public int getSum (){
            return sum;
        }
    }
}
