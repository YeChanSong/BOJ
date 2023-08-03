import sys,math
a,b,v = map(int,sys.stdin.readline().strip().split())
print(math.ceil((v-a)/(a-b))+1)
