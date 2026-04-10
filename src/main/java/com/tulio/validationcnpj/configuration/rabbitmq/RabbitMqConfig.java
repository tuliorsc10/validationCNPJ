package com.tulio.validationcnpj.configuration.rabbitmq;

import com.seuprojeto.common.consumer.RabbitQueuesEnum;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class RabbitMqConfig {

    @Value("${messaging.rabbit.exchange}")
    private String exchangeName;

    @Bean
    public Declarables rabbitDeclarables() {

        DirectExchange exchange = new DirectExchange(exchangeName);

        List<Declarable> declarables = new ArrayList<>();
        declarables.add(exchange);

        for (RabbitQueuesEnum q : RabbitQueuesEnum.values()) {
            Queue queue = new Queue(q.name(), true);

            declarables.add(queue);

            declarables.add(
                    BindingBuilder
                            .bind(queue)
                            .to(exchange)
                            .with(q.getRoutingKey())
            );
        }

        return new Declarables(declarables);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();

        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.addTrustedPackages("com.seuprojeto.common");

        converter.setJavaTypeMapper((Jackson2JavaTypeMapper) typeMapper);

        return converter;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);

        return factory;
    }

}
