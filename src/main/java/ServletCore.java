import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by arturkrivopalov on 22.03.16.
 */


public class ServletCore extends HttpServlet {

    final ArrayList<String> wordsList = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.append(
                "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "   <title>Xyiver</title>" +
                        "</head>" +
                        "<body>" +
                        "   <from action= ' " + req.getContextPath() + "/' method='post'>" +
                        "       Name :<input type='text' name='name'>" +
                        "       <input type='submit' value='Submit'>" +
                        "   <from>" +
                        this.viewResult() +
                        "</body>" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        this.wordsList.add(req.getParameter("name"));
        this.doGet(req, resp);
    }

    public String viewResult(){
        StringBuilder sb = new StringBuilder();
        sb.append("<p>Words</p>");
        sb.append("<table style='border : 1px solid black'>");
        for (String s : wordsList){
            sb.append("<tr><td style='border : 1px solid black'>").append(XyinezatorClass.goChange(s)).append("</td></tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }


}
