import sys, collections
li = collections.Counter()
for i in range(10):
    li[int(sys.stdin.readline().strip())%42] +=1
print(len(li))
