<?php
	/* PHP TEST 8 DYNAMIC DATA STRUCTURES: LINKED LISTS */
	if(count($argv)!=5) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$test_times = $argv[1];
	$min_var = $argv[2];
	$max_var = $argv[3];
	$list_size = $argv[4];
	
	$delta_time_c = 0;
	
	$mem1 = memory_get_usage(true);
	$mem2 = 0;
	$before = microtime(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		test($list_size,$min_var,$max_var);
	}
	$after = microtime(true);
	$delta_time = ($after-$before)*1000*1000;
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time;$mem1;$mem2;$mem3;$delta_mem\n";
	
	
	function test($list_size,$min_var,$max_var) {
		global $mem2;
		$list = new SplDoublyLinkedList();
		
		for($i = 0 ; $i  < $list_size ; $i++) {
			$list->push(rand($min_var,$max_var));
		}
		
		$list->setIteratorMode(SplDoublyLinkedList::IT_MODE_FIFO);
		$mem2 = memory_get_usage(true);
		$search_for = rand($min_var,$max_var);
		
		for ($list->rewind(); $list->valid(); $list->next()) {
			if($list->current() == $search_for) {
				//echo "$search_for found\n";
			}
		}
		
	}
?>