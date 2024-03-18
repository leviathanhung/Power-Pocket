package com.se4f7.prj301.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.se4f7.prj301.entities.CouponEntity;
import com.se4f7.prj301.repository.ReceiptPaymentRepositorys;
import com.se4f7.prj301.service.CouponService;
import com.se4f7.prj301.utils.ReadFromExcelFile;

public class CouponServiceImpl implements CouponService {

	private ReceiptPaymentRepositorys toDo = new ReceiptPaymentRepositorys();

	public boolean create(String name, String description, int status, String createdBy, String updatedBy,
			String createdDate, String updatedDate, int Amount, String due) {
		boolean result = false;
		try {
			this.toDo.insertWork(name, description, status, createdBy, updatedBy, createdDate, updatedDate,Amount,
					due);
			result = true;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}

	public boolean update(int id, String name, String description, int status, String createdBy, String updatedBy,
			String createdDate, String updatedDate, int Amount, String due) {
		boolean result = false;
		try {
			this.toDo.updateWork(id, name, description, status, createdBy, updatedBy, createdDate, updatedDate,
					Amount, due);
			result = true;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}

	public boolean delete(String id) {
		boolean result = false;
		try {
			this.toDo.deleteWork(id);
			result = true;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}

	public CouponEntity getWorkById(String id) {
		CouponEntity toDo = new CouponEntity();
		try {
			toDo = this.toDo.getWorkById(id);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return toDo;
	}

	public int count() {
		int result = 0;
		try {
			result = this.toDo.countToDo();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}

	public int countByUser(String userName) {
		int result = 0;
		try {
			result = this.toDo.countUserWork(userName);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return result;
	}

	public String getDueById(int id) {
		String toDoE = null;
		try {
			toDoE = toDo.getDueById(id);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return toDoE;
	}

	public String getCreatedById(int id) {
		String toDoE = null;
		try {
			toDoE = toDo.getCreatedById(id);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return toDoE;
	}

	public List<CouponEntity> getWorkByDue(String due) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = toDo.getWorkByDue(due);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getWorkByDue(String due, String username) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = toDo.getWorkByDue(due, username);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getAllTodo() {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getAllWork();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getAllTodoLimit(int page) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getAllWorkLimit(page);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getAllWorkUser(int page, String userName) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getAllWorkUser(page, userName);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getFilter(int status) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getFilter(status);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getFilterUser(int status, String username) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getFilterUser(status, username);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getPriorityUser(int Amount, String username) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getPriorityUser(Amount, username);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getWorkByName(String name) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = toDo.getWorkByName(name);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getWorkByNameU(String name, String createdBy) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = toDo.getWorkByNameU(name, createdBy);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public List<CouponEntity> getWorkByNameToExcel(String createdBy) {
		List<CouponEntity> list = new ArrayList<>();
		try {
			list = this.toDo.getWorkByNameToExcel();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}

	public boolean importFromExcel(HttpServletRequest request, HttpServletResponse response, String filePath) {
		try {
			ReadFromExcelFile.importExcel(request, response, filePath);
			return true;
		} catch (Exception e) {
			System.out.println("Error importing from Excel: " + e.getMessage());
			return false;
		}
	}

}
