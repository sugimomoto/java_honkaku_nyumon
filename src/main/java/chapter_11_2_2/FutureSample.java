package chapter_11_2_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureSample {

    public String doSomthing(){

        String message = "";

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>(){
            public String call(){
                try{
                    Thread.sleep(1000L);
                }catch(InterruptedException ex){
                    return "execution is failed.";
                }

                return "Finished.";
            }
        });

        System.out.println("ExecutorService is stated.");

        try{
            message = future.get();
            System.out.println("ExecutorService is finished. message = " + message);
        }catch(InterruptedException | ExecutionException ex){
            System.out.println(ex);
        }finally{
            executor.shutdown();
        }

        return message;
    }
}
