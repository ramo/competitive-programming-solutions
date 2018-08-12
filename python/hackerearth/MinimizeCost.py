"""
https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/minimise-cost-89b54cb9/
"""


def main():
    # Get the inputs
    n, k = [int(x) for x in input().split()]
    array = [int(x) for x in input().split()]
    
    # Initialize index 'j' which will be used to point to negative numbers
    j = 0
    # loop through the array
    for i in range(0, n):
        
        # index 'i' will be used to point to positive numbers.
        # So, if the value 'i' pointing is negative one, let's skip it.
        if array[i] <= 0:
            continue

        # increment j if needed to make the distance between
        # i and j as k
        while i - j > k:
            j += 1
        
        # This inner while loop is to redeem the negative numbers with positive ones.
        # We can loop till number pointing by 'i' become 0 (or)
        # 'j' index crossed the distance k from 'i' index (or)
        # 'j' index crossed the array itself (n-1)
        while (array[i] > 0) and (min(n-1, j) <= i+k):
            
            # 'j' index should point to negative number
            # So, if it's not pointing negative, let's skip it
            # and increment 'j' index
            if array[j] >= 0:
                j += 1
                continue
            
            # We can redeem the 'i'th positive number with the 
            # 'j'th negative number
            v = min(array[i], abs(array[j]))
            array[i] -= v
            array[j] += v
            
            # If the negative number pointed by 'j' is redeemed 
            # and become zero or positive, let's move the 'j' index
            if array[j] >= 0:
                j += 1
            # Repeat
        # Repeat
        
    # Print the sum 
    # As we have neutralized negative ones by positive ones within
    # distance 'k', we can take the absolute sum of the array
    print(sum(abs(x) for x in array))


if __name__ == '__main__':
    main()
