package com.qikemi.packages.zxing.test;

import org.junit.Test;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qikemi.packages.zxing.QRcodeEncoder;
import com.qikemi.packages.zxing.QRcodeEntity;
import com.qikemi.packages.zxing.QRcodeLogoEntity;

public class ZxingQRcodeTest {
	
	@Test
	public void qrCodeSampleCreate() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeSampleCreate.png", "png");
			QRcodeEncoder.createQRcode(qRcodeEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrCodeSampleCreate2() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeSampleCreate2.png", 200, 200, "png");
			QRcodeEncoder.createQRcode(qRcodeEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrCodeFullCreate3() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("举头望明月，低头思故乡。\r\n可惜阴天呀。", "E://qrCodeFullCreate3.png", 300, 300, "png", ErrorCorrectionLevel.H, "GBK", 0);
			QRcodeEncoder.createQRcode(qRcodeEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrCodeLogoCreate() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeLogoCreate.png", "png");
			QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
			QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrCodeLogoCreate2() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeLogoCreate2.png", 200, 200, "png");
			QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
			QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void qrCodeLogoCreate3() {
		try {
			QRcodeEntity qRcodeEntity = new QRcodeEntity("举头望明月，低头思故乡。", "E://qrCodeLogoCreate3.png", 300, 300, "png", ErrorCorrectionLevel.H, "GBK", 0);
			QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
			QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
