package org.elis.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.elis.dao.inMemory.JDBCUtenteDao;
import org.elis.utility.MyUtility;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ResetPasswordServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("public-jsp/resetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String step = request.getParameter("step");

        JDBCUtenteDao uDao = new JDBCUtenteDao(MyUtility.getDataSource());

        if ("1".equals(step)) {
            // Primo step: controllo email
            String email = request.getParameter("Email");

            if (!controllaVuoto(email)) {
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?error=campiMancanti");
                return;
            }

            try {
                if (uDao.findUtenteByEmail(email) != null) {
                    request.getSession().setAttribute("emailReset", email);
                    response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?step=2");
                } else {
                    response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?error=notFound");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?error=serverError");
            }

        } else if ("2".equals(step)) {
            // Secondo step: reset password
            String password = request.getParameter("Password");
            String confirmPassword = request.getParameter("confirmPassword");

            String emailInSessione = (String) request.getSession().getAttribute("emailReset");
            if (emailInSessione == null) {
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?error=sessionExpired");
                return;
            }

            if (password == null || password.isBlank() || confirmPassword == null || confirmPassword.isBlank()) {
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?step=2&error=vuoti");
                return;
            }

            if (!password.equals(confirmPassword)) {
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?step=2&error=diverse");
                return;
            }

            try {
                uDao.updatePasswordByEmail(emailInSessione, password);
                request.getSession().removeAttribute("emailReset");
                response.sendRedirect(request.getContextPath() + "/HomePageServlet");
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet?step=2&error=serverError");
            }
        } else {
            // Nel caso arrivi un POST senza step valido
            response.sendRedirect(request.getContextPath() + "/ResetPasswordServlet");
        }
    }
    private boolean controllaVuoto(String email) {
		if(email.isBlank())
			return false;
		return true;
	}
}