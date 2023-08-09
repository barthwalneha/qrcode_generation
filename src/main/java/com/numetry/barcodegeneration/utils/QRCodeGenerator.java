package com.numetry.barcodegeneration.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.numetry.barcodegeneration.model.Employee;
//import com.google.zxing.qrcode.encoder.MatrixToImageWriter;
import java.io.IOException;

import java.nio.file.FileSystems;
import java.nio.file.Path;
public class QRCodeGenerator {
    public static void generatesQRCode(Employee employee) throws WriterException, IOException {
        String qrCodePath = "/Users/swarooppandey/Desktop/barcodegeneration/QR_CODES/";
        String qrCodeName = qrCodePath + employee.getFirstName() + employee.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("ID:" + employee.getId() + "\n" +
                                                      "Firstname:" +employee.getFirstName() +"\n"+
                                                      "Lastname:"+employee.getLastName()+"\n"+
                                                       "Email:" +employee.getEmail()+"\n"+
                                                       "Mobile:" +employee.getMobile(), BarcodeFormat.QR_CODE,400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
       // boolean created = path.toFile().createNewFile();
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);

    }
}
