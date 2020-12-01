import sys
n = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
m = max(li)
s = sum(li)
avg = (((s/m)*100)/n)
print(avg)
