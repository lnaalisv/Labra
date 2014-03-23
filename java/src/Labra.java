
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.JSONValue;


public class Labra {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Too few arguments for test class");
		}
		String test = args[0];
		if(test.equals("test1")) {
			test1(args);
		} else if(test.equals("test2")) {
			test2(args);
		} else if(test.equals("test3")) {
			test3(args);
		} else if(test.equals("test4")) {
			test4(args);
		} else if(test.equals("test5")) {
			test5(args);
		} else if(test.equals("test6")) {
			test6(args);
		} else if(test.equals("test7")) {
			test7(args);
		} else if(test.equals("test8")) {
			test8(args);
		} else if(test.equals("test9")) {
			test9(args);
		} else {
			System.out.println("Invalid test name : " + test);
		}
	}
	
	public static long memory_get_usage() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
	
	public static int[][] get_matrix(int width, int height, int min_var, int max_var) {
		int matrix[][] = new int[width][height];
		for(int x = 0 ; x < width ; x++) {
			for(int y = 0 ; y < height ; y++) {
				matrix[x][y] = min_var + (int)(Math.random()*(max_var-min_var));
			}
		}
		return matrix;
	}
	
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	public static byte[] readFileToBytes(String file) throws IOException {
        return readFileToBytes(new File(file));
    }

    public static byte[] readFileToBytes(File file) throws IOException {
        // Open file
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
            // Get and check length
            long longlength = f.length();
            int length = (int) longlength;
            if (length != longlength)
                throw new IOException("File size >= 2 GB");
            // Read file and return data
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }
	
	public static int[][] matrixmult(int[][] m1, int[][] m2) {
		int r = m1.length;
		int c = m2[0].length;
		int p = m2.length;
		int[][] m3 = new int[r][c];
		for(int i = 0 ; i < r ; i++) {
			for(int j = 0 ; j < c ; j++) {
				m3[i][j] = 0;
				for(int k = 0 ; k < p ; k++) {
					m3[i][j] += m1[i][k]*m2[k][j];
				}
			}
		}
		return m3;
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
	public static void test2(String[] args) {
		if(args.length != 5) {
			System.out.println("Too few arguments for test2");
			return;
		}
		int test_times = Integer.parseInt(args[1]);
		int min_var = Integer.parseInt(args[2]);
		int max_var = Integer.parseInt(args[3]);
		int matrix_size = Integer.parseInt(args[4]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;
		
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			int[][] m1 = get_matrix(matrix_size, matrix_size, min_var, max_var);
			int[][] m2 = get_matrix(matrix_size, matrix_size, min_var, max_var);
			matrixmult(m1, m2);
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);		
	}
	public static void test3(String[] args) {
		if(args.length != 4) {
			System.out.println("Too few arguments for test3");
			return;
		}
		String file = args[1];
		String word = args[2];
		int test_times = Integer.parseInt(args[3]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;
		String[] stringArray = null;
		try {
			Path filePath = new File(file).toPath();
			Charset charset = Charset.defaultCharset();
			List<String> stringList = Files.readAllLines(filePath, charset);
			stringArray = stringList.toArray(new String[]{});
		} catch(IOException ex) {
			System.out.println("Exception in test3: " + ex.getMessage());
			return;
		}
			
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			for(int j = 0 ; j < stringArray.length ; j++) {
				String line = stringArray[j];
				if(line.contains(word)) {
					//System.out.println("Word " + word + " found at line " + j);
				}
			}
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);	
	}
	
	public static void test4(String[] args) {
		if(args.length != 3) {
			System.out.println("Too few arguments for test4");
			return;
		}
		String file = args[1];
		int test_times = Integer.parseInt(args[2]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;
		String input = null;
		
		try {
			input = readFile(file, Charset.defaultCharset());
		} catch(IOException ex) {
			System.out.println("IOException in test4 " + ex.getMessage());
			return;
		}
		//System.out.println("Starting JSON parse");
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			JSONArray json = new JSONArray(input);
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);			
	}
	
	public static void test5(String[] args) {
		if(args.length != 3) {
			System.out.println("Too few arguments for test5");
			return;
		}
		String file = args[1];
		int test_times = Integer.parseInt(args[2]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;

		//System.out.println("Starting file read");
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			try {
				byte[] f = readFileToBytes(file);
			} catch(IOException ex) {
				System.out.println("IOException in test5 " + ex.getMessage());
				return;
			}
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);				
	}
	
	public static void test6(String[] args) {
		if(args.length != 4) {
			System.out.println("Too few arguments for test6");
			return;
		}
		String file = args[1];
		String output = args[2];
		int test_times = Integer.parseInt(args[3]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;
		byte[] f;
		try {
			f = readFileToBytes(file);
		} catch(IOException ex) {
			System.out.println("IOException in test6 " + ex.getMessage());
			return;
		}

		//System.out.println("Starting file write");
		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			try {
				FileOutputStream fos = new FileOutputStream(output);
				fos.write(f);
				mem2 = memory_get_usage();
				fos.close();
			} catch(Exception ex) {
				System.out.println("Exception in test6 " + ex.getMessage());
				return;
			}
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);				
	}
	
	public static void test7(String[] args) {
		if(args.length != 5) {
			System.out.println("Invalid number of arguments for test7");
			return;
		}
		int test_times = Integer.parseInt(args[1]);
		int min_var = Integer.parseInt(args[2]);
		int max_var = Integer.parseInt(args[3]);
		int array_size = Integer.parseInt(args[4]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;

		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
			for(int j = 0 ; j < array_size ; j++) {
				ArrayList<Integer> narray = new ArrayList<Integer>();
				for(int k = 0 ; k < array_size ; k++) {
					int x = (int)(Math.random()*(max_var-min_var));
					narray.add(new Integer(x));
				}
				array.add(narray);
			}
			int search_for = (int)(Math.random()*(max_var-min_var));
			Integer search_fori = new Integer(search_for);
			
			for(int j = 0 ; j < array_size ; j++) {
				if(array.get(j).contains(search_fori)) {
					
				}
			}
			
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);			
	}
	
	public static void test8(String[] args) {
		if(args.length != 5) {
			System.out.println("Invalid number of arguments for test8");
			return;
		}
		int test_times = Integer.parseInt(args[1]);
		int min_var = Integer.parseInt(args[2]);
		int max_var = Integer.parseInt(args[3]);
		int list_size = Integer.parseInt(args[4]);
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;

		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			for(int x = 0 ; x < list_size ; x++) {
				int v = (int)(Math.random()*(max_var-min_var));
				list.add(new Integer(v));
			}
			
			int search_for = (int)(Math.random()*(max_var-min_var));
			Integer search_fori = new Integer(search_for);
			if(list.contains(search_fori)) {
				
			}
			
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);				
	}
	
	public static void test9(String[] args) {
		if(args.length != 4) {
			System.out.println("Invalid number of arguments for test9");
			return;
		}
		
		String file = args[1];
		int test_times = Integer.parseInt(args[2]);
		String output = args[3];
		
		long mem1 = memory_get_usage();
		long mem2 = 0;
		long mem3 = 0;

		long start_time = System.nanoTime();
		for(int i = 0 ; i < test_times ; i++) {
			
			String[] lines = null;
			try {
				Path filePath = new File(file).toPath();
				Charset charset = Charset.defaultCharset();
				List<String> stringList = Files.readAllLines(filePath, charset);
				lines = stringList.toArray(new String[]{});
			} catch(IOException ex) {
				System.out.println("Exception in test9: " + ex.getMessage());
				return;
			}
			List l1 = new LinkedList();
	
			for(int x = 0 ; x < lines.length - 1 ; x++) {
				String line = lines[x];
				String[] attr = line.split(", ");
				if(!attr[14].equals(">50K")) {
					continue;
				}
				Map m1 = new LinkedHashMap();
				m1.put("age", attr[0]);
				m1.put("education", attr[3]);
				m1.put("race", attr[8]);
				m1.put("gender", attr[9]);
				m1.put("nationality", attr[13]);
				
				l1.add(m1);
			}
			String jsonString = JSONValue.toJSONString(l1);
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter( new FileWriter( output));
				writer.write(jsonString);
				writer.close();
			} catch(Exception ex) {
				System.out.println("Exception in test9: " + ex.getMessage());
			}
			mem2 = memory_get_usage();
		}
		
		long end_time = System.nanoTime();
		float delta = (end_time - start_time)/1000.0f;
		mem3 = memory_get_usage();
		long delta_mem = mem3-mem1;
		System.out.println(delta + ";" + mem1 + ";" + mem2 + ";" + mem3 + ";" + delta_mem);				
	}
	

}

