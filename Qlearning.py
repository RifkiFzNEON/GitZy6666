import pandas as pd
import numpy as np
import random

data = np.genfromtxt('DataTugas3ML2019.txt', delimiter='\t',dtype=int)
array = np.zeros((10,10,2))
Q = np.zeros((4,255))
alpha = 0.1
gamma = 0.9
k = 0

def get_coor_by_action(random,x,y):
    if random == 0:
        x = x-1
        if x<0:
            x = x+1
    elif random == 1:
        y = y+1
        if y>9:
            y = y-1
    elif random == 2:
        x = x+1
        if x>9:
            x = x-1
    elif random == 3:
        y = y-1
        if y<0:
            y = y+1
    return x,y

for i in range(10):
    for j in range(10):
        p = data[i,j]
        q = np.array([k,p])
        array[i,j] = q
        k += 1

for j in range(600):
    x = 9
    y = 0
    s = 90

    while (x != 0 & y != 9):
        pol = np.random.choice(4, 1)
        x, y = get_coor_by_action(pol, x, y)
        maks = np.amax(Q, axis=0)
        Q[pol, s] = (Q[pol, s] + (alpha * (array[x, y][1] + (gamma * maks[int(array[x, y][0])]) - Q[pol, s])))
        s = int(array[x, y][0])

st = 90
xt = 9
yt = 0
rew = 0
state = []

while (st != 9):
    makst = np.amax(Q, axis=0)
    pola, st = np.where(Q == makst[st])
    if (pola.size > 1):
        pol = pola[0]
    else:
        pol = pola

    xt, yt = get_coor_by_action(pol, xt, yt)
    st = int(array[xt, yt][0])

    state.append(st)
    rew += array[xt, yt][1]

print('Total Reward =',rew)
print(state)
