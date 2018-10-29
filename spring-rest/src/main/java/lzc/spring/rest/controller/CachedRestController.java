package lzc.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuzc on 2018/10/25.
 */
@Controller
public class CachedRestController {

    @RequestMapping
    @ResponseBody
    public String helloWorld(){
        return "hello world!";
    }

    @RequestMapping("/cache")
    public ResponseEntity<String> cachedHelloWorld(
            @RequestParam(required = false, defaultValue = "false") boolean cached){
        if(cached){
            return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
        }

        ResponseEntity<String> responseEntity = new ResponseEntity<String>("hello world!",HttpStatus.OK);
        return responseEntity;
    }
}
