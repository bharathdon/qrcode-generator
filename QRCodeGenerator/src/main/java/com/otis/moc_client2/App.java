package com.otis.moc_client2;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Hello world!
 *
 */
public class App {

	private static final String QR_CODE_IMAGE_PATH = "F:/bharath.png";

	private static void generateQrCodeImage(String text, int width, int height, String filepath)
			throws WriterException, IOException {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filepath);
		MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
	}

	public static void main(String[] args) throws WriterException, IOException {

		generateQrCodeImage("this is my first qr code generator", 400, 400, QR_CODE_IMAGE_PATH);
		System.out.println("program completed successfully");
	}

}
