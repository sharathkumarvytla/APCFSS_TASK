package com.example.OrderService.Utility;

import java.util.Random;

public class GenerateOrderId {

	public String createOrderId() {
		String randomString = "";
		try {
			String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			int length = 7;
			for (int i = 0; i < length; i++) {
				int index = random.nextInt(alphabet.length());
				char randomChar = alphabet.charAt(index);
				sb.append(randomChar);
			}
			randomString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomString;
	}
}