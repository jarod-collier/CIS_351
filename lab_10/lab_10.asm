.globl nCk

	# Jarod Collier and Josef Hartsough

nCk:
	blt $a0, $0, minusOne # if first parameter is less than 0 return -1
	blt $a1, $0, minusOne # if secobd parameter is less than 0 return -1
	blt $a0, $a1, minusOne # if n is less than k
	beq $a1, $0, one # n choose 0 = 1
	beq $a1, 1, n # n choose 1 = n
	beq $a0, $a1, one # n chose n = 1

	addi $sp, $sp, -12 # clearing space on the stack
	sw $ra, 8($sp)	   # saving current return address in the stack so we can come back
	sw $s1, 4($sp)	   # saving n and k on the stack
	sw $s0, 0($sp)

	# (n-1 choose k)
	addi $a0, $a0, -1  # decrementing n
	add $s0, $a0, $0   # putting decremented n in s0
	add $s1, $a1, $0   # putting k in s1
	jal nCk		   # recurse

	# (n-1 choose k-1)
	add $a0, $s0, $0   # put already decremented into params
	add $s0, $v0, $0   # put return from (n-1 choose k) into s0
	addi $a1, $s1, -1  # decrement k
	jal nCk

	add $v0, $s0, $v0  # put (n-1 choose k) + (n-1 choose k-1) into v0

	lw $s0, 0($sp)     # reload values from stack including return address
	lw $s1, 4($sp)
	lw $ra, 8($sp)
	addi $sp, $sp, 12  # deallocate space on the stack
	jr $ra

n:	# return n
	add $v0, $0, $a0
	jr $ra

one:	# return 1
	addi $v0, $zero 1
	jr $ra

minusOne:	# return -1
	addi $v0, $zero -1
	jr $ra
