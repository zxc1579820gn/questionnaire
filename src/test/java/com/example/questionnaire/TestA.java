package com.example.questionnaire;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TestA {
	
	@Test
	public void TestA1() { // ==============================�٧�=============================
		Scanner scanner = new Scanner(System.in);
		int size;
		while(true) {
			while (true) {
				System.out.print("�п�J�٧Ϊ��j�p�]�_�ơ^: ");
				size = scanner.nextInt();
	
				if (size % 2 != 0) {
					break; // �p�G�O�_�ơA���X�j��
				} else {
					System.out.println("�п�J�_�ơC");
				}
			}
//			scanner.close();
	
			int space = size / 2;
			int stars = 1;
	
			// �W�b�����٧�
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
