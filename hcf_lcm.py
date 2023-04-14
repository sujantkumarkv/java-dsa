def hcf(a, b):
    if a == 0:
        return b
    # Euclidean algorithm: hcf(a, b) = hcf(remainder(b, a), a)
    return hcf(b % a, a)

def lcm(a, b):
    return (a * b) / hcf(a, b)

def main():
    a = int(input("Enter a number: "))
    b = int(input("Enter another number: "))
    print("HCF of", a, "and", b, "is", hcf(a, b))
    print("LCM of", a, "and", b, "is", lcm(a, b))

main()