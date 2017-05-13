package Control;

import javax.servlet.http.Cookie;

/**
 *
 * @author budhidarmap
 */
public class LongLivedCookie extends Cookie {

    public static final int SECONDS_PER_YEAR = 60 * 60 * 3;

    public LongLivedCookie(String name, String value) {
        super(name, value);
        setMaxAge(SECONDS_PER_YEAR);
    }
}
