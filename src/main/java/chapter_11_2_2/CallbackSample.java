package chapter_11_2_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackSample {
    public void doSomething(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AsyncProcess proc = new AsyncProcess(new AsyncCallback() {
            public void notify(String message){
                System.out.println("callback messaage:" + message);
                executor.shutdown();
            }
        });

        executor.execute(proc);
        System.out.println("AsyncProcess is started.");
    }
}
