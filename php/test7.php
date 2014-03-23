<?php
	/* PHP TEST 7 DYNAMIC DATA STRUCTURES: ARRAYS */
	if(count($argv)!=5) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$test_times = $argv[1];
	$min_var = $argv[2];
	$max_var = $argv[3];
	$array_size = $argv[4];
	
	$delta_time_c = 0;

	$mem1 = memory_get_usage(true);
	$mem2 = 0;
	
	for($i = 0 ; $i < $test_times ; $i++) {
		$before = microtime(true);
		
		test($array_size,$min_var,$max_var);
	
		$after = microtime(true);
		
		$delta_time = $after-$before;
		$delta_time_c += $delta_time;
		//echo "Test $i in $delta seconds where $before and $after\n";
	}
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	
	echo "$delta_time_c;$mem1;$mem2;$mem3;$delta_mem\n";
	
	
	function test($array_size,$min_var,$max_var) {
		global $mem2;
		// create the array
		$a = array();
		for($i = 0 ; $i < $array_size ; $i++) {
			$aa = array();
			for($j = 0 ; $j < $array_size ; $j++) {
				$aa[] = rand($min_var,$max_var);
			}
			$a[] = $aa;
		}
		$mem2 = memory_get_usage(true);
		$search_for = rand($min_var,$max_var);
		for($x = 0 ; $x < count($a) ; $x++) {
			$row = $a[$x];
			for($y = 0 ; $y < count($row) ; $y++) {
				if($row[$y] == $search_for) {
				
				}
			}
		}
		
	}
?>