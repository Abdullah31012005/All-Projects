.model small 
.stack 100h 


.data
msgO db 'Our Poject$'
msg1 db 'welcome to our dquiz game !'
msg2 db 'Rules: $'
msg3 db '*. For Every Correct answer you will get 1 point.$'
msg8 db 'You have successfully completed your quiz.$'
msg9 db 'Your Total obtained point is: $'
msg10 db 'Press 1 to Re-attempt quiz or to Exit.$'
msg11 db '                   *Thank you.! *$'
  
extra db 'press any key to return$'
again db 'press any key$'  
choice db 'Enter any choice', 10, 13 
             db '1. Admin Panal', 10, 13
             db '2. Student panal', 10, 13
             db 'Press any button to Exit', 10, 13,
             db 'Choice $'      



username db 'admin$'
password db 'admin$'

  
marks1 db ?
name1 db 30 dup(?)
id1 db 10 dup(?)     


marks2 db ?
name2 db 30 dup(?)
id2 db 10 dup(?)  

marks3 db ?
name3 db 30 dup(?)
id3 db 10 dup(?)  

marks4 db ?
name4 db 30 dup(?)
id4 db 10 dup(?)  

marks5 db ?
name5 db 30 dup(?)
id5 db 10 dup(?)  


sum db 0

masg db 'no record!$'

cycle db 0  
  
Q1 db '1. 2+3=?$'
QA1 db 'a) 5    b> 6   c) 7$'

Q2 db '2. 5+6=?$'
QA2 db 'a> 10   b> 11   c> 12$'

Q3 db '3. 15-12=?$' 
QA3 db 'a) 5    b> 1   c> 3$'

Q4 db '4.3*6=?$' 
QA4 db ' a) 10  b> 18   c) 12$'

Q5 db '5. 6/3=?$'
QA5 db 'a) 2    b> 1   c) 12$'

Q6 db '6.8-8=?$'
QA6 db 'a) -1   b> -2   c> 0$'

Q7 db '7. 3*12=?$'
QA7 db 'a> 33   b> 36   c> 38$'

Q8 db '8. 9*9=?$'
QA8 db 'a) 72   b> 91   c> 81$'

Q9 db '9. 11+13=?$'
QA9 db 'a) 24   b> 26   c> 19$' 

Q10 db '10. 56/8=?$'
QA10 db 'a) 7   b) 9    c> 6$'  

msg db 'your score is: $' 


msg12 db 'Please enter your Name: $'
msg13 db 'Please enter your ID: $'   

msg16 db 'wrong password or email!!! Please try again$' 


mesg db 'you have exceed the limit of entering students$' 

.code

main proc
    mov ax,@data 
    mov ds, ax
    call enter   ;Enter function for choices

    mov ah,4ch
    int 21h
    
main endp 

enter proc
mov ax,@data
mov ds,ax  

call nl

lea dx,choice
mov ah,9
int 21h

mov ah,1    ;get input from user for specific choice
int 21h

cmp al,'1'
je call authentication    ;if true then call authentication function

cmp al,'2'    
je arrow     ;if true then jump to arrow label
jne ender    ;if false then jump to ender label

arrow:
add cycle,1  ;add 1 to cycle variable
cmp cycle,6  ;cmp cycle to 6
je ednow     ;if true jump to ednow
cmp cycle,1  ;cmp value of cycle is 1
je call stu1 ;Student1 function call
cmp cycle,2  ;cmp value of cycle is 2
je call stu2 ;Student2 function call
cmp cycle,3  ;cmp value of cycle is 3
je call stu3 ;Student3 function call
cmp cycle,4  ;cmp value of cycle is 4
je call stu4 ;Student4 function call
cmp cycle,5  ;cmp value of cycle is 5
je call stu5 ;Student5 function call 

ednow:      ;ednow label
lea dx,mesg ;message: You have exceed the limit of entering students
mov ah,9
int 21h
jmp enter   ; jmp to enter function

ender:   ;ender label
lea dx,msg11 ;message: *Thank you.! *$
mov ah,9
int 21h

mov ah,4ch  ;PROGRAM HAS RETURNED CONTROL TO THE OPERATING SYSTEM
int 21h      
ret
enter endp

