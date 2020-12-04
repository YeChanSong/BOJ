import sys

n = int(sys.stdin.readline().strip())
li = []
for i in range(n):
    member = sys.stdin.readline().strip().split()
    member.append(i)
    member[0] = int(member[0])
    li.append(member)
li = sorted(li,key=lambda x: (x[0],x[2]))
for i in li:
    print(i[0],i[1])