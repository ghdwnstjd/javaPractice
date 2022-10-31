package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
   public static final int DELETED_USER_CODE = -1; //탈퇴한 아이디
   public static final int RESTORED_USER_CODE = 0; //회복한 계정
   public static final int DUPLICATED_ID_CODE = 1; // 중복 아이디
   public static final int ENABLED_ID_CODE = 2; //이용 가능한 아이디
   

   public Connection connection;
   public PreparedStatement preparedStatement;
   public ResultSet resultSet;

   /**
    * @param userId
    * @return
    *    RESTORED_USER_CODE = 0;<br>
      DELETED_USER_CODE = 1;<br>
      DUPLICATED_ID_CODE = 2;<br>
      ENABLED_ID_CODE = 3;<br>
    */
//   아이디 중복검사   
   public int checkId(String userId) {
//	   아이디에 부합하는 유저 상태를 출력
      String query = "select userStatus from tbl_user where userId = ?";
      int code = 0, userStatus = 0;
      
      try {
//        연결 객체 가져오기
         connection = DBConnector.getConnection();
//       작성한 쿼리문을 preparedStatement에 전달
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
//       쿼리 실행
//       쿼리가 SELECT 문이기 때문에 executeQuery를 실행
         resultSet = preparedStatement.executeQuery();
//         resultSet에 걸린다는건 이미 아이디가 존재하거나, 탈퇴한 계정이라는 것
         if(resultSet.next()) {
//        	 code에 중복 아이디 코드를 담는다.
            code = DUPLICATED_ID_CODE;
            
//            만약 탈퇴 계정이라면
            if(resultSet.getInt(1) == DELETED_USER_CODE) {
//            	code를 탈퇴 계정 코드로 변경
               code = DELETED_USER_CODE;
               
            }
         }else {
//        	 다 아니라면 이용 가능한 코드로 변경
            code = ENABLED_ID_CODE;
         }

      } catch (SQLException e) {
         System.out.println("checkId()에서 쿼리문 오류");
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }

      return code;
   }

//   회원가입
// 회원가입은 회원 전체 정보를 전달해야하므로 매개변수도 UserVo 타입으로 한다.
// 회원가입 후 리턴할 정보가 있는건 아니기 때문에 void로 설정하고, resultSet이 필요없다.
   public boolean insert(UserVO userVO) {
//	   만약 check 메소드가 false가 되면 핸드폰 번호가 3개 이상 사용된 것이기 때문에 false를 리턴하고 메소드를 종료한다.
      if(!check(userVO.getUserPhoneNumber())) { return false; }
      
      String query = "insert into tbl_user "
            + "(userId, userPassword, userName, userAge, userPhoneNumber, userBirth) " + "values(?, ?, ?, ?, ?, ?)";

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userVO.getUserId());
         preparedStatement.setString(2, userVO.getUserPassword());
         preparedStatement.setString(3, userVO.getUserName());
         preparedStatement.setInt(4, userVO.getUserAge());
         preparedStatement.setString(5, userVO.getUserPhoneNumber());
         preparedStatement.setString(6, userVO.getUserBirth());
         preparedStatement.executeUpdate();
      } catch (SQLException e) {
         System.out.println(e);
         System.out.println("insert()에서 쿼리문 오류");

      } finally {
         try {
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return true;
   }

//   로그인
   public int login(String userId, String userPassword) {
      String query = "select userNumber, userStatus from tbl_user where userId = ? and userPassword =?";
//		회원의 상태를 담을 userNumber 변수 초기화
      int userNumber = 0;

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userId);
         preparedStatement.setString(2, userPassword);

         resultSet = preparedStatement.executeQuery();

         if (resultSet.next()) {
//        	 userNumber 변수에 회원번호를 담아준다.
            userNumber = resultSet.getInt("userNumber");
//            만약 userStatus의 값이 탈퇴한 코드와 같다면
            if(resultSet.getInt(2) == DELETED_USER_CODE) {
//            	userNumber를 탈퇴 코드로 수정
               userNumber = DELETED_USER_CODE;
            }
         }

      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("login() 쿼리문 오류");
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userNumber;
   }

