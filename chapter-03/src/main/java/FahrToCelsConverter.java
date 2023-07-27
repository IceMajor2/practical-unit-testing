public class FahrToCelsConverter {

	public static double toFahrenheit(int celsius) {
		return (int) (celsius * 1.8) + 32;
	}

	public static int toCelsius(int fahrenheit) {
		return (int) (( 5 *(fahrenheit - 32.0)) / 9.0);
	}
}
