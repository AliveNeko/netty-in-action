package org.example.chapter1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class Example_1_1_BlockingIoTest {

    @Test
    void server() throws IOException {
        new Example_1_1_BlockingIo().server(80);
    }
}