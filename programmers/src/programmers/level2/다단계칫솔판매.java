package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import common.CommonUtils;

public class 다단계칫솔판매 {
	
	public static void main(String[] args) {
		
		String[] enroll 	= {"john", "mary", "edward", "sam",    "emily", "jaimie", "tod",    "young"};
		String[] referral 	= {"-",    "-",    "mary", 	 "edward", "mary", 	"mary",   "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		CommonUtils.printArray(solution(enroll, referral, seller, amount));
	}

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
        int[] answer = {};
        
        // 이름에 따른 Member객체 DB생성
        Map<String, Member> memberMap = new HashMap<String, Member>();
        memberMap.put("Center", new Member("Center"));
        
        for(int i = 0; i < enroll.length; i++) {
        	// 해당 이름으로 Member객체 생성 후 DB에 저
        	String name = enroll[i];
        	memberMap.put(name, new Member(name));
        	
        	// 고용주가 존재하면 해당 Member의 boss로 세팅
        	String bossName = referral[i];
        	if(!bossName.equals("-")) {
        		memberMap.get(name).setBoss(memberMap.get(bossName));
        	}else {
        		memberMap.get(name).setBoss(memberMap.get("Center"));
        	}
        }
        
        for(int i = 0; i < seller.length; i++) {
        	
        	String name = seller[i];
        	int price = Math.multiplyExact(amount[i], 100);
        	
        	System.out.println("name : " + name);
        	System.out.println("price : " + price);
        	
        	Member curMember = memberMap.get(name);
        	int curIncome = price;
        	do {
        		
        		int bossIncome = curIncome / 10;
        		int income = curIncome - bossIncome;
        		
        		System.out.println("cur Member : " + curMember.getName());
        		System.out.println("cur Income : " + curIncome);
        		System.out.println("income : " + income);
            	System.out.println("bossIncome : " + bossIncome);
        		curMember.addIncome(income);
        		
        		System.out.println("added Income : " + curMember.getIncome());
        		
        		curIncome = bossIncome;
        		
        		curMember = curMember.getBoss();
        		System.out.println("============================");
        	}while(curMember != null && curIncome != 0);
        }
        
        System.out.println("=================SUM======================");
        int cnt = 0;
        answer = new int[memberMap.size() -1];
        for(Entry<String, Member> entry : memberMap.entrySet()) {
        	System.out.println("name : " + entry.getKey());
        	System.out.println("income : " + entry.getValue().getIncome());
        	if(entry.getValue().getBoss() != null) {
	        	System.out.println("bossName : " + entry.getValue().getBoss().getName());
	        	System.out.println("bossIncome : " + entry.getValue().getBoss().getIncome());
        	}else {
        		System.out.println("No boss");
        	}
        	System.out.println("=====================");
        }
        
        for(String name : enroll) {
        	if(name != "Center") {
        		answer[cnt++] = memberMap.get(name).getIncome();
        	}
        }
        
        return answer;
    }
	
	// Member 에 대한 정보를 담기위한 내부 클래스 생
	static class Member{
		
		private Member boss;
		private String name;
		
		private int income = 0;
		
		Member(String name){
			this.name = name;
		}
		
		public void setBoss(Member boss) {
			this.boss = boss;
		}

		public void addIncome(int income) {
			this.income += income;
		}
		
		public Member getBoss() {
			return this.boss;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getIncome() {
			return this.income;
		}
	}
}
