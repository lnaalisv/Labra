<?php
	/* PHP TEST 5 IO: FILE READ */
	if(count($argv)!=3) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$file = $argv[1];
	$test_times = $argv[2];
	
	$delta_time_c = 0;
	$delta_mem_c = 0;
	$mem1 = memory_get_usage(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		$before = microtime(true);

		// read the file only once
		$data = file_get_contents($file);
	
		$after = microtime(true);
		$mem2 = memory_get_usage(true);
		
		$delta_time = $after-$before;
		$delta_time_c += $delta_time;

		//echo "Test $i in $delta seconds where $before and $after\n";
	}
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time_c;$mem1;$mem2;$mem3;$delta_mem\n";
?>