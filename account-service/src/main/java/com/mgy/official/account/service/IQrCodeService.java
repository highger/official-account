package com.mgy.official.account.service;

import com.mgy.official.account.service.req.QrCodeReq;

/**
 * @author mgy
 * @date 2023/8/28
 */
public interface IQrCodeService {

    String getTemporaryQrCode(QrCodeReq qrCodeReq);
}
