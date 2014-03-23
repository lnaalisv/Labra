using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

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

        public static void test1(string[] args)
        {
            if (args.Length != 5)
            {
                Console.WriteLine("Invalid number of arguments for test1");
            }
            int test_times =;
            int min_var = ;
            int max_var = ;
        }

        public static void test2(string[] args)
        {

        }

        public static void test3(string[] args)
        {

        }

        public static void test4(string[] args)
        {

        }

        public static void test5(string[] args)
        {

        }

        public static void test6(string[] args)
        {

        }

        public static void test7(string[] args)
        {

        }

        public static void test8(string[] args)
        {

        }

        public static void test9(string[] args)
        {

        }
    }
}
