package consumer;

import data.Message;
import queue.Queue;

public class ConsumerA extends Consumer{

    public ConsumerA(Queue messageQueue, String consumerName) {
        super(messageQueue, consumerName);
    }

    public void consumeA(Message message) {
        System.out.println(this.getConsumerName()+" consumed Message -" + message.getData());
    }
}
