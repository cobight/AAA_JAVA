import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


class Mytask implements Callable<Integer> {
    private int upperbounds;

    public Mytask(int upperbounds) {
        this.upperbounds = upperbounds;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < upperbounds; i++) {
            sum += i;
        }
        return sum;
    }
}

public class lijia {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            list.add(service.submit(new Mytask((int) (Math.random() * 100))));
        }
        int sum = 0;
        for (Future<Integer> future : list) {
            sum += future.get();
        }
        System.out.println(sum);
    }
}
