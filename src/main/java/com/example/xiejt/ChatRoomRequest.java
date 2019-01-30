package com.example.xiejt;

/**
 * @author xiejt
 * @Description:
 * @date : 2019-1-25 13:34
 *//*
 * @功能描述
 * @Author xiejt
 * @Date $ $
 **/
public class ChatRoomRequest {
    String name;
    String chatValue;
    String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChatValue() {
        return chatValue;
    }

    public void setChatValue(String chatValue) {
        this.chatValue = chatValue;
    }
}
