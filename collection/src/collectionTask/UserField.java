package collectionTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class UserField {
   private final int KEY = 3;

//   - 회원 정보를 담을 DB를 ArrayList로 선언
   public static ArrayList<User> users = new ArrayList<User>();

//   - 아이디 중복검사
   public User checkId(String id) {
      User user = null;
//      DB에 있는 회원 수 만큼
//      for (int i = 0; i < users.size(); i++) {
////         회원별 아이디 검사
//         if (users.get(i).getId().equals(id)) {
////            일치하는 아이디가 있다면 user에 저장
//            user = users.get(i);
//            break;
//         }
//      }
      
      for (User temp : users) {
         if(temp.getId().equals(id)) {
            user = temp;
         }
      }
      
//      null 또는 해당 회원 리턴
      return user;
   }

//   - 회원가입
   public void join(User user) {
//      암호화
      user.setPassword(encrypt(user.getPassword()));
//      DB에 저장
      users.add(user);
   }

//   - 로그인
   public User login(String id, String pw) {
//      아이디 검사
      User user = checkId(id);
      if (user != null) { // 아이디가 있다면
//         비밀번호 검사
         if (user.getPassword().equals(encrypt(pw))) {
//            로그인 성공(성공 시 로그인된 회원의 정보 리턴)
            return user;
         }
      }
//      로그인 실패
      return null;
   }

//   - 암호화
   public String encrypt(String password) {
      String decryptedPassword = "";

      for (int i = 0; i < password.length(); i++) {
         char c = password.charAt(i);
         decryptedPassword += (char) (c * KEY);
      }

      return decryptedPassword;
   }

//   - 비밀번호 변경(비밀번호 찾기 서비스)
   public void changePassword(User user) {
//      외부에서 사용자가 입력한 정보 중, 아이디로 전체 정보 조회
      User userOriginal = checkId(user.getId());
//      해당 회원의 비밀번호를 새로운 비밀번호로 변경
      userOriginal.setPassword(encrypt(user.getPassword()));
   }

//   - 인증번호 전송
//   인증번호 전송 시 전송된 인증번호가 화면에서 필요하다.
//   따라서 전송한 인증번호를 사용한 화면쪽으로 리턴해준다.
   public String sendSms(String phoneNumber) {
      String api_key = "NCSBGR1K2TNLV4TT";
      String api_secret = "#ENTER_YOUR_OWN#";
      Message coolsms = new Message(api_key, api_secret);
      String certificationNumber = getCertificationNumber();

      // 4 params(to, from, type, text) are mandatory. must be filled
      HashMap<String, String> params = new HashMap<String, String>();
//      사용자가 입력한 핸드폰 번호로
      params.put("to", phoneNumber);
      params.put("from", "01000000000");
      params.put("type", "SMS");
//      인증번호 발송
      params.put("text", certificationNumber);
      params.put("app_version", "test app 1.2"); // application name and version

      try {
         JSONObject obj = (JSONObject) coolsms.send(params);
         System.out.println(obj.toString());
      } catch (CoolsmsException e) {
         System.out.println(e.getMessage());
         System.out.println(e.getCode());
      }
//      화면쪽에 발송한 인증번호를 리턴
      return certificationNumber;
   }
   
//   인증번호 6자리 만들기
   private String getCertificationNumber() {
      Random r = new Random();
      String number = "";
//      000000~999999
//      앞에 0이 붙으면 정수이기 때문에 생략된다.
      number = r.nextInt(1000000) + "";
//      생략된 0만큼 앞에 직접 연결시켜주어야 한다.
      for (int i = 0; i < 6 - number.length(); i++) {
         number = "0" + number;
      }
      return number;
   }
}



















