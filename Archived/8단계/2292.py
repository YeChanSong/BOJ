import sys

init = int(sys.stdin.readline().strip())

n = 0
res = 1
while 1:
    if res >= init:
        break
    n += 1
    res = res + 6*n
print(n+1)
