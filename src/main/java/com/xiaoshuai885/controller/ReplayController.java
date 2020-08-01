package com.xiaoshuai885.controller;

import com.xiaoshuai885.domain.userCserviceReplay;
import com.xiaoshuai885.service.ucsReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("replay")
public class ReplayController {
    @Autowired
    private ucsReplayService ucsReplayService;

    @RequestMapping("getFM")
    @ResponseBody
    public userCserviceReplay getFirstMessage(Long nsuserId){
        return ucsReplayService.findFirstMessage(nsuserId);

    }

    @RequestMapping("getOM")
    @ResponseBody
    public userCserviceReplay getOneMessage(Long id){
        return ucsReplayService.getOneMessage(id);
    }

//    @RequestMapping("getAll")
//    @ResponseBody
    public List<userCserviceReplay> getAllMessage(Long nsuserId){
        List<userCserviceReplay> list = new ArrayList<>();
        //先判断第一条消息是否存在
        userCserviceReplay firstMessage = ucsReplayService.findFirstMessage(nsuserId);
        //存在
        if (!ObjectUtils.isEmpty(firstMessage)) {
            list.add(firstMessage);
            userCserviceReplay message = ucsReplayService.getOneMessage(firstMessage.getId());
            //是否有后续的消息存在
            while (!ObjectUtils.isEmpty(message)) {
                list.add(message);
                message = ucsReplayService.getOneMessage(message.getId());
            }
            return list;
        } else {//不存在
            return list;//null
        }
    }
    @RequestMapping("test")
    public void test(Long nsuserId){
        String customer = "";
        List<userCserviceReplay> message = getAllMessage(nsuserId);
        for (userCserviceReplay replay : message) {
            if (replay.getNsuserId() != null) {
                customer = "用户";
            } else {
                customer = "客服";
            }
            System.out.println(customer+":"+replay.getText());
        }
    }
}
