package br.inatel.dm110.beans.order;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.google.gson.Gson;

import br.inatel.dm110.trabalho.api.interfaces.LogLocal;
import br.inatel.dm110.trabalho.api.model.LogTO;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topic/trabalho-dm110-topic") })
public class LogTopicMDB implements MessageListener {

    @EJB
    private LogLocal logBean;

    private static Logger log = Logger.getLogger(LogTopicMDB.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage txtMessage = (TextMessage) message;
                String logText = txtMessage.getText();

                LogTO logTO = new Gson().fromJson(logText, LogTO.class);

                logBean.saveLog(logTO);

                log.info("Log saved: " + logText);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
