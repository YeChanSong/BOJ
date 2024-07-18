import sys
li = []
for i in range(9):
    li.append([int(sys.stdin.readline().strip()),i])
li = sorted(li)
print(li[-1][0])
print(li[-1][1]+1)
