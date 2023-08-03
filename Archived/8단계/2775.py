import sys
sys.setrecursionlimit(1000000)
floor0 = [i for i in range(1,15)]

def recur(a,b):
    global floor
    if a<0 or b<0:
        return 0
    
    if floor[a][b] != None:
        return floor[a][b]
    
    floor[a][b] = recur(a-1,b) + recur(a,b-1)
    return floor[a][b]


C = sys.stdin.readline().strip()
for i in range(int(C)):
    floor = [[None for i in range(14)] for i in range(15)]
    floor[0] = floor0
    k = int(sys.stdin.readline().strip())
    n = int(sys.stdin.readline().strip())
    print(recur(k,n-1))
    
