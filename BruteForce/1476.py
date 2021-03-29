import sys

E,S,M = map(int,sys.stdin.readline().strip().split())
year = 0
e,s,m = 0,0,0
while 1:
    if e==E and s==S and m==M:
        break
    year+=1
    e = year%15
    if e==0:
        e = 15
    s = year%28
    if s==0:
        s = 28
    m = year%19
    if m == 0:
        m = 19
    
print(year)