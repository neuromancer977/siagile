package code.siagile.dojo.cases;

import static java.lang.Character.*;

import org.hamcrest.*;

/** @author Luca Marrocco */
public class GoodCamelCase {
	interface ChangeCase {
		char apply(char ch);

		boolean beAppliedTo(String string, int i);
	}

	interface Condition {
		boolean condition(String string, int i);
	}

	public static Condition newWord = new Condition() {
		public boolean condition(String string, int i) {
			return charAt(string, i - 1) == 0;
		}
	};

	public static Condition firstCharacter = new Condition() {
		public boolean condition(String string, int i) {
			return i == 0;
		}
	};

	private static void appendTo(StringBuilder stringBuilder, String string, int i, ChangeCase... changeCases) {
		char ch = charAt(string, i);
		for (ChangeCase changeCase : changeCases) {
			if (changeCase.beAppliedTo(string, i)) ch = changeCase.apply(ch);
		}
		if (ch != 0) stringBuilder.append(ch);
	}

	public static final String asCamelCase(String string) {
		return asMixedCase(string, uppercase(newWord), lowercase(firstCharacter));
	}

	public static final String asMixedCase(String string, ChangeCase... changeCases) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			appendTo(stringBuilder, string, i, changeCases);
		}
		return stringBuilder.toString();
	};

	private static char charAt(String string, int i) {
		if (i < 0) return 0;
		final char ch = string.charAt(i);
		if (!isLetterOrDigit(ch)) return 0;
		return ch;
	}

	public static final boolean isCamelCase(String string) {
		return string.equals(asCamelCase(string));
	}

	@Factory
	public static ChangeCase lowercase(final Condition condition) {
		return new ChangeCase() {
			public char apply(char ch) {
				return toLowerCase(ch);
			}

			public boolean beAppliedTo(String string, int i) {
				return condition.condition(string, i);
			}
		};
	}

	@Factory
	public static ChangeCase uppercase(final Condition condition) {
		return new ChangeCase() {
			public char apply(char ch) {
				return toUpperCase(ch);
			}

			public boolean beAppliedTo(String string, int i) {
				return condition.condition(string, i);
			}
		};
	}

}
