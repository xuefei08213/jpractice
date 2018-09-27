/**
 * 
 */
package org.jpractice.jvm.classloader.passiveref;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 作者： chengaofeng
 * @date: 创建时间：2018-09-11 16:50:59
 * @Description: TODO
 * @version V1.0
 */
public class MatSimple {

	public static void main(String[] args) {
		PersonRepo pp = new PersonRepo();
		pp.autoCreatePerson(10000000);
	}

	public static class PersonRepo {

		private List<Person> repo = new ArrayList<>();

		public void autoCreatePerson(long count) {
			for (long l = 0; l < count; l++) {
				repo.add(new Person(l));
			}
		}
	}

	public static class Person {
		private long num;

		/**
		 * @param num
		 */
		public Person(long num) {
			this.num = num;
		}

		public long getNum() {
			return this.num;
		}

	}
}
