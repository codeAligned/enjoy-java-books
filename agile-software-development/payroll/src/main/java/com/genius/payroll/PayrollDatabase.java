package com.genius.payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

	private static Map<Long, Employee> employees = new HashMap<>();
	private static Map<Long, Long> unionMembers = new HashMap<>();

	public static Employee getEmployee(long empId) {
		return employees.get(empId);
	}

	public static void addEmployee(long empId, Employee employee) {
		employees.putIfAbsent(empId, employee);
	}

	public static void deleteEmployee(long empId) {
		employees.remove(empId);
	}

	public static void clear() {
		employees.clear();
		unionMembers.clear();
	}

	public static void addUnionMember(long memberId, Employee employee) {
		unionMembers.putIfAbsent(memberId, employee.getEmpId());
	}

	public static Employee getUnionMember(long memberId) {
		return employees.get(unionMembers.get(memberId));
	}

	public void removeUnionMember(long memberId) {
		unionMembers.remove(memberId);
	}
}