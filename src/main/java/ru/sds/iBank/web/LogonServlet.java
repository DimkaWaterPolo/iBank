package ru.sds.iBank.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ru.sds.iBank.dao.impl.Dao;
import ru.sds.iBank.entities.Client;
import ru.sds.iBank.services.impl.Service;


public class LogonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Service service;

	public LogonServlet() {
		Dao dao = new Dao();
		service = new Service();
		service.setDao(dao);
	}
	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String password = request.getParameter("password");
    	String login = request.getParameter("login");
    	
 		if(service.isLogin(login, password)) {
 			Client client = service.getClientByLogin(login);
 			HttpSession session = request.getSession(true);
 			session.setAttribute("client", client);
 			response.sendRedirect("./main");
    	}else {
    		response.sendRedirect("./error");
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}
