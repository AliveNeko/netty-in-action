package org.example.chapter6;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Example_6_5_ModifyChannelPipeline {
    public static void main(String[] args) {
        ChannelPipeline pipeline = new NioSocketChannel().pipeline();
        FirstHandler firstHandler = new FirstHandler();
        pipeline.addLast("handler1", firstHandler);
        pipeline.addFirst("handler2", new SecondHandler());
        pipeline.addLast("handler3", new ThirdHandler());
        // ...
        pipeline.remove("handler3");
        pipeline.remove(firstHandler);
        pipeline.replace("handler2", "handler4", new ForthHandler());
    }

    public static class FirstHandler extends ChannelInboundHandlerAdapter {}
    public static class SecondHandler extends ChannelInboundHandlerAdapter {}
    public static class ThirdHandler extends ChannelInboundHandlerAdapter {}
    public static class ForthHandler extends ChannelInboundHandlerAdapter {}
}
