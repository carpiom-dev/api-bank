package com.mcarpio.bank.infrastructure.out.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final RabbitProperties rabbitProperties;

    public RabbitConfig(RabbitProperties rabbitProperties) {
        this.rabbitProperties = rabbitProperties;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(rabbitProperties.getExchange().getName());
    }

    @Bean
    public Queue defaultQueue() {
        return new Queue(rabbitProperties.getQueue().getName(), true);
    }

    @Bean
    public Binding defaultBinding(Queue defaultQueue, DirectExchange defaultExchange) {
        return BindingBuilder.bind(defaultQueue).to(defaultExchange).with(rabbitProperties.getRouting().getKey());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}