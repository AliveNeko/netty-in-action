package org.example.chapter5;

import java.nio.ByteBuffer;

public class Example_5_3_CompositeWithNioByteBuffer {
    public static void main(String[] args) {
        ByteBuffer header = ByteBuffer.allocate(16);
        ByteBuffer body = ByteBuffer.allocate(16);
        // Use an array to hold the message parts
        ByteBuffer[] message = new ByteBuffer[] { header, body };
        // Create a new ByteBuffer and use copy to merge the header and body
        ByteBuffer message2 =
                ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }
}
