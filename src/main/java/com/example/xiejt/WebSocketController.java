package com.example.xiejt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate template;

    //广播推送消息
    //@Scheduled(fixedRate = 1000)
    public void sendTopicMessage() {
        System.out.println("后台广播推送！");
        User user=new User();
        user.setUserName("guangbo");
        user.setAge(10);
        this.template.convertAndSend("/topic/getResponse",user);
    }

    //一对一推送消息
    //@Scheduled(fixedRate = 1000)
    public void sendQueueMessage() {
        System.out.println("后台一对一推送！");
        User user=new User();
        user.setUserId(1);
        user.setUserName("yiduiyi");
        user.setAge(10);
        this.template.convertAndSendToUser(user.getUserId()+"","/queue/getResponse",user);
    }

    //群发
    @MessageMapping("/massRequest")
    //SendTo 发送至 Broker 下的指定订阅路径
    @SendTo("/mass/getResponse")
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest){
        //方法用于群发测试
        System.out.println("name = " + chatRoomRequest.getName());
        System.out.println("chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        return response;
    }

    //单独聊天
    @MessageMapping("/aloneRequest")
    public ChatRoomResponse alone(ChatRoomRequest chatRoomRequest){
        //方法用于一对一测试
        System.out.println("userId = " + chatRoomRequest.getUserId());
        System.out.println("name = " + chatRoomRequest.getName());
        System.out.println("chatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response=new ChatRoomResponse();
        response.setName(chatRoomRequest.getName());
        response.setChatValue(chatRoomRequest.getChatValue());
        this.template.convertAndSendToUser(chatRoomRequest.getUserId()+"","/alone/getResponse",response);
        return response;
    }
}