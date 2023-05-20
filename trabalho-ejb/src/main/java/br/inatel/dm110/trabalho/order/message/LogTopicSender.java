package br.inatel.dm110.trabalho.order.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import com.google.gson.Gson;

import br.inatel.dm110.trabalho.api.model.LogTO;

@Stateless
public class LogTopicSender {
    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/topic/trabalho-dm110-topic")
    private Topic topic;

    public void sendLogMessage(LogTO log) {
        try {
            Connection conn = connectionFactory.createConnection();
            Session session = conn.createSession();
            MessageProducer msgProducer = session.createProducer(topic);
            TextMessage txtMsg = session.createTextMessage(new Gson().toJson(log));
            msgProducer.send(txtMsg);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
