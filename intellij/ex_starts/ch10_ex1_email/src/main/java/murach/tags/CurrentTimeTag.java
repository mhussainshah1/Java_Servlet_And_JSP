package murach.tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CurrentTimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        ZonedDateTime currentTime = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG);
        String currentTimeFormatted = currentTime.format(formatter);

        try {
            JspWriter out = pageContext.getOut();
            out.print(currentTimeFormatted);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}
