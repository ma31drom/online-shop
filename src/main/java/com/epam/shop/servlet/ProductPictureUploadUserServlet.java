package com.epam.shop.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.epam.shop.domain.Person;
import com.epam.shop.domain.ProductPicture;
import com.epam.shop.repo.ProductPictureRepo;
import com.epam.shop.service.UserService;

@WebServlet(value = "/product-photo/upload", name = "product_upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ProductPictureUploadUserServlet extends HttpServlet {

	public static final String SAMPLE_IMAGE_DIR_PATH = "c:\\Users\\Maksim_Naumovich\\training\\";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long pId = Long.valueOf(req.getParameter("productId"));
		Part filePart = req.getPart("file");
		
		ProductPicture pic = new ProductPicture();
		
		pic.setName(filePart.getSubmittedFileName());
		pic.setPicturePath(SAMPLE_IMAGE_DIR_PATH.concat(pic.getName()));
		pic.setProductId(pId);
		
		ProductPicture save = ProductPictureRepo.getInstance().save(pic);
		
		
		filePart.getInputStream();
		File file = new File(pic.getPicturePath());

		if (!file.exists()) {
			file.createNewFile();
		}
		try (OutputStream os = new FileOutputStream(file)) {
			IOUtils.copy(filePart.getInputStream(), os);
		}
		req.getRequestDispatcher("/listProductsForEdit.jsp").forward(req, resp);
	}

}
