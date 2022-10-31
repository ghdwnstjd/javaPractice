package myCollectionTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Page {
	public static void main(String[] args) {
//		회원가입, 로그인, 비밀번호 변경

		String firstMsg = "1. 회원가입\n2. 로그인\n3. 비밀번호 변경\n4. 회원정보 보기\n5. 나가기", nameMsg = "이름: ", idMsg = "아이디 : ",
				passwordMsg = "비밀번호 : ", phoneMsg = "핸드폰 번호: ", numberMsg = "인증번호: ";
		String id = null, password = null, phoneNumber = null, name = null, smsNumber = null, newPassword = null;
		int firstChoice = 0, smsMsg = 0, sendSms = 0;

		Scanner sc = new Scanner(System.in);

		User user = null; // User 객체 user를 생성, null로 초기화하고 이후 회원가입 창에서 생성자를 만든다.
							// 만약 지금 생성자를 만들면 회원 가입 시에 이전 가입된 정보가 그대로 들어갈 수 있다.
		UserField userField = new UserField(); // UserField의 객체를 null로 잡으면 idCheck시에 userField가 null이 되어 NullPointerException이 발생한다.
														    // UserField는 계속 새로운 생성자를 만드는 것이 아니라, 한 번 만들어놓은 생성자에 새로운 정보를 계속 추가하는 것이기 때문에 초기에 생성자를 만들어놓는다.
		try {
			while (true) {
				System.out.println(firstMsg);
				firstChoice = sc.nextInt();
				if (firstChoice == 5) { // 종료 메세지
					System.out.println("==========================종료==========================");
					break;
				}

				switch (firstChoice) {
				case 1: // 회원가입
					user = new User(); // 회원가입이라는 건 처음 정보를 입력하는 것이기 때문에 생성자를 만들어 정보를 갱신한다.

//				이름 입력
//				이름은 두 글자 이상 작성, 숫자는 작성할 수 없음
					while (true) {

						System.out.print(nameMsg);
						name = sc.next();
						int i = 0; // for문에서 빠져나오는 순간 i의 값이 사라지므로 for문 전에 초기화 진행
						for (i = 0; i < name.length(); i++) { // 작성한 이름 길이만큼 for문 반복
							char c = name.charAt(i); // 각 글자별 c의 값을 뽑아내고
							if (c >= 48 && c <= 57) { // c의 char 값이 48~57 사이라면(이름에 숫자를 기재했다면)
								break;
							}
						}
						if (name.length() != i) { // 이름에 숫자가 들어갔을 경우, 즉시 break가 걸리기 때문에 이름의 길이만큼 i의 숫자가 올라가지 못했다.
													// 따라서 이름의 길이와 i의 값이 다르다는 것은 위의 for문이 끝까지 돌지 못했다는 것이고, 이름에 숫자가 들어갔다는
													// 것을 뜻한다.
							System.out.println("이름에 숫자는 넣을 수 없습니다.");
							continue;
						}
						if (name.length() < 2) { // 이름이 2글자 미만으로 작성되었을 경우
							System.out.println("이름은 두 글자 이상 작성하셔야 합니다.");
							continue;
						}
						user.setName(name); // User 클래스에 name 값을 저장
						break;
					}

//				아이디 입력
//				중복된 아이디가 있는지 체크
					while (true) {
						System.out.print(idMsg);
						id = sc.next();
						if (userField.idCheck(id) == null) { // 만약 중복된 아이디가 없다면
							break;
						}
						System.out.println("동일한 아이디가 있습니다."); // 중복된 아이디가 있으면 idCheck메소드가 user를 리턴하므로 해당 메세지가 출력됨
					}
					user.setId(id); // User 클래스에 id 값을 저장

//				비밀번호 입력
//				비밀번호는 4자리 이상 입력
					while (true) {
						System.out.print(passwordMsg);
						password = sc.next();
						if (password.length() >= 4) { // 비밀번호가 4자리 이상이라면
							user.setPassword(password); // User 클래스에 password 값을 저장
							break;
						}
						System.out.println("비밀번호는 4자리 이상 입력해주세요."); // 비밀번호가 4자리 미만이라면
					}

//				핸드폰 번호 입력
//				중복된 번호가 있는지 체크
					while (true) {
						System.out.print(phoneMsg);
						phoneNumber = sc.next();

						int i = 0;

						for (i = 0; i < phoneNumber.length(); i++) { // 핸드폰 번호의 길이만큼 반복문을 돌린다.
							char c = phoneNumber.charAt(i); // 각 자리수별 값을 char로 변환한다.
							if (c < 48 || c > 57) { // 번호에 숫자 외 다른 게 적혀있을 경우
								break;
							}
						}

//						숫자가 아닌 다른 것을 입력했을 경우
						if (phoneNumber.length() != i) { // 숫자말고 다른 게 적혀있을 경우 위의 for문이 끝까지 돌지 않았다는 것이기 때문에
															// phoneNumber길이와 i의 값이 다르다.
							System.out.println("숫자만 입력해주세요.");
							continue;
						}

//						11자리로 입력 안했을 경우
						if (phoneNumber.length() != 11) {
							System.out.println("핸드폰 번호는 11자리를 모두 입력해주세요.");
							continue;
						}

//						010 입력 안했을 경우
						if (!phoneNumber.startsWith("010")) {
							System.out.println("핸드폰 번호는 010부터 입력해주세요.");
							continue;
						}

//						중복인 핸드폰 번호가 있는지 체크
						if (userField.phoneCheck(phoneNumber) == null) { // 중복된 번호가 없다면
							user.setPhoneNumber(phoneNumber);				// User 클래스 객체 user에 phoneNumber 값을 저장
							break;
						}
						System.out.println("해당 번호는 이미 가입된 번호입니다."); // phoneCheck메소드가 user를 리턴
					}

//				아이디 생성
					userField.createId(user); // 이름, 아이디, 비밀번호, 핸드폰번호를 받아 createId 메소드 실행
					System.out.println("새로운 아이디가 생성되었습니다.");

//				제대로 생성되었는지 확인을 위해 User객체의 override한 toString 값 출력
					System.out.println(user.toString());
					break;

				case 2: // 로그인
					if(user == null) {
						System.out.println("아직 가입한 아이디가 없습니다.");
						break;
					}
					while (true) {
						user = null; // user 초기화, 로그인을 해야하는데 user에 이전 정보가 들어있으면 로그인이 안됨
						System.out.print(idMsg);
						id = sc.next();
						System.out.print(passwordMsg);
						password = sc.next();
						user = userField.login(id, password); // 1. 입력한 id, 패스워드 정보로 login 메소드 실행
																		 // 2. user를 입력한 정보로 전환
						if (user != null) { // 아이디와 비밀번호가 저장된 정보와 일치할 경우
							System.out.println("=============로그인 성공!=============");
							break;
						}
						System.out.println("아이디나 비밀번호를 잘못 입력하셨습니다.");
					}
					break;

				case 3: // 비밀번호 변경(비밀번호 찾기 서비스)
					System.out.print(idMsg);
					id = sc.next();

					if (userField.idCheck(id) != null) { // 존재하는 아이디라면
						user = userField.idCheck(id); // user를 바꾸려고 하는 정보의 id 값을 가진 것으로 변경

						// 인증번호 발송 전 한 번 더 체크
						System.out.println("해당 아이디의 핸드폰 번호 " + user.getPhoneNumber() + "(으)로 인증번호를 발송하려고 합니다. 발송할까요?\n1.예\n2. 아니요");
						sendSms = sc.nextInt();
						switch (sendSms) {
						case 1: // 인증번호 발송 
							smsNumber = userField.sendSms(user); // 인증번호 발송
							System.out.println("해당 ID의 핸드폰 번호로 인증번호를 발송하였습니다. \n인증번호를 입력하신 후, 새로운 비밀번호로 변경해주세요.");
							System.out.print(numberMsg);
							smsMsg = sc.nextInt();
							if (smsNumber.equals(Integer.toString(smsMsg))) { // 전송된 번호와 입력한 번호가 일치할 경우
								System.out.println("새로운 비밀번호를 입력하세요.");
								newPassword = sc.next();
								userField.changePassword(user); // changePassword 메소드를 통해 기존 비밀번호 초기화
								user.setPassword(userField.encrypt(newPassword)); // 새로운 비밀번호로 변경(암호화된 번호로)
								System.out.println("비밀번호 변경 성공!");
								break;
							}
						case 2: // 인증번호 발송 미동의
							break;
						}

					} else {
						System.out.println("입력하신 ID는 가입되지 않은 ID 입니다.");
					}
					break;

				case 4: // 회원정보 보기
					if (user == null) { // user에 저장된 값이 없을 경우
						System.out.println("아직 가입한 회원이 없습니다.");
						break;
					}
					for (int i = 0; i < userField.users.size(); i++) { // 가입된 유저의 수만큼 반복문을 돌림
						System.out.println("회원 번호: " + (i + 1));
						System.out.println(userField.users.get(i)); // arraylist에 저장된 정보를 하나씩 출력
					}
					break;

				default:
					System.out.println("올바른 값을 넣어주세요.");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("1~4 사이의 정수만 입력해주세요");
		}
	}
}
