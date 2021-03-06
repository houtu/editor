package com.lanqiao.editor.tools;

import java.io.File;
import java.io.UnsupportedEncodingException;

import com.lanqiao.editor.component.EditorFrame;
import com.lanqiao.editor.component.FileMune;

public class EditorTool {
	public static void searchFile(File file1, String fileName) {
		if (file1.isDirectory()) {
			File[] files = file1.listFiles();
			if (files.length == 0 && file1.getName().equals(fileName)) {
				FileMune.file = new File(file1.getAbsolutePath());
			}
			for (File file2 : files) {
				searchFile(new File(file2.getAbsolutePath()), fileName);
			}
		} else {
			if (file1.getName().equals(fileName)) {
				FileMune.file = new File(file1.getAbsolutePath());
			}
		}
	}

	public static void searchFileForSave(File file1, String fileName) {
		if (file1.isDirectory()) {
			File[] files = file1.listFiles();
			for (File file2 : files) {
				searchFileForSave(new File(file2.getAbsolutePath()), fileName);
			}
		} else {
			if (file1.getName().equals(fileName)) {
				EditorFrame.jTreeFile = new File(file1.getAbsolutePath());
			}
		}
	}

	public static String bSubstring(String string, int length) {
		byte[] bytes = null;
		try {
			bytes = string.getBytes("Unicode");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int n = 0; // 表示当前的字节数
		int i = 2; // 要截取的字节数，从第3个字节开始
		for (; i < bytes.length && n < length; i++) {
			// 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
			if (i % 2 == 1) {
				n++; // 在UCS2第二个字节时n加1
			} else {
				// 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
				if (bytes[i] != 0) {
					n++;
				}
			}
		}
		// 如果i为奇数时，处理成偶数
		if (i % 2 == 1) {
			// 该UCS2字符是汉字时，去掉这个截一半的汉字
			if (bytes[i - 1] != 0)
				i = i - 1;
			// 该UCS2字符是字母或数字，则保留该字符
			else
				i = i + 1;
		}
		if (bytes.length > 20) {
			String string2 = null;
			try {
				string2 = new String(bytes, 0, i, "Unicode") + "…";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return string2;
		} else {
			return string + "     ";
		}
	}
}
