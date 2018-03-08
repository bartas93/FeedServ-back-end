package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import java.math.BigDecimal;

public class EmployeeStatisticsTo {
	private SimpleEmployeeTo simpleEmployeeTo;
	private int quantityOfOrders;
	private BigDecimal sumOrdersMoney;

	public EmployeeStatisticsTo() {
		super();
	}

	public EmployeeStatisticsTo(SimpleEmployeeTo simpleEmployeeTo, int quantityOfOrders, BigDecimal sumOrdersMoney) {
		super();
		this.simpleEmployeeTo = simpleEmployeeTo;
		this.quantityOfOrders = quantityOfOrders;
		this.sumOrdersMoney = sumOrdersMoney;
	}

	public SimpleEmployeeTo getSimpleEmployeeTo() {
		return simpleEmployeeTo;
	}

	public void setSimpleEmployeeTo(SimpleEmployeeTo simpleEmployeeTo) {
		this.simpleEmployeeTo = simpleEmployeeTo;
	}

	public int getQuantityOfOrders() {
		return quantityOfOrders;
	}

	public void setQuantityOfOrders(int quantityOfOrders) {
		this.quantityOfOrders = quantityOfOrders;
	}

	public BigDecimal getSumOrdersMoney() {
		return sumOrdersMoney;
	}

	public void setSumOrdersMoney(BigDecimal sumOrdersMoney) {
		this.sumOrdersMoney = sumOrdersMoney;
	}

}
