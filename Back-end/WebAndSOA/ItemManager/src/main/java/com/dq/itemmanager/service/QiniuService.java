package com.dq.itemmanager.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * @author: Gu HungJou
 * @date: 2022/5/15 16:28
 * Describe:
 */
public interface QiniuService {
    String uploadFile(File file) throws QiniuException;

    String uploadFile(InputStream inputStream) throws QiniuException;

    Response delete(String key) throws QiniuException;
}
