package com.lakshini.configconsumer.configconsumer;

import com.lakshini.configconsumer.configconsumer.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller //to fetch the response to a browser.
public class profileController {

    @Autowired //autowiring the configurations
    MemberProfileConfiguration memberProfileConfiguration;

    /*
    //For Rrestendpoint call
    @RequestMapping(value = "/profile")
    public MemberProfileConfiguration getConfig() {
        return memberProfileConfiguration;   //returns entire configurations in the MemberProfileConfiguration class.
    }
    */

    //For getting response in the browser or UI
    @RequestMapping(value = "/profile")
    public String getConfig(Model model) {
        model.addAttribute("model", memberProfileConfiguration.getDefaultModel());
        model.addAttribute("min", memberProfileConfiguration.getMinRentPeriod());
        return "mprofile"; //this has nothing to do with the URL or the file name. Also we are returning a String here.
    }

}


