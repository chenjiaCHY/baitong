package com.ntschy.baitong.controller;

import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.entity.dto.RadarRequest;
import com.ntschy.baitong.service.AddressService;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/address")
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 输入非标准地址，搜索出标准地址并定位
     * @param key
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @GetMapping("/search")
    @ResponseBody
    public Result search(@RequestParam("key") String key) {

        try {
            List<SolrDocument> objects = addressService.search(key);
            return new Result<>(objects);
        } catch (Exception ex){
            return new Result<>(false,ex.getMessage());
        }
    }

    /**
     * 搜索附近150米范围内的地址
     * @param radarRequest
     * @return
     */
    @PostMapping("/radar")
    @ResponseBody
    public Result radar(@RequestBody @Validated RadarRequest radarRequest) {

        try {
            Result result = addressService.radar(radarRequest);
            return result;
        } catch (Exception ex){
            return new Result<>(false,ex.getMessage());
        }
    }
}
