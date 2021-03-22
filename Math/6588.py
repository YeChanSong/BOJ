import sys, math

checker = list(True for i in range(1000001))
checker[:1] = [False,False]
for i in range(2,1000001):
    if checker[i] == True:
        j = i*i
        while j<1000001:
            checker[j] = False
            j+=i
            
n = 1
while n!=0:
    n = int(sys.stdin.readline().strip())
    if n == 0:
        break
    r = n-1
    while r >= n//2:
        j+=1
        if checker[r] and checker[n-r]:
            a=r
            b=n-r
            if r>=n-r:
                a=n-r
                b=r 
            print(str(n)+' = '+str(a)+' + '+str(b))
            flag = False
            break
        r-=1