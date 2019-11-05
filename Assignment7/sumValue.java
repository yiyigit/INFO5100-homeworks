import java.util.Random;

public class sumValue {
    /*generate array of random numbers*/
    static void generateRandomArray(int[] arr){
        Random r = new Random();
        for(int i = 0; i< arr.length;i++){
            arr[i] = r.nextInt(arr.length);
        }
    }

    /*get sum of an array using 4 threads*/
    public static long sum(int[] arr){
        long res = 0;
        ThreadSum a = new ThreadSum(arr, 0, 1000000);
        a.run();
        ThreadSum b = new ThreadSum(arr, 1000000, 2000000);
        b.run();
        ThreadSum c = new ThreadSum(arr,2000000,3000000);
        c.run();
        ThreadSum d = new ThreadSum(arr, 3000000,4000000);
        d.run();
        res = a.getSum()+b.getSum()+c.getSum()+d.getSum();
        return res;
    }

    public static class ThreadSum implements Runnable{
        int[] arr;
        int begin,end;
        private long res = 0;
        ThreadSum(int[] arr, int begin, int end){
            this.arr = arr;
            this.begin = begin;
            this.end =end;
        }
        public void run(){
            for(int i= begin;i<end;i++){
                res += arr[i];
            }
        }
        public long getSum(){
            return res;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[4000000];
        generateRandomArray(arr);
        long sum = sum(arr);
        System.out.println("Sum: " + sum);
    }
}

