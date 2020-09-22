class DoMath{

	public static double calculateAverage(int[] numbers){

		double total=0;
		
		for(int number:numbers){
				total += number;
		}
		
		return total/numbers.length;
		
		

	}
}