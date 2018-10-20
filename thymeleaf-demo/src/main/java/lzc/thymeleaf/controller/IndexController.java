package lzc.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by liuzc on 2018/10/20.
 */
@Controller
public class IndexController {

    @GetMapping({"/", ""})
    public String index(Model model){
        model.addAttribute("message","hello, world!");
        return "index";
    }

}
