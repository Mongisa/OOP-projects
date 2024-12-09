package testserviceiz;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new Task<String>() {
            @Override
            protected String call() throws Exception {
                //Exception viene lanciata chissà dove (:-o)
                String msg = "";

                for(int i = 1; i <= 10; i++) {
                    msg = "itearation : " + i;
                    Thread.sleep(2*1000);
                    updateProgress(i, 10);
                    updateValue(msg);
                }

                return msg;
            }
        };
    }
}
