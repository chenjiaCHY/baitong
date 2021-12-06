package com.ntschy.baitong.service.impl;

import com.ntschy.baitong.dao.QPointDao;
import com.ntschy.baitong.entity.base.FileDec;
import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.service.QPointService;
import com.ntschy.baitong.utils.ToolUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class QPointServiceImpl implements QPointService {

    @Value("${file.uploadPath}")
    private String uploadPath;

    @Resource
    private QPointDao qPointDao;

    @Override
    public Result uploadImage(String qid, MultipartFile file) throws RuntimeException {

        FileDec fileDec = ToolUpload.fileUpload2(file, uploadPath);

        // 更新数据库表
        qPointDao.updateImagePath(qid, fileDec.getFileName());

        return new Result<>(fileDec);
    }

}
