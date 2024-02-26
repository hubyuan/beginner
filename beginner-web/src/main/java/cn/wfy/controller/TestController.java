package cn.wfy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addUser() {
        Excutor excutor = new Excutor();

        try {
            excutor.excutor1("SEND:Hello World");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
