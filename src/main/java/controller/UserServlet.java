package controller;

import dao.AbstractDao;
import dao.UserDao;
import model.User;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private AbstractDao<User> userAbstractDao = new UserDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String action = request.getParameter("action");

       if (action == null)
       {
           action = "";
       }
       switch (action)
       {
           case "add":
                   break;
           case "edit":
                 Long id = Long.parseLong(request.getParameter("id"));
                 User user = userAbstractDao.get(id);
                 request.setAttribute("id", id);
                 request.setAttribute("name", user.getName());
                 request.setAttribute("email", user.getEmail());
                 request.setAttribute("country", user.getCountry());
                 request.getRequestDispatcher("update.jsp").forward(request, response);

               break;
           default:
               request.setAttribute("users", userAbstractDao.findAll());
               request.getRequestDispatcher("index.jsp").forward(request, response);
       }
    }

}