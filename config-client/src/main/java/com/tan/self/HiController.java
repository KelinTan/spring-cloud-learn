package com.tan.self;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Mr.tan
 * Date: 2017/9/9
 */
@RestController
@RefreshScope
public class HiController {


    @Value("${lucky-word}")
    String luckyWord;
    @RequestMapping(value = "/hi")
    public String hi(){
        return luckyWord;
    }
}
