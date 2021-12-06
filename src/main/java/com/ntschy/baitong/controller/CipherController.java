package com.ntschy.baitong.controller;

import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.entity.dto.CipherRequest;
import com.ntschy.baitong.utils.MD5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cipher")
@Validated
public class CipherController {

    @PostMapping("/cipherText")
    @ResponseBody
    public Result cipherText(@RequestBody @Validated CipherRequest cipherRequest) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appId").append(cipherRequest.getAppId())
                .append("appKey").append(cipherRequest.getAppKey())
                        .append("randomSeries").append(cipherRequest.getRandomSeries())
                        .append("timestamp").append(cipherRequest.getTimestamp());
        String cipherText = MD5Utils.StringToMD5(stringBuilder.toString());

        return new Result(cipherText);
    }

}
