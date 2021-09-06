package murach.tags;

import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.text.DateFormat;

public class CurrentTimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        
        Date currentTime = new Date();
        DateFormat shortTime = DateFormat.getTimeInstance(DateFormat.LONG);
        String currentTimeFormatted = shortTime.format(currentTime);

        try {
            JspWriter out = pageContext.getOut();
            out.print(currentTimeFormatted);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }
}