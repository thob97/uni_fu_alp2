import math
import random
# Aufgabe 1
def pythTripelsSmaller (n):
    if (n<=0): print("Fehler")
    else:
        liste = []
        for a in range (1,n):
            for b in range (a,n):
                for c in range (b,n):
                    if (math.sqrt(a**2+b**2)==math.sqrt(c**2)):
                        liste.append((a,b,c))
        return liste
                        
# Aufgabe 2                        
def apply_until(f,p,xs):
    liste = []
    for i in xs:
        if (p (i)):                        
            liste.append(f(i))
        else: 
            return liste
    return liste

# Aufgabe 3
def filter_rec (p, xs):
    if(xs==[]): 
        return []
    else:
        if(p(xs[0])):
            return [xs[0]] + filter_rec(p,xs[1:])
        else:
            return filter_rec(p,xs[1:])
            
def filter_iter(p,xs):
    liste= []
    for i in xs:
        if(p(i)):
            liste.append(i)
    return liste
                        
        
def factorial (n): 
    if n<=0:
        return 1 
    else:
        return n * factorial(n-1)
        
def odd (n):
    if n==0 or n%2==0:
        return False
    else:
        return True
                        
                
# Aufgabe 4
def repeat (n,m):
    dictionary = { }
    randm=random.randint(n,m)
    while(randm not in dictionary):
        dictionary[randm]=randm
        randm=random.randint(n,m)
    return ((dictionary.values()),randm)

#Aufgabe 5 
# Hilfsfunktion aus Uebung 1
def testweekday (day,month):
    if ((day>31 and (month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12)) or (day>30 and (month==4 or month==6 or month==9 or month==11)) or (day>29 and month==2)):
        return False
    else:
        return True
     

def double_birthday():
    dictionary = { }
    while(True):
        day=random.randint(1,31)
        month=random.randint(1,12)
        if(testweekday(day,month)):
            if((day,month)in dictionary):
#                 return (dictionary.keys(),(day,month))
                return(len(dictionary)+1)
            dictionary[(day,month)]= 1

def repeat_double_birthday(n):
    liste =[]
    for i in range(1,n+1):
        liste= liste+[double_birthday()]
    return liste
        

def birthday_paradox(n):
    sum=0
    liste = repeat_double_birthday(100)
    for i in liste:
        sum +=i
    sum /=100.0
    return (n/sum)*100

# Testfunktionen
def test_pythTripelsSmaller(zahl):
    print("pythTripelSmaller (",zahl,") = ",pythTripelsSmaller(zahl))

test_pythTripelsSmaller(16)

    
def test_apply_until(f,p,xs):
    print("apply_until ( f, p",xs,") = ",apply_until(f,p,xs))

test_apply_until(factorial,odd,[3,5,7,4,9,6])
    
def test_filter_rec(p,xs):
    print("filter_rec ( p",xs,") = ",filter_rec(p,xs))    
test_filter_rec(odd,[2,4,3,7,1,0,8,3])

    
def test_filter_iter(p,xs):
    print("filter_iter ( p",xs,") = ",filter_iter(p,xs))
test_filter_iter(odd,[2,4,3,7,1,0,8,3])

def test_repeat(n,m):
    print("repeat (",n,m,") = ",repeat(n,m))
test_repeat(1,100)


def test_double_birthday():
    print("double_birthday() = ",double_birthday())
test_double_birthday()

def test_repeat_double_birthday(n):
    print("repeat_double_birthday(",n,") = ",repeat_double_birthday(n))
test_repeat_double_birthday(100)

def test_birthday_paradox(n):
    print("birthday_paradox(",n,") = ",birthday_paradox(n),"%")
test_birthday_paradox(23)
