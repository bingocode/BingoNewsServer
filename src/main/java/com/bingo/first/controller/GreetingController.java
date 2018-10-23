package com.bingo.first.controller;

import com.bingo.first.domain.Customer;
import com.bingo.first.domain.CustomerRepository;
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

    @Autowired
    private CustomerRepository customerRepository;

    //从数据库读取数据(好像不支持list)
    @RequestMapping("/greeting")
    public Customer greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Customer customer = customerRepository.findByName("zengbin");
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