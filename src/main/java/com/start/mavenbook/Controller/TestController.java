package com.start.mavenbook.Controller;

import com.start.mavenbook.DTO.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public UserDTO test() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(21);
        userDTO.setName("park");
        return userDTO;
    }

}
