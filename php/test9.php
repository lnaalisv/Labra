<?php
	/* PHP TEST 9 COMBINE TEST */
	if(count($argv)!=4) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$file = $argv[1];
	$test_times = $argv[2];
	$output = $argv[3];
	
	$delta_time_c = 0;
	
	$mem1 = memory_get_usage(true);
	$mem2 = 0;
	$before = microtime(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		test($file,$output);
	}
	$after = microtime(true);
	$delta_time = ($after-$before)*1000*1000;
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time;$mem1;$mem2;$mem3;$delta_mem\n";
	
	
	function test($file,$output) {
		global $mem2;
		$lines = file($file);
		$items = array();

		for($i = 0 ; $i < count($lines)-1; $i++) {
			$line = $lines[$i];

			$attrs = explode(", ",$line);
			$str = trim($attrs[14]);
			if($str != ">50K") {
				continue;
			}
			$nobj = array();
			$nobj["age"] = $attrs[0];
			$nobj["education"] = $attrs[3];
			$nobj["race"] = $attrs[8];
			$nobj["gender"] = $attrs[9];
			$nobj["nationality"] = $attrs[13];
			$items[] = $nobj;
			
		}

		$json_items = json_encode($items);
		$mem2 = memory_get_usage(true);
		file_put_contents($output,$json_items);
	}
?>