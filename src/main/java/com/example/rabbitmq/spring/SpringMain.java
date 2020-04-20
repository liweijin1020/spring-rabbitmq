package com.example.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 * 生产者
 */
public class SpringMain {
    public static void main(String[] args) throws InterruptedException {
        /**加载配置文件*/
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/rabbitmq-context.xml");
        /**RabbitMQ模板*/
        RabbitTemplate rabbitTemplate = context.getBean(RabbitTemplate.class);
        /**发送消息*/
        rabbitTemplate.convertAndSend("Hello World!!");
        Thread.sleep(1000);
        /**销毁*/
        context.destroy();
    }
}
