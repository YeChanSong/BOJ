import sys

N = sys.stdin.readline().strip()
l = len(N)
lim = 10
mul = 9
cntr = 0
for i in range(l):
    if int(N)<lim:
        cntr += (i+1)*(int(N) + 1 -lim//10)
        break
    else:
        cntr += (i+1)*mul
        mul *=10
        lim *=10
print(cntr)