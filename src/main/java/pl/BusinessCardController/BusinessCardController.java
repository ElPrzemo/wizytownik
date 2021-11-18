package pl.BusinessCardController;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component


@RequestMapping("person")

public class BusinessCardController {

    public String getPerson() {
        return "details";
    }


}

