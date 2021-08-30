package com.cj.controller;


import com.cj.pojo.StationInformation;
import com.cj.service.StationInformationService;
import com.cj.utils.CheckBindingResult;
import com.cj.utils.CommentResult;
import com.cj.utils.CommentResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hcj
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/station-information")
public class StationInformationController {
    @Autowired
    private StationInformationService stationInformationService;
    @PostMapping(value = "/updateStation")
    public CommentResult updateStation(@RequestBody @Valid StationInformation stationInformation, BindingResult bindingResult){
        CheckBindingResult.checkBindResult(bindingResult);
        return CommentResultUtil.success(stationInformationService.updateStation(stationInformation));
    }

    @GetMapping(value = "/getStation")
    public CommentResult selectStation(){
        return CommentResultUtil.success(stationInformationService.selectStation());
    }
}

