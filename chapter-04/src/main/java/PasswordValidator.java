import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class PasswordValidator {

	private static final int MIN_CHARS = 12;
	private static final int MIN_LOWERCASE = 1;
	private static final int MIN_UPPERCASE = 1;
	private static final int MIN_SYMBOLS = 1;
	private static final int MIN_DIGITS = 1;

	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
	private static final String DIGITS = "0123456789";

	public static boolean isValid(String password) {
		//List<Character> passwordChars = stringToCharList(password);
		if(password.length() < MIN_CHARS) {
			return false;
		}
		if(!StringUtils.containsAny(password, DIGITS)) {
			return false;
		}
		if(!StringUtils.containsAny(password, UPPERCASE)) {
			return false;
		}
		if(!StringUtils.containsAny(password, LOWERCASE)) {
			return false;
		}
		if(!StringUtils.containsAny(password, SYMBOLS)) {
			return false;
		}
		return true;
	}

//	private static List<Character> stringToCharList(String string) {
//		return string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//	}
}
