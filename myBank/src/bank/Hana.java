package bank;

public class Hana extends Bank{
	@Override
	public int checkAccount() {
		setMoney(getMoney() / 2);
		return super.checkAccount();
	}
}