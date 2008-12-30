package code.siagile.dojo.cases;

/** @author Luca Marrocco */
public class BadCamelCase {
	public static final String asCamelCase(String string) {
		char pch = 0, ch = 0;
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			ch = string.charAt(i);
			if (!Character.isLetterOrDigit(ch)) {
				pch = 0;
				continue;
			}
			if (pch == 0 && i > 0) ch = Character.toUpperCase(ch);
			if (pch == ' ') ch = Character.toUpperCase(ch);
			stringBuffer.append(pch = ch);
		}
		return stringBuffer.toString();
	}
}
