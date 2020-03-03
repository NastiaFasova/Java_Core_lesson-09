package task1;

/**This class extends Exception class and throws exceptions 
 * if the user entered the wrong data*/

	@SuppressWarnings("serial")
	public class WrongInputConsoleParametersException extends Exception{
		private String message;
		public WrongInputConsoleParametersException(String message) {
			super(message);
		}
	}





