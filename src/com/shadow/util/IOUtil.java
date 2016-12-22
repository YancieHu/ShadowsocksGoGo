package com.shadow.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class IOUtil {
	/**
	 * ���ļ����뵽һ��String������FileReader+BufferedReader(�ṩreadLine����)
	 * 
	 * @param fileName
	 * @return String
	 */
	public static String fileReaderStringHandle(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			File file = new File(fileName);
			BufferedReader in = new BufferedReader(new FileReader(
					file.getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	/**
	 * ʹ��FileInputStream+BufferedInputStream��byte�ķ�ʽ�����ļ�
	 * 
	 * @param fileName
	 * @return byte[]
	 */
	public static byte[] fileReaderByteHandle(String fileName) {
		byte[] data = null;
		try {
			BufferedInputStream bf = new BufferedInputStream(
					new FileInputStream(fileName));
			try {
				data = new byte[bf.available()];
				bf.read(data);

			} finally {
				bf.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return data == null ? new byte[] {} : data;
	}

	/**
	 * ��ָ����textд�뵽�ļ���ΪfileName���ļ���
	 * 
	 * @param fileName
	 * @param text
	 */
	public static void fileWriterHandle(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName));
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		fileWriterHandle("D:/zj.txt",
				fileReaderStringHandle("src/com/shadow/util/IOUtil.java"));
	}
}