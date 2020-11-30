package com.study.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.study.bean.UserBean;
import com.study.mapper.impl.UserMapperImpl;
import com.study.po.User;
import java.util.List;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 消费者
 *
 * @author pengwei.tan 2019-03-23
 */
@Service
@RocketMQMessageListener(
    topic = "USER_DOMN_FILE_TOPIC",
    consumerGroup = "ROCKET_GROUP",
    selectorExpression = "*")
public class ServiceRocketUserConsumer implements RocketMQListener<String> {

  private static final Logger logger = LoggerFactory.getLogger(ServiceRocketUserConsumer.class);
  private static final String head = "用户信息下载";

  @Autowired private UserMapperImpl userMapperImpl;

  @Override
  public void onMessage(String msg) {
    logger.info("接收消息message{}", msg);
    User user = JSONObject.parseObject(msg, User.class);
    List<User> userList = userMapperImpl.selectAll(user);
    String fileName = "/Users/tanpengwei/Documents/" + System.currentTimeMillis() + ".xlsx";
    EasyExcel.write(fileName, UserBean.class).sheet("用户").doWrite(userList);
  }
}
