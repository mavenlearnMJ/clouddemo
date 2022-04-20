package com.wqbr.clouddemo.rabbitmqservice8083.controller;

import com.wqbr.clouddemo.rabbitmqservice8083.queue.MyCallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.UUID;

@RestController
@RequestMapping("/confirm2")
@Slf4j
public class Producer2 {

    public static final String CONFIRM_EXCHANGE_NAME = "confirm.exchange";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MyCallBack myCallBack;

    //rabbitTemplate 注入之后就设置该值
    @PostConstruct
    private void init() {
        rabbitTemplate.setConfirmCallback(myCallBack);
        /**
         * true： * 交换机无法将消息进行路由时，会将该消息返回给生产者
         * false： * 如果发现消息无法进行路由，则直接丢弃
         */
        rabbitTemplate.setMandatory(true);
        //设置回退消息交给谁处理
        rabbitTemplate.setReturnCallback(myCallBack);
    }

    @GetMapping("sendMessage")
    public void sendMessage(String message){
        //让消息绑定一个 id 值
        CorrelationData correlationData1 = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("confirm.exchange","key1",message+"key1",correlationData1);
        log.info("发送消息 id 为:{}内容为{}",correlationData1.getId(),message+"key1");
        CorrelationData correlationData2 = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("confirm.exchange","key2",message+"key2",correlationData2);
        log.info("发送消息 id 为:{}内容为{}",correlationData2.getId(),message+"key2");
    }

}
