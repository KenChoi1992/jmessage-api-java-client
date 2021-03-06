package cn.jmessage.api.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jmessage.api.JMessageClient;
import cn.jmessage.api.common.model.MessageBody;
import cn.jmessage.api.message.SendMessageResult;

public class MessageExample {

    protected static final Logger LOG = LoggerFactory.getLogger(MessageExample.class);

    private static final String appkey = "242780bfdd7315dc1989fe2b";
    private static final String masterSecret = "2f5ced2bef64167950e63d13";

    /**
     * Send single text message by admin, this method will invoke sendMessage() in JMessageClient eventually, whose 
     * parameters are as list:
     * @param version Current version is 1
     * @param targetType Group or single
     * @param targetId The message receiver 
     * @param fromType Only support admin now
     * @param fromId Sender
     * @param messageType Only support text now
     * @param messageBody A MessageBody instance
     * @return
     * @throws APIConnectionException
     * @throws APIRequestException
     */
    public static void testSendSingleTextByAdmin() {
        JMessageClient client = new JMessageClient(appkey, masterSecret);

        try {
            MessageBody body = MessageBody.text("Help me!");
            SendMessageResult result = client.sendSingleTextByAdmin("targetUserName", "fromUserName", body);
            LOG.info(String.valueOf(result.getMsg_id()));
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }
    
    /**
     * Send group text message by admin
     */
    public static void testSendGroupTextByAdmin() {
    	JMessageClient client = new JMessageClient(appkey, masterSecret);
    	
    	try {
    		MessageBody body = MessageBody.text("Hello World!");
    		SendMessageResult result = client.sendGroupTextByAdmin("targetUserName", "fromUserName", body);
    		LOG.info(String.valueOf(result.getMsg_id()));
    	} catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Message: " + e.getMessage());
        }
    }
}
