package org.example.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Example_4_5_MultiWriteToChannel {
    public void multiWriteToChannel() {
        final Channel channel = new NioSocketChannel();
        // 创建持有要写数据的ByteBuf
        final ByteBuf buf = Unpooled.copiedBuffer("your data", CharsetUtil.UTF_8).retain();
        // 创建将数据写到 Channel 的 Runnable
        Runnable writer = new Runnable() {
            @Override
            public void run() {
                channel.writeAndFlush(buf.duplicate());
            }
        };
        Executor executor = Executors.newCachedThreadPool();
        // write in one thread
        // 递交写任务给线程池以便在某个线程中执行
        executor.execute(writer);
        // write in another thread
        // 递交另一个写任务以便在另一个线程中执行
        executor.execute(writer);
    }
}
