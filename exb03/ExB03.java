public class ExB03{

	public static void main(String[] args){
		int[] integerArray = {1,2,3,4,5,6,7,8,9,10};
		double total=0;
		double average;
		
		/*
		for(int i=0;i<integerArray.length;i++){
				total = total+integerArray[i];
		}
		*/	
		
		for(int number:integerArray){
				total += number;
		}
		
		average=total/integerArray.length;
		
		System.out.println("Total : " + total + " average : " + average);
		
	}
}