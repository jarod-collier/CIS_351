.text
.globl main 

main:
	addi $a0, $0, 3
	addi $a1, $0, 7
	addi $a2, $0, 2
	jal WackySum
	addi $a0, $v0, 0			# put the total in $a0
	addi $v0, $0, 1				# print integer signal
	syscall
	
	addi $v0, $0, 10			# exit signal
	syscall

WackySum:
	addi $s0, $0, 0 			# sum 
	addi $s1, $a0, 0 			# index
	addi $sp, $sp, -12			# create space for 3 variables on the stack
	sw $ra, 8($sp)				# store where we came from in main
	sw $a1, 4($sp)				# save b
	sw $a2, 0($sp)				# save c

loop:
	bgt $s1, $a1, out_loop
	addi $a0, $s1, 0 			# new a
	addi $a1, $s1, 1
	sra $a1, $a1, 1				# new b
	addi $a2, $s1, 2
	sra $a2, $a2, 1				# new c
	addi $a3, $s1, 3			# new d
	jal CombineFour
	add $s0, $s0, $v0			# sum +=
	lw $a1, 4($sp)				# get old b for loop
	lw $a2, 0($sp)				# get old c for loop
	add $s1, $s1, $a2			# i += c
	j loop

CombineFour:
	add $t1, $a0, $a1 			# sum = a + b
	add $t1, $t1, $a2			# sum += c
	add $t1, $t1, $a3			# sum += d
	andi $t2, $t1, 1			# LSB of result to check for even or odd
	beq $t2, 1, else
	addi $v0, $t1, 0 			# return sum
	jr $ra

else:
	sra $t1, $t1, 1 			# sum / 2
	add $v0, $t1, 0
	jr $ra
	
out_loop:
	addi $v0, $s0, 0 			# return sum
	lw $ra, 8($sp)				# get address of main
	addi $sp, $sp, 12 			# deallocate stack
	jr $ra
