package com.genius.payroll;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

	public ChangeClassificationTransaction(long empId) {
		super(empId);
	}

	abstract PaymentClassification getClassification();

	abstract PaymentSchedule getSchedule();

	public void change(Employee employee) {
		employee.setClassification(getClassification());
		employee.setSchedule(getSchedule());
	}
}
