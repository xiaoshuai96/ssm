package com.xiaoshuai885.service;
import com.xiaoshuai885.domain.userCserviceReplay;


public interface ucsReplayService {
    userCserviceReplay findFirstMessage(Long nsuserId);

    userCserviceReplay getOneMessage(Long id);
}
