import random

#1a)
def insertsort(seq): 
    for j in range(1, len(seq)):           
        key = seq[j]           
        k = j-1
        while k>=0 and seq[k]>key:                    
            seq[k+1] = seq[k]                      
            k = k-1          
        seq[k+1] = key
    return seq

def merge(low, high):
    res = []
    i, j = 0, 0
    while i<len(low) and j<len(high):
        if low[i] <= high[j]:
            res.append(low[i])
            i = i+1
        else:
            res.append(high[j])
            j = j+1           
    res = res + low[i:]
    res = res + high[j:]
    return res   
    
def mergesort(A):
    if len(A) < 2:
        return A
    elif len(A)<=9:             # Hier
        return insertsort(A)    # bis hier verändert
    else:            
        m = len(A) // 2
        return merge( mergesort(A[:m]), mergesort(A[m:]) )
        
# 1b)
def new_mergesort(A, xs=[]):   
        for i in range (len(A)):
            xs.append([A[i]])
        
        counter = len(A)
        while (counter > 1):
            counter /=2
            pt = 0
            while (pt < len(xs)-1):
                
                xs[pt] = merge (xs[pt],xs[pt+1])
                del (xs[pt+1])
                pt +=1
        return xs[0]

#Aus der Vorlesung
def parent(i):
    return i//2
def left(i): 
    return i*2
def right(i): 
    return i*2+1        

#Hilfsfunktionen
def insertsort2(seq): 
    if (seq == []):         
        return seq          
    j=0                     
    while (j != len(seq)-1):
        j +=1               
        key = seq[j]           
        k = j-1
        while (k>=0 and seq[k][1]<key[1]):                    
            seq[k+1] = seq[k]                      
            k = k-1          
        seq[k+1] = key
    return seq    

#Gibt dem Weg vom Obersten Element zum neusten "Blatt" an    
def calc_way (taskList):
    xs = []
    i = taskList[0]
    while (i>=1):
        xs.append(i)
        i = parent(i)
    return xs[::-1]    
    
#Gibt die Elemente eines Baumes, ab einer beliebigen stelle, als Liste aus.
def get_Tree_Elements(taskList,current):
    xs = []   
    if (taskList[0]>= right(current) and taskList[0]>= left(current)):
       return [left(current)] + get_Tree_Elements(taskList,(left(current)) ) + [right(current)] + get_Tree_Elements(taskList,(right(current)) )
    elif(taskList[0]>= left(current)):
       return [left(current)] + get_Tree_Elements(taskList,(left(current)) )
    elif(taskList[0]>= right(current)):
        [right(current)] + get_Tree_Elements(taskList,(right(current)) )
    else:
        return xs
        
#2        
def buildPriorityQueue(taskList):
    insertsort2(taskList)
    taskList.insert(0,len(taskList))
    
    i=2                             
    while (i<=(len(taskList)-2)):   #Damit left <= right  
        taskList[i],taskList[i+1] = taskList[i+1],taskList[i]
        i +=2
    return taskList
  
def insert(taskList,task):
    taskList[0] +=1
    if (taskList[0]<=1):
        taskList.append(task)
        return taskList
    taskList.append((0,0))            
    
    for i in (calc_way(taskList)):
        if ( taskList[i][1] < task[1] ):
            task, taskList[i] = taskList[i], task   
            lp,rp=left(parent(i)),right(parent(i))  #damit left <= right
            if (i!=1 and lp<= taskList[0] and rp<= taskList[0] and taskList[lp][1] > taskList[rp][1] ):
                taskList[lp], taskList[rp] = taskList[rp], taskList[lp]
    return taskList
          
def isEmpty(taskList):
    if (taskList[0]==0):
        return True
    else:
        return False
        
def removeTask(taskList):
    if (taskList[0]==0):
        return taskList
    elif (taskList[0]==1):
        del taskList[1]
        taskList[0] -=1
        return taskList
    else:    
        xs = sorted([2] + get_Tree_Elements(taskList,2))
        j=0
        ys = []
#       print(xs)
        for i in xs:    #Löscht den linken "teil" Baum 
#           print(taskList[i-j])
            ys += [taskList[i-j]]
            del taskList[i-j]
            taskList[0] -=1
            j +=1
#       print(taskList)
        del taskList[1] #Löscht die höchste priority => rechter "teil" Baum wird zum "main" Baum
        taskList[0] -=1
#       print(taskList)
        for task in ys: #Fügt den linken teil Baum wieder hinzu.
            insert(taskList,task)
        return taskList
     
# 3
def counting_sort(A, k): # T(n) = k + n*1 + 1 + k + (n * (1 + 1 + 1)) => O(n) oder O(k)
    C = [0 for i in range(0, k+1)]  #k (range(k))
    for j in range(0, len(A)):      #n (laenge der Liste A)
        C[A[j]] += 1                #1
        
    j = 0                           #1
    A=[]
    for i in range (len(C)):        #k (range(k))
        A = A + ([i]*C[i])  
            
    return A                        #1
    
