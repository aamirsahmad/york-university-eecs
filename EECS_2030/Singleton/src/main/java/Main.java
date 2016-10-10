
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public void task001(ConcurrentMap map, UUIDFactory uuidFactory)
    {
        UUID k = uuidFactory.generate();

        if (map.containsKey(k)) {
            System.out.println("Key Exist!!");
        } else {
            map.put(k, "");
            logger.info("UUID added to the map: " + k); 
            //System.out.printf("%s :%s\n", k, Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        logger.info("CommonPoolParallelism factor: " + ForkJoinPool.getCommonPoolParallelism() );


        ConcurrentMap<UUID, String> map = new ConcurrentHashMap<>();
        Main m = new Main();
        UUIDFactory uuidFactory = UUIDFactory.getInstance();

        ExecutorService executor = Executors.newFixedThreadPool(7);

        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task = () ->
                            m.task001(map, uuidFactory);
                    executor.submit(task);
                });

        try {
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            executor.shutdownNow();
        }


        System.out.println("Done!");

        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=6
        //System.out.println(ForkJoinPool.getCommonPoolParallelism());

        //map.forEach((key, value) -> System.out.printf("%s  ---> %s , Thread:%s\n", key, value, Thread.currentThread().getName()));
        //for (Object o : map.keySet()) System.out.println(o);
    }
}
