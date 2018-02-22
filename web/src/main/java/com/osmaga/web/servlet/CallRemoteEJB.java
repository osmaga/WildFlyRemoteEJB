package com.osmaga.web.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.osmaga.ejb.HelloRemote;

/**
 * Servlet implementation class CallRemoteEJB
 */
@WebServlet ("/CallRemoteEJB")
public class CallRemoteEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallRemoteEJB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

			InitialContext ctx = new InitialContext(properties);

			Object obj = ctx.lookup("ejbEAR/ejb/HelloBean!com.osmaga.ejb.HelloRemote");
			HelloRemote bean = (HelloRemote)obj;
			response.getWriter().append(bean.hello());
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("\nServed at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
