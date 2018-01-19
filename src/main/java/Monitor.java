import com.uptop.websocket.WebSocketTest;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Monitor implements Runnable {

    @Override
    public void run() {
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.sendMsg("当前时间:" + new Date());
    }

    public void sendMsg() {
        ScheduledExecutorService newScheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        //启动20s后向客户端发送消息，接下来每隔5s发消息
        newScheduledThreadPool.scheduleWithFixedDelay(new Monitor(), 20, 5, TimeUnit.SECONDS);

    }
}

