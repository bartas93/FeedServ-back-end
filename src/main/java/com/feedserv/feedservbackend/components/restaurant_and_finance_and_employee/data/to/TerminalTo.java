package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.to;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TerminalTo {
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BigDecimal cashMoney;
	private BigDecimal cardMoney;
	private BigDecimal bankTransferMoney;
	private int deliveriesOrdersQuantity;
	private BigDecimal deliveriesMoney;
	private int takeawayOrdersQuantity;
	private BigDecimal takeawayMoney;
	private int localOrdersQuantity;
	private BigDecimal localMoney;
	// private List<EmployeeStatisticsTo> driversStatistics;
	// private List<EmployeeStatisticsTo> staffStatistics;

	public TerminalTo() {
	}

	public TerminalTo(LocalDate dateFrom, LocalDate dateTo, BigDecimal cashMoney, BigDecimal cardMoney,
			BigDecimal bankTransferMoney, int deliveriesOrdersQuantity, BigDecimal deliveriesMoney,
			int takeawayOrdersQuantity, BigDecimal takeawayMoney, int localOrdersQuantity, BigDecimal localMoney) {
		super();
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.cashMoney = cashMoney;
		this.cardMoney = cardMoney;
		this.bankTransferMoney = bankTransferMoney;
		this.deliveriesOrdersQuantity = deliveriesOrdersQuantity;
		this.deliveriesMoney = deliveriesMoney;
		this.takeawayOrdersQuantity = takeawayOrdersQuantity;
		this.takeawayMoney = takeawayMoney;
		this.localOrdersQuantity = localOrdersQuantity;
		this.localMoney = localMoney;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}

	public BigDecimal getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(BigDecimal cashMoney) {
		this.cashMoney = cashMoney;
	}

	public BigDecimal getCardMoney() {
		return cardMoney;
	}

	public void setCardMoney(BigDecimal cardMoney) {
		this.cardMoney = cardMoney;
	}

	public BigDecimal getBankTransferMoney() {
		return bankTransferMoney;
	}

	public void setBankTransferMoney(BigDecimal bankTransferMoney) {
		this.bankTransferMoney = bankTransferMoney;
	}

	public int getDeliveriesOrdersQuantity() {
		return deliveriesOrdersQuantity;
	}

	public void setDeliveriesOrdersQuantity(int deliveriesOrdersQuantity) {
		this.deliveriesOrdersQuantity = deliveriesOrdersQuantity;
	}

	public BigDecimal getDeliveriesMoney() {
		return deliveriesMoney;
	}

	public void setDeliveriesMoney(BigDecimal deliveriesMoney) {
		this.deliveriesMoney = deliveriesMoney;
	}

	public int getTakeawayOrdersQuantity() {
		return takeawayOrdersQuantity;
	}

	public void setTakeawayOrdersQuantity(int takeawayOrdersQuantity) {
		this.takeawayOrdersQuantity = takeawayOrdersQuantity;
	}

	public BigDecimal getTakeawayMoney() {
		return takeawayMoney;
	}

	public void setTakeawayMoney(BigDecimal takeawayMoney) {
		this.takeawayMoney = takeawayMoney;
	}

	public int getLocalOrdersQuantity() {
		return localOrdersQuantity;
	}

	public void setLocalOrdersQuantity(int localOrdersQuantity) {
		this.localOrdersQuantity = localOrdersQuantity;
	}

	public BigDecimal getLocalMoney() {
		return localMoney;
	}

	public void setLocalMoney(BigDecimal localMoney) {
		this.localMoney = localMoney;
	}

}
