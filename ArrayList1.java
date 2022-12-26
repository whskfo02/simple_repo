package list;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList1 {
	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(10);
		
		list1.add(10);							// 10(기본형)을 알아서 wrapper클래스로 변환해서 넣어줌
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(9));
		list1.add(new Integer(1));
		list1.add(new Integer(0));
		list1.add(new Integer(3));
		
		
		// subList() : arrayList에서 일부를 뽑아서 새로운 배열을 생성
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		
		print(list1, list2);
		
		// Collection : 인터페이스 / Collections : 유틸클래스
		// 오름차순 정렬
		Collections.sort(list1);
		Collections.sort(list2);

		
		// 오름차순 정렬 후 뒤집어주기 -> 내림차순
		Collections.reverse(list1);
		
		print(list1, list2);
		
		// containsAll() : 모든 요소가 전부 포함되어있는지 확인
		// Collection의 추상메서드
		// List, set은 Collection을 구현하고 있기 때문에 사용이 가능함
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		// add() : 내용 추가. 위치(인덱스)지정 가능
		list2.add("B");
		list2.add("C");
		
		list2.add(3, "A");
		
		
		print(list1, list2);
		
		list2.set(3, "AA");
		
		print(list1, list2);
		
		// indexOf() : 지정된 객체의 위치(인덱스를 알려줌)
		list1.add(0, "1");
		System.out.println("index = " + list1.indexOf("1"));					// 문자와 숫자를 구분해서 찾아줌
		System.out.println("index = " + list1.indexOf(1));
		
				
		// remove() : 해당 인덱스의 값이 삭제
		list1.remove(1);							// 1번 인덱스의 값이 삭제됨
		list1.remove(new Integer(1)); 				// 객체로 넣어주면 숫자 1을 지울 수 있음
		
		print(list1, list2);
		
		// retainAll() : 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		
		print(list1, list2);
		

		// for문 돌려서 list2의 자료를 하나씩 지우기
//		for(int i=0; i<list2.size(); i++) {
//			list2.remove(i);
//		}
//		print(list1, list2);
		/* 전부 지워지지않음 -> 자료가 하나씩 지워질 때마다 인덱스번호가 하나씩 앞으로 밀리기 때문(=길이자체가 줄어듬) 
		 				==> 마지막 객체부터 지워나가면 됨 */
		// 마지막 객체부터 삭제하기
//		for(int i=list2.size()-1; i>=0; i--) {
//			list2.remove(i);
//		}
//		print(list1, list2);
//		
//		
		// ==> ArrayList는 삽입과 삭제가 빈번하게 일어난다면 사용하지 않는게 좋음
		
		// list2에서 list1과 겹치는 부분을 삭제
		for(int i=list2.size()-1; i>=0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
			}
		print(list1, list2);
	
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
