package com.cbfacademy.restapiexercise.ious;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ious")
public class IOU {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String borrower;
	private String lender;
	private BigDecimal amount;
	private Instant dateTime;

	public IOU() {
		this(null, null, BigDecimal.ZERO, Instant.now());
	}

	public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime) {
		this.borrower = borrower;
		this.lender = lender;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public UUID getId() {
		return this.id;
	}

	public String getBorrower() {
		return this.borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getLender() {
		return this.lender;
	}

	public void setLender(String lender) {
		this.lender = lender;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Instant getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Instant dateTime) {
		this.dateTime = dateTime;
	}
}
