package com.mozhengfly.count.demo.business.controller;


import com.mozhengfly.count.demo.business.service.IJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mozhengfly123
 * @since 2019-02-18
 */
@Controller
@RequestMapping("/count")
public class JController {

    @Autowired
    IJService ijService;

    @ResponseBody
    @RequestMapping("/add")
    public ResponseEntity<String> addCount() {
        String res = ijService.addCount();
        return ResponseEntity.ok("current count : " + res);
    }
}

