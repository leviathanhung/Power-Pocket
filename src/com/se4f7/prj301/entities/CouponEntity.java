package com.se4f7.prj301.entities;

public class CouponEntity extends BaseEntity {

	private String name;

	private String description;

	private int status;

	private int Amount;

	private String due;

	public CouponEntity(int id, String name, String description, int status, String createdBy, String updatedBy,
						String createdDate, String updatedDate, int Amount, String due) {
		super(id, createdBy, updatedBy, createdDate, updatedDate);
		this.name = name;
		this.description = description;
		this.status = status;
		this.Amount = Amount;
		this.due = due;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public CouponEntity() {
		super();
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "CouponEntity{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", status=" + status +
				", Amount=" + Amount +
				", due='" + due + '\'' +
				'}';
	}
}
