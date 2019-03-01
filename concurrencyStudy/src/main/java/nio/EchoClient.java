package nio;

import java.nio.ByteBuffer;
import java.util.LinkedList;

public class EchoClient {

    private LinkedList<ByteBuffer> outq;

    EchoClient() {
        outq = new LinkedList<>();
    }

    public LinkedList<ByteBuffer> getOutq() {
        return outq;
    }

    public void enqueue(ByteBuffer bb) {
        outq.addFirst(bb);
    }
}
