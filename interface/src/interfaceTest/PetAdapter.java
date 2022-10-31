package interfaceTest;

public abstract class PetAdapter implements Pet {

//	인터페이스의 강제성을 없애기 위한 Adapter 클래스
//	추상클래스이며 클래스명에는 편의를 위해 뒤에 Adapter를 붙인다.
	@Override
	public void bang() {;}

	@Override
	public void giveYourHand() {;}

	@Override
	public void bite() {;}

	@Override
	public void sitDown() {;}

	@Override
	public void waitNow() {;}

	@Override
	public void getNose() {;}

}
