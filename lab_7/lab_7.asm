.globl makes10 intMax close10 dateFashion
.text

# Jarod Collier and Josef Hartsough

true: 
	add $v0, $0, 1
	jr $ra
false: 
	add $v0, $0, 0
	jr $ra
	
param_1:
	add $v0, $0, $a0
	jr $ra

param_2:
	add $v0, $0, $a1
	jr $ra

param_3:
	add $v0, $0, $a2
	jr $ra
	 
makes10:
	beq $a0, 10, true
	beq $a1, 10, true
	add $t0, $a0, $a1
	beq $t0, 10, true
	j false
	jr $ra

intMax:
	sgt $t0, $a0, $a1
	sgt $t1, $a0, $a2
	and $t2, $t0, $t1
	beq $t2, 1, param_1
	
	sgt $t0, $a1, $a0
	sgt $t1, $a1, $a2
	and $t2, $t0, $t1
	beq $t2, 1, param_2
	
	sgt $t0, $a2, $a0
	sgt $t1, $a2, $a1
	and $t2, $t0, $t1
	beq $t2, 1, param_3
	
	jr $ra

close10:
	subi $t0, $a0, 10 	# $t0 is difference of first param
	abs $t1, $t0 		# $t1 is absolute value of the difference
	subi $t2, $a1, 10	# $t2 is difference of second param
	abs $t3, $t2		# $t3 is the absolute value of the difference
	
	blt $t1, $t3, param_1
	blt $t3, $t1, param_2
	j false	
	
	jr $ra

return_2:
	add $v0, $0, 2
	jr $ra

dateFashion:

	sle $t0, $a0, 2		# you is less than or equal to 2
	sle $t1, $a1, 2		# date is less than or equal to 2
	or $t2, $t0, $t1
	beq $t2, 1, false
	
	sge $t3, $a0, 8		# you are greater than or equal to 8
	sge $t4, $a1, 8		# date is greater than or equal to 8
	or $t5, $t3, $t4
	beq $t5, 1, return_2
	
	j true	
		
	jr $ra
