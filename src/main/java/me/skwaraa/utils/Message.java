package me.skwaraa.utils;

import me.skwaraa.Main;
import me.skwaraa.sql.message.MessageSql;

public class Message {
    private final int messageId;
    private final MessageSql mSql;
    public Message(int messageId, Main main) {
        this.messageId = messageId;
        mSql = new MessageSql(main);
    }

    public void delete() {
        mSql.deleteMessage(messageId);
    }

    public int getMessageId() {
        return messageId;
    }

    public String getContent() {
        return mSql.getContentById(messageId);
    }

    public int getAuthorId() {
        return mSql.getAuthorId(messageId);
    }

    public int getReceiverId() {
        return mSql.getReceiverId(messageId);
    }

    public String getDate() {
        return mSql.getDate(messageId);
    }

}
