package com.bingo.news.controller;

import com.bingo.news.domain.Customer;
import com.bingo.news.domain.CustomerRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @RestController 的意思就是controller里面的方法都以json格式输出
 */
@RestController
public class GreetingController {
    private static final String TAG = "BC-GreetingController : ";
    private Log mLog = LogFactory.getLog(GreetingController.class);


    @Autowired
    private CustomerRepository customerRepository;

    //从数据库读取数据(好像不支持list)
    @RequestMapping("/greeting")
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Customer customer = customerRepository.findByName("zengbin");
        mLog.info("-->Customer: " + customer.getUserId());
        return customer;
    }

    //返回字符串接口
    @RequestMapping("/like")
    public String likeing() {
        return "like me";
    }

    //返回Json接口
    @RequestMapping("/getAuthorInfo")
    public Customer getAuthor() {
        Customer me = new Customer();
        me.setName("zengbin");
        me.setUserId(1L);
        return me;
    }

}