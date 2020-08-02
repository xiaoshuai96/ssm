package com.xiaoshuai885.service.impl;
import com.xiaoshuai885.dao.ucsReplayMapper;
import com.xiaoshuai885.domain.userCserviceReplay;
import com.xiaoshuai885.service.ucsReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ucsReplayServiceImpl implements ucsReplayService {
    @Autowired
    private ucsReplayMapper replayDao;

    @Override
    public userCserviceReplay findFirstMessage(Long nsuserId) {
//        userCserviceReplay first = replayDao.judgeExistFirstMessage(nsuserId);
//        if (!ObjectUtils.isEmpty(first)) {
//            return replayDao.getFirstMessage(nsuserId);
//        } else {
//            return null;
//        }
        return replayDao.getFirstMessage(nsuserId);
    }

    @Override
    public userCserviceReplay getOneMessage(Long id) {
//        userCserviceReplay message = replayDao.judgeExistLastMessage(id);
//        if (!ObjectUtils.isEmpty(message)) {
//            return replayDao.getOneMessage(id);
//        } else {
//            return null;
//        }
        return replayDao.getOneMessage(id);
    }

    @Override
    public boolean saveMessage(Long nsuserId, String text, Date date, Long lastId) {
        return replayDao.insertNewMessage(nsuserId,text,date,lastId);
    }

}
