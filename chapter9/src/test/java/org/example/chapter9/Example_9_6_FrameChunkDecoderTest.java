package org.example.chapter9;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.chapter9.Example_9_5_FrameChunkDecoder.FrameChunkDecoder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example_9_6_FrameChunkDecoderTest {
    @Test
    public void testFramesDecoded() {
        // 创建一个 ByteBuf，并向它写入 9 字节
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(
                new FrameChunkDecoder(3));

        // 向它写入 2 字节，并断言它们将会产生一个新帧
        assertTrue(channel.writeInbound(input.readBytes(2)));
        try {
            channel.writeInbound(input.readBytes(4));
            // 如果上面没有抛出异常，那么就会到达这个断言，并且测试失败
            Assertions.fail();
        } catch (TooLongFrameException e) {
            // expected exception
        }
        // 写入剩余的2字节，并断言将会产生一个有效帧
        assertTrue(channel.writeInbound(input.readBytes(3)));
        // 将该 Channel 标记为已完成状态
        assertTrue(channel.finish());
        // Read frames
        // 读取产生的消息，并且验证值
        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(2), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.skipBytes(4).readSlice(3), read);
        read.release();
        buf.release();
    }
}
