<?php
	/* PHP TEST 2 MATH: MATRIX MULTIPLICATION */
	if(count($argv)!=5) {
		exit("Not enough arguments for ".$argv[0]);
	}
	
	$test_times = $argv[1];
	$min_var = $argv[2];
	$max_var = $argv[3];
	$matrix_size = $argv[4];
	
	$mem3;
	$mem1 = memory_get_usage(true);
	$before = microtime(true);
	for($i = 0 ; $i < $test_times ; $i++) {
		// init test
		$m1 = get_matrix($matrix_size,$matrix_size,$min_var,$max_var);
		$m2 = get_matrix($matrix_size,$matrix_size,$min_var,$max_var);
		matrixmult($m1,$m2);
	}
	$after = microtime(true);
	$delta_time = ($after-$before)*1000*1000;
	$mem3 = memory_get_usage(true);
	$delta_mem = $mem3-$mem1;
	echo "$delta_time;$mem1;$mem2;$mem3;$delta_mem\n";
	
	function get_matrix($x,$y,$min_var,$max_var) {
		$m = array();
		for($i = 0 ; $i < $x ; $i++) {
			$xx = array();
			for($j = 0 ; $j < $y ; $j++) {
				$xx[] = rand($min_var,$max_var);
			}
			$m[] = $xx;
		}
		return $m;
	}

	function matrixmult($m1,$m2){
		global $mem2;
		$r=count($m1);
		$c=count($m2[0]);
		$p=count($m2);
		if(count($m1[0])!=$p){throw new Exception("Incompatible matrixes");}
		$m3=array();
		for ($i=0;$i< $r;$i++){
			for($j=0;$j<$c;$j++){
				$m3[$i][$j]=0;
				for($k=0;$k<$p;$k++){
					$m3[$i][$j]+=$m1[$i][$k]*$m2[$k][$j];
				}
			}
		}
		$mem2 = memory_get_usage(true);
		return($m3);
	}
?>