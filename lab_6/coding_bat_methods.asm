.globl monkeyTrouble sleepIn posNeg
.text

monkeyTrouble: 
	xor $t0, $a0, $a1
	not $t0, $t0
	andi $v0, $t0, 1
	jr $ra
sleepIn:
	not $a0, $a0
	andi $t0, $a0, 1
	or $v0, $t0, $a1
	jr $ra
	
posNeg:
	not $t7, $a2
	andi $t0, $t7, 1	# negates negative stored in t0
	slti $t1, $a0, 0	# checks if a is neg
	slti $t2, $a1, 0	# checks if b is neg
	xor $t3, $t1, $t2	# checks if a and b are different
	and $t4, $t0, $t3	# first two conditions t4
	
	and $t5, $t1, $t2 	# check if both inputs are neg
	and $t6, $t5, $a2	# checks the third condition
	
	or $v0, $t4, $t6
	jr $ra