package myJobTask;

import java.util.Random;
import java.util.Scanner;

public class MainGame {

	// sleep 메소드를 간편하게 사용하기 위해 구현
	void sleep(double num) { //시간 정지를 위한 메소드 구현
		for (int i = 0; i < num; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				;
			} 
		}
	}

	public static void main(String[] args) {

		MainGame mainGame = new MainGame(); // sleep 을 이용한 메소드 활용

//		직업 선택창에 들어갈 배열
// 		직업명, 레벨, 경험치, 체력, 최대 체력, 힘, 마력, 운
		JobTask[] jobTask = { 
				new JobTask("전사", 1, 0, 30, 50, 5, 2, 1), 
				new JobTask("마법사", 1, 0, 12, 20, 2, 5, 1),
				new JobTask("도적", 1, 0, 15, 25, 1, 3, 3) 
				};

//		몬스터 이름, 체력, 경험치, 공격력
		Monster[] monsterTask = { 
				new Monster("달팽이", 45, 3, 3, 3), 
				new Monster("민달팽이", 150, 4, 6, 5),
				new Monster("멧돼지", 1020, 5, 9, 15), 
				new Monster("코끼리", 5500, 20, 10, 25),
				new Monster("티라노", 25000, 100, 50, 300) 
				};

//		물약 이름, 가격, 체력 충전수치
		Medicine[] medicineTask = { 
				new Medicine("빨간 포션", 5, 5), 
				new Medicine("주황 포션", 10, 10),
				new Medicine("하얀 포션", 20, 20), 
				new Medicine("이상한 포션", 100, 100)
				};

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		String title = "■■■■■■■■■■■■■인간 키우기 게임■■■■■■■■■■■■■";
		String idMakeMessage = "사용할 캐릭터의 이름을 입력하세요\n이름: ", id = "";
		String jobSelectMessage = "직업을 선택하세요.\n1. 전사\n2. 마법사\n3. 도적\n4. 나가기\n선택: ";
		String actionMessage = "1. 전투\n2. 물약먹기\n3. 상점가기\n4. 내 상태\n5. 취침하기\n6. 나가기\n선택: ";
		String fightMessage = "1.공격\n2.물약먹기\n3.내 상태\n4. 도망치기\n선택: ";

		int jobSelectNumber = 0, actionSelectNumber = 0, battleMonster = 0, 
				fightSelectNumber = 0, 	medicineChoiceNumber = 0, medicineBattleChoiceNumber = 0,
				initializeMonsterHealthPoint = 0, earnMoney = 0, usingMedicine = 0, attackPassing = 0;

		int[] medicineWallet = new int[medicineTask.length]; //물약 

	
		
//		============게임 시작==============
		System.out.print(idMakeMessage);
		id = sc.next();
		System.out.println(id +"님 환영합니다.");

		while (true) {
			System.out.println(title);
			System.out.print(jobSelectMessage);
			jobSelectNumber = sc.nextInt();
			if (jobSelectNumber == 4) {break;}
			if (jobSelectNumber > 4) {
				System.out.println("올바른 숫자를 입력해주세요.");
				continue;
			}
			JobTask myJob = jobTask[jobSelectNumber - 1];
			System.out.println(myJob.jobName + "을(를) 고르셨습니다.");

			while (true) {

				System.out.print(actionMessage);
				actionSelectNumber = sc.nextInt();
				if (actionSelectNumber == 6) { break; }

				switch (actionSelectNumber) {
				case 1: // 싸우기
					battleMonster = myJob.monsterAppear();
					Monster monster = monsterTask[battleMonster];
					
					initializeMonsterHealthPoint = monster.monsterHealthPoint; //몬스터 HP 초기화를 위한 변수

					// 몬스터 출현
					System.out.println("야생의 " + monster.monsterName + "이(가) 나타났다!");

//					// 전투 진행
					while (true) {
						System.out.print(fightMessage);
						fightSelectNumber = sc.nextInt();

						switch (fightSelectNumber) {
						case 1: // 공격
							myJob.attack();
							System.out.println("--------------------------------");
							System.out.println(id + "이(가) " + monster.monsterName + "을(를) 공격해 " + myJob.randomAttackPoint + " 데미지를 입혔다!");
							monster.monsterHealthPoint -= myJob.randomAttackPoint;
							if (monster.monsterHealthPoint > 0) { // 몬스터의 체력이 남아있을 때만 출력
								System.out.println(monster.monsterName + "의 남은 체력: " + monster.monsterHealthPoint);
							}

							if (monster.monsterHealthPoint <= 0) { // 전투에서 이긴 상황
								// 현금 획득
								earnMoney = r.nextInt(monster.money);
								myJob.money += earnMoney;

								System.out.println(monster.monsterName + "을(를) 해치웠다!");
								System.out.println("경험치 " + monster.monsterPoint + "획득!");
								System.out.println("현금 " + earnMoney + "원 획득!");
								earnMoney = 0; // 전투로 취득한 현금 액수 초기화
								System.out.println("--------------------------------");
								myJob.experiencePoint += monster.monsterPoint;

								// 몬스터의 체력 초기화
								monster.monsterHealthPoint = initializeMonsterHealthPoint; // 이걸 안하면 전투 종료 후의 체력으로 나옴

								// 레벨업 시
								if (myJob.experiencePoint >= myJob.needExperiencePoint) {
									myJob.levelUp();
									System.out.println("레벨업! 현재 레벨은 " + myJob.level + "입니다.");
									System.out.println("--------------------------------");
									if (jobSelectNumber == 1) { // 전사일 때
										// 체력, 힘, 마력, 운은 개별적으로 운영
										myJob.warriorStatUp();
									} else if (jobSelectNumber == 2) { // 마법사
										myJob.magicianStatUp();
									} else if (jobSelectNumber == 3) { // 도적
										myJob.thiefStatUp();
									}
									break;
								}
							} else { // 아직 이기지는 못했을 때
								//운에 따라 안맞을 수도 있음 -> luckPoint가 높을 수록 안맞을 확률 증가
								if(myJob.luckPoint>80) { // luckPoint가 80 이상이면 회피율을 80%로 고정
									attackPassing = 80;
								} else {
									attackPassing = myJob.luckPoint;
								}
								
								if(myJob.rate(attackPassing)) { //공격 회피 시
									System.out.println(monster.monsterName + "의 공격을 피했다!");
									System.out.println("현재 남은 체력: " + myJob.healthPoint);
									continue;
								}
								else {
									monster.monsterAttack();
									System.out.println("--------------------------------");
									System.out.println(monster.monsterName + "이(가) " + id + "을(를) 공격해 " + monster.randomMonsterAttackPoint + " 데미지를 입혔다!");
									myJob.healthPoint -= monster.randomMonsterAttackPoint;
									if (monster.monsterHealthPoint > 0) { // 내 캐릭터의 체력이 남아있을 때만 출력
										System.out.println(id + "의 남은 체력: " + myJob.healthPoint);
										System.out.println("--------------------------------");
									}
									if (myJob.healthPoint <= 0) { // 내가 졌을 때
										myJob.lose();
										System.out.println("전투에서 패배했다! 강제로 취침 모드에 들어간다!!");
										System.out.print(id + "체력 회복 중");
										for (int i = 0; i < 3; i++) {
											mainGame.sleep(1);
											System.out.print("."); // for문으로 반복이 되므로, 1초당 "."이 한 번씩 나와 총 3개가 나온다.
										}
										System.out.println();
										System.out.println("--------------------------------");
										System.out.println("잠에서 깨어났다!");
										System.out.println("--------------------------------");
	
										// 몬스터의 체력 초기화
										monster.monsterHealthPoint = initializeMonsterHealthPoint;
										break;
									}
									continue; // while문이 끝난게 아니고 다시 전투 선택창 모드로 넘어가야 하기 때문에 break가 아닌 continue를 쓴다
								}
							}
							break;
						case 2: // 물약먹기
							System.out.println("■■■■현재 보유 물약■■■■");
							for (int i = 0; i < medicineWallet.length; i++) {
								System.out.println((i+1) + ". " + medicineTask[i].name + ": " + medicineWallet[i] + "개");
							}
							System.out.print((medicineTask.length + 1 )+". 나가기\n선택: ");

							medicineBattleChoiceNumber = sc.nextInt();
							usingMedicine = medicineBattleChoiceNumber - 1;

							if (medicineBattleChoiceNumber == medicineWallet.length+1) { //선택한 번호가 물약 개수+1 개면 나가기 번호
								continue;
							} else if (medicineBattleChoiceNumber > medicineWallet.length+1 || medicineBattleChoiceNumber <= 0) { //나가기 번호 이상의 번호를 눌렀거나 0이하의 숫자를 입력했을 때
								System.out.println("올바른 숫자를 입력해주세요.");
								System.out.println("--------------------------------");
								continue;
							} else if (medicineWallet[usingMedicine] == 0) { // 보유한 물약이 없을 때
								System.out.println("물약이 없습니다.");
								System.out.println("--------------------------------");
								continue;
							}

							else {
								if (myJob.maxHealthPoint == myJob.healthPoint) { // 현재 체력이 최대치일 때
									System.out.println("체력이 최대치여서 물약을 사용할 수 없습니다.");
									continue;
								} else if (myJob.healthPoint + medicineTask[usingMedicine].recoverPoint > myJob.maxHealthPoint) {// 포션을 먹었을 때 최대 체력보다 높아지는 경우
									medicineWallet[usingMedicine]--; 
									System.out.println(medicineTask[usingMedicine].name + " 1개 사용!");
									System.out.println("HP가 " + (myJob.maxHealthPoint-myJob.healthPoint) + "만큼 회복됐다!");
									myJob.healthPoint = myJob.maxHealthPoint;
								} else { // 일반적인 물약 사용 효과 발현
									medicineWallet[usingMedicine]--; // 물약 사용
									myJob.healthPoint += medicineTask[usingMedicine].recoverPoint; // 체력 회복
									System.out.println(medicineTask[usingMedicine].name + " 1개 사용!");
									System.out.println("HP가 " + medicineTask[usingMedicine].recoverPoint + "만큼 회복됐다!");
									continue;
								}
							}
							break;

						case 3: // 내 상태보기
							System.out.println("■■■■■■■■전투 중인 내 상태■■■■■■■■■");
							System.out.println("직업: " + myJob.jobName);
							System.out.println("레벨: " + myJob.level);
							System.out.println("경험치: " + myJob.experiencePoint + "/" + myJob.needExperiencePoint);
							System.out.println("체력: " + myJob.healthPoint + "/" + myJob.maxHealthPoint);
							System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
							continue;
						case 4: // 도망치기
							// 몬스터의 체력 초기화
							monster.monsterHealthPoint = initializeMonsterHealthPoint;
							System.out.println("성공적으로 도망쳤다!");
							System.out.println("--------------------------------");
							break;
						default:
							System.out.println("올바른 번호를 입력해주세요.");
							System.out.println("--------------------------------");
							continue;

						}
						break;
					}
					break;
				case 2: // 체력보충
					System.out.println("■■■■현재 보유 물약■■■■");
					for (int i = 0; i < medicineWallet.length; i++) {
						System.out.println((i+1) + ". " + medicineTask[i].name + ": " + medicineWallet[i] + "개");
					}
					System.out.print((medicineTask.length + 1 )+". 나가기\n선택: ");

					medicineBattleChoiceNumber = sc.nextInt();
					usingMedicine = medicineBattleChoiceNumber - 1;

					if (medicineBattleChoiceNumber == medicineWallet.length+1) { //물약 개수 +1 개면 나가기
						continue;
					} else if (medicineBattleChoiceNumber > medicineWallet.length+1 || medicineBattleChoiceNumber <= 0) { //나가기 번호 이상의 번호를 눌렀거나 0이하의 숫자를 입력했을 때
						System.out.println("올바른 숫자를 입력해주세요.");
						continue;
					}

					else if (medicineWallet[usingMedicine] == 0) {
						System.out.println("물약이 없습니다.");
						continue;
					}

					else {
						if (myJob.maxHealthPoint == myJob.healthPoint) { // 현재 체력이 최대치일 때
							System.out.println("체력이 최대치여서 물약을 사용할 수 없습니다.");
							continue;
						} else if (myJob.healthPoint + medicineTask[usingMedicine].recoverPoint > myJob.maxHealthPoint) { // 포션을 먹었을 때 최대 체력보다 높아지는 경우
							medicineWallet[usingMedicine]--; // 물약 사용
							System.out.println(medicineTask[usingMedicine].name + " 1개 사용!");
							System.out.println("HP가 " + (myJob.healthPoint + medicineTask[usingMedicine].recoverPoint - myJob.maxHealthPoint) + "만큼 회복됐다!");
							myJob.healthPoint = myJob.maxHealthPoint;
						} else { // 일반적인 물약 사용 효과 발현
							medicineWallet[usingMedicine]--; // 물약 사용
							myJob.healthPoint += medicineTask[usingMedicine].recoverPoint; // 체력 회복
							System.out.println(medicineTask[usingMedicine].name + " 1개 사용!");
							System.out.println("HP가 " + medicineTask[usingMedicine].recoverPoint + "만큼 회복됐다!");
							continue;
						}
					}
					break;

				case 3: // 상점가기
					while (true) {
						String medicineShopMessage = "■■■■■■■■■■■■■■■■■■상점■■■■■■■■■■■■■■■■■■\n* 현재 보유 현금: " + myJob.money + "원";
						System.out.println(medicineShopMessage);

						for (int i = 0; i < medicineWallet.length; i++) {
							System.out.println((i+1) +". " + medicineTask[i].name + "(체력 " + medicineTask[i].recoverPoint + " 회복): " + medicineTask[i].pay +"원");
						}
						System.out.print((medicineTask.length+1) +". 나가기\n선택: ");
						medicineChoiceNumber = sc.nextInt();
						if (medicineChoiceNumber == medicineTask.length+1) {
							break;
						} // 여기서 잡아줘야 아래 medicineTask 배열의 개수에 오류가 생기지 않음
						if (medicineChoiceNumber > medicineTask.length+1 || medicineChoiceNumber <= 0) {
							System.out.println("정확한 번호를 입력해주세요.");
							continue;
						}

						Medicine medicine = medicineTask[medicineChoiceNumber - 1];
						
							if (myJob.money >= medicine.pay) {
								myJob.money -= medicine.pay;
								medicineWallet[medicineChoiceNumber - 1]++;
								System.out.println(medicine.name + " 구매 성공!\n남은 현금: " + myJob.money);
								continue;
							} else {
								System.out.println("돈이 부족합니다.");
								continue;
							}
					}
					break;
				case 4: // 내 상태 보기
					System.out.println("■■■■■■■■내 상태■■■■■■■■■");
					System.out.println("직업: " + myJob.jobName);
					System.out.println("현금: " + myJob.money);
					System.out.println("레벨: " + myJob.level);
					System.out.println("경험치: " + myJob.experiencePoint + "/" + myJob.needExperiencePoint);
					System.out.println("체력: " + myJob.healthPoint + "/" + myJob.maxHealthPoint);
					System.out.println("공격력: " + myJob.level + "~" + myJob.powerPoint * myJob.magicPoint * myJob.luckPoint);
					System.out.println("-힘: " + myJob.powerPoint);
					System.out.println("-마력: " + myJob.magicPoint);
					System.out.println("-운: " + myJob.luckPoint);
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■");
					break;
				case 5: // 취침하기
					if(myJob.healthPoint == myJob.maxHealthPoint) {
						System.out.println("체력이 최대치이기 때문에 취침할 수 없습니다.");
						System.out.println("--------------------------------");
						break;
					}
					
					System.out.println();
					if(myJob.healthPoint + 10> myJob.maxHealthPoint) { // 체력 최대치를 넘어가면 체력 최대치로 수정
						System.out.print("취침 중");
						for (int i = 0; i < 3; i++) {
							mainGame.sleep(1);
							System.out.print(".");
						}
						System.out.println("체력이 " + (myJob.maxHealthPoint-myJob.healthPoint)+ " 증가했습니다.\n현재 남은 체력: " + myJob.maxHealthPoint);
						System.out.println("--------------------------------");
						myJob.healthPoint = myJob.maxHealthPoint;
						break;
					}
					System.out.print("취침 중");
					for (int i = 0; i < 3; i++) {
						mainGame.sleep(1);
						System.out.print(".");
					}
					myJob.sleep();
					System.out.println("체력이 10 증가했습니다. \n현재 남은 체력: " + myJob.healthPoint);
					System.out.println("--------------------------------");
					break;
				default:
					System.out.println("다시 입력해주세요.");
					System.out.println("--------------------------------");
					break;
				}
			}
		}
	}
}
