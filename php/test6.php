<?php
	/* PHP TEST 6 IO: FILE WRITE */
	if(count($argv)!=4) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$file = $argv[1];
	$output = $argv[2];
	$test_times = $argv[3];
	
	$data = file_get_contents($file);
	
	$delta_time_c = 0;
	$delta_mem_c = 0;
	$mem1 = memory_get_usage(true);
	$before = microtime(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		
		// write the file
		file_put_contents($output,$data);
	
		$mem2 = memory_get_usage(true);
	}
	$after = microtime(true);
	$delta_time = ($after-$before)*1000*1000;
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time;$mem1;$mem2;$mem3;$delta_mem\n";
?>