quiz proc
mov ax,@data 
mov ds, ax   
    mov sum,0
    call qu1  ;calling question1 function
    call qu2  ;calling question2 function
    call qu3  ;calling question3 function
    call qu4  ;calling question4 function
    call qu5  ;calling question5 function
    call qu6  ;calling question6 function
    call qu7  ;calling question7 function
    call qu8  ;calling question8 function
    call qu9  ;calling question9 function
    call qu10 ;calling question10 function 
    lea dx,msg ;your score is: 
    mov ah,9
    int 21h    
    mov dl,sum ;taking value from sum variable
    cmp dl,10  ;cmp value in dl = 10
    je chk    ; if true then jump to chk label
    jne nikal
    
    
    chk:
    mov ah,0    ;Moves 0 into the high byte of the AX register, clearing any previous value.
    mov al,dl   ;Moves the value in the DL register into the low byte of the AX register.
    aaa         ;Adjusts AX after addition, converting a binary-coded decimal (BCD) result to a packed BCD format.
    
    mov ch,ah   ;Moves the high byte of AX into the CH register.
    mov cl,al   ;Moves the low byte of AX into the CL register
    
    
    mov dl,ch   ; Moves the tens digit from CH into DL for printing.
    add dl,48   ;Adds 48 to DL to convert the digit to its ASCII character code
    mov ah,2    
    int 21h
    
    mov dl,cl   ;Moves the units digit from CL into DL for printing.
    add dl,48   ;Converts a digit in DL to its ASCII character code
    mov ah,2
    int 21h 
    ret
    
    nikal: 
    add dl,48   ;Converts a digit in DL to its ASCII character code
    mov ah,2
    int 21h
    ret         ;return
quiz endp   

teacher proc    
mov ax,@data   ;Loads the address of the data segment into the AX register.
mov ds,ax      ;Sets the DS register to point to the data segment, allowing access to variables and data stored there.

call nl        ;Calls a subroutine named nl, which is likely responsible for printing a newline character.

cmp cycle,0     ;Compares the value in the cycle variable to 0.
je exc          ;Jumps to the label exc if cycle is equal to 0.

cmp cycle,1
je scene1
                 ; ( Perform similar comparisons 
cmp cycle,2      ;   for cycle values 1 to 6, 
je scene1        ;   jumping to the label scene1
                 ;   if any of them match. )
cmp cycle,3
je scene1

cmp cycle,4
je scene1

cmp cycle,5
je scene1

cmp cycle,6
je scene1

jne call enter    ;Jumps to a subroutine named enter if cycle doesn't match any of the checked values (0 to 6).

scene1:

mov cx,30      ;Sets the CX register to 30, likely indicating a maximum name length of 30 characters.
lea si,name1   ;Loads the address of a variable or memory location named name1 into the SI register.
show11:        
mov dl,[si]    ;Fetches the character at the memory address pointed to by SI and stores it in DL.
cmp dl,0       ;Compares the character in DL to 0 (null terminator).
je mover1      ;Jumps to a label named mover1 if the character is 0, indicating the end of the name string.
mov ah,2
int 21h
inc si         ;Increments SI to point to the next character in the name string.
show111:       ;Jumps back to the show11: label to continue the loop.
loop show11

call nl        ;Calls a subroutine named nl, which is likely responsible for printing a newline character.
mov cx,10      ;Sets CX to 10, likely indicating a maximum ID length of 10 characters.
lea si,id1     ;Loads the address of a variable or memory location named id1 into SI.
show12:        
mov dl,[si]    
cmp dl,0       
je mover12     
mov ah,2       
int 21h        
inc si         ;Increments SI
show112:
loop show12

call nl

mov dl,marks1  ;Moves a value (presumably marks) from a variable or memory location named marks1 into DL. 
    mov ah,0   ;Moves 0 into the high byte of the AX register, clearing any previous value.
    mov al,dl  ;Moves the value in the DL register into the low byte of the AX register.
    aaa        ;Adjusts AX after addition, converting a binary-coded decimal (BCD) result to a packed BCD format.
    
    mov ch,ah  ;Moves the high byte of AX into the CH register.
    mov cl,al  ;Moves the low byte of AX into the CL register
    
    
    mov dl,ch  ;Moves the tens digit from CH into DL for printing.
    add dl,48  ;Adds 48 to DL to convert the digit to its ASCII character code
    mov ah,2
    int 21h
    
    mov dl,cl   ;Moves the units digit from CL into DL for printing.
    add dl,48   ;Adds 48 to DL to convert the digit to its ASCII character code
    mov ah,2
    int 21h
    cmp cycle,1 ;Compares the value in the cycle variable to 1.
    je ending    


