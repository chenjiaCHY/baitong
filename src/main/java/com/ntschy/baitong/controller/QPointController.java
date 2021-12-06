package com.ntschy.baitong.controller;

import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.service.QPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/qpoint")
@Validated
public class QPointController {

    @Autowired
    private QPointService qPointService;

    @PostMapping("/uploadImage")
    @ResponseBody
    public Result uploadImage(@RequestParam("qid") String qid, @RequestParam("file") MultipartFile file) {

        try {
            Result result = qPointService.uploadImage(qid, file);
            return result;
        } catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

}
