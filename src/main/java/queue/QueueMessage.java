package queue;

import data.Message;

public class QueueMessage {
    private String messageId;
    private int retryCount;
    private Message payload;

    public QueueMessage(String messageId, int retryCount, Message payload) {
        this.messageId = messageId;
        this.retryCount = retryCount;
        this.payload = payload;
    }

    public QueueMessage() {
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public Message getPayload() {
        return payload;
    }

    public void setPayload(Message payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "QueueMessage{" +
                "messageId='" + messageId + '\'' +
                ", retryCount=" + retryCount +
                ", payload=" + payload +
                '}';
    }
}
