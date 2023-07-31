import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator {

	private static final int MIN_CHARS = 12;
	private static final int MIN_LOWERCASE = 1;
	private static final int MIN_UPPERCASE = 1;
	private static final int MIN_SYMBOLS = 1;
	private static final int MIN_DIGITS = 1;

	private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

	public static boolean isValid(String password) {
		List<Character> passwordChars = stringToCharList(password);
		if(passwordChars.size() < MIN_CHARS) {
			return false;
		}
		return true;
	}

	private static List<Character> stringToCharList(String string) {
		return string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	}
}
