# 1.Uebungszettel von Thore Brehmer und Jonny Lahm
# Abgabe bei Natusch, Dennis Nikolaus am 30.03.2019
import math
import random

#Aufgabe 1
def leap_year (year):
    if ((year%100==0) and (year%400==0)) or ((year%4==0)and(year%100!=0) and year>0):
            return True
    else:
            return False
 
#Aufgabe 2        
def weekday (day,month,year):
     if(month>12 or month<1 or year<0 or day<1):
         print (day,month,year,"is an invalide date")
     elif ((day>31 and month==1 or month==3 or month==5 or month==7 or month==8 or month==10 or month==12) or (day>30 and month==4 or month==6 or month==9 or month==11) or (day>28 and month==2 and not leap_year(year)) or (day>29 and month==2 and leap_year(year)) ):   
         print (day,month,year,"is an invalide date")
     else:
         y = year - ((14 - month)/12)
         x = y+(y/4)-(y/100)+(y/400)
         m = month + (12*((14-month)/12))-2
         name = (day+x+(31*m)/12) % 7
         if ((name)   ==0): print("Der Wochentag vom Datum",day,month,year,"ist ein Sonntag")
         elif ((name) ==6): print("Der Wochentag vom Datum",day,month,year,"ist ein Samstag")
         elif ((name) ==5): print("Der Wochentag vom Datum",day,month,year,"ist ein Freitag")
         elif ((name) ==4): print("Der Wochentag vom Datum",day,month,year,"ist ein Donnerstag")
         elif ((name) ==3): print("Der Wochentag vom Datum",day,month,year,"ist ein Mittwoch")
         elif ((name) ==2): print("Der Wochentag vom Datum",day,month,year,"ist ein Dienstag")
         elif ((name) ==1): print("Der Wochentag von Datum",day,month,year,"ist ein Montag")    

             
#Aufgabe 3                 
def triangle_area (a,b,c):
     if (a<0 or b<0 or c<0 or a+b<=c or a+c<=b or b+c<=a):
         return 0
     else:    
         s = (a+b+c)/2
         flaecheninhalt = math.sqrt(s*(s-a)*(s-b)*(s-c))
         return flaecheninhalt

# Hilfsfunktion berechnet Seitenlaenge von 2 punkten
def sl (p1, p2):
    punkt1= p1[0] - p2[0] 
    punkt2= p1[1] - p2[1]
    seitenl= math.sqrt(punkt1**2 + punkt2**2)         
    return seitenl
    
def convex_polygon (liste):
    temp = 0
    for i in range(1,len(liste)-1):
        temp += triangle_area(sl(liste[0],liste[i]), sl(liste[i],liste[i+1]), sl(liste[0], liste[i+1]))
    return temp

#Aufgabe 4             
#Hilfsfunktion
def isPrime(zahl):
    for i in range (2,zahl):
        if (zahl % i == 0):
            return False
    return True    
       
def factors(zahl):
    liste = [] 
    if zahl<=1: 
        return 0
    else:
        for i in range(2,zahl+1):
            while (isPrime(i) and zahl%i==0):
                 liste.append(i)
                 zahl /=i
        return liste
       
       
# Testfunktionen

print("\n")
def test_leap_year(year):
    if leap_year (year) == True:
        print(year,"is a leap year")
    else:
        print(year,"is not a leap year")    
      
test_leap_year(2000)      


print("\n")
def test_weekday(day,month,year):
    return weekday(day,month,year)

test_weekday (29,2,2000)


print("\n")
def test_triangle_area(a,b,c):
    if triangle_area(a,b,c) == 0:
        print ("Die Punkte", a, b, c, "ergeben kein Dreieck")
    else:
        print ("Der Flaecheninhalt von",a,b,c,"ist =",triangle_area(a,b,c))

test_triangle_area (10,10,10)        


print("\n")
def test_convex_polygon (liste):
    print ("Flaecheninhalt =",convex_polygon(liste), "von den Eckpunkten des Konvexen Polygons: ",liste)    

test_convex_polygon([(0,1),(1,2),(2,2),(3,1),(4,0),(0,0)])


print("\n")
def test_factors(zahl):
    if factors(zahl) == 0:
        print ("zahl > 1 eingeben! Sie haben ",zahl," eingegeben")
    else:
        print("Produkt aus Primzahlen von der Zahl ", zahl ," ist: ", factors(zahl))
        
test_factors(250)


