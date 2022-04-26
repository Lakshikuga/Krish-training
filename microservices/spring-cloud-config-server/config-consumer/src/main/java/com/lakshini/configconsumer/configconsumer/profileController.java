package com.lakshini.configconsumer.configconsumer;

import com.lakshini.configconsumer.configconsumer.model.MemberProfileConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class profileController {

    @Autowired //autowiring the configurations
    MemberProfileConfiguration memberProfileConfiguration;

    @RequestMapping(value = "/profile")
    public MemberProfileConfiguration getConfig() {
        return memberProfileConfiguration;   //returns entire configurations in the MemberProfileConfiguration class.
    }
}
