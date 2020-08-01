package com.xiaoshuai885.dao;

import com.xiaoshuai885.domain.userCserviceReplay;

public interface ucsReplayMapper {
    /**
     * 按照nsuserId查找他和客服的第一条聊天记录
     * @param nsuserId
     * @return
     */
    userCserviceReplay getFirstMessage(Long nsuserId);

    /**
     * 获取一条聊天记录
     * @param lastId
     * @return
     */
    userCserviceReplay getOneMessage(Long lastId);

    /**
     * 判断是否存在该用户与客户的第一条聊天记录
     * @param nsuserId
     * @return
     */
    userCserviceReplay judgeExistFirstMessage(Long nsuserId);

    /**
     * 判断是否还有聊天记录
     * @param lastId
     * @return
     */
    userCserviceReplay judgeExistLastMessage(Long lastId);
}
