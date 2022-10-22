import consumer.ConsumerA;
import consumer.ConsumerB;
import consumer.ConsumerC;
import consumer.ConsumerD;
import producer.MessageProducer;
import producer.Producer;
import queue.JsonMessageQueue;
import queue.Queue;

public class TestApplication {
    public static void main(String[] args) throws InterruptedException {
        //1. Create Queue with capacity 3
        Queue queue = new JsonMessageQueue(3);
        //2. Create Producer
        Producer messageProducer = new MessageProducer(queue);
        //3. Create 4 Consumers and name them
        ConsumerA consumerA = new ConsumerA(queue, "Consumer A");
        ConsumerB consumerB = new ConsumerB(queue, "Consumer B");
        ConsumerC consumerC = new ConsumerC(queue, "Consumer C");
        ConsumerD consumerD = new ConsumerD(queue, "Consumer D");

        /*4. Subscribe consumers to messages
        Consumer C depends on ConsumerA,B; ConsumerB depends on Consumer A; ConsumerA non-dependent
        So order of Consumption should be ConsumerA, ConsumerB || ConsumerA, Consumer C(end)*/
        consumerA.subscribe("abc","consume_A");
        consumerB.subscribe("def","consume_B",consumerA);
        consumerC.subscribe("xyz","consume_C",consumerA,consumerB);

        // Todo remaining case need to added

        //5. Start producer Thread which produces messages - messageA, messageB, messageC,messageD ,messageE
        Thread producerThread = new Thread(messageProducer);
        producerThread.start();
        //6. Setting Queue to new Capacity
        Thread.sleep(80);
        queue.setQueueCapacity(4);
        System.out.println("Exiting Main Application");

    }
}

