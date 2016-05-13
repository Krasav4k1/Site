package com.servise.impl;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/activation")
    public class UserMonitoringWebSocket {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    public static Set<Session> getSessions() {
        return sessions;
    }


        @OnOpen
        public void onOpen(Session session){
            sessions.add(session);
        }


        @OnClose
        public void onClose(Session session){
            sessions.remove(session);
        }

    }
