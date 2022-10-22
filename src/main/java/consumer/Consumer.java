package consumer;

import exception.ConsumerAlreadySubscribedException;
import exception.InvalidDependentConsumers;
import queue.Queue;

public abstract class Consumer {
    private Queue messageQueue;
    private String consumerName;

    Consumer(Queue messageQueue, String consumerName) {
        this.messageQueue = messageQueue;
        this.consumerName = consumerName;
    }

    public void subscribe(String messageId, String callbackMethod, Consumer... dependentConsumers) {
        try {
            messageQueue.subscribe(this, messageId, callbackMethod,dependentConsumers);
            System.out.println(this.getConsumerName() + " consumed messageId " + messageId);
            for (Consumer dependentConsumer : dependentConsumers) {
                System.out.println("\tDepends on - " + dependentConsumer.getConsumerName());
            }
        } catch (InvalidDependentConsumers | ConsumerAlreadySubscribedException e) {
            System.err.println(e.getMessage());
        }
    }

    public String getConsumerName() {
        return this.consumerName;
    }
}
