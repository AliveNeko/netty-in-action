package org.example.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Example_7_1_EventLoop {
    public static void main(String[] args) {
        boolean terminated = false;

        while (!terminated) {
            // 阻塞，直到有事件已经就绪可被运行
            List<Runnable> readyEvents = blockUntilEventsReady();
            for (Runnable ev: readyEvents) {
                // 循环遍历，并处理所有的事件
                ev.run();
            }
        }
    }

    private static List<Runnable> blockUntilEventsReady() {
        return new ArrayList<>();
    }
}
