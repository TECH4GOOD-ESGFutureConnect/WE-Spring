package com.example.walkeverywhere.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoadViewController{
    @GetMapping("/loadview")
    public String loadview(){


        return "loadview";
    }

}
