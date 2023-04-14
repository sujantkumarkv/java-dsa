def main():
    print(countZeros(n=300230, c=0))

def recursion(n):
    if n == 0:
        return
    #prints while stacking up the function calls
    print(n )
    recursion(n-1)

def recursionRev(n):
    if n == 0:
        return
    recursionRev(n-1)
    print(n) #prints while the function call stack is emptied

def infiniteRec(n):
    if n == 0:
        return
    print(n)
    infiniteRec(n)
    n-=1 #post decrement (n--) doest exist in python so this is the way, pre decrement exists as (--n)

def reverse(n, revnum):
    """
    def main():
    #n, revnum = 1234, 0
    #the above doesn't work as int in immutable & changes in reverse doesnt affect so array required
    n, revnum = 1234, [0]
    reverse(n, revnum)
    print(revnum[0])

    """
    if n == 0:
        return
    else:
        rem = n % 10
        revnum[0] = revnum[0]*10 + rem
        reverse(n//10, revnum)
        #return revnum

def countZeros(n, c):
    if n == 0:
        return c
    else:
        rem = n % 10
        if rem == 0:
            return countZeros(n//10, c+1)  
        else:
            return countZeros(n//10, c)


    
main()