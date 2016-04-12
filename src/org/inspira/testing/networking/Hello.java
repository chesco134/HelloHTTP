package org.inspira.testing.networking;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataInputStream entrada = new DataInputStream(request.getInputStream());
		int length;
		byte[] chunk = new byte[128];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while((length = entrada.read(chunk)) != -1)
			baos.write(chunk, 0, length);
		System.out.println("Recibimos: " + baos.toString());
		DataOutputStream salida = new DataOutputStream(response.getOutputStream());
		salida.write("Yeah!!".getBytes());
	}

}
