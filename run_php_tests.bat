php -f "php/test1.php" -- 100 100 1000 1000 >> output/php_test_1.txt
php -f "php/test2.php" -- 100 100 1000 50 >> output/php_test_2.txt
php -f "php/test3.php" -- "data/book1.txt" almost 100 >> output/php_test_3.txt
php -f "php/test4.php" -- "data/json.txt" 100 >> output/php_test_4.txt
php -f "php/test5.php" -- "data/aalto_ericsson_visit" 1 >> output/php_test_5.txt
php -f "php/test6.php" -- "data/aalto_ericsson_visit" output2/phpfileoutput 1 >> output/php_test_6.txt
php -f "php/test7.php" -- 100 100 1000 100 >> output/php_test_7.txt
php -f "php/test8.php" -- 500 100 1000 1000 >> output/php_test_8.txt
php -f "php/test9.php" -- "data/adult_small.csv" 100 output2/php_output9.txt >> output/php_test_9.txt
php -f "php/test9.php" -- "data/adult.csv" 10 output2/php_output10.txt >> output/php_test_10.txt