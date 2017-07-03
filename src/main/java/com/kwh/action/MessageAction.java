package com.kwh.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.kwh.dao.BaseDaoI;
import com.kwh.model.Message;
import com.kwh.service.MessageServiceI;
import com.opensymphony.xwork2.ModelDriven;
public class MessageAction extends BaseAction implements ModelDriven<Message> {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(MessageAction.class);
    private Message message = new Message();
    private List<Message> messages = new ArrayList<Message>();

    
    @Action(value = "messageAction", results = { @Result(name = "success", location = "/WEB-INF/jsp/messages.jsp") })
    public String execute() {
        try {
            message.setMsgIp(ServletActionContext.getRequest().getRemoteAddr());
            message.setMsgTime(new Timestamp(System.currentTimeMillis()));
            messageService.saveMessage(message);
            logger.info("save message success");
            setMessages(baseDao.find("from Message"));
        } catch (Exception e) {
            logger.error(e);
            return ERROR;
        }
        return SUCCESS;
    }
    
    @Action(value = "toinput", results = { @Result(name = "success", location = "/WEB-INF/jsp/input.jsp") })
    public String toinput() {
        return SUCCESS;
    }

    @Override
    public Message getModel() {
        return message;
    }

    @Resource
    private MessageServiceI messageService;

    @Resource
    private BaseDaoI<Message> baseDao;

    public void setMessages(List<Message> messageS) {
        this.messages = messageS;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
