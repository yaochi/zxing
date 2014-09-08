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
