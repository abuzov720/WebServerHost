import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by arturkrivopalov on 23.03.16.
 */
public class XyinezatorClass {

    public static String goChange(String s){
        Pattern pattern = Pattern.compile("[Б|В|Г|Д|Ж|З|К|Л|М|Н|П|Р|С|Т|Ф|Х|Ц|Ч|Ш|Щ|б|в|г|д|ж|з|к|л|м|н|п|р|с|т|ф|х|ц|ч|ш|щ]*");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()){
            return matcher.replaceFirst("хуй");
        }
        return "хуй" + s;
    }
}
