package com.ntschy.baitong.service;

import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.entity.dto.RadarRequest;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AddressService {
    // 搜索地址
    List<SolrDocument> search(String key) throws IOException, SolrServerException;

    // 找到一定范围内的地址
    Result radar(RadarRequest radarRequest) throws RuntimeException;
}
