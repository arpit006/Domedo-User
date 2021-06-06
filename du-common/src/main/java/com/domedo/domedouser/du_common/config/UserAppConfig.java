package com.domedo.domedouser.du_common.config;

import com.domedo.notificationservice.sdk.service.OtpRestCaller;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * TODO:: move the properties to config people
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Configuration
public class UserAppConfig {

    @Bean
    public OtpRestCaller otpRestCaller() {
        return new OtpRestCaller(okHttpClient());
    }

    @Bean
    public OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectionPool(connectionPool())
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .connectTimeout(5000L, TimeUnit.MILLISECONDS)
                .writeTimeout(5000L, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

    private ConnectionPool connectionPool() {
        ConnectionPool connectionPool = new ConnectionPool(50, 15000, TimeUnit.MILLISECONDS);
        return connectionPool;
    }
}
