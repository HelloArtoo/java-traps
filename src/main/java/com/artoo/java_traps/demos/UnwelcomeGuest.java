package com.artoo.java_traps.demos;

public class UnwelcomeGuest {
	public static final long GUEST_USER_ID = -1;
	/*private static final long USER_ID;
	static {
		try {
			USER_ID = getUserIdFromEnviroment();
		} catch (IdUnavailableException e) {
			USER_ID = GUEST_USER_ID;  //编译不通过
			System.out.println("Logging in as guest");
		}
	}*/
	/** 
	 * 解决这类问题的最好方式就是将这个烦人的域从空 final 类型改变为普通的final 类型,用一个静态域的初始化操作替换掉静态的初始化语句块
	 * 如果你必须重构一个程序,以消除由明确赋值规则所引发的错误,那么你应该考虑添加一个新方法。这样做除了可以解决明确赋值问题,还可以使程序 的可读性提高。
	 * 
	 **/
	private static final long USER_ID_RIGHT = getUserIdOrGuest();
	private static long getUserIdOrGuest() {
		try{
			return getUserIdFromEnviroment();
		}catch(IdUnavailableException e){
			System.out.println("Logging in as guest");
			return GUEST_USER_ID;
		}
		
	};
	

	/**
	 * 在程序中,一个空 final 域只有在它是明确未赋过值的地方才可以被赋值。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("User ID:" + USER_ID_RIGHT);

	}

	private static long getUserIdFromEnviroment() throws IdUnavailableException {
		throw new IdUnavailableException();
	}

}

class IdUnavailableException extends Exception {

}
