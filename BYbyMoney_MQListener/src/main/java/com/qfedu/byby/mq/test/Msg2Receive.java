package com.qfedu.byby.mq.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Msg2Receive {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2、设置服务器信息
        factory.setHost("47.99.220.57");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //3、获取连接对象
        Connection connection=factory.newConnection();
        //4、获取通道对象
        Channel channel=connection.createChannel();
        //5,创建储存消息对象
        channel.queueDeclare("ppifang",false,false,false,null);
        //6,将队列和交换机绑定
        /*参数说明：
         * 1、队列名称
         * 2、交换机名称
         * 3、路由名*/
        channel.queueBind("pipifang","pipipiex","pipipi");
        channel.basicQos(1);
        //7.消息消费
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("获取消息："+new String(body));
            }
        };
        channel.basicConsume("pipifang",true,consumer);


    }
}
