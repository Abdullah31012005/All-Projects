org 100h

.model small 
.stack 100h 


.data
msgO db 'Our Poject$'
msg1 db 'welcome to our quiz game !'
msg2 db 'Rules: $'
msg3 db '*. For Every Correct answer you will get 1 point.$'
msg8 db 'You have successfully completed your quiz.$'
msg9 db 'Your Total obtained point is: $'
msg10 db 'Press 1 to Re-attempt quiz or to Exit.$'
msg11 db '                   ***Thank you.! ***$'
  
extra db 'press any key to return$'
again db 'press y to start again$'  
choice db 'Enter any choice', 10, 13 
             db '1. Admin Panal', 10, 13
             db '2. Student panal', 10, 13
             db 'Press any button to Exit', 10, 13,
             db 'Choice $'      

  
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

mesg db 'you have exceed the limit of entering students$' 

.code

main proc
    mov ax,@data 
    mov ds, ax  
    call strt
    call enter 
    call stu1
    call enter
    call stu2 
    call enter
    call stu3
    call enter
    call stu4
    call enter
    call stu5
    call enter
    mov ah,4ch
    int 21h
    
main endp 

enter proc
mov ax,@data
mov ds,ax
lea dx,choice
mov ah,9
int 21h

mov ah,1
int 21h

cmp al,'1'
je teacher

cmp al,'2'
je arrow
jne ender

arrow:
add cycle,1
cmp cycle,5
je ednow 
ret

ednow:
lea dx,mesg
mov ah,9
int 21h
jmp enter

ender:
lea dx,msg11
mov ah,9
int 21h

mov ah,4ch
int 21h
ret
enter endp

quiz proc
mov ax,@data 
mov ds, ax   
    mov sum,0
    call qu1
    call qu2
    call qu3
    call qu4
    call qu5
    call qu6
    call qu7
    call qu8
    call qu9
    call qu10  
    lea dx,msg
    mov ah,9
    int 21h    
    mov dl,sum
    cmp dl,10
    je chk
    jne nikal
    
    
    chk:
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
    ret
    
    nikal: 
    add dl,48
    mov ah,2
    int 21h
    ret
quiz endp   

teacher proc    
mov ax,@data
mov ds,ax

call nl

cmp cycle,1
je scene1

cmp cycle,2
je scene1

;cmp cycle,3
;je scene3

;cmp cycle,4
;je scene4

;jne call enter

scene1:

mov cx,30
lea si,name1
show1:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show1

call nl
mov cx,10
lea si,id1
show12:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show12

call nl

mov dl,marks1
cmp dl,10
    je c
    jne nika
    
    nika: 
    add dl,48
    mov ah,2
    int 21h
    cmp cycle,1
    je ending
    
    c:
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
    cmp cycle,1
    je ending    


call nl


scene2:

mov cx,30
lea si,name2
show21:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show21

call nl
mov cx,10
lea si,id2
show22:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show22

call nl

mov dl,marks2
cmp dl,10
    je co
    jne nik
    
    nik: 
    add dl,48
    mov ah,2
    int 21h
    cmp cycle,2
    je ending
    
    
    co:
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

scene3:

mov cx,30
lea si,name3
show31:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show31

call nl
mov cx,10
lea si,id3
show32:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show32

call nl

mov dl,marks3
cmp dl,10
    je cc
    jne ni
    
    ni: 
    add dl,48
    mov ah,2
    int 21h
    cmp cycle,3
    je ending
    
    
    cc:
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


scene4:

mov cx,30
lea si,name4
show41:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show41

call nl
mov cx,10
lea si,id4
show42:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show42

call nl

mov dl,marks4
cmp dl,10
    je clp
    jne nir
    
    nir: 
    add dl,48
    mov ah,2
    int 21h
    cmp cycle,4
    je ending
    
    
    clp:
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


scene5:

mov cx,30
lea si,name5
show51:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show51

call nl
mov cx,10
lea si,id5
show52:
mov dl,[si]
mov ah,2
int 21h
inc si
loop show52

call nl

mov dl,marks5
cmp dl,10
    je cpl
    jne nri
    
    nri: 
    add dl,48
    mov ah,2
    int 21h
    cmp cycle,5
    je ending
    
    
    cpl:
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


ending:
lea dx,extra
mov ah,9
int 21h

call nl

mov ah,1
int 21h

cmp al,13 
je call enter
jne call enter


    
teacher endp           



stu1 proc    
mov ax,@data
mov ds,ax
 
call nl 
 
call detail1  

 call quiz
        
call nl 

mov dl,sum
mov marks1,dl
  
mov dx,offset again
mov ah,9
int 21h

call nl

mov ah,1
int 21h

cmp al,'y'
je re

re: 
ret

jne call enter       
 
stu1 endp

stu2 proc    
mov ax,@data
mov ds,ax
 
call nl 
 
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

cmp al,'y'
je retu

retu: 
ret

jne call enter       
 
stu2 endp

stu3 proc    
mov ax,@data
mov ds,ax
 
call nl 
 
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

cmp al,'y'
je retur

retur: 
ret

jne call enter       
 
stu3 endp

stu4 proc    
mov ax,@data
mov ds,ax
 
call nl 
 
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

cmp al,'y'
je return

return: 
ret

jne call enter       
 
stu4 endp



stu5 proc    
mov ax,@data
mov ds,ax
 
call nl 
 
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

cmp al,'y'
je retr

retr: 
ret

jne call enter       
 
stu5 endp



detail1 proc     
    lea dx,msg12
    mov ah,9
    int 21h
    
    call nl  
    
    lea si,name1
        cmp [si],0
        jne check1
    lp1:
        mov ah,1
        int 21h
        cmp al,13
        je se1
        mov [si],al
        inc si 
    jnz lp1
    
    ar1: 
    call nl 
    
    lea dx,msg13
    mov ah,9
    int 21h
    
    call nl       
    lea si,id1
        cmp [si],0 
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
                                                     

nl proc
    mov dx,10
    mov ah,2
    int 21h
    mov dx,13
    mov ah,2
    int 21h
    ret
nl endp

end main
