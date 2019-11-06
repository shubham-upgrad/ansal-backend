package mywebapp.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 *   There are three ways to create a Servlet
 *   1. Implement the Servlet Interface (You'll have handle everything from scratch)
 *   2. Extend the GenericServlet class (You'll have default implementations
 *                                      for Servlet method...Protocol Independent)
 *   3. Extend the HttpServlet class (For HTTP only with GET,POST,HEAD,DELETE,PUT,etc methods)
 */
@WebServlet("/helloworld")
public class HelloWorld extends HttpServlet {

    protected void someStuffIWantToDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String name=req.getParameter("nm");
        out.write("<h1>Hello, "+name+"</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        someStuffIWantToDo(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        someStuffIWantToDo(req,resp);
    }
}
// Business Logic with Presentational logic
// Here the servlet and the jsps are handling the request on their own
// and they contain business logic as well as the presentational
// Model 1 Architecture


// Model 2 Architecture : MVC - Model View Controller
