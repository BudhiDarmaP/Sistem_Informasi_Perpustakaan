package Control;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author budhidarmap
 */
public class CookieUtilities {

    public static String getCookieValue(HttpServletRequest request,
            String cookieName,
            String defaultValue) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return (cookie.getValue());
                }
            }
        }
        return (defaultValue);
    }

    public static Cookie getCookie(HttpServletRequest request,
            String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return (cookie);
                }
            }
        }
        return (null);
    }
}
