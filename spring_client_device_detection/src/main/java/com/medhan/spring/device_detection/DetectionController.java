package com.medhan.spring.device_detection;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by mhan on 4/6/16.
 */

@Controller
public class DetectionController {

    @RequestMapping("/detect_my_device")
    public @ResponseBody String detectDevice (Device device){
        String deviceType = "unknown";
        if(device.isNormal()){
            deviceType = "PC";
        } else if (device.isMobile()){
            deviceType = "mobile";
        } else if (device.isTablet()){
            deviceType = "tablet";
        }
        return "THis browser runs on top of a "+deviceType+" !";
    }
}
