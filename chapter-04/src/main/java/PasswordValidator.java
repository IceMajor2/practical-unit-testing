import org.apache.commons.lang3.StringUtils;

public class PasswordValidator {

	private static final int MIN_CHARS = 12;

	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

	private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";

	private static final String DIGITS = "0123456789";

	public static boolean isValid(String password) {
		if (password.length() < MIN_CHARS
				|| !StringUtils.containsAny(password, DIGITS)
				|| !StringUtils.containsAny(password, UPPERCASE)
				|| !StringUtils.containsAny(password, LOWERCASE)
				|| !StringUtils.containsAny(password, SYMBOLS)) {
			return false;
		}
		return true;
	}
}