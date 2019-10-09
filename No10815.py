"""
입력으로 주어진 M개의 수에 대해서, 
각 수가 적힌 숫자 카드를 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
"""

#가지고 있는 n개의 숫자 카드 
n = int(input())
n_cards = list(input().split(' '))
n_cards.sort()

#찾아야 할 m개의 숫자 카드
m = int(input())
m_cards = list(input().split(' '))

def bst_find(num):
    l = 0
    r = n-1

    while l <= r:    
        mid = (l+r)//2
        if n_cards[mid] == num:
            return 1
        elif n_cards[mid] > num:
            r = mid-1
        else:
            l = mid+1
    return 0

for card in m_cards:
    print(bst_find(card), end=" ")