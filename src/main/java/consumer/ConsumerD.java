package consumer;

import data.Message;
import queue.Queue;

public class ConsumerD extends Consumer {

    public ConsumerD(Queue messageQueue, String consumerName) {
        super(messageQueue, consumerName);
    }

    public void consumeD(Message message) {
        System.out.println(this.getConsumerName() + " consumed Message -" + message.getData());
    }

}
