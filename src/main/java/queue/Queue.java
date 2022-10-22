package queue;

import consumer.Consumer;
import data.Message;
import exception.ConsumerAlreadySubscribedException;
import exception.InvalidDependentConsumers;

public interface Queue {
    void setQueueCapacity(int size);

    int getRemainingQueueCapacity();

    int getQueueSize();

    void addMessage(Message message, String messageId);

    void subscribe(Consumer consumer, String messageId, String callbackMethod, Consumer... dependentConsumers) throws InvalidDependentConsumers, ConsumerAlreadySubscribedException;
}
