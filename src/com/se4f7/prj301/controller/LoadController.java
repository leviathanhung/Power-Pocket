package com.se4f7.prj301.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se4f7.prj301.entities.CouponEntity;
import com.se4f7.prj301.service.AuthService;
import com.se4f7.prj301.service.CouponService;
import com.se4f7.prj301.service.impl.AuthServiceImpl;
import com.se4f7.prj301.service.impl.CouponServiceImpl;

public class LoadController extends HttpServlet {

	private static final long serialVersionUID = 2860215007883522580L;

	private CouponService couponService;
	private AuthService authService;
	public void init() {
		couponService = new CouponServiceImpl();
		authService = new AuthServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("page");
		int sumMoney= 0;
		if (index == null) {
			index = "1";
		}
		int page = Integer.parseInt(index);
		try {
			int count = couponService.count();
			int endP = count / 5;
			if (count % 5 != 0) {
				endP++;
			}
			List<CouponEntity> list = couponService.getAllTodoLimit(page);
			for(CouponEntity todo : list) {
				if(todo.getStatus() == 0){
					sumMoney += todo.getAmount();
				}
				else{
					sumMoney -= todo.getAmount();
				}
			}

			int money = authService.getMoney(9);
			money = money + sumMoney;

			request.setAttribute("sumMoney", money);
			request.setAttribute("list", list);
			request.setAttribute("endP", endP);
			request.setAttribute("tag", page);
			request.setAttribute("count", count);
			request.getRequestDispatcher("admin.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
