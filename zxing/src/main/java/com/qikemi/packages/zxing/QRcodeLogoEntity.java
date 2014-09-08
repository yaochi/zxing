package com.qikemi.packages.zxing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 * 
 * Create Date: 2014年8月30日 下午11:38:22
 * Author XieXianbin<a.b@hotmail.com>
 * Source Repositories Address: <https://github.com/qikemi/zxing>
 */
public class QRcodeLogoEntity {
	
	private String logoPath;
	private Stroke stroke = new BasicStroke(2);
	private Color color = Color.RED;
	
	// default 
	public QRcodeLogoEntity() {
		super();
	}
	
	// sample 
	public QRcodeLogoEntity(String logoPath) {
		super();
		this.logoPath = logoPath;
	}
	
	// full 
	public QRcodeLogoEntity(String logoPath, Stroke stroke, Color color) {
		super();
		this.logoPath = logoPath;
		this.stroke = stroke;
		this.color = color;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