call nl                                          


;;;;;;;;;;;;;;;;;;;;;  same comments for further scene's (scene2,scene3,scene4,scene5) ;;;;;;;;;;;;;;;;;;;



scene2:

mov cx,30      
lea si,name2   
show21:
mov dl,[si]
cmp dl,0
je mover21
mov ah,2
int 21h
inc si 
show211:
loop show21

call nl
mov cx,10
lea si,id2
show22:
mov dl,[si]
cmp dl,0
je mover22
mov ah,2
int 21h
inc si
show222:
loop show22

call nl

mov dl,marks2
    mov ah,0
    mov al,dl
    aaa   
    
    mov ch,ah
    mov cl,al
    
    
    mov dl,ch
    add dl,48
    mov ah,2
    int 21h
    
    mov dl,cl
    add dl,48
    mov ah,2
    int 21h
    
    cmp cycle,2
    je ending  
    
    call nl

scene3:

mov cx,30
lea si,name3
show31:
mov dl,[si]
cmp dl,0
je mover31
mov ah,2
int 21h
inc si 
show311:
loop show31

call nl
mov cx,10
lea si,id3
show32:
mov dl,[si]
cmp dl,0
je mover32
mov ah,2
int 21h
inc si 
show322:
loop show32

call nl

mov dl,marks3
    mov ah,0
    mov al,dl
    aaa   
    
    mov ch,ah
    mov cl,al
    
    
    mov dl,ch
    add dl,48
    mov ah,2
    int 21h
    
    mov dl,cl
    add dl,48
    mov ah,2
    int 21h
    
    cmp cycle,3
    je ending

     call nl   
        
scene4:

mov cx,30
lea si,name4
show41:
mov dl,[si]
cmp dl,0
je mover41
mov ah,2
int 21h
inc si 
show411:
loop show41

call nl
mov cx,10
lea si,id4
show42:
mov dl,[si]
cmp dl,0
je mover42
mov ah,2
int 21h
inc si
show422:
loop show42

call nl

mov dl,marks4
    mov ah,0
    mov al,dl
    aaa   
    
    mov ch,ah
    mov cl,al
    
    
    mov dl,ch
    add dl,48
    mov ah,2
    int 21h
    
    mov dl,cl
    add dl,48
    mov ah,2
    int 21h
    
    cmp cycle,4
    je ending

    call nl     
         
scene5:

mov cx,30
lea si,name5
show51:
mov dl,[si]
cmp dl,0
je mover51
mov ah,2
int 21h
inc si
show511:
loop show51

call nl
mov cx,10
lea si,id5
show52:
mov dl,[si]
cmp dl,0
je mover52
mov ah,2
int 21h
inc si
show522:
loop show52

call nl

mov dl,marks5
    mov ah,0
    mov al,dl
    aaa   
    
    mov ch,ah
    mov cl,al
    
    
    mov dl,ch
    add dl,48
    mov ah,2
    int 21h
    
    mov dl,cl
    add dl,48
    mov ah,2
    int 21h
    
    cmp cycle,5
    je ending
    
    call nl
    

mover1:       ;jumps to show111, likely related to displaying the first name.
mov cx,1
jmp show111

mover12:      ;jumps to show112, likely related to displaying the first ID.
mov cx,1
jmp show112  

mover21:
mov cx,1
jmp show211

mover22:
mov cx,1
jmp show222

mover31:
mov cx,1
jmp show311

mover32:
mov cx,1
jmp show322

mover41:
mov cx,1
jmp show411

mover42:
mov cx,1
jmp show422

mover51:
mov cx,1
jmp show511

mover52:
mov cx,1
jmp show522


ending:

call nl

lea dx,extra    ;Loads the address of a string or message named extra into the DX register.
mov ah,9
int 21h

call nl

mov ah,1
int 21h

cmp al,13       ;Compares the character in AL to ASCII code 13 (Enter key).
je call enter   ;Jumps to a subroutine named enter if the Enter key was pressed.
jne call enter  ;Jumps to the enter subroutine even if the Enter key was not pressed, ensuring it's always called.

