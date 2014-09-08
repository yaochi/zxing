zxing
=====

package for zxing. create by xiexianbin, use for creating QRcode.

http://zxing.github.io/zxing/apidocs/


实例
==

Default barcode:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeSampleCreate.png", "png");
QRcodeEncoder.createQRcode(qRcodeEntity);
```

demo1:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeSampleCreate2.png", 200, 200, "png");
QRcodeEncoder.createQRcode(qRcodeEntity);
```

demo2:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("举头望明月，低头思故乡。\r\n可惜阴天呀。", "E://qrCodeFullCreate3.png", 300, 300, "png", ErrorCorrectionLevel.H, "GBK", 0);
QRcodeEncoder.createQRcode(qRcodeEntity);
```

demo3:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeLogoCreate.png", "png");
QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
```

demo4:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("http://www.baidu.com", "E://qrCodeLogoCreate2.png", 200, 200, "png");
QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
```

demo5:
```
QRcodeEntity qRcodeEntity = new QRcodeEntity("举头望明月，低头思故乡。", "E://qrCodeLogoCreate3.png", 300, 300, "png", ErrorCorrectionLevel.H, "GBK", 0);
QRcodeLogoEntity rcodeLogoEntity = new QRcodeLogoEntity("E://l.png");
QRcodeEncoder.createQRcode(qRcodeEntity, rcodeLogoEntity);
```
