package com.qikemi.packages.zxing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.QRCode;

/**
 * 创建二维码 
 * Create Date: 2014年8月30日 下午11:59:34
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/zxing>
 */
public class QRcodeEncoder {

	private static Logger logger = Logger.getLogger(QRcodeEncoder.class);
	public QRcodeEncoder() {}
	public static QRcodeEncoder encoder;
	
	public static QRcodeEncoder getInstance(){
		if(null == encoder){
			encoder = new QRcodeEncoder();
		}
		return encoder;
	}
	
	/**
	 * create a new QRcode width 
	 */
	public static void createQRcode(QRcodeEntity qRcodeEntity){
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// char set 
		if(null == qRcodeEntity.getEncodeCharacterSet()){
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		}else{
			hints.put(EncodeHintType.CHARACTER_SET, qRcodeEntity.getEncodeCharacterSet());
		}
		// set error correction level 
		if(null == qRcodeEntity.getErrorCorrectionLevel()){
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		}else{
			hints.put(EncodeHintType.ERROR_CORRECTION, qRcodeEntity.getErrorCorrectionLevel());
		}
		// set margin 
		if(null == qRcodeEntity.getMargin()){
			hints.put(EncodeHintType.MARGIN, 0);
		}else{
			hints.put(EncodeHintType.MARGIN, qRcodeEntity.getMargin());
		}
		OutputStream outputStream = null;
		try {
			BitMatrix matrix = QRcodeEncoder.encode(qRcodeEntity.getContent(), BarcodeFormat.QR_CODE, qRcodeEntity.getWidth(),  qRcodeEntity.getHeight(), hints);
			File barCodeFile = new File(qRcodeEntity.getBarCodePath());
			outputStream = new FileOutputStream(barCodeFile);
			//		Parameters:
			//			matrix - BitMatrix to write
			//			format - image format
			//			file - file Path to write image to
			//			config - output configuration
			MatrixToImageWriter.writeToStream(matrix, qRcodeEntity.getBarCodeImgFormat(), outputStream, new MatrixToImageConfig());
			// save QRcode  
			outputStream.flush();
			outputStream.close();
			
			// judge has or has not logo 
			if(qRcodeEntity.isHasLogo()){
				BufferedImage bufferedImage = ImageIO.read(new FileInputStream(barCodeFile));
				int width_4 = matrix.getWidth() / 4;  
	            int width_8 = width_4 / 2;  
	            int height_4 = matrix.getHeight() / 4;  
	            int height_8 = height_4 / 2; 
	            /* 返回由指定矩形区域定义的子图像 */  
	            BufferedImage bufferedTargetImage = bufferedImage.getSubimage(width_4 + width_8, height_4 + height_8, width_4, height_4);  
				/*获取一个绘图工具笔*/ 
				Graphics2D graphics2d = bufferedTargetImage.createGraphics();
				/*读取logo图片信息*/
				File logoFile = new File(qRcodeEntity.getLogoPath());
				BufferedImage logoBufferImg = ImageIO.read(logoFile);
	            /*当前图片的宽与高*/  
	            int currentLogoWidth = logoBufferImg.getWidth(null);
	            int currentLogoHeight = logoBufferImg.getHeight(null);
	            /*处理图片的宽与高*/  
	            int resultLogoWidth = 0;  
	            int resultLogoHeight = 0;  
	            if(currentLogoWidth != width_4){  
	            	resultLogoWidth = width_4;  
	            }  
	            if(currentLogoHeight != width_4){  
	            	resultLogoHeight = width_4;  
	            } 
	            /*设置边框*/
	            graphics2d.setStroke(new BasicStroke(2));
	            graphics2d.setColor(Color.RED);
	            /*绘制图片*/  
	            graphics2d.drawImage(logoBufferImg, 0, 0, resultLogoWidth, resultLogoHeight, null);
	            graphics2d.dispose();
	            bufferedImage.flush(); 
				/* save file */
				ImageIO.write(bufferedImage, qRcodeEntity.getBarCodeImgFormat(), barCodeFile);
			}
		} catch (WriterException e) {
			logger.debug(e.getMessage());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
	}
	
	/**
	 * package for encode QRcode.
	 * 
	 * * Encode a barcode using the default settings.
	 * 
	 * http://zxing.github.io/zxing/apidocs/com/google/zxing/qrcode/encoder/Encoder.html#encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel)
		public static QRCode encode(String content,
	            ErrorCorrectionLevel ecLevel)
	                     throws WriterException
		Parameters:
		content - text to encode
		ecLevel - error correction level to use
		Returns:
		QRCode representing the encoded QR code
		Throws:
		WriterException - if encoding can't succeed, because of for example invalid content or configuration
	*/
	public static QRCode encode(String contents, ErrorCorrectionLevel ecLevel){
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		return null;//multiFormatWriter.encode(contents, format, width, height);
	}
	
	/**
	 * 
	 * http://zxing.github.io/zxing/apidocs/com/google/zxing/MultiFormatWriter.html
	 * Encode a barcode using the default settings.
	 * @throws WriterException 
	 */
	
	public static BitMatrix encode(String contents, BarcodeFormat format, int width, int height) throws WriterException{
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		return multiFormatWriter.encode(contents, format, width, height);
	}
	
	/**
	 * http://zxing.github.io/zxing/apidocs/com/google/zxing/MultiFormatWriter.html#encode(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map)
	 * @throws WriterException 
	 */
	public static BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException{
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		return multiFormatWriter.encode(contents, format, width, height, hints);
	}
	
	/** getters and setters **/
	public static QRcodeEncoder getEncoder() {
		return encoder;
	}
	public static void setEncoder(QRcodeEncoder encoder) {
		QRcodeEncoder.encoder = encoder;
	}
	
}
