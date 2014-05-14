package co.uk.escape.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestHandler;

import co.uk.escape.model.EmployeeA;
import co.uk.escape.model.EmployeeB;
import co.uk.escape.service.EmployeeService;

@Component("findServlet")
public class findServlet 
implements HttpRequestHandler {

	@Autowired
	private EmployeeService employeeService;
	
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeA em1 = new EmployeeA();
		em1.setId("123");

		
		try {
				em1 = employeeService.findEmployees(em1);
				resp.setContentType("text/html");
		        PrintWriter out = resp.getWriter();
		        out.println("<h2>EmployeeA</h2>");
		        out.println(em1);
		} catch (Exception e) {
			 resp.setContentType("text/html");
		        PrintWriter out = resp.getWriter();
		        out.println("<h2>Transaction Rollback!</h2>");
			e.printStackTrace();
		}
	}
}