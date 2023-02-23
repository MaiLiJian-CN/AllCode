package cn.mlj;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns ={"/login"})
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");
        String checkCode=req.getParameter("check_code");
        String savedCode=(String) req.getSession().getAttribute("check_code");

        if (Objects.equals(name, "21190351") && Objects.equals(passwd, "21190351")&&checkCode.equals(savedCode)){
            resp.sendRedirect("/mailijian1218/mailijian_index.jsp");
        }else {
            resp.sendRedirect("/mailijian1218/mailijian_login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        doPost(req,resp);
    }
}
