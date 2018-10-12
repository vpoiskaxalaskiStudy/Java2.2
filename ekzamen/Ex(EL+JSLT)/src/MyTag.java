import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MyTag  extends TagSupport {
        public String value = "";
        public String name = "";

        public void setName(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int doStartTag() throws JspException {
            JspWriter out = pageContext.getOut();
            try {
                out.print(
                         "<input name =\"" + name + "\" type = \"text\" width = \"150\""
                        + " maxlength= \"9\" value =\""+this.value+"\" />");
            } catch (IOException e) {
                System.out.println("MyTag: " + e);
            }
            return SKIP_BODY;
        }
    }
