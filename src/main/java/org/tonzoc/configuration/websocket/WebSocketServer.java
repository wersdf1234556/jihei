package org.tonzoc.configuration.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value = "/websocket/{projectId}")
public class WebSocketServer {

    private static Logger logger = LoggerFactory.getLogger(WebSocketServer.class);

    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServers = new CopyOnWriteArraySet<>();
    private static ConcurrentHashMap<String, HashSet<WebSocketServer>> webSocketMap = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "projectId") String projectId) throws IOException {
        this.session = session;
        webSocketServers.add(this);

        if (!webSocketMap.containsKey(projectId)) {
            HashSet<WebSocketServer> set = new HashSet<>();
            webSocketMap.put(projectId, set);
        }
        webSocketMap.get(projectId).add(this);

        addOnlineCount();
        logger.info("有新连接加入：projectId(" + projectId + "), 当前在线人数为" + getOnlineCount());

        sendMessage(projectId + "连接成功");
    }

    @OnClose
    public void onClose(Session session) {
        webSocketServers.remove(this);
        webSocketMap.get(session.getPathParameters().get("projectId")).remove(this);

        subOnlineCount();
        logger.info("有连接关闭：projectId(" + session.getPathParameters().get("projectId") + "), 当前在线人数为" + getOnlineCount());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.error("websocket发生错误(projectId:" + session.getPathParameters().get("projectId") + ")");
        error.printStackTrace();
    }

    public static void broadcast(String message) throws IOException {
        logger.info(message);

        for (WebSocketServer server : webSocketServers) {

            try {
                server.sendMessage(message);
            } catch (IOException e) {
                logger.error("广播发送数据错误！");
                continue;
            }
        }
    }

    public static void sendInfo(String message, String projectId) throws IOException {
        if (webSocketMap.get(projectId) == null) {
            return;
        }
        for (WebSocketServer server : webSocketMap.get(projectId)) {
            if (server != null) {
                logger.info("sent message: " + message);
                server.sendMessage(message);
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            //服务器主动推送
            this.session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
