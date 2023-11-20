package com.example.questionnaire;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TestA {
	
	@Test
	public void TestA1() { // ==============================菱形=============================
		Scanner scanner = new Scanner(System.in);
		int size;
		while(true) {
			while (true) {
				System.out.print("請輸入菱形的大小（奇數）: ");
				size = scanner.nextInt();
	
				if (size % 2 != 0) {
					break; // 如果是奇數，跳出迴圈
				} else {
					System.out.println("請輸入奇數。");
				}
			}
//			scanner.close();
	
			int space = size / 2;
			int stars = 1;
	
			// 上半部分菱形
			for (int i = 0; i < size; i++) {
	
				for (int j = 0; j < space; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < stars; j++) {
					System.out.print("*");
				}
	
				System.out.println();
	
				if (i < size / 2) {
					space--;
					stars += 2;
				} else {
					space++;
					stars -= 2;
				}
			}
		}
	};
}
