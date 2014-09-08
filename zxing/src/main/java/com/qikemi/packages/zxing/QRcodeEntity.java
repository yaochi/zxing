package com.qikemi.packages.zxing;

import java.io.Serializable;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Create Date: 2014年8月30日 下午10:26:16 Author XieXianbin<a.b@hotmail.com> Source
 * Repositories Address: <https://github.com/qikemi/zxing>
 */

public class QRcodeEntity implements Serializable {

	private static final long serialVersionUID = 1219992044559635238L;

	/**
	 * 内容
	 */
	private String content;
	/**
	 * 二维码图片存储地址
	 */
	private String barCodePath;
	/**
	 * 二维码图片的宽度，默认100px 
	 */
	private Integer width = 100;
	/**
	 * 二维码图片的高度，默认同width 
	 */
	private Integer height = this.width;
	/**
	 * 生成图片的格式（默认png） ImageIO.write jpg png
	 */
	private String barCodeImgFormat = "png";
	/**
	 * 纠错级别，默认ErrorCorrectionLevel.H
	 * http://zxing.github.io/zxing/apidocs/com/google/zxing/qrcode/decoder/
	 * ErrorCorrectionLevel.html Enum Constant and Description H H = ~30%
	 * correction L L = ~7% correction M M = ~15% correction Q Q = ~25%
	 * correction
	 */
	private ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.H;
	/**
	 * 编码 http://zxing.github.io/zxing/apidocs/ AZTEC_LAYERS Specifies the
	 * required number of layers for an Aztec code: a negative number (-1, -2,
	 * -3, -4) specifies a compact Aztec code 0 indicates to use the minimum
	 * number of layers (the default) a positive number (1, 2, .. CHARACTER_SET
	 * Specifies what character encoding to use where applicable (type String)
	 * DATA_MATRIX_SHAPE Specifies the matrix shape for Data Matrix (type
	 * SymbolShapeHint) ERROR_CORRECTION Specifies what degree of error
	 * correction to use, for example in QR Codes. MARGIN Specifies margin, in
	 * pixels, to use when generating the barcode. MAX_SIZE Specifies a maximum
	 * barcode size (type Dimension). MIN_SIZE Specifies a minimum barcode size
	 * (type Dimension). PDF417_COMPACT Specifies whether to use compact mode
	 * for PDF417 (type Boolean). PDF417_COMPACTION Specifies what compaction
	 * mode to use for PDF417 (type Compaction). PDF417_DIMENSIONS Specifies the
	 * minimum and maximum number of rows and columns for PDF417 (type
	 * Dimensions).
	 */
	private String encodeCharacterSet = "UTF-8";
	/**
	 * 边缘留白，默认2px 
	 */
	private Integer margin = 2;
	/**
	 * 设置二维码版本
	 * http://zxing.github.io/zxing/apidocs/com/google/zxing/qrcode/decoder/Version.html
	 */
	private int version;

	// default 
	public QRcodeEntity() {
		super();
	}
	
	// sample 
	public QRcodeEntity(String content, String barCodePath, String barCodeImgFormat) {
		this.content = content;
		this.barCodePath = barCodePath;
		this.barCodeImgFormat = barCodeImgFormat;
	}
	
	// sample 2
	public QRcodeEntity(String content, String barCodePath, Integer width, Integer height, String barCodeImgFormat) {
		super();
		this.content = content;
		this.barCodePath = barCodePath;
		this.width = width;
		this.height = height;
	}
	
	// full 
	public QRcodeEntity(String content, String barCodePath, Integer width,
			Integer height, String barCodeImgFormat,
			ErrorCorrectionLevel errorCorrectionLevel,
			String encodeCharacterSet, int version) {
		super();
		this.content = content;
		this.barCodePath = barCodePath;
		this.width = width;
		this.height = height;
		this.barCodeImgFormat = barCodeImgFormat;
		this.errorCorrectionLevel = errorCorrectionLevel;
		this.encodeCharacterSet = encodeCharacterSet;
		this.version = version;
	}

	/** getter and setter **/
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBarCodePath() {
		return barCodePath;
	}

	public void setBarCodePath(String barCodePath) {
		this.barCodePath = barCodePath;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getBarCodeImgFormat() {
		return barCodeImgFormat;
	}

	public void setBarCodeImgFormat(String barCodeImgFormat) {
		this.barCodeImgFormat = barCodeImgFormat;
	}

	public ErrorCorrectionLevel getErrorCorrectionLevel() {
		return errorCorrectionLevel;
	}

	public void setErrorCorrectionLevel(
			ErrorCorrectionLevel errorCorrectionLevel) {
		this.errorCorrectionLevel = errorCorrectionLevel;
	}

	public String getEncodeCharacterSet() {
		return encodeCharacterSet;
	}

	public void setEncodeCharacterSet(String encodeCharacterSet) {
		this.encodeCharacterSet = encodeCharacterSet;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Integer getMargin() {
		return margin;
	}

	public void setMargin(Integer margin) {
		this.margin = margin;
	}

}
