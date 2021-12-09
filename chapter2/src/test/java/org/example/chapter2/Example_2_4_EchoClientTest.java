package org.example.chapter2;

import org.junit.jupiter.api.Test;

import static org.example.chapter2.Example_2_4_EchoClient.EchoClient;

class Example_2_4_EchoClientTest {

    @Test
    public void start() throws Exception {
        new EchoClient("localhost", 8080).start();
    }

}