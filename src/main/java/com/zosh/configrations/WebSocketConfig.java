// =============================================================================
// BACKEND - WebSocketConfig.java - SOLO CAMBIO MÍNIMO
// =============================================================================
package com.zosh.configrations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/api/notifications/ws")
                // 🔧 FIX: SOLO AGREGAR LOS ORIGINS HTTPS
                .setAllowedOrigins(
                        "http://localhost:8080",
                        "http://localhost:3000",
                        "https://front-final-nine.vercel.app", // ✅ AGREGAR ESTO
                        "https://34.203.37.29:5000", // ✅ AGREGAR ESTO
                        "http://34.203.37.29:5000" // ✅ AGREGAR ESTO
                )
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/notification", "/user", "chat");
        registry.setUserDestinationPrefix("/user");
    }
}