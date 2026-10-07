package Assignment1;

import java.util.Scanner;

public class Q4 {

	public static int searchKey(int arr[] , int key)
	{
		int left = 0, right = arr.length - 1, mid;
	
		
		while(left <= right)
		{
			
		mid = (left + right) / 2;

		if(key == arr[mid])
			return mid;
		else if(key > arr[mid])
			right = mid - 1;
		else
			left = mid+1;
		}
		return -1;
		
	}
	
	
	public static void main(String[] args) {

		int arr[] = {99,88,77,66,55,44,33,22,11};
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the key : ");
		
		int key = in.nextInt();
		
		int index = searchKey(arr,key);
		
		if(index != -1)
		{
			System.out.println("Key at found :" + index);
			
		}
		else
			System.out.println("Key not found");
				
	}

}
