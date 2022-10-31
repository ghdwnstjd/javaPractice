package myJobTask;

import java.util.Random;

public class Monster {
// 몬스터 이름, 체력, 경험치, 공격력
//	* 돈은 전투에서 승리 시 랜덤으로 쟁취하는 것으로 진행
	
	String monsterName;
	int monsterHealthPoint;
	int monsterPoint;
	int monsterAttackPoint;
	int money;
	int randomMonsterAttackPoint;
	
	Random r = new Random();
	
	
	public Monster() {;}


	public Monster(String monsterName, int monsterHealthPoint, int monsterPoint, int monsterAttackPoint, int money) {
		this.monsterName = monsterName;
		this.monsterHealthPoint = monsterHealthPoint;
		this.monsterPoint = monsterPoint;
		this.monsterAttackPoint = monsterAttackPoint;
		this.money = money;
	}
	
	int monsterAttack(){
		randomMonsterAttackPoint = r.nextInt(monsterAttackPoint); 
		while(randomMonsterAttackPoint ==0) { //몬스터 공격력은 1~최대공격력 사이 중 무작위로 나옴
			randomMonsterAttackPoint = r.nextInt(monsterAttackPoint);
		} return randomMonsterAttackPoint;
	}
	
	
}
