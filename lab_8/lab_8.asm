.globl indexOf, max, sum13, sum67
.text

# @author: Jarod Collier and Josef Hartsough

done:
	add $v0, $0, $s7	#load needed value to return register
	jr $ra

########################################################

indexOf:

	addi $t0, $0, 0             #load index = 0

startOfIndexOf:
	lw $t2, 0($a1)
	blt $t2, 0, valNotFound    #end of array
	beq $a0, $t2, valFound     #if value is found
	addi $t0, $t0, 1           #increment by 1
	addi $a1, $a1, 4
	j startOfIndexOf           #next element in array

valNotFound:
	addi $v0,$0, -1
	jr $ra

valFound:
	add $v0, $t0, $0
	jr $ra


########################################################
max:

	addi $s0, $0, 0		#loop counter
	add $t1, $0, $a1	#size of the array
	addi $s7, $0, 0		#largest value in the array

maxloop:
	slt $t0, $s0, $t1	#check for loop bound
	beq $t0, $0, done	#if done looping go to "done"
	sll $t0, $s0, 2		#
	add $t0, $t0, $a0	#get the array position corresponding to loop counter
	lw $t2, 0($t0)		#lw the array position to a register

	sgt $t3, $t2, $s7	#check if current array position is greater than s7
	beq $t3, 0, skip	#if its less than the current largest value, skip
	add $s7, $0, $t2	#if greater, set the largest value to current array position

skip:
	addi $s0, $s0, 1	#increament loop counter
	j maxloop



########################################################

sum13:
	add $s7, $0, 0		#total sum
	addi $s0, $0, 0		#loop counter
	add $t1, $0, $a1	#size of the array

sum13loop:
	slt $t2, $s0, $t1 	#check for loop bound
	beq $t2, $0, done	#if done looping go to "done"
	sll $t2, $s0, 2		#
	add $t2, $t2, $a0	#get the array position corresponding to loop counter
	lw $t3, 0($t2)		#lw the array position to a register

	bne $t3, 13, notEqual13	#check if array value != 13
	addi $s0, $s0, 1	#since array value = 13, increment 1 to skip the next number
	j loop13again


notEqual13:
	add $s7, $s7, $t3
	j loop13again

loop13again:
	addi $s0, $s0, 1	#increament loop counter
	j sum13loop


########################################################
sum67:

	add $s7, $0, 0		#total sum
	addi $t0, $0, 0		#skip adding flag
	addi $s0, $0, 0		#loop counter
	add $t1, $0, $a1	#size of the array

sum67loop:
	slt $t2, $s0, $t1 	#check for loop bound
	beq $t2, $0, done	#if done looping go to "done"
	sll $t2, $s0, 2		#
	add $t2, $t2, $a0	#get the array position corresponding to loop counter
	lw $t3, 0($t2)		#lw the array position to a register

	#first if statement
	seq $s1, $t0, 1		#if we encountered 6 already
	beq $s1, 1, nextif
	sne $t5, $t3, 6		#check if current value is not 6
	beq $t5, 0, nextif
	add $s7, $s7, $t3	#add to the sum
	j loop67again

	#second if
nextif:
	seq  $s1, $t0, 1	#if we encountered 6 already
	beq $s1, 0, else
	seq $t5, $t3, 7		#check if current value is 7
	beq $t5, 0, else
	addi $t0, $0, 0		#set the flag to false
	j loop67again

	#last case
else:
	seq $t5, $t3, 6		#check if current value is 6
	beq $t5, 0, loop67again
	addi $t0, $0, 1		#set the flag to true

loop67again:
	addi $s0, $s0, 1	#increament loop counter
	j sum67loop
