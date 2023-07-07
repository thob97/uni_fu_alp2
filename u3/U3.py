import operator
import math
import random
import sys
    
#1
#a) Eine lineare rekursive Suche wird bei einer Liste der laenge 998 versagen.  (n)
#b) Wir nehmen an, dass die rekursive binaere Suchfunktion nur mit einer sortieten Liste funktioniert.
#   Die Liste koennte also maximal 10^^997 lang sein.   (Log n)
#c) Rekursive Funktionen belegen bei jeden Aufruf Speicher, bei zuviel Speicher verbrauch wird die Funktion
#   nicht ausgefuehrt. Eine binaere rekursion kann eine groessere Liste durchsuchen als eine lineare, da die
#   binaere nur log n oft die Liste aufruft, waehrend die lineare die Liste n oft aufruft.
#2
def isSorted (f, xs):
    for i in range(0,len(xs)-1):
        if(not(f (xs[i],(xs[i+1]))) ):
            return False
    return True
    
#3    
def insertsort(seq): 
    if (seq == []):         #Von hier
        return seq          #
    j=0                     #
    while (j != len(seq)-1):#
        j +=1               #Bis hier etwas veraendert
        key = seq[j]           
        k = j-1
        while (k>=0 and seq[k]>key):                    
            seq[k+1] = seq[k]                      
            k = k-1          
        seq[k+1] = key
    return seq    
    
def test_insertsort():
    xs=[]
    for i in range (0, random.randint(0,10)):
        xs += [random.randint(0,20)]
    ys = xs[:]
    print ("insertsort(",ys,")=",insertsort(xs))
    
test_insertsort()        
    
#c) Insertionsort sollte man bei sortieren oder 
#   leicht unsortieren Listen benutzen (Beste Laufzeit).
#   Shellsort sollte man in den restliche Faellen benutzen,
#   sofern die stabilitaet unwichtig ist.
    

#4
def min_diff (xs): #T(n)= c + n*log n + n-2*(c) => O n*log n
    liste = []                          #c
    xs = sorted(xs)                     #O n*log n  wobei n laenge der Liste xs
    tupel = (xs[0],xs[1])               #c
    diff = abs(xs[0] - xs[1])           #c
    for i in range(1,len(xs)-1):        #n-2 wobei n laenge der Liste xs
        current = abs(xs[i] - xs[i+1])  #c
        if (current < diff):            #c
            tupel = (xs[i],xs[i+1])     #c
            diff = current              #c
    return(tupel)                       #c
    
#5
def same_average (xs): #T(n)= c + n+n+1+n*log n + n + (1-n)*(c + n - 1) => O n^2
    avg = (sum(xs) // len(xs))                      #n+n+1 wobei n laenge der Liste xs
    xs = sorted (xs)                                #O n*log n  wobei n laenge der Liste xs
    liste = []                                      #c
    while(xs!=[] and len(xs)!=1):                   #n+n-1 wobei n laenge der Liste xs
        current = (xs[0]+xs[-1])//2                 #c
#print ("main",avg,current, xs[0],xs[-1])
        if (current > avg):                         #c
            xs = xs[:-1]                            #c
        elif (current < avg):                       #c
            xs = xs[1:]                             #c
        else:
            liste.append ((xs[0],xs[-1]))           #c
            for x in xs[1:]:                        #n-1
#print ("sup",avg,(x+xs[-1])//2), x,xs[-1])
                if (((x+xs[-1])//2) ==avg):         #c
                    liste.append ((x,xs[-1]))       #c
                else: 
                    break
            xs = xs[:-1]                            #c
    return liste                                    #c
    


#6
#a) Bsp [(1,(2,1),(2,2),0] ->  -> [0,1,(2,2),(2,1)]

#d
#in einen quicksort durchgang koennte das maximale Element hoechstens n-2 mal bewegt werden
#(wobei n laenge der liste). Der "schlimmste" Fall waere dabei, wenn das max E. neben dem
# pivot liegt und danach nur Elemente liegen fuer die gilt (pivot>E.)
# Bsp. [1,2,0,0,0,0,0]. Laenge = 7, Bewegungen des max E.(2) = laenge - 2 = 5
    
   
    
#Bonus 7
def matrix (n,m):
    return [['.' for i in range(n)]for j in range (m)]
        
def showGameField (xs):
    for i in range (0, len(xs) ):
        for ii in range (0, len(xs[0])):
            print (xs[i][ii], end = '')
        print ('\n')
        
def newGame (p, n, m):
    xs = matrix (n,m)
    for i in range (0, m):            
        for ii in range (0, n ):
            if ( (random.randint(0,100)) <= p ):
                xs[i][ii]= 'o' 
    return xs
    
def genSolution(xs):
    length = len(xs)
    length2 = len(xs[0])
    for rh in range (0, length):            
        for sp in range (0, length2 ):
            if (xs[rh][sp] == '.'):
                temp=0
                for i in (-1,1,0):
                    for ii in (-1,1,0):
                        if (rh+i >=0 and rh+i<length and sp+ii>=0 and sp+ii<length2):
                            if(xs[rh+i][sp+ii] =='o'):
                                temp +=1
            if(xs[rh][sp] == '.' and temp !=0):
                xs[rh][sp] = str(temp)
                    
    return xs       
   
    
#Testfunktionen   
def test_isSorted(f, xs):
    print("isSorted (f, ",xs,") = ",isSorted (f, xs))
test_isSorted(operator.lt, [2, 2, 4, 5, 8, 9])
test_isSorted(operator.gt, [2, 2, 4, 5, 8, 9])
test_isSorted(operator.le, [2, 2, 4, 5, 8, 9])

def test_min_diff (xs):
    print("min_diff (",xs,") = ", min_diff (xs))
test_min_diff ([3, 10, 3, 9, 5, 1, 2, 7, 6, 8])

def test_same_average (xs):
    print("same_average (",xs,")=",same_average (xs))
test_same_average ([6, 25, 29, 10, 6, 5, 8, 0, 20, 19])

#7 Bonus
def test_matrix_and_showGameField(n,m):
    print("showGameField(matrix(",n,m,"))=")
    showGameField(matrix(n,m))
test_matrix_and_showGameField(10,5)
    
def test_newGame (p,n,m):
    print("showGameField(newGame(",p,n,m,"))=")
    showGameField(newGame(p,n,m))
test_newGame(10,10,5)
    
def test_genSolution (p,n,m):
    print("showGameField(genSolution(newGame(",p,n,m,")))=")
    showGameField( genSolution(newGame (p,n,m)))
test_genSolution(10,10,5)