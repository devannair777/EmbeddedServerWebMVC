package Demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Controller
@RequestMapping("/iot")
public class WebMvc
{

    public WebMvc(){}

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public String data()
    {
        return "data";
    }



}
