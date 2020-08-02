package com.xiaoshuai885.service;
import com.xiaoshuai885.domain.userCserviceReplay;

import java.util.Date;


public interface ucsReplayService {
    userCserviceReplay findFirstMessage(Long nsuserId);

    userCserviceReplay getOneMessage(Long id);

    boolean saveMessage(Long nsuserId, String text, Date date, Long lastId);
}
