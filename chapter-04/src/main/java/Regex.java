import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	private static final String THREE_OR_MORE_DIGIT_REGEX = "\\d{3,}";

	public static String digitSequence(String input) {
		Pattern pattern = Pattern.compile(THREE_OR_MORE_DIGIT_REGEX);
		Matcher matcher = pattern.matcher(input);

		List<String> sequences = new ArrayList<>();
		StringBuilder sb = new StringBuilder("");
		while(matcher.find()) {
			sequences.add(matcher.group());
		}
		return String.join(", ", sequences);
	}
}
