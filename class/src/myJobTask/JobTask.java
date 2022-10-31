package myJobTask;

import java.util.Iterator;
import java.util.Random;

public class JobTask {
	// 직업 이름, 레벨, 경험치, 체력, 힘, 운
	String jobName;
	int level;
	int experiencePoint;
	int needExperiencePoint;
	int healthPoint;
	int maxHealthPoint;
	int powerPoint;
	int magicPoint;
	int luckPoint;
	int money;

	int attackPoint;
	int randomAttackPoint;

	Random r = new Random();

	public JobTask() {
		;
	}

	public JobTask(String jobName, int level, int experiencePoint, int healthPoint, int maxHealthPoint, int powerPoint,
			int magicPoint, int luckPoint) {
		this.jobName = jobName;
		this.level = level;
		this.experiencePoint = experiencePoint;
		this.healthPoint = healthPoint;
		this.maxHealthPoint = maxHealthPoint;
		this.powerPoint = powerPoint;
		this.magicPoint = magicPoint;
		this.luckPoint = luckPoint;
		this.needExperiencePoint = level * level * 10;
	}

	void levelUp() {
		level++;
		experiencePoint = 0;
		needExperiencePoint = needExperiencePoint + level * 20;
		// 체력, 힘, 마력, 운은 개별적으로 운영
	}

	void warriorStatUp() {
		maxHealthPoint += 20;
		healthPoint = maxHealthPoint;
		powerPoint += 5;
		magicPoint++;
		luckPoint += 2;
	}
	
	void magicianStatUp() {
		maxHealthPoint += 10;
		healthPoint = maxHealthPoint;
		powerPoint++;
		magicPoint += 6;
		luckPoint += 2;
	}
	
	void thiefStatUp() {
		maxHealthPoint += 15;
		healthPoint = maxHealthPoint;
		powerPoint ++;
		magicPoint += 2;
		luckPoint += 5;
	}

	int monsterAppear() { // 각각 독립적인 확률로 진행됨.
		if (rate(60)) {// 달팽이 등장
			return 0;
		}
		if (rate(60)) {// 민달팽이 등장
			return 1;
		}
		if (rate(50)) {// 멧돼지 등장
			return 2;
		}
		if (rate(35)) {// 코끼리 등장
			return 3;
		}
		return 4; // 티라노 등장
	}

	int attack() {
		attackPoint = powerPoint * magicPoint * luckPoint; // 공격력
		randomAttackPoint = r.nextInt(attackPoint);

		while (randomAttackPoint < level) { // 공격력은 본인 레벨이상 ~ 최대 공격력 범위 내 무작위로 결정된다.
			randomAttackPoint = r.nextInt(attackPoint);
		}
		return randomAttackPoint;
	}
	
	void lose() {
		if (experiencePoint < 10) {
			experiencePoint = 0;
		} else {
			experiencePoint = experiencePoint - 10; // 경험치 10 감소
		}
		
		healthPoint = 10;
	}
	

	void sleep() {
		healthPoint += 10;
	}

	boolean rate(int rating) {
		int[] percent = new int[100];
		for (int i = 0; i < rating; i++) {
			percent[i] = 1;
		}
		return percent[r.nextInt(percent.length)] == 1;
	}
}