# 4
#Aus den in den Vorlesung gezeigten Sortieralgorithmen eignet sich keiner. 
#Bei Quicksort und Mergesort kommt es zum Rekursionsfehler.
#Heap-Sport und Bucket-Sort sind nicht für den Wertebereich geeignet.
#Bei Counting-Sort kommt es zu einen MemoryError
#Radix-Sort wurde in der Vorlesung nicht implementiert
#Und Bubble-Inters- und Selection-Sort sind einfach zu langsam
#-----------------------------------------------------------------------
  
#Funktionen aus U4
def matrix (n,m):
    return [[' . ' for i in range(n)]for j in range (m)]
        
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
                xs[i][ii]= ' o ' 
    return xs
    
def genSolution(xs):
    length = len(xs)
    length2 = len(xs[0])
    for rh in range (0, length):            
        for sp in range (0, length2 ):
            if (xs[rh][sp] == ' . '):
                temp=0
                for i in (-1,1,0):
                    for ii in (-1,1,0):
                        if (rh+i >=0 and rh+i<length and sp+ii>=0 and sp+ii<length2):
                            if(xs[rh+i][sp+ii] ==' o '):
                                temp +=1
            if(xs[rh][sp] == ' . ' and temp !=0):
                xs[rh][sp] = " " + str(temp) + " "
                    
    return xs       
   
#Bonus 5
def start_game (p,n,m):
    matrix = [[' X ' for i in range(n)]for j in range (m)]
    solution = genSolution(newGame(p,n,m))
    print("Solutione = ")   #Zur Kontrolle
    showGameField(solution) #Zur Kontrolle
    showGameField(matrix)
    return (matrix,solution)
   
def count_holes(xs):    #Zählt die Anzahl der Löcher für die Siegbedingung
    length = len(xs)*len(xs[0])
    count = 0
    for x in xs:
        count += x.count(' o ')
    return (length - count)
    
def bomb_neighbor(xs,ys,x,y, win): #Kettenreaktion falls ' . ' getroffen wird
    length = len(xs)
    length2 = len(xs[0])
    if (xs[y][x] == ' X ' and ys[y][x] == ' . '):
        xs[y][x] = ys[y][x] 
        win +=1

    for i in (-1,1,0):
            for ii in (-1,1,0):    
                if (y+i >=0 and y+i<length and x+ii>=0 and x+ii<length2):
                    if (xs[y+i][x+ii] == ' X ' and ys[y+i][x+ii] in [' 1 ',' 2 ',' 3 ',' 4 ',' 5 ',' 6 ',' 7 ',' 8 ']):
                        xs[y+i][x+ii] = ys[y+i][x+ii]
                        win +=1
                        
                    elif (xs[y+i][x+ii] == ' X ' and ys[y+i][x+ii] == ' . ' and ( (i==0 and ii in [1,-1]) or (i in [1,-1] and ii==0) )):
                        xs[y+i][x+ii] = ys[y+i][x+ii]
                        win +=1
                        xs,win = bomb_neighbor(xs,ys,x+ii,y+i,win)   
                        
    else:
        return (xs,win)

def play(p,n,m):
    (xs,ys)=start_game(p,n,m)
    count = count_holes(ys)
    win = 0
    while(count != win):
        x = int(input("Bitte x eingeben: "))
        y = int(input("Bitte y eingeben: "))
        print (win)
        if (ys[y][x]==' o '):
            showGameField(ys)
            return -1
        
        elif (ys[y][x]== ' . '):
            xs,win = bomb_neighbor(xs,ys,x,y,win)
 
        elif (ys[y][x] in [' 1 ',' 2 ',' 3 ',' 4 ',' 5 ',' 6 ',' 7 ',' 8 '] and xs[y][x] == ' X '):
            xs[y][x] = ys[y][x]
            win +=1
            
        else:
            pass
            
        showGameField(xs)
    showGameField(ys)    
    return 1        
  
#Test Funktionen    
def test_Sortier_Funktionen(xs):
    xs1 = xs[:]
    xs2 = xs[:]
    xs3 = xs[:]
    print("mergesort",xs,"=",mergesort(xs1))
    print("new_mergesort",xs,"=",new_mergesort(xs2,[]))
    k = max(xs)
    print("counting_sort",xs,"=",counting_sort(xs3,k))
test_Sortier_Funktionen([2,3,2,1,0,4,6,9,1,1,1])

def test_queue (taskList,newtask):
    xs = taskList[:]
    print ("buildPriorityQueue(",xs,") = ",buildPriorityQueue(taskList))
    
    xss = taskList[:]
    print ("insert (",xss,newtask,") = ",insert (taskList,(newtask)) )
    
    print ("isEmpty([0]) = ",isEmpty([0]),",isEmpty([1,(100,100)]) = ",isEmpty(taskList))
    
    xsss = taskList[:]
    print ("removeTask(",xsss,") = ",removeTask(taskList))
test_queue([('a',random.randint(0,100)),('b',random.randint(0,100)),('c',random.randint(0,100)),('d',random.randint(0,100))],('z',60) )



def test_play(p,n,m):
    if (play(p,n,m)==1):
        print("You won")
    else: 
        print("You lost")   
test_play(5,10,5)        