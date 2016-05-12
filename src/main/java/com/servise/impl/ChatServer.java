package com.servise.impl;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/chat/{user}/{friend}")
public class ChatServer {

    private void sendMessageToAll(String message,String friend){
        for(Session s : UserMonitoringWebSocket.getSessions()){
            try {
               if (Integer.parseInt(s.getUserPrincipal().getName()) == Integer.parseInt(friend)) s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String name){
        System.out.println(session.getId() + " has opened a connection");
        System.out.println(session.getUserPrincipal().getName());
//        sendMessageToAll(name+" був підключений");
        try {
            session.getBasicRemote().sendText("Підключення вдале");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(@PathParam("user") String name,@PathParam("friend") String friend,String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        sendMessageToAll(message,friend);
    }

    @OnClose
    public void onClose(Session session, @PathParam("user") String name){
        System.out.println("Session " +session.getId()+" has ended");
//        sendMessageToAll(name+" був відключений");
    }


}