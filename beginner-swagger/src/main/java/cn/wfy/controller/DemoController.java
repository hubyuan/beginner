package cn.wfy.controller;


import cn.wfy.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User addUser(@RequestBody @Valid User user){
        user.setPassword("had been dealed");
        return user;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
        //mock deleted;
        return new ResponseEntity("User had been deleted", HttpStatus.OK);
    }

    @RequestMapping(value = "/show", method= RequestMethod.GET)
    public User showUser(@RequestParam("id") Integer id){
        User user = new User();
        user.setAge(1);
        user.setPassword("show user");
        user.setGender("100");
        user.setName("test");
        return user;
    }
}
