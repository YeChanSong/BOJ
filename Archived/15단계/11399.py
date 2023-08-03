import sys

N = int(sys.stdin.readline().strip())
li = sorted(list(map(int,sys.stdin.readline().strip().split())))
tmp = 0
total = 0
for i in li:
    tmp += i
    total += tmp
print(total)