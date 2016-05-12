package com.servise.impl;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/activation")
    public class UserMonitoringWebSocket {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    public static Set<Session> getSessions() {
        return sessions;
    }

    private void sendMessageToAll(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @OnOpen
        public void onOpen(Session session){
            System.out.println("connect "+ session.getUserPrincipal().getName());
            sessions.add(session);
        }

        @OnMessage
        public void onMessage(String message, Session session)  {
            sendMessageToAll(session, " : " + message+" : " + new java.util.Date());
        }

        @OnClose
        public void onClose(Session session){
            System.out.println("Disconnect "+ session.getUserPrincipal().getName());
            sessions.remove(session);
        }

    }
