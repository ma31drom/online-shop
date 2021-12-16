package com.epam.shop.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet(value = "/sample-image", name = "getImage")
public class SampeImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (InputStream is = new FileInputStream(new File(FileUploadUserServlet.SAMPLE_IMAGE_PATH))) {
			resp.setContentType("image/jpeg");
			IOUtils.copy(is, resp.getOutputStream());
		}
	}

}
