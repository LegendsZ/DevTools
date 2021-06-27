import java.util.Arrays;

public class DevTools {
	
	static String version = "V1.0.0.0";
	
	public DevTools() {
		System.out.println("You are using DevTools | " + version);
	}
	
	//checks if 2 objects are equal
	public boolean checkObjects_Equal(Object a, Object b) {
		try {
			if (a.getClass().equals(b.getClass())) {
				if (a.equals(b)) {
					return true;
				}
			}
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
	
	//checks if an array has a value
	public int checkArray_value_String(String value, String[] arrayString) {
		int index = -1;
		for (int i = 0; i < arrayString.length; i++) {
			if (arrayString[i].equals(value)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//checks if an array has a value
	public int checkArray_value_Integer(int value, int[] arrayString) {
		int index = -1;
		for (int i = 0; i < arrayString.length; i++) {
			if (arrayString[i] == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	//Copies values from one array to another (string variant)
	public boolean updateArray_String(String[] origin, String[] copyTo) {
		try {
			for (int i = 0; i < origin.length; i++) {
				copyTo[i] = origin[i];
			}
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	
	//Copies values from one array to another (integer variant)
	public boolean updateArray_Integer(int[] origin, int[] copyTo) {
		try {
			for (int i = 0; i < origin.length; i++) {
				copyTo[i] = origin[i];
			}
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	
	//Returns a number from a string
	public String retNum(String input) {
		if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
			return input.substring(0);
		} else if (input.length()==1 && !Character.isDigit(input.charAt(0))) {
			return "0";
		}
		
		String number = "";
		int start = -1;
		int end = -1;
		boolean isNum = false;
		String[] skips = {","};
		
		for (int i = 0; i < input.length(); i++) { 
			if (Character.isDigit(input.charAt(i)) || Arrays.stream(skips).anyMatch((input.charAt(i) + "")::equals)) {
				isNum = true;
				if (start == -1) start = i;
			} else {
				if (end == -1 && start != -1) end = i;
			}
		}
		if (isNum == true) {
			number = input.substring(start, end);
			number = number.replaceAll(",", "");
		}
		return number;
	}

	public Double retPlusTax(Double value, Double percent) {
		return value + ((value * percent)/100);
	}


	public String convertToWord(String input) {
		static String[] number_exception = {"-", ".",","};
		static String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
		static String[] words_set_one = {"hundred","thousand","million"};

		StringBuffer output = new StringBuffer(input);

		String number = "";
		int seq_start = -1;
		int seq_end = -1;

		for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i)) || Arrays.stream(number_exception).anyMatch((input.charAt(i) + "")::contains) == true) {
				if (seq_start == -1) {
					seq_start = i;
				}
				seq_end = i + 1;
			} else {
				if (seq_start != -1 && seq_end != -1) {
					number = input.substring(seq_start,seq_end);



					switch(number) {
						case "1":
							output.replace(seq_start, seq_end, "one");
							break;
						case "2":
							output.replace(seq_start, seq_end, "two");
							break;
						case "3":
							output.replace(seq_start, seq_end, "three");
							break;
						case "4":
							output.replace(seq_start, seq_end, "four");
							break;
						case "5":
							output.replace(seq_start, seq_end, "five");
							break;
						case "6":
							output.replace(seq_start, seq_end, "six");
							break;
						case "7":
							output.replace(seq_start, seq_end, "seven");
							break;
						case "8":
							output.replace(seq_start, seq_end, "eight");
							break;
						case "9":
							output.replace(seq_start, seq_end, "nine");
							break;
					}


				}
			}
		}
		return output.toString();
	}
}
