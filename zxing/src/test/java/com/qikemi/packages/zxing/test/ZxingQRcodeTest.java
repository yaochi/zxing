package com.qikemi.packages.zxing.test;

import org.junit.Test;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qikemi.packages.zxing.QRcodeEncoder;
import com.qikemi.packages.zxing.QRcodeEntity;

public class ZxingQRcodeTest {
	
	@Test
	public void test1() {
		try {
//			int width = 200;
//			int height = 200;
//			String content = "测试信息图片的内容哦。";
//			BitMatrix matrix = MatrixToImageWriterEx.createQRCode(content, width, height);
//			MatrixToLogoImageConfig logoConfig = new MatrixToLogoImageConfig(Color.BLACK, 2);
//			MatrixToImageWriterEx.writeToFile(matrix, "jpg", "E:/img/1.jpg", "E:/img/1.jpg", logoConfig);
//			System.out.println("生成二维码结束！");
			QRcodeEncoder.createQRcode(new QRcodeEntity("http://www.baidu.com", "E://logo.png", 200, 200, true, "E://logo.png", "jpg", ErrorCorrectionLevel.H, "UTF-8", 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
