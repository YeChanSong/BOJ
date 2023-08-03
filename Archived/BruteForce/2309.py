import sys

h = list()
for i in range(9):
    h.append(int(sys.stdin.readline().strip()))
h.sort()
total = sum(h)
a,b = -1,-1
flag = False
for i in range(9):
    if flag:
        break
    for j in range(i,9):
        if total-h[i]-h[j] == 100:
            a,b = i,j
            flag = True
            break
for i in range(9):
    if i == a or i == b:
        continue
    print(h[i])