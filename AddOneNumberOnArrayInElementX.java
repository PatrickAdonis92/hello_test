/**
 *AddOneNumberOnArrayInElementX.java; 2024-04-11
 *Nguyễn Hoàn
 */
package oop.array;

import java.util.Scanner;

/**
 * Tạo ngẫu nhiên mảng một chiều n phần tử - n do người dùng nhập vào, có giá
 * trị chứa trong đoạn [-100, 100] và xuất mảng. Thêm 1 phần tử x tại vị trí k
 * do người dùng nhập vào.
 */
public class AddOneNumberOnArrayInElementX {

	private static int MIN = -1000;
	private static int MAX = 1000;

	/**
	 * 
	 * @param scan
	 * @return
	 */
	public static int inputN(Scanner scan) {
		int n;
		do {
			System.out.println("Nhập vào số phần tử n của mảng với n > 0: ");
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int[] createArray(int n) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (MIN + Math.random() * ((MAX - MIN) + 1));
		}
		return arr;
	}

	/**
	 * 
	 * @param arr
	 */
	public static void printArray(int arr[]) {
		System.out.println("Mảng đã khởi tạo là: ");
		for (int element : arr) {
			System.out.print(element + "\t");
		}
		System.out.println();
	}

	public static int[] addElement(int arr[], Scanner scan) {
		int k;
		int x;
		int arrTemp[] = new int[arr.length + 1];
		do {
			System.out.println("Nhập vào vị trí k cần thêm: ");
			k = Integer.parseInt(scan.nextLine());
		} while (k < 0 || k > arr.length);

		for (int i = 0; i < arrTemp.length; i++) {
			if (i < k) {
				arrTemp[i] = arr[i];
			} else if (i == k) {
				System.out.println("Nhập giá trị thêm vào x = ");
				x = Integer.parseInt(scan.nextLine());
				arrTemp[k] = x;
			} else {
				arrTemp[i] = arr[i - 1];
			}
		}
		arr = arrTemp;
		return arr;
	}

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			int n = inputN(scan);
			int arr[] = createArray(n);
			printArray(arr);
			arr = addElement(arr, scan);
			printArray(arr);
		} catch (Exception e) {
			System.out.println("Lỗi: " + e);
		}
	}
}
