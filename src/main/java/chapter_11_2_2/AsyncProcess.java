package chapter_11_2_2;

public class AsyncProcess implements Runnable {

    private AsyncCallback callback;

    public AsyncProcess(AsyncCallback asyncCallback){
        this.callback = asyncCallback;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000L);
            this.callback.notify("Finished");
        }catch(InterruptedException ex){
            System.out.println(ex);
        }
        
        System.out.println("AsyncProcess is finished");
    }
}
