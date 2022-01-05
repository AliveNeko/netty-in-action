package org.example.chapter10;

import io.netty.channel.CombinedChannelDuplexHandler;

import static org.example.chapter10.Example_10_8_ByteToCharDecoder.ByteToCharDecoder;
import static org.example.chapter10.Example_10_9_CharToByteEncoder.CharToByteEncoder;

public class Example_10_10_CombinedChannelDuplexHandler {
    // 通过该解码器和编码器实现参数化 CombinedByteCharCodec
    public static class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {
        public CombinedByteCharCodec() {
            // 将委托实例传递给父类
            super(new ByteToCharDecoder(), new CharToByteEncoder());
        }
    }
}
