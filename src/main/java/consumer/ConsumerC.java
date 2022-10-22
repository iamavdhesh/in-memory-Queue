package consumer;

import data.Message;
import queue.Queue;

public class ConsumerC extends Consumer {

    public ConsumerC(Queue messageQueue, String consumerName) {
        super(messageQueue, consumerName);
    }

    public void consumeC(Message message) {
        System.out.println(this.getConsumerName() + " consumed Message -" + message.getData());
    }

}
