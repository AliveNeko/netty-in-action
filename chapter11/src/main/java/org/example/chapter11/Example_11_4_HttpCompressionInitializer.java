package org.example.chapter11;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpServerCodec;

public class Example_11_4_HttpCompressionInitializer {
    public static class HttpCompressionInitializer extends ChannelInitializer<Channel> {
        private final boolean isClient;

        public HttpCompressionInitializer(boolean isClient) {
            this.isClient = isClient;
        }

        @Override
        protected void initChannel(Channel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            if (isClient) {
                // 如果是客户端，则添加 HttpClientCodec
                pipeline.addLast("codec", new HttpClientCodec());
                // 如果是客户端，则添加 HttpContentDecompressor 以处理来自服务器的压缩内容
                pipeline.addLast("decompressor", new HttpContentDecompressor());
            } else {
                // 如果是服务器，则添加 HttpServerCodec
                pipeline.addLast("codec", new HttpServerCodec());
                // 如果是服务器，则添加 HttpContentCompressor 来压缩数据（如果客户端支持它）
                pipeline.addLast("compressor", new HttpContentCompressor());
            }
        }
    }
}
