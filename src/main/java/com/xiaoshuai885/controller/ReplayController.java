package com.xiaoshuai885.controller;

import com.xiaoshuai885.domain.userCserviceReplay;
import com.xiaoshuai885.service.ucsReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


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

    @RequestMapping("getAll")
    @ResponseBody
    public Map<Object,Object> getAllMessage(Long nsuserId){
        Map<Object,Object> map = new HashMap<>();
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
            map.put("message",list);
            return map;
        } else {//不存在
            map.put("no message",list);
            return map;
        }
    }
//    @RequestMapping("test")
//    public void test(Long nsuserId){
//        String customer = "";
//        List<userCserviceReplay> message = getAllMessage(nsuserId);
//        for (userCserviceReplay replay : message) {
//            if (replay.getNsuserId() != null) {
//                customer = "用户";
//            } else {
//                customer = "客服";
//            }
//            System.out.println(customer+":"+replay.getText());
//        }
//    }

    @RequestMapping("save")
    @ResponseBody
    public Map<Object,Object> saveMessage(Long nsuserId, String text, Long lastId){
        if ( (text == null || text == "") && lastId == null ) {
            return null;
        }
        boolean b = ucsReplayService.saveMessage(nsuserId,text,new Date(),lastId);
        HashMap<Object, Object> map = new HashMap<>();
        if (b) {
            map.put("success","1111111111");
        }else{
            map.put("failure","5555555555");
        }
        return map;
    }
}
