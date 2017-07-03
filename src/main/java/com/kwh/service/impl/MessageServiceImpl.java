package com.kwh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kwh.dao.BaseDaoI;
import com.kwh.model.Message;
import com.kwh.service.MessageServiceI;

@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageServiceI {

	@Resource
	private BaseDaoI<Message> baseDao;

	@Override
	public void saveMessage(Message rmessage) {
		baseDao.save(rmessage);
	}

}