exc:
lea dx,masg     ;Loads the address of a string or message named masg into DX.
mov ah,9
int 21h
call nl
call enter
    
teacher endp           



stu1 proc            ;Defines a procedure named stu1, which likely handles student-related actions.
mov ax,@data
mov ds,ax 
call nl 
call strt 
call detail1 
call quiz        
call nl
mov dl,sum           ;Moves a value (presumably the quiz score) from a variable named sum into DL.
mov marks1,dl        ;Stores the score in a variable named marks1.
mov dx,offset again  ;Loads the address of a string or message named again into DX.
mov ah,9
int 21h
call nl
mov ah,1
int 21h
call enter 
stu1 endp
 
                    ;;;  same procedure like stu1   ;;;
 
stu2 proc    
mov ax,@data
mov ds,ax 
call nl  
call strt 
call detail2
call quiz        
call nl    
mov dl,sum
mov marks2,dl
mov dx,offset again
mov ah,9
int 21h
call nl
mov ah,1
int 21h
call enter 
stu2 endp

                    ;;;  same procedure like stu1   ;;;
         
stu3 proc    
mov ax,@data
mov ds,ax 
call nl  
call strt 
call detail3         
call quiz 
call nl
mov dl,sum
mov marks3,dl        
mov dx,offset again
mov ah,9
int 21h
call nl
mov ah,1
int 21h
call enter
stu3 endp
  
                    ;;;  same procedure like stu1   ;;;
  
stu4 proc    
mov ax,@data
mov ds,ax
call nl  
call strt 
call detail4  
call quiz        
call nl
mov dl,sum
mov marks4,dl
mov dx,offset again
mov ah,9
int 21h
call nl
mov ah,1
int 21h
call enter
stu4 endp

                    ;;;  same procedure like stu1   ;;;

stu5 proc    
mov ax,@data
mov ds,ax 
call nl  
call strt 
call detail5
call quiz        
call nl
mov dl,sum
mov marks5,dl  
mov dx,offset again
mov ah,9
int 21h
call nl
mov ah,1
int 21h
call enter 
stu5 endp



detail1 proc           ;Defines a procedure named detail1, likely for handling student details.
        lea dx,msg12   ;Loads the address of a prompt message (probably asking for a name) into DX.
        mov ah,9
        int 21h    
        call nl
        lea si,name1   ;Loads the address of a memory location named name1 into SI.
        cmp [si],0     
        jne check1
    lp1:
        mov ah,1
        int 21h
        cmp al,13
        je se1
        mov [si],al    ;Stores the character in the memory location pointed to by SI (likely part of name1).
        inc si 
        jnz lp1
    
    ar1: 
        call nl    
        lea dx,msg13   ;loads the address of the prompt message into dx
        mov ah,9
        int 21h    
        call nl       
        lea si,id1     ;loads the address of the memory loaction named id1 into si.
        cmp [si],0     ;comparing
        jne check2
    lp2:
        mov ah,1
        int 21h
        cmp al,13
        je se2 
        mov [si],al
        inc si
        jnz lp2
    
    ar2:
    call nl    
    ret
    
    se1:
        mov dl,32 
        mov [si],dl
        inc si
        jmp ar1    
        
    se2:
        mov dl,32 
        mov [si],dl
        inc si
        jmp ar2
    
    check1:
        inc si
        cmp [si],32
        je lp1
        jne check1 
    
    check2:
        inc si
        cmp [si],32
        je lp2
        jne check2 
        ret
detail1 endp
             
                     ;;;; same procedure like detail1  ;;;;
                     
detail2 proc     
    lea dx,msg12
    mov ah,9
    int 21h
    
    call nl  
    
    lea si,name2
        cmp [si],0
        jne chk1
    lop1:
        mov ah,1
        int 21h
        cmp al,13
        je sp1
        mov [si],al
        inc si 
    jnz lop1
    
    aft1: 
    call nl 
    
    lea dx,msg13
    mov ah,9
    int 21h
    
    call nl       
    lea si,id2
        cmp [si],0 
        jne chk2
    lop2:
        mov ah,1
        int 21h
        cmp al,13
        je sp2 
        mov [si],al
        inc si
    jnz lop2
    aft2:
    call nl
            
    ret
    sp1:
        mov dl,32 
        mov [si],dl
        inc si
    jmp aft1    
        
    sp2:
        mov dl,32 
        mov [si],dl
        inc si
    jmp aft2
    
    chk1:
        
        inc si
        cmp [si],32
    je lop1
    jne chk1 
    
    chk2:
        inc si

        cmp [si],32
    je lop2
    jne chk2 
    ret
