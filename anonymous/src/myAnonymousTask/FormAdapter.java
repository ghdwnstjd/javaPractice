package myAnonymousTask;


// form의 강제성 소멸을 위해 adapter를 만듦
public abstract class FormAdapter implements Form{

	@Override
	public String[] getMenu() {
		return null;
	}

	@Override
	public void sell(String order) {;}

}
