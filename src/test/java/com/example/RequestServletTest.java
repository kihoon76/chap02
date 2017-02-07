package com.example;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RequestServletTest extends Mockito {

	private PrintWriter writer;
	
	@Before
	public void setup() throws UnknownHostException, IOException {
		Socket soc = new Socket("localhost", 8080);
		
		OutputStream out = soc.getOutputStream();
		writer = new PrintWriter(out);
	}
	
	
	/*@Test
	public void requestTest() throws UnknownHostException, IOException {
		Socket soc = new Socket("localhost", 8080);
		
		OutputStream out = soc.getOutputStream();
		InputStream in = soc.getInputStream();
		
		PrintWriter writer = new PrintWriter(out);
		Scanner reader = new Scanner(in);
		
		writer.println("GET /request HTTP/1.1");
		writer.println("Host: localhost");
		writer.println();
		writer.flush();
		
		while(reader.hasNextLine()) {
			System.out.println(reader.nextLine());
		}
	}*/
	
	@Test
	public void test() throws IOException, ServletException {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		when(response.getWriter()).thenReturn(writer);
		
		new RequestServlet().doGet(request, response);
		
		
	}
	
	
}
