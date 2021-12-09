package org.example.chapter2;

import org.junit.jupiter.api.Test;

import static org.example.chapter2.Example_2_2_EchoServer.EchoServer;

class Example_2_2_EchoServerTest {

    @Test
    public void start() throws Exception {
        new EchoServer(8080).start();
    }

}