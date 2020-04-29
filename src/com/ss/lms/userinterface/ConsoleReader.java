package com.ss.lms.userinterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
	static BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));

	public static int readInt() {
		try {
			return Integer.parseInt(inputStream.readLine());
		} catch (Exception e) {
			System.out.println("Invalid Input");
			return -1;
		}
	}

	public static String readString() {
		try {
			return inputStream.readLine();
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

	public static boolean readBoolean() {
		try {
			return Boolean.valueOf(inputStream.readLine());
		} catch (Exception e) {
			System.out.println(e);
			return true;
		}
	}

	public static void pause() {
		try {
			System.in.read();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
