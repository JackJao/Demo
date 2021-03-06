package com.jaon.demo.config;

import com.jaon.demo.component.websocket.MarcoHandler;
import com.jaon.demo.component.websocket.MarcoHandler2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 简单的web socket
 * @author Gao
 * @date 2018/8/2 12:30
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //添加socket注册处理器
        //配置websocket访问地址：String url = "ws://localhost:8080/websocket/marco";
        webSocketHandlerRegistry.addHandler(marcoHandler(),"/websocket/marco");
        webSocketHandlerRegistry.addHandler(marcoHandler2(),"/websocket/marco2");
        //如果WebSocket不可用的话， SockJS的备用方案就会发挥作用
        webSocketHandlerRegistry.addHandler(marcoHandler(),"/websocket/marco").withSockJS();
        webSocketHandlerRegistry.addHandler(marcoHandler2(),"/websocket/marco2").withSockJS();
    }


    @Bean
    public MarcoHandler marcoHandler(){
        return new MarcoHandler();
    }

    @Bean
    public MarcoHandler2 marcoHandler2(){
        return new MarcoHandler2();
    }
}