//   아이디 찾기
//   같은 아이디로 여러개의 아이디가 있을 수 있기 때문에 UserVO 타입의 ArrayList를 리턴한다.
   public ArrayList<UserVO> findId(String userPhoneNumber) {

      String query = "select userNumber, userId, userPhoneNumber from tbl_user where userPhoneNumber = ?";
      ArrayList<UserVO> users = new ArrayList<UserVO>();

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPhoneNumber);
         resultSet = preparedStatement.executeQuery();

         while (resultSet.next()) {
//        	 핸드폰 번호에 부함하는 정보가 있다면 UserVO 객체를 만들고
            UserVO userVO = new UserVO();
//            해당 객체에 회원번호, 아이디, 핸드폰번호를 담는다.
            userVO.setUserNumber(resultSet.getInt(1));
            userVO.setUserId(resultSet.getString(2));
            userVO.setUserPhoneNumber(resultSet.getString(3));
//			담은 정보를 arrayList에 담는다.
            users.add(userVO);
         }

      } catch (SQLException e) {
         System.out.println("findId() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return users;
   }

//   회원 정보 전체 수정
   public void update(UserVO userVO) {
      String query = "update tbl_user " + "set userName=?, userPassword=?, userPhoneNumber=?, userAge=?, userBirth=? "
            + "WHERE userNumber = ?";

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);

         preparedStatement.setString(1, userVO.getUserName());
         preparedStatement.setString(2, userVO.getUserPassword());
         preparedStatement.setString(3, userVO.getUserPhoneNumber());
         preparedStatement.setInt(4, userVO.getUserAge());
         preparedStatement.setString(5, userVO.getUserBirth());
         preparedStatement.setInt(6, userVO.getUserNumber());
         preparedStatement.executeUpdate();

      } catch (SQLException e) {
         System.out.println("update() 쿼리 오류");
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

//   회원 전체 정보 조회
   public UserVO selectUser(int userNumber) {
      String query = "select userNumber, userId, userPassword, userName, userAge, userPhoneNumber, userStatus, userBirth from tbl_user "
            + "where userNumber=?";

      int i = 0;
      UserVO userVO = new UserVO();
      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1, userNumber);
         resultSet = preparedStatement.executeQuery();

         if (resultSet.next()) {
            userVO.setUserNumber(resultSet.getInt(++i));
            userVO.setUserId((resultSet.getString(++i)));
            userVO.setUserPassword(resultSet.getString(++i));
            userVO.setUserName(resultSet.getString(++i));
            userVO.setUserAge(resultSet.getInt(++i));
            userVO.setUserPhoneNumber(resultSet.getString(++i));
            userVO.setUserStatus(resultSet.getInt(++i));
            userVO.setUserBirth(resultSet.getString(++i));
         }
      } catch (SQLException e) {
         System.out.println("updateUser() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      return userVO;
   }

//   회원탈퇴
//   회원 탈퇴 시에는 테이블 내용을 삭제하는 것이 아니라, 삭제된 회원으로 status를 변경하면 된다.
   public void delete(int userNumber) {
      String query = "update tbl_user set userStatus=? where userNumber= ?";

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
//         회원 번호에 맞는 userStatus를 탈퇴 회원 코드로 바꾼다.
         preparedStatement.setInt(1, DELETED_USER_CODE);
         preparedStatement.setInt(2, userNumber);
         preparedStatement.executeUpdate();

      } catch (SQLException e) {
         System.out.println("delete() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

//   회원탈퇴 복구
//   회원번호를 통해 회원 정보를 복구한다.
   public void restore(int userNumber) {
      String query = "update tbl_user set userStatus=? where userNumber = ?";

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);

//         회원 번호와 일치하는 회원의 코드를 복구 회원 코드로 변경한다.
         preparedStatement.setInt(1, RESTORED_USER_CODE);
         preparedStatement.setInt(2, userNumber);
         preparedStatement.executeUpdate();

      } catch (SQLException e) {
         System.out.println("restore() 쿼리문 오류");
         e.printStackTrace();
      } finally {
         try {
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

//   같은 핸드폰 번호로 가입된 아이디가 몇 개 있는지 확인하는 메소드
//   같은 번호로 3개가 넘어가면 false를 리턴하도록 하여 타입은 boolean으로 설정한다.
//   해당 메소드만 따로 사용하는 것이 아니기 때문에 은닉화(캡슐화)한다.
   private boolean check(String userPhoneNumber) {
      boolean check = false;
      String query = "select count(userPhoneNumber) result from tbl_user where userPhoneNumber = ?";

      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPhoneNumber);
         resultSet = preparedStatement.executeQuery();
//        정보가 있고, 해당 번호를 쓰는 아이디가 3개 이하면 true, 3개 초과면 false를 리턴한다.
         if (resultSet.next()) { 
            check = resultSet.getInt("result") < 3;
         }

      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("login() 쿼리문 오류");
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }

      return check;
   }
   
//   핸드폰번호로 가입한 전체 회원 정보 조회
//   핸드폰 번호를 3개까지 쓸 수 있으므로 리턴 타입은 ArrayList로 한다.
   public ArrayList<UserVO> findUsersByUserPhoneNumber(String userPhoneNumber) {
      String query = "select userNumber, userId, userName, userAge, userPhoneNumber, userBirth, userStatus from tbl_user "
            + "where userPhoneNumber = ?";
      ArrayList<UserVO> users = new ArrayList<UserVO>();
      try {
         connection = DBConnector.getConnection();
         preparedStatement = connection.prepareStatement(query);
         preparedStatement.setString(1, userPhoneNumber);
         resultSet = preparedStatement.executeQuery();
         
         while (resultSet.next()) {
            UserVO userVO = new UserVO();
            userVO.setUserNumber(resultSet.getInt(1));
            userVO.setUserId(resultSet.getString(2));
            userVO.setUserName(resultSet.getString(3));
            userVO.setUserAge(resultSet.getInt(4));
            userVO.setUserPhoneNumber(resultSet.getString(5));
            userVO.setUserBirth(resultSet.getString(6));
            userVO.setUserStatus(resultSet.getInt(7));
            users.add(userVO);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (resultSet != null) {
               resultSet.close();
            }
            if (preparedStatement != null) {
               preparedStatement.close();
            }
            if (connection != null) {
               connection.close();
            }
         } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
         }
      }
      
      return users;
   }
}






















