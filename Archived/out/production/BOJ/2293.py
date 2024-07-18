import sys
    
n,k = map(int,sys.stdin.readline().strip().split())
values = list()
for i in range(n):
    values.append(int(sys.stdin.readline().strip()))
values.sort()
cache = list(0 for i in range(k+1))
cache[0] = 1
for i in values:
    for j in range(i,k+1):
        cache[j]+= cache[j-i]
        
print(cache[k])