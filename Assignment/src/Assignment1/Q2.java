// Implement linear search algorithm to find the nth occurence of the given element. 
// If nth occurrence is not found, return -1

package Assignment1;


import java.util.Scanner;

public class Q2 {

	
	public static int searchKey(int arr[],int key,int o)
	{
		int count = 0;
		
		for(int i = 0; i < arr.length;i++)
		{
			if(key == arr[i])
			{
				count++;		
				if (count == o) 
				{
                    return i;
				}
				
			}
		}
		return -1;
	
	}
	
	public static void main(String[] args)
	{
		
		int arr[] = {10,20,30,10,40,20,50,10,20,30,30};
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a key :");
		
		int key = in.nextInt();
		
		System.out.println("Enter the ocurrence no you want. :");
		int o = in.nextInt();
		
		int index = searchKey(arr,key,o);	
			System.out.println("Occurence of " + key + " element is at:" + index);
		
	}
	
	
}


