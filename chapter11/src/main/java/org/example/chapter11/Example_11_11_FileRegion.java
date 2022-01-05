package org.example.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.File;
import java.io.FileInputStream;

public class Example_11_11_FileRegion {
    private static final Channel channel = new NioSocketChannel();
    private static final File file = new File("tmp.txt");

    public static void main(String[] args) throws Exception {
        // 创建一个 FileInputStream
        FileInputStream in = new FileInputStream(file);
        // 以该文件的完整长度创建一个新的 DefaultFileRegion
        DefaultFileRegion region = new DefaultFileRegion(in.getChannel(), 0, file.length());
        channel.writeAndFlush(region).addListener(
                new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            Throwable cause = future.cause();
                            // Do something
                        }
                    }
                });
    }
}
