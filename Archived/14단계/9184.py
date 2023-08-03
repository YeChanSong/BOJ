import sys

def w(a,b,c):
    global cache
    if a <=0 or b <= 0 or c <= 0:
        return 1
    if a > 20 or b > 20 or c > 20:
        return w(20,20,20)
    if cache[a][b][c] != None:
        return cache[a][b][c]
    if a<b and b<c:
        tmp = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c)
        cache[a][b][c] = tmp
        return tmp
    tmp = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1)
    cache[a][b][c] = tmp
    return tmp

global cache
cache = list([[None for k in range(21)] for j in range(21)] for i in range(21))

while 1:
    a,b,c = map(int,sys.stdin.readline().strip().split())
    if a==b==c==-1:
        break
    
    print('w(%s, %s, %s) = %s' %(a,b,c,w(a,b,c)))
