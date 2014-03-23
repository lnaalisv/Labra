<?php
	/* PHP TEST 1 MATH: SIMPLE*/
	if(count($argv)!=5) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$test_times = $argv[1];
	$min_var = $argv[2];
	$max_var = $argv[3];
	$test_size = $argv[4];
	
	$delta_time_c = 0;
	
	$mem1 = memory_get_usage(true);
	$mem2 = 0;
	
	// init test
	$a = rand($min_var,$max_var);
	$b = rand($min_var,$max_var);
	$c = rand($min_var,$max_var);
	$d = rand($min_var,$max_var);
	$e = rand($min_var,$max_var);
	$f = rand($min_var,$max_var);
	$g = rand($min_var,$max_var);
	$h = rand($min_var,$max_var);
	
	$before = microtime(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		test($test_size,$a,$b,$c,$d,$e,$f,$g,$h);
	}
	$after = microtime(true);
	$delta_time = ($after-$before)*1000*1000;
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time;$mem1;$mem2;$mem3;$delta_mem\n";
	
	function test($test_size,$a,$b,$c,$d,$e,$f,$g,$h) {
		global $mem2;
		$result = 0;
		for($i = 0 ; $i < $test_size ; $i++) {
			$result += ($a*$b^3)/$c*($d-$e^$i)-$f+($g/$h);
		}
		$mem2 = memory_get_usage(true);
		return $result;
	}
?>