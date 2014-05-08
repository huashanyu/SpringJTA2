package co.uk.escape.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import co.uk.escape.model.EmployeeA;
import co.uk.escape.model.EmployeeB;
import co.uk.escape.service.EmployeeService;

@Component("appServlet")
public class AppServlet 
implements HttpRequestHandler {

	@Autowired
	private EmployeeService employeeService;

	public void handleRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeA em1 = new EmployeeA();
		em1.setId("123");
		em1.setName("John");
		em1.setAge(35);
		EmployeeB em2 = new EmployeeB();
		em2.setId("123");
		em2.setName("Mary");
		em2.setAge(31);

		try {
			employeeService.persistEmployees(em1, em2);
			 resp.setContentType("text/html");
		        PrintWriter out = resp.getWriter();
		        out.println("<h2>Both employees are inserted!</h2>");
		} catch (Exception e) {
			 resp.setContentType("text/html");
		        PrintWriter out = resp.getWriter();
		        out.println("<h2>Transaction Rollback!</h2>");
			e.printStackTrace();
		}
	}
}