package employee;

public class ContractEmployee extends chap98_homework.nc230321.employee.Employee {
	private int workDay;

	public ContractEmployee(int eno, String name, int pay, int workDay) {
		super(eno, name, pay);
		this.workDay = workDay;
	}

	@Override
	public double getMonthPay() {
		// TODO Auto-generated method stub
		return this.getPay() * this.workDay;
	}
	
	@Override
	public void showEmployeeInfo() {
		super.showEmployeeInfo();
		System.out.println("근무일수 : " + this.workDay);
		System.out.println("월급 : " + this.getMonthPay());
	}
}