detail2 endp

                        ;;;;  same procedure like detail1   ;;;;
                        
detail3 proc     
    lea dx,msg12
    mov ah,9
    int 21h
    
    call nl  
    
    lea si,name3
        cmp [si],0
        jne ck1
    l1:
        mov ah,1
        int 21h
        cmp al,13
        je s1
        mov [si],al
        inc si 
    jnz l1
    
    a1: 
    call nl 
    
    lea dx,msg13
    mov ah,9
    int 21h
    
    call nl       
    lea si,id3
        cmp [si],0 
        jne ck2
    l2:
        mov ah,1
        int 21h
        cmp al,13
        je s2 
        mov [si],al
        inc si
    jnz l2
    a2:
    call nl
            
    ret
    s1:
        mov dl,32 
        mov [si],dl
        inc si
    jmp a1    
        
    s2:
        mov dl,32 
        mov [si],dl
        inc si
    jmp a2
    
    ck1:
        
        inc si
        cmp [si],32
    je l1
    jne ck1 
    
    ck2:
        inc si

        cmp [si],32
    je l2
    jne ck2 
    ret
detail3 endp
                           
                           ;;;;    same procedure like detail1   ;;;;
                           
detail4 proc     
    lea dx,msg12
    mov ah,9
    int 21h
    
    call nl  
    
    lea si,name4
        cmp [si],0
        jne chek1
    lo1:
        mov ah,1
        int 21h
        cmp al,13
        je spe1
        mov [si],al
        inc si 
    jnz lo1
    
    at1: 
    call nl 
    
    lea dx,msg13
    mov ah,9
    int 21h
    
    call nl       
    lea si,id4
        cmp [si],0 
        jne chek2
    lo2:
        mov ah,1
        int 21h
        cmp al,13
        je spe2 
        mov [si],al
        inc si
    jnz lo2
    at2:
    call nl
            
    ret
    spe1:
        mov dl,32 
        mov [si],dl
        inc si
    jmp at1    
        
    spe2:
        mov dl,32 
        mov [si],dl
        inc si
    jmp at2
    
    chek1:
        
        inc si
        cmp [si],32
    je lo1
    jne chek1 
    
    chek2:
        inc si

        cmp [si],32
    je lo2
    jne chek2 
    ret
detail4 endp
                         
                       ;;;;    same procedure like detail1  ;;;;  
                         
detail5 proc     
    lea dx,msg12
    mov ah,9
    int 21h
    
    call nl  
    
    lea si,name5
        cmp [si],0
        jne chik1
    pl1:
        mov ah,1
        int 21h
        cmp al,13
        je sc1
        mov [si],al
        inc si 
    jnz pl1
    
    ae1: 
    call nl 
    
    lea dx,msg13
    mov ah,9
    int 21h
    
    call nl       
    lea si,id5
        cmp [si],0 
        jne chik2
    pl2:
        mov ah,1
        int 21h
        cmp al,13
        je sc2 
        mov [si],al
        inc si
    jnz pl2
    ae2:
    call nl
            
    ret
    sc1:
        mov dl,32 
        mov [si],dl
        inc si
    jmp ae1    
        
    sc2:
        mov dl,32 
        mov [si],dl
        inc si
    jmp ae2
    
    chik1:
        
        inc si
        cmp [si],32
    je pl1
    jne chik1 
    
    chik2:
        inc si

        cmp [si],32
    je pl2
    jne chik2 
    ret
detail5 endp

       
strt proc
    mov ax,@data
    mov ds,ax
    lea dx,msgO
    mov ah,9
    int 21h
    
    call nl
    
    lea dx,msg1
    mov ah,9
    int 21h
    
    call nl
    
    lea dx,msg2
    mov ah,9
    int 21h
    
    call nl
    
    lea dx,msg3
    mov ah,9
    int 21h
    
    call nl
    
    call nl
    ret
strt endp 
                   
;;;;  procedure for Questions and Answers calling and excecution  ;;;;
                   
qu1 proc               
mov ax,@data
mov ds,ax
lea dx,Q1
mov ah,9
int 21h
    
