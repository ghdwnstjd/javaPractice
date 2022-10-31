package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
//   암호화를 위한 KEY값 생성
   private final int KEY = 3;
   
   public Connection connection; //연결 객체
   public PreparedStatement preparedStatement; //쿼리(SQL문) 객체
   public ResultSet resultSet; //결과 테이블 객체
   
//   아이디 중복검사
   public boolean checkId(String id) {
//      USER_ID 컬럼에서 사용자가 입력한 id 검사
//	   DBeaver에서 작성한 쿼리문을 그대로 작성하면 되고, 변수를 ?로 나타내면 된다.
      String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_ID = ?";
      boolean check = false;
      try {
//         연결 객체 가져오기
//    	  hr계정으로 연결
         connection = DBConnecter.getConnection();
//         작성한 쿼리문을 preparedStatement에 전달
//         hr계정으로 연결을 했기 때문에 connection객체를 통해 query문을 전달할 수 있다.
         preparedStatement = connection.prepareStatement(query);
//         ? 채우기(좌에서 우로 1부터 1씩 증가)
//         checkId 메소드의 매개변수를 쿼리문의 변수에 대입
         preparedStatement.setString(1, id);
//         쿼리 실행
//         쿼리가 SELECT 문이기 때문에 executeQuery를 실행
         resultSet = preparedStatement.executeQuery();
//         결과 행 1개 가져오기
//         중복된 아이디는 1개를 넘어갈 수 없기 때문에 while문 없이 값 한 개만 가져온다.
//         .next()가 한 줄씩 정보를 읽어온다.
         resultSet.next();
//         결과 첫번째 열 1개 가져오기
//         1이라면 사용자가 입력한 아이디가 1개 조회된 것이기 때문에 중복된 아이디이다.
//         check문이 true라면 중복된 아이디가 있는 것, false이면 중복 아이디가 없는 것을 의미한다.
         check = resultSet.getInt(1) == 1;
         
      } catch (SQLException e) {
         System.out.println("checkId()에서 쿼리문 오류");
      } finally {
         try {
//            연결 객체 모두 닫기
//        	 연결 객체를 모두 닫을 때는 열었던 것의 반대 순서로 닫아야 한다.
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      
      return check;
   }
//   회원가입
//   회원가입은 회원 전체 정보를 전달해야하므로 매개변수도 UserVo 타입으로 한다.
//   회원가입 후 리턴할 정보가 있는건 아니기 때문에 void로 설정하고, resultSet이 필요없다.
   public void insert(UserVO userVO) {
      String query = "INSERT INTO TBL_USER "
            + "(USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMEND_ID, USER_JOB)"
            + "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
      try {
//    	  hr계정으로 연결
         connection = DBConnecter.getConnection();
//         hr 계정으로 쿼리문 전달할 변수 선언
         preparedStatement = connection.prepareStatement(query);
         
//         전달할 물음표의 개수만큼 preparedStatement를 만들어주면 된다.
         preparedStatement.setString(1, userVO.getUserId());
         preparedStatement.setString(2, userVO.getUserName());
         preparedStatement.setString(3, userVO.getUserPassword());
         preparedStatement.setString(4, userVO.getUserPhone());
         preparedStatement.setString(5, userVO.getUserNickname());
         preparedStatement.setString(6, userVO.getUserEmail());
         preparedStatement.setString(7, userVO.getUserAddress());
         preparedStatement.setString(8, userVO.getUserBirthDate());
         preparedStatement.setString(9, userVO.getUserGender());
         preparedStatement.setString(10, userVO.getUserRecommendId());
         preparedStatement.setString(11, userVO.getUserJob());
//         SELECT 문이 아니기 때문에 executeUpdate()를 실행한다.
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println(e);
         System.out.println("insert()에서 쿼리문 오류");
         
      } finally {
         try {
//        	 리턴값이 없어 resultSet이 없으므로, preparedStatement와 connection만 닫아준다.
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
//   로그인
//   회원번호(userNumber)를 리턴해주기 때문에 로그인 타입은 int로 설정한다.
   public int login(String userId, String userPassword) {
//	   아이디와 비밀번호가 맞는지 일치여부 확인을 위한 쿼리문
      String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ? AND USER_PASSWORD = ?";
//      회원번호 초기화
      int userNumber = 0;
      try {
//    	  hr계정 연결
         connection = DBConnecter.getConnection();
//         연결한 계정으로 쿼리문 실행
         preparedStatement = connection.prepareStatement(query);
//         쿼리문 변수에 각각 아이디와 비밀번호 입력
         preparedStatement.setString(1, userId);
         preparedStatement.setString(2, userPassword);
//         Select 문이기 때문에 executeQuery 실행
         resultSet = preparedStatement.executeQuery();
         
//       	아이디가 일치하지 않을 경우 resultSet에는 아무 값에도 담기지 않아 null 상태가 된다.
//         NPE를 피하기 위해 if문으로 묶어 조건을 검사한다.
         if(resultSet.next()) {
//        	 아이디가 맞을 경우 테이블 회원 번호를 userNumber에 추가한다.
            userNumber = resultSet.getInt("USER_NUMBER");
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("login() 쿼리문 오류");
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userNumber;
   }
//   암호화
   public String encrypt(String password) {
      String encryptedPassword = "";
      for (int i = 0; i < password.length(); i++) {
         encryptedPassword += (char)(password.charAt(i) * KEY);
      }
      return encryptedPassword;
   }
   
//   회원탈퇴
//   userNumber를 이용해 회원정보를 불러와 삭제한다.
   public void delete(int userNumber) {
      String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
      try {
//    	  hr 계정 연결
         connection = DBConnecter.getConnection();
//         쿼리문 실행
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, userNumber);
//         SELECT문이 아니므로 executeUpdate()
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("delete() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
   
//   아이디 찾기
//   핸드폰번호 정보를 이용해 아이디 찾기
   public String findId(String userPhone) {
      String userId = null;
      String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE = ?";
      try {
//    	  hr계정 연결
         connection = DBConnecter.getConnection();
//         쿼리문 실행
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPhone);
//         SELECT문이므로 executeQuery 실행
         resultSet = preparedStatement.executeQuery();
         
//         핸드폰번호 정보가 존재하는 정보라면 userId값을 출력
//         user_ID값 하나만 출력하기 때문에 getString(1)이다. -> 첫 번째 값 
         if(resultSet.next()) {
            userId = resultSet.getString(1);
         }
         
      } catch (SQLException e) {
         System.out.println("findId() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userId;
   }
   
//   비밀번호 변경
   public void updateUserPassword(String userId, String userPassword) {
      String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
      try {
//    	  hr 계정 연결
         connection = DBConnecter.getConnection();
//         쿼리문 연결
         preparedStatement = connection.prepareStatement(query);
//         쿼리문에 새롭게 추가할 비밀번호와 비밀번호를 바꿀 아이디 정보 저장
         preparedStatement.setString(1, userPassword);
         preparedStatement.setString(2, userId);
//         SELECT문이 아니므로 executeUpdate 실행
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("updateUserPassword() 쿼리 오류");
         e.printStackTrace();
      } finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
   
//   회원정보 수정
//   유저 정보 전체를 가져와서 수정을 해야하므로 UserVo를 매개변수로 받는다.
   public void update(UserVO userVO) {
      String query = "UPDATE TBL_USER "
            + "SET USER_NAME=?, USER_PASSWORD=?, USER_PHONE=?, USER_NICKNAME=?, USER_ADDRESS=?, USER_BIRTH_DATE=?, USER_GENDER=? , USER_JOB=?"
            + "WHERE USER_NUMBER = ?";
      
      try {
//    	  hr 계정 연결
         connection = DBConnecter.getConnection();
//         쿼리문 실행
//         변경이 불가능한 PK 등은 기재하지 않음
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userVO.getUserName());
         preparedStatement.setString(2, userVO.getUserPassword());
         preparedStatement.setString(3, userVO.getUserPhone());
         preparedStatement.setString(4, userVO.getUserNickname());
         preparedStatement.setString(5, userVO.getUserAddress());
         preparedStatement.setString(6, userVO.getUserBirthDate());
         preparedStatement.setString(7, userVO.getUserGender());
         preparedStatement.setString(8, userVO.getUserJob());
         preparedStatement.setInt(9, userVO.getUserNumber());
//         SELECT 문이 아니므로 executeUpdate() 실행
         preparedStatement.executeUpdate();
         
      } catch (SQLException e) {
         System.out.println("update() 쿼리 오류");
         e.printStackTrace();
      }finally {
         try {
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }
   
//   회원정보 조회
   public UserVO selectUser(int userNumber) throws ParseException{
      String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMEND_ID, USER_JOB FROM TBL_USER "
            + "WHERE USER_NUMBER = ?";
//      날짜 서식을 통일하기 위한 sdf 객체 생성
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      
      int i = 0;
//      UserVO 객체 생성
      UserVO userVO = new UserVO();
      try {
//    	  hr 계정 연결
         connection = DBConnecter.getConnection();
//         query문 연결
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, userNumber);
//         SELECT문이므로 executeQuery 실행
         resultSet = preparedStatement.executeQuery();
         resultSet.next();
         
         userVO.setUserNumber(resultSet.getInt(++i));
         userVO.setUserId(resultSet.getString(++i));
         userVO.setUserName(resultSet.getString(++i));
         userVO.setUserPassword(resultSet.getString(++i));
         userVO.setUserPhone(resultSet.getString(++i));
         userVO.setUserNickname(resultSet.getString(++i));
         userVO.setUserEmail(resultSet.getString(++i));
         userVO.setUserAddress(resultSet.getString(++i));
//         생년월일은 resultSet에서 가져오는 정보와 표현 형식 통일이 되어 있지 않기 때문에 SimpleDateFormat 으로 형식을 바꿔준다.
         userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));
         userVO.setUserGender(resultSet.getString(++i));
         userVO.setUserJob(resultSet.getString(++i));
         
      } catch (SQLException e) {
         System.out.println("updateUser() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if(resultSet != null) {
               resultSet.close();
            }
            if(preparedStatement != null) {
               preparedStatement.close();
            }
            if(connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userVO;
   }
   
   
// 추천수
 public int getTotalOfRecommender(String userId) {
    String query = "SELECT COUNT(USER_RECOMMEND_ID) FROM TBL_USER WHERE USER_RECOMMEND_ID = ?";
//    추천수를 담아준 count 변수 초기화
    int count = 0;
    try {
//    	hr 계정 연결
       connection = DBConnecter.getConnection();
//       쿼리문 담아줄 변수 선언
       preparedStatement = connection.prepareStatement(query);
       preparedStatement.setString(1, userId);
//       SELECT문이므로 executeQuery 실행
       resultSet = preparedStatement.executeQuery();
       if(resultSet.next()) {
//    	   쿼리문을 통해 나오는 값이 COUNT 이므로 그 값을 그대로 count 변수에 넣어준 후 리턴한다.
          count = resultSet.getInt(1);
       }
       
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       try {
          if(resultSet != null) {
             resultSet.close();
          }
          if(preparedStatement != null) {
             preparedStatement.close();
          }
          if(connection != null) {
             connection.close();
          }
       } catch (SQLException e) {
          throw new RuntimeException(e.getMessage());
       }
    }
    return count;
 }
 
// 나를 추천한 사람
 public ArrayList<UserVO> selectRecommenders(String userId){
    String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMEND_ID, USER_JOB FROM TBL_USER "
          + "WHERE USER_RECOMMEND_ID = ?";
//    나를 추천한 사람이 몇 명인지 모르기 때문에 ArrayList를 선언한다.
    ArrayList<UserVO> recommends = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    int i = 0;
    try {
//    	hr계정 연결
       connection = DBConnecter.getConnection();
//       쿼리문 실행을 위한 변수 선언
       preparedStatement = connection.prepareStatement(query);
       preparedStatement.setString(1, userId);
//       SELECT 문이기 때문에 executeQuery 실행
       resultSet = preparedStatement.executeQuery();
       
//       값이 몇 개인지 알 수 없으므로 while문을 돌린다.
       while(resultSet.next()) {
          i = 0;
//          결과값을 출력하기 위한 정보를 담을 UserVO 객체 선언
          UserVO userVO = new UserVO();
          userVO.setUserNumber(resultSet.getInt(++i));
          userVO.setUserId(resultSet.getString(++i));
          userVO.setUserName(resultSet.getString(++i));
          userVO.setUserPassword(resultSet.getString(++i));
          userVO.setUserPhone(resultSet.getString(++i));
          userVO.setUserNickname(resultSet.getString(++i));
          userVO.setUserEmail(resultSet.getString(++i));
          userVO.setUserAddress(resultSet.getString(++i));
//          생년월일은 반드시 기재해야하는 항목이 아니므로, null값 도출 시 parse 오류가 날 수 있다. 따라서 try-catch문으로 오류를 무시한다.
          try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
          userVO.setUserGender(resultSet.getString(++i));
          userVO.setUserRecommendId(resultSet.getString(++i));
          userVO.setUserJob(resultSet.getString(++i));
          
//          ArrayList에 유저 정보 추가
          recommends.add(userVO);
       }
       
       
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       try {
          if(resultSet != null) {
             resultSet.close();
          }
          if(preparedStatement != null) {
             preparedStatement.close();
          }
          if(connection != null) {
             connection.close();
          }
       } catch (SQLException e) {
          throw new RuntimeException(e.getMessage());
       }
    }
    return recommends;
 }
// 내가 추천한 사람
 public UserVO getMyRecommender(String userId) {
//	 쿼리문이 복잡하기 때문에 DBeaver에서 먼저 작성해보는 것이 좋음
    String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMEND_ID, USER_JOB " +
          "FROM TBL_USER WHERE USER_ID = " + 
          "(" +
             "SELECT USER_RECOMMEND_ID FROM TBL_USER " + 
             "WHERE USER_ID = ?" +
          ")";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    내가 추천한 사람의 정보를 담을 UserVO 객체 선언
    UserVO userVO = new UserVO();

    int i = 0;
    try {
//    	hr 계정 연결
       connection = DBConnecter.getConnection();
//       query문을 담을 변수 선언
       preparedStatement = connection.prepareStatement(query);
       preparedStatement.setString(1, userId);
//       SELECT 문이므로 executeQuery 실행
       resultSet = preparedStatement.executeQuery();
       
       if(resultSet.next()) {
//    	   내가 추천한 사람이 있다면 그 유저의 정보를 출력
          userVO.setUserNumber(resultSet.getInt(++i));
          userVO.setUserId(resultSet.getString(++i));
          userVO.setUserName(resultSet.getString(++i));
          userVO.setUserPassword(resultSet.getString(++i));
          userVO.setUserPhone(resultSet.getString(++i));
          userVO.setUserNickname(resultSet.getString(++i));
          userVO.setUserEmail(resultSet.getString(++i));
          userVO.setUserAddress(resultSet.getString(++i));
          try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
          userVO.setUserGender(resultSet.getString(++i));
          userVO.setUserRecommendId(resultSet.getString(++i));
          userVO.setUserJob(resultSet.getString(++i));
       }
       
       
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       try {
          if(resultSet != null) {
             resultSet.close();
          }
          if(preparedStatement != null) {
             preparedStatement.close();
          }
          if(connection != null) {
             connection.close();
          }
       } catch (SQLException e) {
          throw new RuntimeException(e.getMessage());
       }
    }
    return userVO;
 }
}













