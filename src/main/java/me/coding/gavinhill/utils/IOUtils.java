package me.coding.gavinhill.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	private IOUtils() {

	}

	/**
	 * 读取流中的数据写到输出流中
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void In2Out(InputStream in, OutputStream out) throws IOException {
		int len = 0;
		byte buffer[] = new byte[1024];
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param in
	 * @param out
	 */
	public static void closeIO(InputStream in, OutputStream out) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				in = null;
			}
		}
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out = null;
			}
		}
	}
}
