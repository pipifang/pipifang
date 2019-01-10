package com.qfedu.byby.mq.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MsglReceive {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1,创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2,设置服务器信息
        factory.setHost("47.99.220.57");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        //3,获取连接对象
        Connection connection = factory.newConnection();

        //4，获取通道对象
        Channel channel = connection.createChannel();

        //5、创建队列对象 存储消息
        /*参数说明：
         * 1、队列名称
         * 2、是否持久化 队列消息是否存储到磁盘
         * 3、是否独占队列
         * 4、是否断开之后自动删除消息*/
        channel.queueDeclare("yuanpipi",false,false,false,null);
        System.out.println("消费者---监听");
        //6、接收消息
        Consumer consumer=new DefaultConsumer(channel){
            //重写回调函数
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                System.out.println("接收消息："+ new String(body));
            }
        };
        //7.自动回复应答
        channel.basicConsume("yuanpipi",true,consumer);

        //8,关闭
        channel.close();
        connection.close();
    }

}
