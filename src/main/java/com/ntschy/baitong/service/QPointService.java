package com.ntschy.baitong.service;

import com.ntschy.baitong.entity.base.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface QPointService {

    Result uploadImage(String qid, MultipartFile file) throws RuntimeException;
}
