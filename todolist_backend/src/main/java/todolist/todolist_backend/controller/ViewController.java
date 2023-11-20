import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping({ "/**/{[path:[^\\.]*}" })
    public String redirect() {
        return "forward:/";
    }

}