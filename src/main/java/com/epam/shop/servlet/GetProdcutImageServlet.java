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

import com.epam.shop.domain.ProductPicture;
import com.epam.shop.repo.ProductPictureRepo;

@WebServlet(value = "/product-photo", name = "get-image-for-prodcut")
public class GetProdcutImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("productImgId");

		ProductPicture byId = ProductPictureRepo.getInstance().getById(Long.valueOf(parameter));

		try (InputStream is = new FileInputStream(new File(byId.getPicturePath()))) {
			resp.setContentType("image/jpeg");
			IOUtils.copy(is, resp.getOutputStream());
		}
	}

}
