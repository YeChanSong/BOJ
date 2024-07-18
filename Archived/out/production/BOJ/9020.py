import sys, math

def closest_prime_num(n):
    mid = n//2
    flag = True
    closest = -1
    for i in range(mid,n):
        flag = True
        for j in range(2,math.floor(math.sqrt(i))+1):
            if i%j==0:
                flag = False
                break
        if flag == True:
            flag2 = True
            for j in range(2,math.floor(math.sqrt(n-i))+1):
                if (n-i)%j==0:
                    flag2 = False
                    break
            if flag2 == True:
                closest = i
                break
            
    return closest

C = int(sys.stdin.readline().strip())
for i in range(C):
    n = int(sys.stdin.readline().strip())
    big = closest_prime_num(n)
    print(n-big,big)
