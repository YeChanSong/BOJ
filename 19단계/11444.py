import sys
sys.setrecursionlimit(10000000)
'''
Fn = F(k+1)*F(n-k) + F(k)*F(n-k-1)
F5 = 5 = F3*F3 + F2*F2 = 2*2 + 1*1
Fn(mod p) = F(k+1)(mod p)*F(n-k)(mod p) + F(k)(mod p)*F(n-k-1)(mod p)
'''

def dq(idx):
    global cache

    tmp = cache.get(idx%1000000007)
    if tmp != None:
        return tmp
    
    if idx%2 == 0:
        tmp = (dq(idx-1)%1000000007 + dq(idx-2)%1000000007)%1000000007
        cache.setdefault(idx,tmp)
        return tmp
    a = dq(idx//2+1)%1000000007
    b = dq(idx//2)%1000000007
    tmp = ((a**2)%1000000007+(b**2)%1000000007)%1000000007
    cache.setdefault(idx,tmp)
    return tmp
    
n = int(sys.stdin.readline().strip())
cache = dict()
cache.setdefault(0,0)
cache.setdefault(1,1)
ans = dq(n)
print(ans)