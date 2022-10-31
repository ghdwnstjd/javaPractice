package myCollectionTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField{
	
	//인증번호를 위한 랜덤함수 사용
	Random r = new Random();  
	
	
//	암호화를 위한 대칭키와 암호화 비밀번호(초기화) 
	final int KEY = 3;
	String encryptedPw ="";
	
//	User 타입의 ArrayList 객체 users 생성
	public ArrayList<User> users = new ArrayList<>();
	
	
//	ID 중복체크
	public User idCheck(String id) { //null인지 아닌지 리턴
		User user = null; //User 클래스 정보를 가져오기 위해 객체 생성- 객체명 user
		
		for (int i = 0; i < users.size(); i++) { //arraylist에 저장된 회원 만큼 반복문을 돌림
			if(users.get(i).getId().equals(id)) { 
				//1. users.get(i) : users arraylist에 저장된 user 값들을 하나씩 순서대로 가져온다.  
				//2. .getId() : user 값 중 저장된 id값을 가져온다.
				//3. .equals(id) : 가져온 id값이 idCheck의 매개변수 id값과 일치한 지 확인한다.
				user = users.get(i); //값이 일치할 경우 user 값은 arraylist에 저장된 user 값으로 저장한다.
				return user;		//중복이 있다면 user에 값이 담기고, 없다면 null을 리턴하게 된다.
			} 
		} return null; //중복값이 없다면 null을 리턴한다.
	}
	
//	핸드폰 번호 중복 체크
	public User phoneCheck(String phoneNumber) {
		User user = null; //User 클래스 정보를 가져오기 위해 객체 생성- 객체명 user
		
		for (int i = 0; i < users.size(); i++) { //arraylist에 저장된 회원 만큼 반복문을 돌림
			if(users.get(i).getPhoneNumber().equals(phoneNumber)) { // arraylist에 저장된 회원들의 정보를 하나씩 가져오고, 그 정보에서 phoneNumber 정보를 가져와 매개변수와 일치한 지 확인한다.
				user = users.get(i); //중복된 내용이 있다면 user의 값을 중복값이 포함된 user정보로 바꾼다.
				return user; //바뀐 user의 값으로 리턴한다.
			}
		} return null; //중복값이 없다면 null을 리턴한다.
	}
	
	
//	회원가입
//	회원가입 시 datas 에 올라감
	public void createId(User user){ //회원가입은 모든 정보를 받아야 하므로 매개변수를 User의 매개변수 user 한다.
		user.setPassword(encrypt(user.getPassword()));	//비밀번호는 암호화된 값으로 저장해야하기 때문에 메인메소드에서 작성한 값을 암호화된 값으로 변환하여 저장한다.
		users.add(user); //users ArrayList에 정보 추가
	}
	
	
//	로그인
	public User login(String id, String password) { //로그인을 하기 위해서는 id와 비밀번호가 필요하기 때문에 매개변수로 두 값을 받는다.
		User user = idCheck(id); //로그인은 빈 정보에 추가하는 게 아니라, 이미 있는 정보를 가져오는 것이기 때문에 null이 아니라 idCheck 메소드의 결과를 user 객체로 받아온다.
		if(user != null) { //만약 아이디가 있다면 
			if(decrypt(user.getPassword()).equals(password)) {; //비밀번호가 로그인을 하기 위해 작성한 password 매개변수와 동일한지 검사하고
				return user; //user를 리턴
			}
		} return null; //아이디나 비밀번호가 틀리다면 null값을 리턴, 그냥 user를 리턴하면 아이디는 맞고, 비밀번호가 틀린 경우에 user값이 null이 아닌 상태로 리턴됨
	}
	
	
//	암호화
	public String encrypt(String password) { //메인메소드에서 작성한 비밀번호를 매개변수로 받는다.
		
		encryptedPw ="";  //암호화된 비밀번호를 저장할 변수를 초기화한다. -> 안하면 나중에 저장한 비밀번호값이 이전에 저장한 비밀번호에 덧붙여서 저장된다.
		
		for(int i = 0; i <password.length(); i++) {	 //작성한 비밀번호의 길이만큼 반복문을 돌림
			encryptedPw += (char)(password.charAt(i)*KEY); //비밀번호 각 자리수별로 KEY값만큼 곱해 암호화 진행
		}
		return encryptedPw;  // 암호화된 비밀번호를 리턴
	}
	
//	복호화
	public String decrypt(String encryptPassword) { //암호화한 비밀번호를 매개변수로 받음
		String decryptPassword = "";	//초기화
		
		for (int i = 0; i < encryptPassword.length(); i++) {	//암호화한 비밀번호의 길이만큼 반복문을 돌림
			decryptPassword += (char)(encryptPassword.charAt(i) / KEY);	// 암호화한 비밀번호를 각 자리수별로 KEY값만큼 나누어 복호화 진행
		}
		return decryptPassword; //복호화된 비밀번호를 리턴
	}
	
//	비밀번호 변경(비밀번호 찾기 서비스) -> 아이디, 핸드폰번호로
//	아이디는 중복검사 메소드로 사용하면 됨
	public void changePassword(User user) {
//		id가 존재한다면 핸드폰 번호를 입력하여 인증번호를 받고, 그 번호가 맞다면 비밀번호 변경 진행
//		기존에 저장되어있던 User 정보가 있는지 확인하여 확인 결과를 User 객체 userOriginal에 저장한다.
		User userOriginal = idCheck(user.getId());
		
		if(userOriginal != null) { //만약 아이디가 존재하면
			userOriginal.setPassword(null); //저장한 아이디의 비밀번호를 초기화한다. 이건 인증번호까지 성공 -> 변경할 비번까지 입력을 한 다음에 시도를 해야함. 안그러면 인증번호 실패했을 때에도 비번이 초기화된다.
		}
	}
	
//	인증번호 전송
//	인증번호가 전송된 거랑 입력된 게 같으면 된 거 아니면 안됨
	
//	인증번호 전송 시 전송된 인증번호가 화면에서 필요하다.
//	따라서 전송한 인증번호를 사용한 화면 쪽으로 리턴해준다.
	public String sendSms(User user) { // 해당 내용은 화면에서 보일 필요 없기 때문에 private으로 진행

//		랜덤함수로 6자리 수 지정
		String number ="";
		for (int i = 0; i < 6; i++) { // 6번 반복 진행
			number += r.nextInt(9); //number를 int로 받으면 숫자끼리 더해지므로 6자리가 나오지 않음. String형태로 작성해야한다.
		}

//		sms 발송 전 테스트
//		System.out.println("인증번호를 입력해주세요.\n인증번호: " + number); 
		
		String api_key = "NCS62XUAPXJVGXEJ";
		String api_secret = "GT5SRJ4OGRQM4D3RSXHHJDWWTZDQT6M3";
		Message coolsms = new Message(api_key, api_secret);
		
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", user.getPhoneNumber());	//메인메소드에서 기재한 user의 핸드폰 번호로 발송
		params.put("from", "01020491601");
		params.put("type", "SMS");
		params.put("text", "인증번호를 입력해주세요.\n인증번호: " + number);
		params.put("app_version", "test app 1.2"); // application name and version

		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
			System.out.println(obj.toString());
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}
				
		return number+"";						//int를 String으로 바꿔서 return.
	}
}
