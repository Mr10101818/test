package com.itheima;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Response {

    @RequestMapping("/response")
    public ResponseEntity<String> hello() {
        return  ResponseEntity.status(200).header("name","mr").body("success");
    }
}