call nl

lea dx,QA1
mov ah,9 
int 21h 

call nl

mov ah,1
int 21h 
      
mov ah,0      
push ax

call nl
       
pop ax       
       
mov bl,'a'
cmp al,bl

jne et
add sum,1
ret
et:
ret   
qu1 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu2 proc
mov ax,@data
mov ds,ax
lea dx,Q2
mov ah,9
int 21h
    
call nl

lea dx,QA2
mov ah,9 
int 21h 

call nl

mov ah,1
int 21h 

mov ah,0
push ax

call nl
       
pop ax       
       
mov bl,'b'
cmp al,bl
jne exit
add sum,1
ret 
exit:
ret   
qu2 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu3 proc
mov ax,@data
mov ds,ax
lea dx,Q3
mov ah,9
int 21h
    
call nl

lea dx,QA3
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h 

mov ah,0
push ax 

call nl

pop ax

mov bl,'c'
cmp al,bl
jne ex
add sum,1
ret 
ex:
ret   
qu3 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu4 proc
mov ax,@data
mov ds,ax
lea dx,Q4
mov ah,9
int 21h
    
call nl

lea dx,QA4
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h
       
mov ah,0
push ax

call nl       
       
pop ax       
       
mov bl,'b'
cmp al,bl
jne end
add sum,1
ret 
end:
ret   
qu4 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu5 proc
mov ax,@data
mov ds,ax
lea dx,Q5
mov ah,9
int 21h
    
call nl

lea dx,QA5
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'a'
cmp al,bl
jne ou
add sum,1
ret 
ou:
ret   
qu5 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu6 proc
mov ax,@data
mov ds,ax
lea dx,Q6
mov ah,9
int 21h
    
call nl

lea dx,QA6
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'c'
cmp al,bl
jne o
add sum,1
ret 
o:
ret   
qu6 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu7 proc
mov ax,@data
mov ds,ax
lea dx,Q7
mov ah,9
int 21h
    
call nl

lea dx,QA7
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'b'
cmp al,bl
jne u
add sum,1
ret 
u:
ret   
qu7 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu8 proc
mov ax,@data
mov ds,ax
lea dx,Q8
mov ah,9
int 21h
    
call nl

lea dx,QA8
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'c'
cmp al,bl
jne ot
add sum,1
ret 
ot:
ret   
qu8 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu9 proc
mov ax,@data
mov ds,ax
lea dx,Q9
mov ah,9
int 21h
    
call nl

lea dx,QA9
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'a'
cmp al,bl
jne ut
add sum,1
ret 
ut:
ret   
qu9 endp

;;;;  procedure for Questions and Answers calling and excecution  ;;;;

qu10 proc
mov ax,@data
mov ds,ax
lea dx,Q10
mov ah,9
int 21h
    
call nl

lea dx,QA10
mov ah,9 
int 21h
       
call nl       
       
mov ah,1
int 21h

mov ah,0
push ax       
       
call nl

pop ax

mov bl,'a'
cmp al,bl
jne outt
add sum,1 
ret 
outt:
ret   
qu10 endp


nl proc              ;; newline function
    mov dx,10
    mov ah,2
    int 21h
    mov dx,13
    mov ah,2
    int 21h
    ret
nl endp 


authentication proc       ;; authentication process for admin panel  ;;
call nl 
    mov bh,0      
    lea si,username
    mov cx,5 
    mov bl,0
    naam:
        mov ah,1
        int 21h
        
        cmp al,[si]
        je right1  
        jne mistake1
        m1:
        inc si
    loop naam 
    loopout1:
    call nl   
    lea si,password       
    mov cx,5
    pass:
        mov ah,1
        int 21h
        
        cmp al,[si]
        je right2 
        
        jne mistake2 
        
        m2:
        inc si
    loop pass
    
    cmp bl,10
    je call teacher
    
    cmp bh,0
    jne wrong
    
    mistake1: 
    inc bh
    jmp m1  
     
    right1:
    inc bl
    jmp m1
    
    right2:          
    inc bl
    jmp m2    
    
    mistake2: 
    inc bh
    jmp m2
    
    wrong:  
    
    call nl
    
    lea dx,msg16
    mov ah,9
    int 21h
      
    call enter                                          
                 
authentication endp 

end main