using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.IO;
using Newtonsoft.Json;
using System.Collections;

namespace LabraCS
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length < 2)
            {
                Console.WriteLine("Invalid number of arguments");
            }
            switch (args[0])
            {
                case "test1":
                    test1(args);
                    break;
                case "test2":
                    test2(args);
                    break;
                case "test3":
                    test3(args);
                    break;
                case "test4":
                    test4(args);
                    break;
                case "test5":
                    test5(args);
                    break;
                case "test6":
                    test6(args);
                    break;
                case "test7":
                    test7(args);
                    break;
                case "test8":
                    test8(args);
                    break;
                case "test9":
                    test9(args);
                    break;
                default:
                    Console.WriteLine("Unknown test " +args[0]);
                    break;
            }
        }

        public static long memory_get_usage()
        {
            Process currentProcess = System.Diagnostics.Process.GetCurrentProcess();
            return currentProcess.WorkingSet64;
        }

        public static int[,] get_matrix(int width, int height, int min_var, int max_var,Random rand) {
            int[,] matrix = new int[width, height];
            for(int x = 0 ; x < width ; x++) {
                for(int y = 0 ; y < height ; y++) {
                 matrix[x,y] = rand.Next(min_var,max_var);
                }
            }
            return matrix;
        }
	    public static int[,] matrixmult(int[,] m1, int[,] m2) {
            int r = m1.GetLength(0);
            int c = m2.GetLength(1);
            int p = m2.GetLength(0);
		    int[,] m3 = new int[r,c];
		    for(int i = 0 ; i < r ; i++) {
			    for(int j = 0 ; j < c ; j++) {
				    m3[i,j] = 0;
				    for(int k = 0 ; k < p ; k++) {
					    m3[i,j] += m1[i,k]*m2[k,j];
				    }
			    }
		    }
		    return m3;
	    }
        
        public static void test1(string[] args)
        {
            if (args.Length != 5)
            {
                Console.WriteLine("Invalid number of arguments for test1");
                return;
            }
            int test_times = Convert.ToInt32(args[1]);
            int min_var = Convert.ToInt32(args[2]);
            int max_var = Convert.ToInt32(args[3]);
            int test_size = Convert.ToInt32(args[4]);

            Random rand = new Random();
            int a = rand.Next(min_var,max_var);
            int b = rand.Next(min_var,max_var);
            int c = rand.Next(min_var,max_var);
            int d = rand.Next(min_var,max_var);
            int e = rand.Next(min_var,max_var);
            int f = rand.Next(min_var,max_var);
            int g = rand.Next(min_var,max_var);
            int h = rand.Next(min_var,max_var);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for(int i = 0 ; i < test_times ; i++) {
                float result = 0;
                for (int j = 0; j < test_size; j++)
                {
                    result += (a * b ^ 3) / c * (d - e ^ j) - f + (g / h);
                }
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test2(string[] args)
        {
            if (args.Length != 5)
            {
                Console.WriteLine("Invalid number of arguments for test2");
                return;
            }
            int test_times = Convert.ToInt32(args[1]);
            int min_var = Convert.ToInt32(args[2]);
            int max_var = Convert.ToInt32(args[3]);
            int matrix_size = Convert.ToInt32(args[4]);

            Random rand = new Random();
            //int a = rand.Next(min_var, max_var);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                int[,] m1 = get_matrix(matrix_size, matrix_size, min_var, max_var, rand);
                int[,] m2 = get_matrix(matrix_size, matrix_size, min_var, max_var, rand);
                matrixmult(m1,m2);
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test3(string[] args)
        {
            if (args.Length != 4)
            {
                Console.WriteLine("Invalid number of arguments for test3");
                return;
            }

            String file = args[1];
            String word = args[2];
            int test_times = Convert.ToInt32(args[3]);

            Random rand = new Random();
            //int a = rand.Next(min_var, max_var);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            String[] lines = File.ReadAllLines(file);
            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                for (int k = 0; k < lines.Length; k++ )
                {
                    String line = lines[k];
                    if (line.Contains(word))
                    {
                        //Console.WriteLine("Sana " + word + " esiintyy rivillä " + k);
                    }
                }
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test4(string[] args)
        {
            if (args.Length != 3)
            {
                Console.WriteLine("Invalid number of arguments for test4");
                return;
            }

            String file = args[1];
            int test_times = Convert.ToInt32(args[2]);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            String lines = File.ReadAllText(file);
            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                object json = JsonConvert.DeserializeObject(lines);
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test5(string[] args)
        {
            if (args.Length != 3)
            {
                Console.WriteLine("Invalid number of arguments for test5");
                return;
            }

            String file = args[1];
            int test_times = Convert.ToInt32(args[2]);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                byte[] bytes = File.ReadAllBytes(file);
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test6(string[] args)
        {
            if (args.Length != 4)
            {
                Console.WriteLine("Invalid number of arguments for test6");
                return;
            }

            String file = args[1];
            String output = args[2];
            int test_times = Convert.ToInt32(args[3]);

            long mem1 = memory_get_usage();
            long mem2 = 0;

            byte[] bytes = File.ReadAllBytes(file);

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                File.WriteAllBytes(output, bytes);
                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test7(string[] args)
        {
            if (args.Length != 5)
            {
                Console.WriteLine("Invalid number of arguments for test7");
                return;
            }

            int test_times = Convert.ToInt32(args[1]);
            int min_var = Convert.ToInt32(args[2]);
            int max_var = Convert.ToInt32(args[3]);
            int array_size = Convert.ToInt32(args[4]);

            Random rand = new Random();
            long mem1 = memory_get_usage();
            long mem2 = 0;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                ArrayList list = new ArrayList();
                for (int x = 0; x < array_size; x++ )
                {
                    ArrayList yy = new ArrayList();
                    for (int y = 0; y < array_size; y++ )
                    {
                        yy.Add(rand.Next(min_var,max_var));
                    }
                    list.Add(yy);
                }
                int search_for = rand.Next(min_var, max_var);
                foreach(ArrayList listitem in list) {
                    if (listitem.IndexOf(search_for) != -1)
                    {
                        //Console.WriteLine(search_for + " found ! ");
                    }
                }

                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test8(string[] args)
        {
            if (args.Length != 5)
            {
                Console.WriteLine("Invalid number of arguments for test7");
                return;
            }

            int test_times = Convert.ToInt32(args[1]);
            int min_var = Convert.ToInt32(args[2]);
            int max_var = Convert.ToInt32(args[3]);
            int list_size = Convert.ToInt32(args[4]);

            Random rand = new Random();
            long mem1 = memory_get_usage();
            long mem2 = 0;

            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < test_times; i++)
            {
                LinkedList<int> list = new LinkedList<int>();
                for (int x = 0; x < list_size; x++)
                {
                    list.AddLast(rand.Next(min_var, max_var));
                }

                int search_for = rand.Next(min_var, max_var);
                if (list.Find(search_for) != null)
                {

                }

                mem2 = memory_get_usage();
            }

            sw.Stop();
            double delta = sw.Elapsed.TotalMilliseconds * 1000;
            long mem3 = memory_get_usage();
            Console.WriteLine(delta + ";" + mem1 + ";" + mem2 + ";" + mem3);
        }

        public static void test9(string[] args)
        {

        }
    }
}
