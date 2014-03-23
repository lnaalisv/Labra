<?php
	/* PHP TEST 3 STRING: FIND WORD */
	if(count($argv)!=4) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$file = $argv[1];
	$word = $argv[2];
	$test_times = $argv[3];
	
	$delta_time_c = 0;
	$delta_mem_c = 0;
	
	// read the file only once
	$lines = file($file);
	$mem1 = memory_get_usage(true);
	$mem2 = 0;
	for($i = 0 ; $i < $test_times ; $i++) {
		$before = microtime(true);
		
		find_word($lines,$word);
		
		$after = microtime(true);
		
		$delta_time = $after-$before;
		$delta_time_c += $delta_time;

		//echo "Test $i in $delta seconds where $before and $after\n";
	}
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time_c;$mem1;$mem2;$mem3;$delta_mem\n";
	
	function find_word($lines,$word) {
		global $mem2;
		$n = 0;
		for($i = 0 ;$i < count($lines); $i++) {
			if(strpos($lines[$i],$word) !== false) {
				//echo "$word found in line $i\n";
				$n++;
			}
		}
		if($n == 0) {
			//echo "$word not found!\n";
		}
		$mem2 = memory_get_usage(true);
	}
?>