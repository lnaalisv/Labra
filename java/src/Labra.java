public class Labra {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Too few arguments for test class");
		}
		String test = args[0];
		if(test.equals("test1")) {
			test1(args);
		} else {
			System.out.println("Invalid test name : " + test);
		}
	}
	
	public static long memory_get_usage() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
	
	public static void test1(String[] args) {
		if(args.length != 5) {
			System.out.println("Too few arguments for test1");
			return;
		}
		int test_times = Integer.parseInt(args[1]);
		int min_var = Integer.parseInt(args[2]);
		int max_var = Integer.parseInt(args[3]);
		int test_size = Integer.parseInt(args[4]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;
		
		int a = min_var + (int)(Math.random()*(max_var-min_var));
		int b = min_var + (int)(Math.random()*(max_var-min_var));
		int c = min_var + (int)(Math.random()*(max_var-min_var));
		int d = min_var + (int)(Math.random()*(max_var-min_var));
		int e = min_var + (int)(Math.random()*(max_var-min_var));
		int f = min_var + (int)(Math.random()*(max_var-min_var));
		int g = min_var + (int)(Math.random()*(max_var-min_var));
		int h = min_var + (int)(Math.random()*(max_var-min_var));
		
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			
			float result = 0;
			for(int j = 0 ; j < test_size ; j++) {
				result += (a*b^3)/c*(d-e^j)-f+(g/h);
			}
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);
	}
	public void test2(String[] args) {
		
	}
	public void test3(String[] args) {
		
	}
	public void test4(String[] args) {
		
	}
	public void test5(String[] args) {
		
	}
	public void test6(String[] args) {
		
	}
	public void test7(String[] args) {
		
	}
	public void test8(String[] args) {
		
	}
	public void test9(String[] args) {
		
	}
	public void test10(String[] args) {
		
	}

}

