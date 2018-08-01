package frequenciesCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyClass {
    public static void main(String args[]) {
        int[] array = readData();
        int minValue = findMinValue(array);
        int maxValue = findMaxValue(array);
        minValue = checkIfMinEqualsMax(minValue, maxValue);
        Number[] numberArray = new Number[101];
        int maxFrequency = findMaxFrequency(minValue, maxValue, array);
        int minFrequency = findMinFrequency(minValue, maxValue, array);
        fillArrayWithNumbers(array, numberArray, minValue, maxValue);
        printGraph(numberArray, minFrequency, maxFrequency, minValue, maxValue);
        printNumbers(minValue, maxValue);
    }
    
    static int findMinValue(int[] numberArray){
        int min = 99999;
        for(int i = 0; i < numberArray.length; i++){
            if(min > numberArray[i]){
                min = numberArray[i];
            }
        }
        return min;
    }
    
    static int[] readData() {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("Enter your number list: ");
    	String name = "";
    	try {
			name = reader.readLine();
		} catch (IOException e) {
			System.out.println("You have to enter a valid number list");
		}
    	if(name.length() > 0) {
    		String[] integerStrings = name.split(" "); 
    		int[] temp = new int[integerStrings.length];
    		for (int i = 0; i < integerStrings.length; i++){
    		    try {
    		    	temp[i] = Integer.parseInt(integerStrings[i]); 
    		    }
    		    catch(Exception ex){
    		    	System.out.println("You have failed to provide the list in the required form. Please seperate the integers with a single whitespace. The app needs to be restarted. Example: 2 5 8 9 7");
    		    	break;
    		    }
    		}
    		return temp;
    	}
    	else {
    		System.out.println("You have to enter a valid number list, please restart the application.");
    		
    	}
    	return null;
    }
    
    static int checkIfMinEqualsMax(int minValue, int maxValue){
        int temp = 1;
        if(minValue == maxValue){
            return temp;
        }
        else{
            return minValue;
        }
    }
    
    static void printGraph(Number[] numberArray, int minFrequency, int maxFrequency, int minNumber, int maxNumber){
        int temp = maxFrequency;
        for (int i = maxFrequency; i > minFrequency ; i-- ){
            for(int j = minNumber; j < maxNumber + 1; j++){
                String tempString = "" + numberArray[j].getValue();
                if(numberArray[j].getFrequency() >= temp){
                    System.out.print("*");
                    for(int k = 0; k < tempString.length(); k++){
                        System.out.print(" ");
                    }
                }
                else{
                    for(int k = 0; k < tempString.length() + 1; k++){
                       System.out.print(" ");
                    }
                }
            }
            System.out.println("");
            temp = i - 1;
        } 
    }
    
    static void printNumbers(int minValue, int maxValue){
        for(int i = minValue; i < maxValue + 1; i++){
            if(i == maxValue) {
            	System.out.println(i);
            }
            else {
            	System.out.print(i + " ");
            }
        }
    }
    
    static int findMaxValue(int[] numberArray){
        int max = 0;
        for(int i = 0; i < numberArray.length; i++){
            if(max < numberArray[i]){
                max = numberArray[i];
            }
        }
        return max;
    }
    
    static int countFrequency(int[] numberArray, int numberToFind){
        int frequency = 0;
        for(int i = 0; i < numberArray.length; i++){
            if(numberToFind == numberArray[i]){
                frequency++;
            }
        }
        return frequency;
    }
    
    
    static void fillArrayWithNumbers(int[] array, Number[] numberArray, int minValue, int maxValue){
        for(int i = minValue; i < maxValue + 1; i++){
            numberArray[i] = new Number(i, countFrequency(array, i));
        }
    }
    
    
    static int findMaxFrequency(int minValue, int maxValue, int[] array){
        int maxFrequency = 0;
        for (int i = minValue; i < maxValue + 1 ; i++ ){
            int temp = countFrequency(array, i);
            if(maxFrequency < temp){
                maxFrequency = temp;
            }
        }
        return maxFrequency;
    }
    
    static int findMinFrequency(int minValue, int maxValue, int[] array){
        int minFrequency = 99999;
        for (int i = minValue; i < maxValue + 1 ; i++ ){
            int temp = countFrequency(array, i);
            if(minFrequency > temp){
                minFrequency = temp;
            }
        }
        return minFrequency;
    }
    
}

class Number{
    private int numberValue;
    private int frequencyValue;
    
    public Number(int numbervalue, int frequencyvalue){
        numberValue = numbervalue;
        frequencyValue = frequencyvalue;
    }
    
    public int getValue(){
        return numberValue;
    }
    
    public int getFrequency(){
        return frequencyValue;
    }
    
    public int lowerFrequency(){
        return frequencyValue - 1;
    }
}
