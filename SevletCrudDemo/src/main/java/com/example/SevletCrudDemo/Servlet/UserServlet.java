package com.example.SevletCrudDemo.Servlet;

import java.io.IOException;
import java.util.List;

import com.example.SevletCrudDemo.model.User;
import com.example.SevletCrudDemo.service.UserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (id == null || email == null || name == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" + " \"message\" : \"some fields are missing\"\n" + "}");
            return;
        }

        User user = new User(id, mobile, mobile, mobile);
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setMobile(mobile);

        userService.createdUser(user);

        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" + "\"messsage\" : \"user Added successfully" + "}");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");

        // 1. if 'id' paramenter is missing, return all users
        if (idParam == null || idParam.isEmpty()) {
            List<User> users = userService.getAllusers();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }

        // 2. parse ID and find specific user
        Integer id = Integer.parseInt(idParam);
        User userResp = userService.getUserById(id);

        // 3. handle user notfound
        if (userResp == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\n \"message\": \"User not found\"\n}");
            return;
        }

        // 4. return single user success response
        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userResp));
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {

    }

    private String userToJson(User userResp) {
        return ("{\n" +
                "  \"id\":" + userResp.getId() + ",\n" +
                "  \"name\":" + userResp.getName() + ",\n" +
                "  \"email\":" + userResp.getEmail() + ",\n" +
                "  \"mobile\":" + userResp.getMobile() + ",\n" +
                "}");
    }

    private String usersToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {
            stringBuilder.append(userToJson(users.get(i)));
            if (i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
