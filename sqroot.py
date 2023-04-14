def main():
    print("This program finds the square root of a number.")
    n = int(input("Enter a number: "))
    precision = int(input("Enter the precision: "))
    print("The square root of", n, "is", sqroot(n, precision))

def sqroot(n, precision):
    start, end = 0, n
    while (start <= end):
        mid = start + (end - start)/2
        if (mid * mid == n):
            return mid
        elif (mid * mid > n):
            end = mid - 1
        else:
            start = mid + 1

    # now for precision
    increment = 0.1
    for i in range(precision):
        while (mid * mid < n):
            mid += increment
        mid -= increment
        increment /= 10
    return mid
    
main()

    

