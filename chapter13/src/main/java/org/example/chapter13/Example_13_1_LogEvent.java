package org.example.chapter13;

import java.net.InetSocketAddress;

public class Example_13_1_LogEvent {
    public static class LogEvent {
        public static final byte SEPARATOR = (byte) ':';
        private final InetSocketAddress source;
        private final String logfile;
        private final String msg;
        private final long received;

        // 用于传出消息的构造函数
        public LogEvent(String logfile, String msg) {
            this(null, -1, logfile, msg);
        }

        // 用于传入消息的构造函数
        public LogEvent(InetSocketAddress source, long received, String logfile, String msg) {
            this.source = source;
            this.logfile = logfile;
            this.msg = msg;
            this.received = received;
        }

        /**
         * 返回发送 LogEvent 的源的 InetSocketAddress
         * @return
         */
        public InetSocketAddress getSource() {
            return source;
        }

        /**
         * 返回所发送的 LogEve 的日志文件的名称
         * @return
         */
        public String getLogfile() {
            return logfile;
        }

        /**
         * 返回消息内容
         * @return
         */
        public String getMsg() {
            return msg;
        }

        /**
         * 返回接收 LogEvent 的时间
         * @return
         */
        public long getReceivedTimestamp() {
            return received;
        }
    }
}
